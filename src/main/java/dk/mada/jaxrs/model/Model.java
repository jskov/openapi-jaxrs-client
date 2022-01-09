package dk.mada.jaxrs.model;

import dk.mada.jaxrs.model.types.Types;

public class Model {
	private final Info info;
	private final Operations operations;
	private final Types types;

	public Model(Info info, Operations operations, Types types) {
		this.info = info;
		this.operations = operations;
		this.types = types;
	}

	public Info info() {
		return info;
	}
	
	public Operations operations() {
		return operations;
	}

	public Types types() {
		return types;
	}
	
	@Override
	public String toString() {
		return "Model [operations=" + operations + ", types=" + types + "]";
	}
}
