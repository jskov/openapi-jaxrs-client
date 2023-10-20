This is the custom behavior for collection properties.
Client does not care about detecting present/not-present state, or treats empty as not-present.

Tests that collections that are *not* required are:
 * born null
 * default getter will create empty if missing
 * can be set/read as null

And that collections that *are required*:
 * born empty
 * cannot be nulled
 