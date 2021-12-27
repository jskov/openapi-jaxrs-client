package dk.mada.jaxrs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.logging.LoggerConfig;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		LoggerConfig.loadConfig();
		System.out.println("main");
		logger.trace("TRACE");
		logger.debug("DEBUG");
		logger.info("INFO");
		logger.warn("WARN");
		logger.error("ERROR");
		System.out.println("out");
	}
}
