package dk.mada.jaxrs.openapi;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.Reference;
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
public interface ParserTypeRef extends Reference {
    /**
     * Creates a new reference to a type name (a DTO).
     *
     * @param refTypeName the type name
     * @param validation the validation information if available
     * @return a reference to the type name
     */
    static ParserTypeRef of(TypeName refTypeName, Validation validation) {
        return ImmutableParserTypeRef.builder().refType(null).refTypeName(refTypeName).validation(validation).build();
    }

    /**
     * Creates a new reference to a type (a primitive or special type)
     *
     * @param refType the type, or null
     * @param refTypeName the type name
     * @param validation the validation information if available
     * @return a reference to the type
     */
    static ParserTypeRef of(@Nullable Type refType, TypeName refTypeName, Validation validation) {
        return ImmutableParserTypeRef.builder().refType(refType).refTypeName(refTypeName).validation(validation).build();
    }

    /** {@return the referenced type name} */
    TypeName refTypeName();

    /** {@return the referenced type, or null} */
    @Nullable
    Type refType();

    // FIXME: maybe just use typeName instead of ref?
    @Override
    default TypeName typeName() {
        return refTypeName();
    }
}
