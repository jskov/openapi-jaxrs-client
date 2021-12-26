package dk.mada.jaxrs.model;

import static java.util.stream.Collectors.toSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Operations {
	private final Set<Operation> operations;

	public Operations(Collection<Operation> operations) {
		this.operations = new HashSet<>(operations);
	}
	
	public Set<String> getApiNames() {
		return operations.stream()
			.map(op -> op.group())
			.collect(toSet());
	}

	@Override
	public String toString() {
		return "Operations [operations=" + operations + "]";
	}
}
