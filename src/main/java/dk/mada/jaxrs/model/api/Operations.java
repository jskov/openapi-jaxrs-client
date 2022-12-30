package dk.mada.jaxrs.model.api;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Operations in the model.
 */
public final class Operations {
    /** Newline. */
    private static final String NL = System.lineSeparator();

    /** Operations. */
    private final Set<Operation> ops;

    /**
     * Constructs new instance.
     *
     * @param operations the operations in the model
     */
    public Operations(Collection<Operation> operations) {
        this.ops = new HashSet<>(operations);
    }

    /** {@return all operations} */
    public Set<Operation> getAll() {
        return new HashSet<>(ops);
    }

    /** {@return the operations grouped by their group-id} */
    public Map<String, List<Operation>> getByGroup() {
        return ops.stream()
                .collect(Collectors.groupingBy(this::getGroup));
    }

    /**
     * Get the (first) group of an operation.
     *
     * @param op the operation
     * @return the first group, or Default if it has none
     */
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

    /** {@return information about operations} */
    public String info() {
        StringBuilder sb = new StringBuilder("Operations:").append(NL);
        getByGroup().entrySet().stream()
            .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
            .forEachOrdered(e -> info(sb, e.getKey(), e.getValue()));
        return sb.toString();
    }

    private void info(StringBuilder sb, String group, List<Operation> groupOps) {
        sb.append(" Group: ").append(group).append(NL);
        groupOps.forEach(op -> {
            sb.append("  Op: ").append(op.syntheticOpId()).append(NL);
            if (!op.parameters().isEmpty()) {
                sb.append("   Params:").append(NL);
                op.parameters().forEach(p ->
                    sb.append("    ").append(p.name()).append(" : ").append(p.reference()).append(NL)
                );
            }
            op.requestBody().ifPresent(body -> {
                sb.append("   Body:").append(NL);
                sb.append("     ").append(body.content().reference()).append(NL);
            });
            if (!op.responses().isEmpty()) {
                sb.append("    Responses:").append(NL);
                op.responses().stream().forEach(resp ->
                   sb.append("     ").append(resp.code()).append(" : ").append(resp.content().reference()).append(NL)
                );
            }
        });
    }
}
