package dk.mada.jaxrs.model.types;

import java.util.HashMap;
import java.util.Map;

public class TypeNames {
    public record TypeName(String name) {}

    private static final Map<String, TypeName> NAME_TO_INSTANCES = new HashMap<>();

    public static TypeName of(String name) {
        return NAME_TO_INSTANCES.computeIfAbsent(name, TypeName::new);
    }
}
