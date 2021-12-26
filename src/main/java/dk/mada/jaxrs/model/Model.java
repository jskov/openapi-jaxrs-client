package dk.mada.jaxrs.model;

public class Model {
	private final Operations operations;
	private final Types types;

	public Model(Operations operations, Types types) {
		this.operations = operations;
		this.types = types;
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
