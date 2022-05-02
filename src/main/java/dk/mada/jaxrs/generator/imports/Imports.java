package dk.mada.jaxrs.generator.imports;

import static dk.mada.jaxrs.generator.imports.Jackson.*;
import static dk.mada.jaxrs.generator.imports.Jsonb.*;
import static dk.mada.jaxrs.generator.imports.MicroProfile.*;
import static dk.mada.jaxrs.generator.imports.Quarkus.*;
import static dk.mada.jaxrs.generator.imports.JavaTime.*;
import static dk.mada.jaxrs.generator.imports.JavaUtil.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
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

    private static final String IOEXCEPTION = "java.io.IOException";

//    /** Generator options. */
//    private final GeneratorOpts opts;

    /** Set of classes to be imported.*/
    private final SortedSet<String> importedClasses = new TreeSet<>();

    /** Flag selecting if imports should be added for DTOs. */
    private final boolean includeDtoImports;

    /** External type mapping. */
    private final Map<String, String> externalTypeMapping;

    /**
     * Import rendering preferences.
     */
    record ImportRenderPrefs(
            boolean isJackson,
            boolean isJacksonCodehaus,
            boolean isUseJsonSerializeOptions,
            boolean isJakarta,
            boolean isJsonb,
            String dtoPackage) {
    }

    /** The active import rendering preferences. */
    private final ImportRenderPrefs irp;

    private Imports(GeneratorOpts opts, boolean includeDtoImports) {
//        this.opts = opts;
        this.includeDtoImports = includeDtoImports;

        irp = new ImportRenderPrefs(
                opts.isJackson(),
                opts.isJacksonCodehaus(),
                opts.isUseJsonSerializeOptions(),
                opts.isJakarta(),
                opts.isJsonb(),
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
                .javax("javax.ws.rs.*");
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
                .util(OBJECTS)
                .quarkus(opts.isUseRegisterForReflection(), REGISTER_FOR_REFLECTION)
                .jackson(opts.isUseJsonSerializeOptions(), JSON_SERIALIZE)
                .jackson(JSON_PROPERTY, JSON_PROPERTY_ORDER)
                .jsonb(JSONB_PROPERTY, JSONB_PROPERTY_ORDER);
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
                .addSchema();
    }

    /**
     * Adds imports needed for extra templates.
     *
     * @param opts the generator options
     * @param tmpl the template to add imports for
     * @return a new imports instance
     */
    public static Imports newExtras(GeneratorOpts opts, ExtraTemplate tmpl) {
        var imports = new Imports(opts, false);
        imports
            .add(IOEXCEPTION);

        if (tmpl == ExtraTemplate.LOCAL_DATE_JACKSON_DESERIALIZER) {
            imports
                .time(DATE_TIME_FORMATTER, LOCAL_DATE)
                .jackson(JSON_PARSER, DESERIALIZATION_CONTEXT, JSON_DESERIALIZER);
        }
        if (tmpl == ExtraTemplate.LOCAL_DATE_JACKSON_SERIALIZER) {
            imports
                .time(DATE_TIME_FORMATTER, LOCAL_DATE)
                .jackson(JSON_GENERATOR, SERIALIZER_PROVIDER, JSON_SERIALIZER, JSON_PROCESSING_EXCEPTION);
        }
        if (tmpl == ExtraTemplate.LOCAL_DATE_TIME_JACKSON_DESERIALIZER) {
            imports
                .time(DATE_TIME_FORMATTER, LOCAL_DATE_TIME)
                .jackson(JSON_PARSER, DESERIALIZATION_CONTEXT, JSON_DESERIALIZER, JSON_PROCESSING_EXCEPTION);
        }
        if (tmpl == ExtraTemplate.LOCAL_DATE_TIME_JACKSON_SERIALIZER) {
            imports
                .time(DATE_TIME_FORMATTER, LOCAL_DATE_TIME)
                .jackson(JSON_GENERATOR, SERIALIZER_PROVIDER, JSON_SERIALIZER, JSON_PROCESSING_EXCEPTION);
        }
        if (tmpl == ExtraTemplate.OFFSET_DATE_TIME_JACKSON_DESERIALIZER) {
            imports
                .time(DATE_TIME_FORMATTER, DATE_TIME_PARSE_EXCEPTION, LOCAL_DATE_TIME, OFFSET_DATE_TIME, ZONE_ID)
                .jackson(JSON_PARSER, DESERIALIZATION_CONTEXT, JSON_DESERIALIZER, JSON_PROCESSING_EXCEPTION);
        }
        if (tmpl == ExtraTemplate.OFFSET_DATE_TIME_JACKSON_SERIALIZER) {
            imports
                .time(DATE_TIME_FORMATTER, OFFSET_DATE_TIME)
                .jackson(JSON_GENERATOR, SERIALIZER_PROVIDER, JSON_SERIALIZER, JSON_PROCESSING_EXCEPTION);
        }
        return imports;
    }

    /**
     * Adds imports needed for rendering an enumeration.
     *
     * @param includeTypeAdapter flag to include typeAdaptor
     * @return this
     */
    public Imports addEnumImports(boolean includeTypeAdapter) {
        return util(irp.isJackson(), OBJECTS)
            .jackson(irp.isUseJsonSerializeOptions(), JSON_SERIALIZE)
            .jackson(JSON_CREATOR, JSON_VALUE)
            .jsonb(JSONB_ADAPTER, JSON, JSON_STRING)
            .jsonb(includeTypeAdapter, JSONB_TYPE_ADAPTER);
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
     * Adds imports for javax-class.
     *
     * If jakarta-option is selected, will replace "javax" with "jakarta".
     *
     * @param name the class to add import for
     * @return the imports instance
     */
    public Imports javax(String name) {
        if (irp.isJakarta()) {
            name = name.replace("javax", "jakarta");
        }
        importedClasses.add(name);
        return this;
    }

    /**
     * Adds optional imports if Jackson is the selected serializer.
     *
     * @param enable option to control if the classes should be added
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports jackson(boolean enable, Jackson... classes) {
        if (enable) {
            jackson(classes);
        }
        return this;
    }

    /**
     * Adds imports if the Jackson is the selected serializer.
     *
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports jackson(Jackson... classes) {
        if (!irp.isJackson()) {
            return this;
        }

        for (Jackson ji : classes) {
            add(ji.path(irp));
        }
        return this;
    }

    /**
     * Adds optional imports if Jsonb is the selected serializer.
     *
     * @param enable option to control if the classes should be added
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports jsonb(boolean enable, Jsonb... classes) {
        if (enable) {
            jsonb(classes);
        }
        return this;
    }

    /**
     * Adds imports if Jsonb is the selected serializer.
     *
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports jsonb(Jsonb... classes) {
        if (irp.isJsonb()) {
            for (Jsonb ji : classes) {
                add(ji.importPath());
            }
        }
        return this;
    }

    /**
     * Adds imports for java time types.
     *
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports time(JavaTime... classes) {
        for (JavaTime ti : classes) {
            add(ti.importPath());
        }
        return this;
    }

    /**
     * Adds imports for java util types.
     *
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports util(JavaUtil... classes) {
        for (JavaUtil ui : classes) {
            add(ui.importPath());
        }
        return this;
    }

    /**
     * Adds optional imports for java util types.
     *
     * @param enable option to control if the classes should be added
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports util(boolean enable, JavaUtil... classes) {
        if (enable) {
            for (JavaUtil ui : classes) {
                add(ui.importPath());
            }
        }
        return this;
    }

    /**
     * Adds imports for quarkus types.
     *
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports quarkus(Quarkus... classes) {
        for (Quarkus qi : classes) {
            add(qi.importPath());
        }
        return this;
    }

    /**
     * Adds optional imports for quarkus types.
     *
     * @param enable option to control if the classes should be added
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports quarkus(boolean enable, Quarkus... classes) {
        if (enable) {
            for (Quarkus qi : classes) {
                add(qi.importPath());
            }
        }
        return this;
    }

    /**
     * Adds imports for MicroProfile types.
     *
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports mp(MicroProfile... classes) {
        for (MicroProfile mpi : classes) {
            add(mpi.importPath());
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
        String mappedToExternalType = externalTypeMapping.get(typeName);
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
    public Imports addSchema() {
        return mp(SCHEMA);
    }

    private void addDtoImport(Type type) {
        if (includeDtoImports && type.isDto()) {
            String name = type.typeName().name();
            importedClasses.add(irp.dtoPackage() + "." + name);
        }
    }

    /**
     * Adds imports for the specified (fully qualified) class names.
     *
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports add(String... classes) {
        importedClasses.addAll(Arrays.asList(classes));
        return this;
    }

    /**
     * Adds optional imports for the specified (fully qualified) class names.
     *
     * @param include option to control if the classes should be added
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports add(boolean include, String... classes) {
        if (include) {
            add(classes);
        }
        return this;
    }

    /**
     * Remove container implementations (e.g. ArrayList) from
     * imports for use in Api files.
     * Maybe need a better way to handle this.
     */
    public void trimContainerImplementations() {
        JavaUtil.containerImplementationTypes()
            .forEach(ui -> importedClasses.remove(ui.importPath()));
    }
}
