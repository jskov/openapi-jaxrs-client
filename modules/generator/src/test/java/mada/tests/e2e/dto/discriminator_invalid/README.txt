Example of (bad) api where discriminator is used without the required sibling property oneOf, anyOf, allOf.
 
See https://swagger.io/specification/#discriminator-object

Example from https://github.com/jskov/openapi-jaxrs-client/issues/556
(customerroomv3)


In https://editor.swagger.io/ the "implementation" classes are simply ignored as non-referenced.
So it *is* garbage input, consistent with my reading of the specification.
(I was unsure if the allof-references in the implementations were enough to satisfy the requirement,
but clearly not)
