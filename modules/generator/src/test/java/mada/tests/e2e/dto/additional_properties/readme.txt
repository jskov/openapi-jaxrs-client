Example from https://stoplight.io/api/v1/projects/teamup/api/nodes/reference/generated_docs_public.yaml

As per https://www.apimatic.io/openapi/additionalproperties it should allow custom (additional) properties to be included.

When the additionalProperties takes the boolean value true, it calls for the type Map<String, Object>


The 3.1 spec does not explicitly mention this, whereas the 3.0 spec does.
So the fix may have to move to SchemaParserV30 if it is indeed not allowed with the 3.1 spec.
