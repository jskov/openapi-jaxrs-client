package dk.mada.jaxrs.model.api;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Operations {
	private final Set<Operation> operations;

	public Operations(Collection<Operation> operations) {
		this.operations = new HashSet<>(operations);
	}
	
	public Map<String, List<Operation>> getByGroup() {
		return operations.stream()
				.collect(Collectors.groupingBy(this::getGroup));
	}
	
	private String getGroup(Operation op) {
		List<String> tags = op.tags();
		if (tags.isEmpty()) {
			return "Unknown";
		}
		return tags.get(0);
	}
	
	
	@Override
	public String toString() {
		return "Operations [operations=" + operations + "]";
	}
}
