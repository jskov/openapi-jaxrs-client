Manually constructed from API complaints in Quarkus sbom-collector.

@Validation should in Jakarta (for a long time) be placed inside containers.

V3 spec says to place validation either on fields or getters (see https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation-spec-3.0#constraintdeclarationvalidationprocess-requirements-propertyvalidation).
Keep them on getters, until it is known for sure that they can be moved to fields, which would be nice IMO.

So not:

```java
@Valid List<Dto>
```

But

```java
List<@Valid Dto>
```

