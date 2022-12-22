Manually created openapi.yaml from kunderum

Two sentAt properties, one an anonymous object, the other a date-time object.

Resolver dies with:

Caused by: java.lang.IllegalStateException: Did not find renamed DTO for SentAt
	at dk.mada.jaxrs.openapi.ConflictRenamer.getConflictRenamedDto(ConflictRenamer.java:106)
	at dk.mada.jaxrs.openapi.Resolver.resolveInner(Resolver.java:282)
	at dk.mada.jaxrs.openapi.Resolver.resolve(Resolver.java:264)
	at dk.mada.jaxrs.openapi.Resolver.resolve(Resolver.java:244)
	at dk.mada.jaxrs.openapi.Resolver.derefProperty(Resolver.java:180)
	