package dk.mada.jaxrs.model;

public class Model {
	private final Info info;
	private final Operations operations;
	private final Dtos types;

	public Model(Info info, Operations operations, Dtos types) {
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

	public Dtos types() {
		return types;
	}
	
	@Override
	public String toString() {
		return "Model [operations=" + operations + ", types=" + types + "]";
	}
}
