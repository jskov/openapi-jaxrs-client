
The naming of *things* can be (partly) controlled via a number of operators.

`OPERATIONNAME`, `TYPENAME` and `PROPERTYNAME` are based on the [Java spec for identifiers](https://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.8). They will convert any non-identifier character to '_'. A hyphen ('-') will be removed and the next character upper-cased.

The `-EDGE` variants will downcase all letters, except on edges between upper/down-case.
For example (for properties): `fooBAR -> fooBar`, `FOOBar -> fooBar`, and `FOOBAR -> foobar`.

The operators are

* `APPEND/value/`: Appends the value to the input.
* `DOWNCASE`: Converts the input to lower case.
* `LITERAL/value/`: Returns the provided value.
* `PARAMETERNAME`: Converts the input to a valid java identifier (first letter lower case)  
  Aliases: `OPERATIONNAME`, `PROPERTYNAME`
* `PARAMETERNAME-EDGE`: Converts the input to a valid java identifier (first letter lower case, downcase on edges)  
  Aliases: `OPERATIONNAME-EDGE`, `PROPERTYNAME-EDGE`
* `PREPEND/value/`: Prepends the value to the input.
* `REGEXP/pattern/replacement/`: Will match input against pattern and substitute all matches with replacement.
* `TYPENAME`: Converts the input to a valid java identifier (first letter upper case)
* `TYPENAME-EDGE`: Converts the input to a valid java identifier (first letter upper case, downcase on edges)
* `UPCASE`: Converts the input to upper case.

You can specify a number of operators, separated by ';'. They will be applied left-to-right.

    
## **naming-rename-case-conflicts**

Allows you to enable renaming of types that would conflict (overlap) on a non-case-sensitive filesystem (as used on Windows).

So if there are types `FooBar` and `Foobar`, enabling this option will cause them to be rendered as `FooBar` and `FoobarX`.

The types are assigned names in order selected by [naming-rename-case-conflicts-order](#naming-rename-case-conflicts-order). Any type that conflicts with an already assigned name will be renamed.

The option [naming-rules-type-conflict-renaming](#naming-rules-type-conflict-renaming) controls how the type is renamed.

Note that the naming changes are also applied to the type's MP @Schema name.

    default value: false

## **naming-rename-case-conflicts-order**

Allows you to control how the conflict-renaming orders the schemas before resolving collisions.

Use `document-order` to process the schemas in their OpenApi document declaration order.
Use `name-order` to process the schemas in their naming order (case sensitive).

	default value: document-order

## **naming-rules-api**

Allows you to control the naming of API classes using the operators described above.

The API group (or [generator-api-default-name](./Configuration-generator.md#generator-api-default-name) if missing) value is given as input.

    default value: TYPENAME; REGEXP/Api$//; APPEND/Api/

## **naming-rules-enum-constant**

Allows you to control the naming of enumeration constants using the operators described above.

The enumeration value is given as input.

    default value: REGEXP/-/_/; TYPENAME; UPCASE

## **naming-rules-enum-number-constant**

Allows you to control the naming of enumeration number constants using the operators described above.

The enumeration value is given as input.

    default value: REGEXP/-/NEG_/; PREPEND/NUMBER_/

**naming-rules-entity**

Allows you to control the naming of the entity parameter in APIs using the operators described above.

The type name is given as input.

    default value: LITERAL/dto/

## **naming-rules-mp-schema**

Allows you to control the MP @Schema naming of types using the operators described above.

If your application is not only a REST client, but also passes the upstream types through
to downstream REST clients, this option can be used to alter (downstream) naming.

The @Schema options only affect the generation of OpenApi document for your application,
not its deserialization of upstream types *in* your application.

The type name is given as input.

    default value: (the value of naming-rules-type)

## **naming-rules-multipart-type**

Allows you to control the naming of synthetic multipart types created for form parameters.

The resource method's name is given as input.

    default value: PREPEND/Multipart-/; TYPENAME

## **naming-rules-operation**

Allows you to control the naming of operations (without specific operation ids) using the operators described above.

A synthetic id, based on the resource path and http-method is provided as input.

Note that if the operation's id has been specified, you should use *naming-rules-operationid*.

    default value: OPERATIONNAME


## **naming-rules-operationid**

Allows you to transform operationIds using the operators described above.

The operationId is provided as input.

    default value:


## **naming-rules-parameter**

Allows you to control the naming of parameters using the operators described above.

The parameter name is given as input.

    default value: REGEXP/_/-/; PARAMETERNAME

## **naming-rules-property**

Allows you to control the naming of properties using the operators described above.

The property name is given as input.

    default value: REGEXP/_/-/; PROPERTYNAME

## **naming-rules-type**

Allows you to control the naming of types using the operators described above.

The type name is given as input.

    default value: TYPENAME


## **naming-rules-type-conflict-renaming**

Allows you to control how conflicting types are renamed if [naming-rename-case-conflicts](#naming-rename-case-conflicts) is enabled.

    default value: APPEND/X/

