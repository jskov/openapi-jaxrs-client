Example of (my take, bad) api where discriminator is used without the required sibling property oneOf, anyOf, allOf.
 
See https://swagger.io/specification/#discriminator-object

Example from https://github.com/jskov/openapi-jaxrs-client/issues/556
(customerroomv3)


In https://editor.swagger.io/ the "implementation" classes are simply ignored as non-referenced.
So it *is* garbage input, consistent with my reading of the specification.
(I was unsure if the allof-references in the implementations were enough to satisfy the requirement,
but clearly not)

On the other hand, in the same documentation, there is an example without the "required" anyOf/allOf on the
super type. So the wording is probably not as clear as it should have been (for me to understand it, anyway).
