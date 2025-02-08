package dk.mada.jaxrs.model;

import java.util.List;

import org.jspecify.annotations.Nullable;

/**
 * Additional information provided on a type reference.
 */
public record AdditionalInfo(@Nullable String description, List<String> examples) {

    public static AdditionalInfo EMPTY = new AdditionalInfo(null, List.of());
}
