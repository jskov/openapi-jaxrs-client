package dk.mada.jaxrs.model.types;

public interface TypeContainer extends Type {
    Type innerType();

    String containerImplementation();

    // TODO: map like in TypeArray
    default Type mappedInnerType() {
        return innerType();
    }
}
