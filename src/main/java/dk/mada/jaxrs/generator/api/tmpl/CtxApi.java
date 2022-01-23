package dk.mada.jaxrs.generator.api.tmpl;

import java.util.List;
import java.util.SortedSet;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Context passed to Mustache when compiling an api.
 */
@Immutable
public interface CtxApi {
	public static ImmutableCtxApi.Builder builder() {
		return ImmutableCtxApi.builder();
	}
	
	String appName();
	String version();
	@Nullable
	String appDescription();
	@Nullable
	String infoEmail();
	
	SortedSet<String> getImports();
	
	List<CtxOperationRef> operations();
	public record CtxOperationRef(CtxApiOp operation) {}
	
	String packageName();
	String classname();

	String generatorClass();
	@Nullable
	String generatedDate();
	
	String commonPath();
	
	default boolean hideGenerationTimestamp() {
		return generatedDate() == null;
	}
}
