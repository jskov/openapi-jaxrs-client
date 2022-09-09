package dk.mada.jaxrs.model.types;

import static java.util.stream.Collectors.joining;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Contains all declared type names in the model.
 *
 * The primitive types and a number of customary types
 * are predefined.
 */
public final class TypeNames {
    //-- Primitive(ish) types
    /** The type name of boolean. */
    public static final TypeName BOOLEAN = new TypeName("boolean");
    /** The type name of Boolean. */
    public static final TypeName BOOLEAN_WRAPPER = new TypeName("Boolean");
    /** The type name of byte. */
    public static final TypeName BYTE = new TypeName("byte");
    /** The type name of Byte. */
    public static final TypeName BYTE_WRAPPER = new TypeName("Byte");
    /** The type name of short. */
    public static final TypeName SHORT = new TypeName("short");
    /** The type name of Short. */
    public static final TypeName SHORT_WRAPPER = new TypeName("Short");
    /** The type name of int. */
    public static final TypeName INTEGER = new TypeName("int");
    /** The type name of Integer. */
    public static final TypeName INTEGER_WRAPPER = new TypeName("Integer");
    /** The type name of long. */
    public static final TypeName LONG = new TypeName("long");
    /** The type name of Long. */
    public static final TypeName LONG_WRAPPER = new TypeName("Long");
    /** The type name of float. */
    public static final TypeName FLOAT = new TypeName("float");
    /** The type name of Float. */
    public static final TypeName FLOAT_WRAPPER = new TypeName("Float");
    /** The type name of double. */
    public static final TypeName DOUBLE = new TypeName("double");
    /** The type name of Double. */
    public static final TypeName DOUBLE_WRAPPER = new TypeName("Double");
    /** The type name of String. */
    public static final TypeName STRING = new TypeName("String");
    /** The type name of void. */
    public static final TypeName VOID = new TypeName("void");
    /** The type name of Object. */
    public static final TypeName OBJECT = new TypeName("Object");
    //-- Date/Time types
    /** The type name of LocalDate. */
    public static final TypeName LOCAL_DATE = new TypeName("LocalDate");
    /** The type name of LocalTime. */
    public static final TypeName LOCAL_TIME = new TypeName("LocalTime");
    /** The type name of LocalDateTime. */
    public static final TypeName LOCAL_DATE_TIME = new TypeName("LocalDateTime");
    /** The type name of OffsetDateTime. */
    public static final TypeName OFFSET_DATE_TIME = new TypeName("OffsetDateTime");
    /** The type name of ZonedDateTime. */
    public static final TypeName ZONED_DATE_TIME = new TypeName("ZonedDateTime");
    //-- Others
    /** The type name for a BigDecimal. */
    public static final TypeName BIG_DECIMAL = new TypeName("BigDecimal");
    /** The type name for a byte array. */
    public static final TypeName BYTE_ARRAY = new TypeName("byte[]");
    /** The type name for InputStream. */
    public static final TypeName INPUT_STREAM = new TypeName("InputStream");
    /** The type name for a UUID. */
    public static final TypeName UUID = new TypeName("UUID");
    /** The type name for a validation marker - not a real type. */
    public static final TypeName MARKER_VALIDATION = new TypeName("<VALIDATION>");
    
    /** TypeName instances indexed by their name. */
    private final Map<String, TypeName> nameToInstances = new HashMap<>();

    /** Rewritten type names. */
    private final Map<String, String> nameOverrides = new HashMap<>();

    /**
     * Constructs a new instance.
     */
    public TypeNames() {
        nameToInstances.put(BOOLEAN.name, BOOLEAN);
        nameToInstances.put(BOOLEAN_WRAPPER.name, BOOLEAN_WRAPPER);
        nameToInstances.put(BYTE.name, BYTE);
        nameToInstances.put(BYTE_WRAPPER.name, BYTE_WRAPPER);
        nameToInstances.put(SHORT.name, SHORT );
        nameToInstances.put(SHORT_WRAPPER.name, SHORT_WRAPPER);
        nameToInstances.put(INTEGER.name, INTEGER);
        nameToInstances.put(INTEGER_WRAPPER.name, INTEGER_WRAPPER );
        nameToInstances.put(LONG.name, LONG);
        nameToInstances.put(LONG_WRAPPER.name, LONG_WRAPPER);
        nameToInstances.put(FLOAT.name, FLOAT);
        nameToInstances.put(FLOAT_WRAPPER.name, FLOAT_WRAPPER);
        nameToInstances.put(DOUBLE.name, DOUBLE);
        nameToInstances.put(DOUBLE_WRAPPER.name, DOUBLE_WRAPPER);
        nameToInstances.put(STRING.name, STRING);
        nameToInstances.put(VOID.name, VOID);
        nameToInstances.put(OBJECT.name, OBJECT );
        nameToInstances.put(LOCAL_DATE.name, LOCAL_DATE);
        nameToInstances.put(LOCAL_TIME.name, LOCAL_TIME);
        nameToInstances.put(LOCAL_DATE_TIME.name, LOCAL_DATE_TIME);
        nameToInstances.put(OFFSET_DATE_TIME.name, OFFSET_DATE_TIME);
        nameToInstances.put(ZONED_DATE_TIME.name, ZONED_DATE_TIME);
        nameToInstances.put(BIG_DECIMAL.name, BIG_DECIMAL);
        nameToInstances.put(BYTE_ARRAY.name, BYTE_ARRAY);
        nameToInstances.put(INPUT_STREAM.name, INPUT_STREAM);
        nameToInstances.put(UUID.name, UUID);
        nameToInstances.put(MARKER_VALIDATION.name, MARKER_VALIDATION);
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
