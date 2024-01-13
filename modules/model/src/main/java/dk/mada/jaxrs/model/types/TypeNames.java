package dk.mada.jaxrs.model.types;

import static java.util.stream.Collectors.joining;

import java.util.HashMap;
import java.util.Map;

import org.jspecify.annotations.Nullable;

/**
 * Contains all declared type names in the model.
 *
 * The primitive types and a number of customary types are predefined.
 */
public final class TypeNames {
    // -- Primitive(ish) types
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
    // -- Date/Time types
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
    // -- Others
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
    /** The type name for an unknown type at parse time - not a real type. */
    public static final TypeName MARKER_UNKNOWN = new TypeName("<UNKNOWN>");
    /** The type name marking an integer of unknown format/size. */
    public static final TypeName MARKER_NOFORMAT_INT = new TypeName("<noformat-int>");
    /** The type name marking an number of unknown format/size. */
    public static final TypeName MARKER_NOFORMAT_NUMBER = new TypeName("<noformat-number>");

    /** TypeName instances indexed by their name. */
    private final Map<String, TypeName> nameToInstances = new HashMap<>();

    /**
     * Constructs a new instance.
     */
    public TypeNames() {
        nameToInstances.put(BOOLEAN.name(), BOOLEAN);
        nameToInstances.put(BOOLEAN_WRAPPER.name(), BOOLEAN_WRAPPER);
        nameToInstances.put(BYTE.name(), BYTE);
        nameToInstances.put(BYTE_WRAPPER.name(), BYTE_WRAPPER);
        nameToInstances.put(SHORT.name(), SHORT);
        nameToInstances.put(SHORT_WRAPPER.name(), SHORT_WRAPPER);
        nameToInstances.put(INTEGER.name(), INTEGER);
        nameToInstances.put(INTEGER_WRAPPER.name(), INTEGER_WRAPPER);
        nameToInstances.put(LONG.name(), LONG);
        nameToInstances.put(LONG_WRAPPER.name(), LONG_WRAPPER);
        nameToInstances.put(FLOAT.name(), FLOAT);
        nameToInstances.put(FLOAT_WRAPPER.name(), FLOAT_WRAPPER);
        nameToInstances.put(DOUBLE.name(), DOUBLE);
        nameToInstances.put(DOUBLE_WRAPPER.name(), DOUBLE_WRAPPER);
        nameToInstances.put(STRING.name(), STRING);
        nameToInstances.put(VOID.name(), VOID);
        nameToInstances.put(OBJECT.name(), OBJECT);
        nameToInstances.put(LOCAL_DATE.name(), LOCAL_DATE);
        nameToInstances.put(LOCAL_TIME.name(), LOCAL_TIME);
        nameToInstances.put(LOCAL_DATE_TIME.name(), LOCAL_DATE_TIME);
        nameToInstances.put(OFFSET_DATE_TIME.name(), OFFSET_DATE_TIME);
        nameToInstances.put(ZONED_DATE_TIME.name(), ZONED_DATE_TIME);
        nameToInstances.put(BIG_DECIMAL.name(), BIG_DECIMAL);
        nameToInstances.put(BYTE_ARRAY.name(), BYTE_ARRAY);
        nameToInstances.put(INPUT_STREAM.name(), INPUT_STREAM);
        nameToInstances.put(UUID.name(), UUID);
        nameToInstances.put(MARKER_UNKNOWN.name(), MARKER_UNKNOWN);
        nameToInstances.put(MARKER_VALIDATION.name(), MARKER_VALIDATION);
    }

    /**
     * {@return the TypeName with the given name, if it exists. Otherwise null}
     *
     * @param name the TypeName to look for
     */
    public @Nullable TypeName find(String name) {
        return nameToInstances.get(name);
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
        return "Type names:" + sep
                + nameToInstances.keySet().stream()
                        .sorted(String::compareToIgnoreCase)
                        .collect(joining(sep));
    }
}
