package dk.mada.jaxrs.generator;

import org.immutables.value.Value.Immutable;

@Immutable
public interface GeneratorOpts {
	String apiPackage();
	String dtoPackage();
}
