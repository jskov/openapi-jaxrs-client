package dk.mada.jaxrs.generator;

/**
 * Make identifiers valid for java.
 * 
 * https://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.8
 */

public class Identifiers {

	public String makeValidVariableName(String input) {
		return makeValid(input, true);
	}
	
	private String makeValid(String input, boolean initialLowerCase) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("Invalid blank identifier input");
		}
		
		StringBuilder sb = new StringBuilder();
		
		char start = input.charAt(0);
		if (Character.isJavaIdentifierStart(start)) {
			if (initialLowerCase && Character.isUpperCase(start)) {
				sb.append(Character.toLowerCase(start));
			} else {
				sb.append(start);
			}
		} else {
			sb.append('_');
		}
		
		for (int i = 1; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isJavaIdentifierPart(c)) {
				sb.append(c);
			} else {
				sb.append('_');
			}
		}
		
		return sb.toString();
	}
}
