package dk.mada.jaxrs.generator.mpclient.imports;

import dk.mada.jaxrs.generator.mpclient.imports.Imports.ImportRenderPrefs;
import java.util.EnumSet;
import java.util.Optional;
import java.util.Set;

/**
 * Java util import paths.
 */
public enum JavaUtil implements TypedImport {
    /** ArrayList. */
    ARRAY_LIST("java.util.ArrayList"),
    /** Arrays. */
    ARRAYS("java.util.Arrays"),
    /** HashMap. */
    HASH_MAP("java.util.HashMap"),
    /** LinkedHashSet. */
    LINKED_HASH_SET("java.util.LinkedHashSet"),
    /** List. */
    LIST("java.util.List"),
    /** Map. */
    MAP("java.util.Map"),
    /** Objects. */
    OBJECTS("java.util.Objects"),
    /** Set. */
    SET("java.util.Set");

    /** The import path for the type. */
    private final String importPath;

    JavaUtil(String importPath) {
        this.importPath = importPath;
    }

    /** {@return the container implementation types} */
    public static Set<JavaUtil> containerImplementationTypes() {
        return EnumSet.of(JavaUtil.ARRAY_LIST, JavaUtil.LINKED_HASH_SET, JavaUtil.HASH_MAP);
    }

    /** {@return the generic container list-type} */
    public static JavaUtil containerListType() {
        return JavaUtil.LIST;
    }

    /** {@return the container list-types (including implementation)} */
    public static Set<JavaUtil> containerListImplementationTypes() {
        return EnumSet.of(JavaUtil.ARRAY_LIST, JavaUtil.LIST);
    }

    /** {@return the container implementation list-type} */
    public static JavaUtil containerListImplementationTypeOnly() {
        return JavaUtil.ARRAY_LIST;
    }

    /** {@return the genetic container map-type} */
    public static JavaUtil containerMapType() {
        return JavaUtil.MAP;
    }

    /** {@return the container map-types (including implementation)} */
    public static Set<JavaUtil> containerMapImplementationTypes() {
        return EnumSet.of(JavaUtil.HASH_MAP, JavaUtil.MAP);
    }

    /** {@return the container implementation map-type} */
    public static JavaUtil containerMapImplementationTypeOnly() {
        return JavaUtil.HASH_MAP;
    }

    /** {@return the generic container set-type} */
    public static JavaUtil containerSetType() {
        return JavaUtil.SET;
    }

    /** {@return the container set-types (including implementation)} */
    public static Set<JavaUtil> containerSetImplementationTypes() {
        return EnumSet.of(JavaUtil.LINKED_HASH_SET, JavaUtil.SET);
    }

    /** {@return the container implementation set-type} */
    public static JavaUtil containerSetImplementationTypeOnly() {
        return JavaUtil.LINKED_HASH_SET;
    }

    @Override
    public Optional<String> path(ImportRenderPrefs irp) {
        return Optional.of(importPath);
    }

    /** {@return the import path regardless of rendering preferences} */
    public String path() {
        return importPath;
    }
}
