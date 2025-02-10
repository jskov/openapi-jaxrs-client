package dk.mada.jaxrs.generator.mpclient;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST common path finder.
 */
public final class CommonPathFinder {
    private static final Logger logger = LoggerFactory.getLogger(CommonPathFinder.class);
    /** The separator string. */
    private static final String SEP = "/";

    /** Constructs new instance. */
    public CommonPathFinder() {}

    /**
     * Find longest common sub-path of the paths provided.
     *
     * First find shortest path, use that as base. From this, build all potential common prefixes, by cutting path elements
     * of. Then simply search this list (which is longest to shortest) for prefixes that matches all paths.
     *
     * @param paths the paths to look through
     * @return the longest common path
     */
    public String findCommonPath(List<String> paths) {
        if (paths.isEmpty()) {
            return SEP;
        }
        if (paths.size() == 1) {
            return paths.get(0);
        }

        logger.debug("Paths: {}", paths);

        // the shortest path is the longest possible common prefix
        String shortestPath = findShortestPath(paths);
        // possible common prefix paths, longest to shortest
        List<String> potentialCommonPaths = makePotentialCommonPaths(shortestPath);

        String commonPath = potentialCommonPaths.stream()
                .filter(cp -> paths.stream().allMatch(p -> p.equals(cp) || p.startsWith(cp + SEP)))
                .findFirst()
                .orElse(SEP);

        logger.debug("Common path: {}", commonPath);
        return commonPath;
    }

    private List<String> makePotentialCommonPaths(String shortestPath) {
        List<String> potentialCommonPaths = new ArrayList<>();
        String p = shortestPath;
        int i;
        potentialCommonPaths.add(p);
        while ((i = p.lastIndexOf('/')) > 0) {
            p = p.substring(0, i);
            potentialCommonPaths.add(p);
        }
        logger.debug(" potential paths: {}", potentialCommonPaths);
        return potentialCommonPaths;
    }

    private String findShortestPath(List<String> paths) {
        String shortestPath = paths.get(0);
        for (String p : paths) {
            if (p.length() < shortestPath.length()) {
                shortestPath = p;
            }
        }

        if (shortestPath.length() > 1 && shortestPath.endsWith(SEP)) {
            shortestPath = shortestPath.substring(0, shortestPath.length() - 1);
        }
        return shortestPath;
    }
}
