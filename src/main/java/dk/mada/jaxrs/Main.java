package dk.mada.jaxrs;

import dk.mada.logging.LoggerConfig;

/**
 * Main class for command line invocation.
 */
public final class Main {
    private Main() {
    }

    /**
     * Will (eventually) start the generator from command line.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        LoggerConfig.loadConfig();
    }
}
