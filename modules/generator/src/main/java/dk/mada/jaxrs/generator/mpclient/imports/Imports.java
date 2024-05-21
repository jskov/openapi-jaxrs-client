package dk.mada.jaxrs.generator.mpclient.imports;

import java.util.Collection;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.mpclient.ExtraTemplate;
import dk.mada.jaxrs.generator.mpclient.GeneratorOpts;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeContainer;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeReference;
import dk.mada.jaxrs.model.types.TypeSet;

/**
 * Keeps track of imports for a single template, taking generator options into consideration.
 */
public final class Imports {
    private static final Logger logger = LoggerFactory.getLogger(Imports.class);

    /** Set of classes to be imported. */
    private final NavigableSet<String> importedClasses = new TreeSet<>();

    /** Flag selecting if imports should be added for DTOs. */
    private final boolean includeDtoImports;

    /** External type mapping. */
    private final Map<String, UserMappedImport> externalTypeMapping;

    /**
     * Import rendering preferences.
     *
     * @param isJackson                  toggle for jackson serializer
     * @param isUseJsonSerializeOptions  toggle for json serialize options
     * @param isJakarta                  toggle for jakarta naming
     * @param isJsonb                    toggle for jsonb serializer
     * @param isUseRegisterForReflection toggle for using the Quarkus RegisterForReflection annotation
     * @param isUseOpenapiSchema         toggle for import of openapi types
     * @param dtoPackage                 the dto package name
     */
    record ImportRenderPrefs(
            boolean isJackson,
            boolean isUseJsonSerializeOptions,
            boolean isJakarta,
            boolean isJsonb,
            boolean isUseRegisterForReflection,
            boolean isUseOpenapiSchema,
            String dtoPackage) {

        /**
         * Fix import path for types that switch from javax to jakarta package.
         *
         * @param importPath the javax import path
         * @return import path changed to jakarta, if specified by the rendering preferences. Otherwise returns the javax import
         *         path.
         */
        public String fixJavaxJakartaImportPath(String importPath) {
            if (isJakarta()) {
                return importPath.replace("javax", "jakarta");
            } else {
                return importPath;
            }
        }
    }

    /** The active import rendering preferences. */
    private final ImportRenderPrefs irp;

    private Imports(GeneratorOpts opts, boolean includeDtoImports) {
        this.includeDtoImports = includeDtoImports;

        irp = new ImportRenderPrefs(
                opts.isJackson(),
                opts.isUseJsonSerializeOptions(),
                opts.isJakarta(),
                opts.isJsonb(),
                opts.isUseRegisterForReflection(),
                opts.getUseOpenapiSchema(),
                opts.dtoPackage());

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
     * Creates a new instance for DTO POJO files.
     *
     * Adds common imports need by all DTOs.
     *
     * @param opts      the generator options
     * @param hasParams true if the DTO has any properties
     * @return a new imports instance loaded with enumeration imports
     */
    public static Imports newDto(GeneratorOpts opts, boolean hasParams) {
        Imports res = new Imports(opts, false)
                .add(JavaUtil.OBJECTS)
                .add(opts.isUseRegisterForReflection(), Quarkus.REGISTER_FOR_REFLECTION)
                .add(opts.isUseJsonSerializeOptions(), Jackson.JSON_SERIALIZE)
                .add(opts.isUsePropertyOrderAnnotation(), Jackson.JSON_PROPERTY_ORDER, Jsonb.JSONB_PROPERTY_ORDER);
        if (hasParams) {
            res = res.add(Jackson.JSON_PROPERTY, Jsonb.JSONB_PROPERTY);
        }
        return res;
    }

    /**
     * Creates a new instance for DTO record files.
     *
     * Adds common imports need by all DTOs.
     *
     * @param opts      the generator options
     * @param hasParams true if the DTO has any properties
     * @return a new imports instance loaded with enumeration imports
     */
    public static Imports newRecord(GeneratorOpts opts, boolean hasParams) {
        Imports res = new Imports(opts, false)
                .add(opts.isUseRegisterForReflection(), Quarkus.REGISTER_FOR_REFLECTION)
                .add(opts.isUseJsonSerializeOptions(), Jackson.JSON_SERIALIZE)
                .add(opts.isUsePropertyOrderAnnotation(), Jackson.JSON_PROPERTY_ORDER, Jsonb.JSONB_PROPERTY_ORDER);
        if (hasParams) {
            res = res.add(Jackson.JSON_PROPERTY, Jsonb.JSONB_PROPERTY);
        }
        return res;
    }

    /**
     * Creates a new instance for enumeration types.
     *
     * @param opts           the generator options
     * @param includeObjects flag to include Objects
     * @return a new imports instance loaded with enumeration imports
     */
    public static Imports newEnum(GeneratorOpts opts, boolean includeObjects) {
        return new Imports(opts, false)
                .addEnumImports(true, includeObjects);
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
     * @param includeObjects     flag to include Objects
     * @return this
     */
    public Imports addEnumImports(boolean includeTypeAdapter, boolean includeObjects) {
        return add(irp.isJackson() && includeObjects, JavaUtil.OBJECTS)
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
        for (TypedImport ti : classes) {
            ti.path(irp).ifPresent(importedClasses::add);
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
        for (TypedImport ti : classes) {
            ti.path(irp).ifPresent(importedClasses::add);
        }
        return this;
    }

    /**
     * Optionally adds typed imports.
     *
     * @param active  option to control if the classes should be added
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
     * Adds import for a reference - the type it references.
     *
     * @param typeRef the type reference
     * @return the imports instance
     */
    public Imports add(Reference typeRef) {
        return add(typeRef.refType());
    }

    /**
     * Adds imports for a type.
     *
     * If the type is externally mapped, just adds an import of the class.
     *
     * Otherwise adds imports for dependency and container-wrapper classes as well.
     *
     * @param type the type to add imports for
     * @return the imports instance
     */
    public Imports add(Type type) {
        String typeName = type.typeName().name();
        UserMappedImport mappedToExternalType = externalTypeMapping.get(typeName);
        if (mappedToExternalType != null) {
            logger.info("mapping type {} to {}", typeName, mappedToExternalType);
            add(mappedToExternalType);
            return this;
        }

        importedClasses.addAll(type.neededImports());
        addJavaContainerImports(type);
        if (type instanceof TypeContainer tc) {
            add(tc.innerType());
        } else {
            addDtoImport(type);
        }

        return this;
    }

    private void addJavaContainerImports(Type t) {
        Set<JavaUtil> addImports = Set.of();
        if (t instanceof TypeReference tr) {
            // Not sure this is the right place, but
            // if inner is a reference, it may be a container type
            // These are only used for signatures, so only need the generic type
            addJavaGenericContainerImports(tr.refType());
        } else if (t instanceof TypeArray) {
            addImports = JavaUtil.containerListImplementationTypes();
        } else if (t instanceof TypeMap) {
            addImports = JavaUtil.containerMapImplementationTypes();
        } else if (t instanceof TypeSet) {
            addImports = JavaUtil.containerSetImplementationTypes();
        }

        addImports.stream()
                .map(JavaUtil::path)
                .forEach(importedClasses::add);
    }

    // FIXME: this should come out of the (outer) type's neededImports, surely?
    private void addJavaGenericContainerImports(Type t) {
        if (t instanceof TypeArray) {
            importedClasses.add(JavaUtil.containerListType().path());
        } else if (t instanceof TypeMap) {
            importedClasses.add(JavaUtil.containerMapType().path());
        } else if (t instanceof TypeSet) {
            importedClasses.add(JavaUtil.containerSetType().path());
        }
    }

    /**
     * Adds import for Schema.
     *
     * @return the imports instance
     */
    public Imports addMicroProfileSchema() {
        if (irp.isUseOpenapiSchema) {
            return add(MicroProfile.SCHEMA);
        } else {
            return this;
        }
    }

    private void addDtoImport(Type type) {
        if (includeDtoImports && type.isDto()) {
            String name = type.typeName().name();
            importedClasses.add(irp.dtoPackage() + "." + name);
        }
    }

    /**
     * Remove container implementations (e.g. ArrayList) from imports for use in Api files. Maybe need a better way to
     * handle this.
     */
    public void trimContainerImplementations() {
        JavaUtil.containerImplementationTypes().stream()
                .map(it -> it.path(irp))
                .forEach(it -> it.ifPresent(importedClasses::remove));
    }
}
