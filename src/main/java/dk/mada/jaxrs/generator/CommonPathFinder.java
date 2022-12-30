package dk.mada.jaxrs.generator;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST common path finder.
 */
public class CommonPathFinder {
    private static final Logger logger = LoggerFactory.getLogger(CommonPathFinder.class);

    /**
     * Find longest common sub-path of the paths provided.
     *
     * First find shortest path, use that as base. Look if it prefixes all paths. If so, longest common path found. If not,
     * trim the last section of and loop around.
     *
     * @param paths the paths to look through
     * @return the longest common path
     */
    public String findCommonPath(List<String> paths) {
        if (paths.isEmpty()) {
            return "/";
        }
        if (paths.size() == 1) {
            return paths.get(0);
        }

        logger.debug("Paths: {}", paths);

        String shortestPath = paths.get(0);
        for (String p : paths) {
            if (p.length() < shortestPath.length()) {
                shortestPath = p;
            }
        }

        if (shortestPath.length() > 1 && shortestPath.endsWith("/")) {
            shortestPath = shortestPath.substring(0, shortestPath.length() - 1);
        }

        String commonPath = "/";
        while (shortestPath.length() > 1) {
            logger.debug("Shortest potential path: {}", shortestPath);
            String matchPath = shortestPath;
            if (paths.stream().allMatch(p -> p.equals(matchPath) || p.startsWith(matchPath + "/"))) {
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
            commonPath = commonPath.substring(0, commonPath.length() - 1);
        }

        logger.debug("Common path: {}", commonPath);
        return commonPath;
    }
}
