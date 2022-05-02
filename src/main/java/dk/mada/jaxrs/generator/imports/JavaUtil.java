package dk.mada.jaxrs.generator.imports;

import java.util.EnumSet;
import java.util.Set;

import dk.mada.jaxrs.generator.imports.Imports.ImportRenderPrefs;

/**
 * Java util import paths.
 */
public enum JavaUtil implements TypedImport {
    /** ArrayList. */
    ARRAY_LIST("java.util.ArrayList"),
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
        return EnumSet.of(
                JavaUtil.ARRAY_LIST,
                JavaUtil.LINKED_HASH_SET,
                JavaUtil.HASH_MAP);
    }

    /** {@return the container list-types} */
    public static Set<JavaUtil> containerListTypes() {
        return EnumSet.of(
                JavaUtil.ARRAY_LIST,
                JavaUtil.LIST);
    }

    /** {@return the container map-types} */
    public static Set<JavaUtil> containerMapTypes() {
        return EnumSet.of(
                JavaUtil.HASH_MAP,
                JavaUtil.MAP);
    }

    /** {@return the container set-types} */
    public static Set<JavaUtil> containerSetTypes() {
        return EnumSet.of(
                JavaUtil.LINKED_HASH_SET,
                JavaUtil.SET);
    }

    @Override
    public String path(ImportRenderPrefs irp) {
        return importPath;
    }

    /** {@return the import path regardless of rendering preferences} */
    public String path() {
        return importPath;
    }
}
