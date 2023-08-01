Manually created openapi.yaml from bolig/fun

Dies with:

Caused by: java.lang.IllegalStateException: Did not find referenced DTO TypeName[name=account]
	at dk.mada.jaxrs.openapi.Resolver.lambda$getDtoWithName$9(Resolver.java:227)
	at java.base/java.util.Optional.orElseThrow(Optional.java:403)
	at dk.mada.jaxrs.openapi.Resolver.getDtoWithName(Resolver.java:227)
	at dk.mada.jaxrs.openapi.Resolver.lambda$extractCompositeDto$3(Resolver.java:141)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
	at java.base/java.util.AbstractList$RandomAccessSpliterator.forEachRemaining(AbstractList.java:720)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:575)
	at java.base/java.util.stream.AbstractPipeline.evaluateToArrayNode(AbstractPipeline.java:260)
	at java.base/java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:616)
	at java.base/java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:622)
	at java.base/java.util.stream.ReferencePipeline.toList(ReferencePipeline.java:627)
	at dk.mada.jaxrs.openapi.Resolver.extractCompositeDto(Resolver.java:142)
	at dk.mada.jaxrs.openapi.Resolver.extractIfCompositeDto(Resolver.java:108)
	at dk.mada.jaxrs.openapi.Resolver.lambda$extractCompositeDtos$2(Resolver.java:100)

