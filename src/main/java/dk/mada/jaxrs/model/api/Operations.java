package dk.mada.jaxrs.model.api;

import static java.util.stream.Collectors.toSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Operations {
    private static final Logger logger = LoggerFactory.getLogger(Operations.class);

    private final Set<Operation> ops;

    public Operations(Collection<Operation> operations) {
        this.ops = new HashSet<>(operations);
    }

    public Map<String, List<Operation>> getByGroup() {
        return ops.stream()
                .collect(Collectors.groupingBy(this::getGroup));
    }

    private String getGroup(Operation op) {
        List<String> tags = op.tags();
        if (tags.isEmpty()) {
            return "Unknown";
        }
        return tags.get(0);
    }

    /**
     * Find longest common path of provided operations.
     * 
     * First find shortest path, use that as base.
     * Look if it prefixes all paths. If so, longest common path found.
     * If not, trim the last section of and loop around.
     */
    public String findCommonPath(List<Operation> operations) {
        if (operations.isEmpty()) {
            return "/";
        }
        if (operations.size() == 1) {
            return operations.get(0).path();
        }

        Set<String> paths = operations.stream()
                .map(Operation::path)
                .collect(toSet());

        logger.debug("Paths: {}", paths);

        String shortestPath = null;
        for (String p : paths) {
            if (shortestPath == null || p.length() < shortestPath.length()) {
                shortestPath = p;
            }
        }

        if (shortestPath.length() > 1 && shortestPath.endsWith("/")) {
            shortestPath = shortestPath.substring(0, shortestPath.length()-1);
        }

        String commonPath = "/";
        while (shortestPath.length() > 1) {
            logger.debug("Shortest potential path: {}", shortestPath);
            String matchPath = shortestPath;
            if (paths.stream().allMatch(p -> p.startsWith(matchPath))) {
                commonPath = shortestPath;
                break;
            }

            int lastSlash = shortestPath.lastIndexOf('/');
            if (lastSlash <= 0) {
                break;
            }
            shortestPath = shortestPath.substring(0, lastSlash);
        }

        if (commonPath.endsWith("/") && commonPath.length() > 1) {
            commonPath = commonPath.substring(0, commonPath.length()-1);
        }

        logger.debug("Common path: {}", commonPath);
        return commonPath;
    }

    @Override
    public String toString() {
        return "Operations [operations=" + ops + "]";
    }
}
