package dk.mada.jaxrs.openapi;

import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeName;

/**
 * A reference to types used during parsing.
 *
 * This is necessary, because the model may not yet have been populated with
 * DTOs that are defined further down in the schema.
 *
 * When the entire scheme is parsed, these will be dereferenced to proper model
 * TypeRefs.
 *
 * @param refType     the referenced type - note that this may be unknown
 * @param refTypeName the referenced type name
 * @param validation  the validation
 *
 */
public record ParserTypeRef(Type refType, TypeName refTypeName, Validation validation) implements Reference {

    @Override
    public TypeName typeName() {
        return refTypeName();
    }

    /**
     * Creates a new reference to a type (a primitive or special type)
     *
     * @param refType     the type
     * @param refTypeName the type name
     * @param validation  the validation information if available
     * @return a reference to the type
     */
    static ParserTypeRef of(Type refType, TypeName refTypeName, Validation validation) {
        return new ParserTypeRef(refType, refTypeName, validation);
    }

    /**
     * Creates a new reference to a type name (a DTO).
     *
     * @param refTypeName the type name
     * @param validation  the validation information if available
     * @return a reference to the type name
     */
    static ParserTypeRef of(TypeName refTypeName, Validation validation) {
        return of(TypeUnknownAtParseTime.get(), refTypeName, validation);
    }
}
