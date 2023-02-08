package dk.mada.jaxrs.model.types;

import java.util.List;
import java.util.Set;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.openapi.ParserTypeRef;

/**
 * Type representing a composite class (schema with allOf).
 * Since java does not allow extending multiple super classes,
 * this will instead aggregate the properties from all of
 * the referenced types.
 * Ideally, for with one reference and additional properties, this could
 * be modeled as extending+extra properties.
 */
@Immutable
public interface TypeComposite extends Type {
    /**
     * Creates a type for a composite class.
     *
     * @param packageName     the package name of DTOs
     * @param typeName        the class type name
     * @param containsTypes   the parser reference aggregated in this type
     * @return an composite type
     */
    static TypeComposite of(String packageName, TypeName typeName, List<ParserTypeRef> containsTypes) {
        return ImmutableTypeComposite.builder()
                .typeName(typeName)
                .packageName(packageName)
                .containsTypes(containsTypes).build();
    }

    /** {@return the name of the package the interface is generated in} */
    String packageName();

    /** {@return the parser references to the composite parts of this type} */
    List<ParserTypeRef> containsTypes();

    @Override
    default Set<String> neededImports() {
        return Set.of(packageName() + "." + typeName().name());
    }
}
