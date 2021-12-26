package mada.fixture;

import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Process helpers akin to Groovy's Process extensions.
 */
public class ProcessHelper {
	private static final Logger logger = LoggerFactory.getLogger(ProcessHelper.class);

	private ProcessHelper() {
	}

	/**
	 * Waits for process output.
	 * 
	 * @throws IllegalStateException if interrupted
	 */
	public static final int waitForProcessOutput(Process process, OutputStream output) {
		Thread outputConsumerThread = new Thread(new ByteDumper(process.getInputStream(), output));
		outputConsumerThread.start();

		try {
			joinAndWait(process, outputConsumerThread);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new IllegalStateException("Interruped while waiting for process output", e);
		} finally {
			try {
				process.getErrorStream().close();
			} catch (IOException ignore) {
				logger.warn("ProcessHelper ES close failed", ignore);
			}
			try {
				process.getOutputStream().close();
			} catch (IOException ignore) {
				logger.warn("ProcessHelper OS close failed", ignore);
			}
			try {
				process.getInputStream().close();
			} catch (IOException ignore) {
				logger.warn("ProcessHelper IS close failed", ignore);
			}
		}

		return process.exitValue();
	}

	private static void joinAndWait(Process process, Thread outputConsumerThread) throws InterruptedException {
		outputConsumerThread.join();
		process.waitFor();
	}
}
