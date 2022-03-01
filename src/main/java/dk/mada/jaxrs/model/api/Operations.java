package dk.mada.jaxrs.model.api;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class Operations {
    private final Set<Operation> ops;

    public Operations(Collection<Operation> operations) {
        this.ops = new HashSet<>(operations);
    }

    public Map<String, List<Operation>> getByGroup() {
        return ops.stream()
                .collect(Collectors.groupingBy(this::getGroup));
    }

    public List<String> getPaths() {
        return ops.stream()
                .map(Operation::path)
                .toList();
    }
    
    private String getGroup(Operation op) {
        List<String> tags = op.tags();
        if (tags.isEmpty()) {
            return "Default";
        }
        return tags.get(0);
    }
    
    @Override
    public String toString() {
        return "Operations [operations=" + ops + "]";
    }
}
