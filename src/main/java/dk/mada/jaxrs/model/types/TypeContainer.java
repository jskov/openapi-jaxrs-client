package dk.mada.jaxrs.model.types;

/**
 * Type representing a container.
 */
public interface TypeContainer extends Type {
    /** {@return the type of data in the container} */
    Type innerType();

    /** {@return the java implementation used to instantiate this container} */
    String containerImplementation();

    /**
     * Returns the "mapped" data type in the container.
     *
     * The type is mapped, meaning that some types may be changed
     * to something else depending on user configuration (e.g. a
     * LocalTime in the specification can be rendered as a DTO
     * with that name, or mapped to the JSE java.time.LocalTime).
     *
     * @return the mapped container type
     */
    // TODO: map like in TypeArray
    default Type mappedInnerType() {
        return innerType();
    }

    @Override
    default boolean isContainer() {
        return true;
    }
}
