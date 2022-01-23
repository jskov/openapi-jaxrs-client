package dk.mada.jaxrs.model;

import dk.mada.jaxrs.model.api.Operations;
import dk.mada.jaxrs.model.types.Types;

public record Model(Info info, Operations operations, Types types) {
}
