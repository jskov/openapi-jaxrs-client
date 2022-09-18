Example extracted from a .Net API.

Causes validation limit "100" to be rendered as "1E+2".


Validation minimum and maximum are captured as BigDecimal in swagger parser.

This must be able to be used as textual input (for @DecimalMin/@DecimalMax)
and for regular primitives (for @Min/@Max).

Since BigDecimal renders "funny", limit the value to long when
used for primitive type validation (@Min/@Max takes a long).

Note that both annotation types are ignored for float/double.
