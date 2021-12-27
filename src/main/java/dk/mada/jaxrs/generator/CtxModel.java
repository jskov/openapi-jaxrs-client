package dk.mada.jaxrs.generator;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Type;

/**
 * Context passed to Mustache when compiling a model.
 */
@Immutable
public interface CtxModel {
	Info info();
	Type type();
	
	String packageName();
}
