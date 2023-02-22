Example of abstract class inheritance.

See https://swagger.io/specification/#discriminator-object

Subclasses are represented in OpenApi document with sum of all properties.
Generator should suppress those that come from the parent class.

Manually added in AbstractType:

      oneOf:
        - $ref: '#/components/schemas/TypeFoo'
        - $ref: '#/components/schemas/TypeBar'

New case, oneOf as only property data:

    # Manually added
    WithRef:
      type: object
      properties:
        combined:
          oneOf:
            - $ref: '#/components/schemas/TypeFoo'
            - $ref: '#/components/schemas/TypeBar'

The java (library=microprofile) generator makes a combined WithRefCombined
for this case, which combines all the properties of the oneOf-types.
The java (library default) generates a more elaborate type that tries to determine
the actual sub-type using deserializer validation.

Use the simple approach for now, although it is crap for all manner of reasons.
