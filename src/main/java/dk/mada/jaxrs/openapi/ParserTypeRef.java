package dk.mada.jaxrs.openapi;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * A reference to types used during parsing.
 *
 * This is necessary, because the model may not
 * yet have been populated with DTOs that are
 * defined further down in the schema.
 *
 * When the entire scheme is parsed, these will be
 * dereferenced to proper model TypeRefs.
 */
@Immutable
public interface ParserTypeRef extends Type {
    /**
     * Creates a new type reference.
     *
     * @param refTypeName the type name
     * @param validation the validation information if available
     * @return a reference to the type name
     */
    static ParserTypeRef of(TypeName refTypeName, Validation validation) {
        return ImmutableParserTypeRef.builder().refTypeName(refTypeName).validation(validation).build();
    }

    /**
     * Validation information that applies to this
     * particular reference of the type.
     *
     * @return the validation information.
     */
    Validation validation();

    /** {@return the referenced type name} */
    TypeName refTypeName();

    FIXME: add refType, for use by all non-DTO types, make TypeConverter return this 
    
    @Override
    default TypeName typeName() {
        throw new IllegalStateException("Should not be called while parsing");
    }
}
