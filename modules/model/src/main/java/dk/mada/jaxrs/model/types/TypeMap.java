package dk.mada.jaxrs.model.types;

import org.immutables.value.Value.Immutable;

/**
 * Keys in a map must be a scalar string.
 *
 * https://swagger.io/specification/#format
 */
@Immutable
public interface TypeMap extends TypeContainer {
    /**
     * Creates a new map-type instance.
     *
     * The key-type is hardwired to String, but the inner-type is as specified.
     *
     * @param typeNames the type names instance
     * @param innerType the type of the map values
     * @return a new map-type.
     */
    static TypeMap of(TypeNames typeNames, Type innerType) {
        return ImmutableTypeMap.builder()
                .typeNames(typeNames)
                .innerType(innerType)
                .isFreeFormObject(false)
                .build();
    }

    /**
     * Creates a new free-form object-type instance.
     *
     * This has a hardwired value type of Object.
     *
     * @param typeNames the type names instance
     * @return a new map-type
     * @see <a href="https://swagger.io/docs/specification/v3_0/data-models/dictionaries/">swagger docs</a> (search for Free-Form Objects)
     */
    static TypeMap newFreeFormObject(TypeNames typeNames) {
        return ImmutableTypeMap.builder()
                .typeNames(typeNames)
                .innerType(TypeObject.get())
                .isFreeFormObject(true)
                .build();
    }

    /** {@return true if this is a free-from object} */
    boolean isFreeFormObject();

    @Override
    default String containerImplementation() {
        return "HashMap";
    }

    @Override
    default String containerImplementationDeclaration() {
        String innerName = innerType().wrapperTypeName().name();
        return "HashMap<String, " + innerName + ">";
    }

    /**
     * {@return the type name}
     *
     * Note that this needs to be resolved late (when accessed) and not when created. This ensures that conflict-renaming of
     * the inner-type is reflected in the final type name.
     */
    @Override
    default TypeName typeName() {
        String innerName = innerType().wrapperTypeName().name();
        return typeNames().of("Map<String, " + innerName + ">");
    }
}
