package dk.mada.jaxrs.generator.imports;

import java.util.Collection;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.ExtraTemplate;
import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeContainer;

/**
 * Keeps track of imports for a single template, taking
 * generator options into consideration.
 */
public final class Imports {
    private static final Logger logger = LoggerFactory.getLogger(Imports.class);

    /** Set of classes to be imported.*/
    private final NavigableSet<String> importedClasses = new TreeSet<>();

    /** Flag selecting if imports should be added for DTOs. */
    private final boolean includeDtoImports;

    /** External type mapping. */
    private final Map<String, UserMappedImport> externalTypeMapping;

    /**
     * Import rendering preferences.
     *
     * @param isJackson toggle for jackson serializer
     * @param isJacksonCodehaus toggle for jackson codehaus
     * @param isUseJsonSerializeOptions toggle for json serialize options
     * @param isJakarta toggle for jakarta naming
     * @param isJsonb toggle for jsonb serializer
     * @param isUseRegisterForReflection toggle for using the Quarkus RegisterForReflection annotation
     * @param dtoPackage the dto package name
     */
    record ImportRenderPrefs(
            boolean isJackson,
            boolean isJacksonCodehaus,
            boolean isUseJsonSerializeOptions,
            boolean isJakarta,
            boolean isJsonb,
            boolean isUseRegisterForReflection,
            String dtoPackage) {
    }

    /** The active import rendering preferences. */
    private final ImportRenderPrefs irp;

    private Imports(GeneratorOpts opts, boolean includeDtoImports) {
        this.includeDtoImports = includeDtoImports;

        irp = new ImportRenderPrefs(
                opts.isJackson(),
                opts.isJacksonCodehaus(),
                opts.isUseJsonSerializeOptions(),
                opts.isJakarta(),
                opts.isJsonb(),
                opts.isUseRegisterForReflection(),
                opts.dtoPackage()
                );

        externalTypeMapping = opts.getExternalTypeMapping();
    }

    /** {@return a sorted set of classes to import} */
    public SortedSet<String> get() {
        return importedClasses;
    }

    /**
     * Creates a new instance for API files.
     *
     * Adds common imports need by all APIs.
     *
     * @param opts the generator options
     * @return a new imports instance loaded with enumeration imports
     */
    public static Imports newApi(GeneratorOpts opts) {
        return new Imports(opts, true)
                .add(JaxRs.RS_STAR);
    }

    /**
     * Creates a new instance for DTO files.
     *
     * Adds common imports need by all DTOs.
     *
     * @param opts the generator options
     * @return a new imports instance loaded with enumeration imports
     */
    public static Imports newDto(GeneratorOpts opts) {
        return new Imports(opts, false)
                .add(JavaUtil.OBJECTS)
                .add(opts.isUseRegisterForReflection(), Quarkus.REGISTER_FOR_REFLECTION)
                .add(opts.isUseJsonSerializeOptions(), Jackson.JSON_SERIALIZE)
                .add(Jackson.JSON_PROPERTY, Jackson.JSON_PROPERTY_ORDER)
                .add(Jsonb.JSONB_PROPERTY, Jsonb.JSONB_PROPERTY_ORDER);
    }

    /**
     * Creates a new instance for enumeration types.
     *
     * @param opts the generator options
     * @return a new imports instance loaded with enumeration imports
     */
    public static Imports newEnum(GeneratorOpts opts) {
        return new Imports(opts, false)
                   .addEnumImports(true);
    }

    /**
     * Adds imports needed for interface templates.
     *
     * @param opts the generator options
     * @return a new imports instance
     */
    public static Imports newInterface(GeneratorOpts opts) {
        return new Imports(opts, false)
                .addMicroProfileSchema();
    }

    /**
     * Adds imports needed for extra templates.
     *
     * @param opts the generator options
     * @param tmpl the template to add imports for
     * @return a new imports instance
     */
    public static Imports newExtras(GeneratorOpts opts, ExtraTemplate tmpl) {
        return new Imports(opts, false)
                    .add(tmpl.requiredImports());
    }

    /**
     * Adds imports needed for rendering an enumeration.
     *
     * @param includeTypeAdapter flag to include typeAdaptor
     * @return this
     */
    public Imports addEnumImports(boolean includeTypeAdapter) {
        return add(irp.isJackson(), JavaUtil.OBJECTS)
            .add(irp.isUseJsonSerializeOptions(), Jackson.JSON_SERIALIZE)
            .add(irp.isUseRegisterForReflection(), Quarkus.REGISTER_FOR_REFLECTION)
            .add(Jackson.JSON_CREATOR, Jackson.JSON_VALUE)
            .add(Jsonb.JSONB_ADAPTER, Jsonb.JSON, Jsonb.JSON_STRING)
            .add(includeTypeAdapter, Jsonb.JSONB_TYPE_ADAPTER);
    }

    /**
     * Add imports for the types referenced by properties.
     *
     * @param properties the properties to add imports for
     */
    public void addPropertyImports(Collection<Property> properties) {
        properties
            .forEach(p -> add(p.reference()));
    }

    /**
     * Adds typed imports.
     *
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports add(TypedImport... classes) {
        for (TypedImport ti: classes) {
            String path = ti.path(irp);
            if (path != null) {
                importedClasses.add(path);
            }
        }
        return this;
    }

    /**
     * Adds typed imports.
     *
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports add(Collection<TypedImport> classes) {
        for (TypedImport ti: classes) {
            String path = ti.path(irp);
            if (path != null) {
                importedClasses.add(path);
            }
        }
        return this;
    }

    /**
     * Optionally adds typed imports.
     *
     * @param active option to control if the classes should be added
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports add(boolean active, TypedImport... classes) {
        if (active) {
            add(classes);
        }
        return this;
    }

    /**
     * Adds imports for a reference.
     *
     * If the reference is externally mapped, just adds an import of the class.
     *
     * Otherwise adds imports for dependency and container-wrapper classes as well.
     *
     * @param ref the reference to add imports for
     * @return the imports instance
     */
    public Imports add(Reference ref) {
        String typeName = ref.typeName().name();
        UserMappedImport mappedToExternalType = externalTypeMapping.get(typeName);
        if (mappedToExternalType != null) {
            logger.info("mapping type {} to {}", typeName, mappedToExternalType);
            add(mappedToExternalType);
            return this;
        }

        Type type = ref.refType();
        importedClasses.addAll(type.neededImports());
        addDtoImport(type);
        if (type instanceof TypeContainer tc) {
            addDtoImport(tc.innerType());
        }

        return this;
    }

    /**
     * Adds import for Schema.
     *
     * @return the imports instance
     */
    public Imports addMicroProfileSchema() {
        return add(MicroProfile.SCHEMA);
    }

    private void addDtoImport(Type type) {
        if (includeDtoImports && type.isDto()) {
            String name = type.typeName().name();
            importedClasses.add(irp.dtoPackage() + "." + name);
        }
    }

    /**
     * Remove container implementations (e.g. ArrayList) from
     * imports for use in Api files.
     * Maybe need a better way to handle this.
     */
    public void trimContainerImplementations() {
        JavaUtil.containerImplementationTypes().stream()
            .map(it -> it.path(irp))
            .forEach(importedClasses::remove);
    }
}
