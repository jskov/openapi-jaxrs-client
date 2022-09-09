package dk.mada.jaxrs.model.types;

import static java.util.stream.Collectors.joining;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Contains all declared type names.
 */
public final class TypeNames {
    public static final TypeName BOOLEAN = new TypeName("boolean");
    public static final TypeName BOOLEAN_WRAPPER = new TypeName("Boolean");
    public static final TypeName BYTE = new TypeName("byte");
    public static final TypeName BYTE_WRAPPER = new TypeName("Byte");
    public static final TypeName SHORT = new TypeName("short");
    public static final TypeName SHORT_WRAPPER = new TypeName("Short");
    public static final TypeName INTEGER = new TypeName("int");
    public static final TypeName INTEGER_WRAPPER = new TypeName("Integer");
    public static final TypeName LONG = new TypeName("long");
    public static final TypeName LONG_WRAPPER = new TypeName("Long");
    public static final TypeName FLOAT = new TypeName("float");
    public static final TypeName FLOAT_WRAPPER = new TypeName("Float");
    public static final TypeName DOUBLE = new TypeName("double");
    public static final TypeName DOUBLE_WRAPPER = new TypeName("Double");
    public static final TypeName STRING = new TypeName("String");
    public static final TypeName VOID = new TypeName("void");
    /** The type name of LocalDate. */
    public static final TypeName LOCAL_DATE = new TypeName("LocalDate");
    /** The type name of LocalTime. */
    public static final TypeName LOCAL_TIME = new TypeName("LocalTime");
    public static final TypeName LOCAL_DATE_TIME = new TypeName("LocalDateTime");
    public static final TypeName OFFSET_DATE_TIME = new TypeName("OffsetDateTime");
    public static final TypeName ZONED_DATE_TIME = new TypeName("ZonedDateTime");
    public static final TypeName MARKER_VALIDATION = new TypeName("<VALIDATION>");
    public static final TypeName UUID = new TypeName("UUID");
    public static final TypeName OBJECT = new TypeName("Object");
    public static final TypeName BIG_DECIMAL = new TypeName("BigDecimal");
    /** The type name for InputStream. */
    public static final TypeName INPUT_STREAM = new TypeName("InputStream");
    public static final TypeName BYTE_ARRAY = new TypeName("byte[]");
    
    /** TypeName instances indexed by their name. */
    private final Map<String, TypeName> nameToInstances = new HashMap<>();

    /** Rewritten type names. */
    private final Map<String, String> nameOverrides = new HashMap<>();

    public TypeNames() {
        
    }
    
    /**
     * Adds a rename mapping for a type name.
     *
     * This will make the TypeName instance for 'typeName' return
     * the name 'newTypeName'.
     *
     * This method should only be used after DTOs have been consolidated.
     *
     * @param typeName the name of the type to rename
     * @param newTypeName the types new name
     */
    public void rename(String typeName, String newTypeName) {
        nameOverrides.put(typeName, newTypeName);
    }

    /**
     * Creates a new type name.
     *
     * @param name name of the type
     * @return a new TypeName instance
     */
    public TypeName of(String name) {
        return nameToInstances.computeIfAbsent(name, TypeName::new);
    }

    /** {@return information about the type names} */
    public String info() {
        String sep = System.lineSeparator() + "  ";
        return new StringBuilder("Type names:").append(sep)
                .append(nameToInstances.keySet().stream()
                    .sorted((a, b) -> a.compareToIgnoreCase(b))
                    .collect(joining(sep)))
                .toString();
    }

    /**
     * A type name.
     */
    public static final class TypeName implements Comparable<TypeName> {
        /** The type name at time of declaration. */
        private String name;

        /**
         * Creates a new type name instance.
         *
         * @param name the name of the type
         */
        private TypeName(String name) {
            this.name = name;
        }

        /**
         * Returns the name of the type.
         *
         * The name may be changed between the time of declaration,
         * and the use for rendering.
         *
         * @return the name of the type
         */
        public String name() {
            return name;
            //FIXME: return nameOverrides.getOrDefault(name, name);
        }

        @Override
        public int compareTo(TypeName other) {
            return name.compareTo(other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            TypeName other = (TypeName) obj;
            return Objects.equals(name, other.name);
        }
    }
}
