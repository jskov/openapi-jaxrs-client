Example of abstract class inheritance.

See https://swagger.io/specification/#discriminator-object

Subclasses are represented in OpenApi document with sum of all properties.
Generator should suppress those that come from the parent class.

Manually added in AbstractType:

      oneOf:
        - $ref: '#/components/schemas/TypeFoo'
        - $ref: '#/components/schemas/TypeBar'
