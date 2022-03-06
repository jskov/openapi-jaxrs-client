package dk.mada.jaxrs.model.types;

/**
 * Type representing a container.
 */
public interface TypeContainer extends Type {
    /** {@return the type of data in the container} */
    Type innerType();

    /** {@return the java implementation used to instantiate this container} */
    String containerImplementation();

    @Override
    default boolean isContainer() {
        return true;
    }
}
