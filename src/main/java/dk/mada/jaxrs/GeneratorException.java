package dk.mada.jaxrs;

/**
 * Wraps any exception throw while parsing or generating code.
 */
public class GeneratorException extends RuntimeException {
	private static final long serialVersionUID = 5823662362805123569L;

	public GeneratorException(String message) {
		super(message);
	}

	public GeneratorException(String message, Throwable cause) {
		super(message, cause);
	}
}
