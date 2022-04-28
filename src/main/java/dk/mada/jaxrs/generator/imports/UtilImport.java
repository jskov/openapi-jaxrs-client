package dk.mada.jaxrs.generator.imports;

import java.util.EnumSet;
import java.util.Set;

/**
 * Java util import paths.
 */
public enum UtilImport {
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

    UtilImport(String importPath) {
        this.importPath = importPath;
    }

    /** {@return the import path for the type} */
    public String importPath() {
        return importPath;
    }

    /** {@return the container implementation types} */
    public static Set<UtilImport> containerImplementationTypes() {
        return EnumSet.of(
                UtilImport.ARRAY_LIST,
                UtilImport.LINKED_HASH_SET,
                UtilImport.HASH_MAP);
    }

    /** {@return the container list-types} */
    public static Set<UtilImport> containerListTypes() {
        return EnumSet.of(
                UtilImport.ARRAY_LIST,
                UtilImport.LIST);
    }

    /** {@return the container map-types} */
    public static Set<UtilImport> containerMapTypes() {
        return EnumSet.of(
                UtilImport.HASH_MAP,
                UtilImport.MAP);
    }

    /** {@return the container set-types} */
    public static Set<UtilImport> containerSetTypes() {
        return EnumSet.of(
                UtilImport.LINKED_HASH_SET,
                UtilImport.SET);
    }
}
