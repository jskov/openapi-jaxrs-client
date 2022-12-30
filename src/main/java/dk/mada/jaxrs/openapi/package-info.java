/**
 * Transforms OpenApi schema-based model to the internal model.
 *
 * This is the only package that should work with OpenApi types.
 *
 * Steps in converting the OpenApi document into the internal model:
 *
 * - Use OpenAPIParser to parse the document - Convert the OpenApi data to model types. All type references are made with ParserTypeRef
 * since there may be references to types not yet encountered. - Find and resolve name conflicts. This causes all affected TypeName
 * references to be updated. - Finally replace all ParserTypeRefs with model's TypeRefs and parser DTO instances with (possibly renamed)
 * model DTO instances.
 *
 * The model is now self-contained and immutable, ready to be used by the generators.
 */
package dk.mada.jaxrs.openapi;
