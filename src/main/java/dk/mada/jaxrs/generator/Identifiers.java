package dk.mada.jaxrs.generator;

import javax.lang.model.SourceVersion;

/**
 * Make identifiers valid for java.
 * 
 * https://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.8
 * 
 * A dash causes the following char to be upper-cased (foo-bar becomes fooBar).
 */

public class Identifiers {

	public String makeValidVariableName(String input) {
		return makeValid(input, true);
	}

	public String makeValidTypeName(String input) {
		return makeValid(input, false);
	}

	private String makeValid(String input, boolean initialLowerCase) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("Invalid blank identifier input");
		}
		
		StringBuilder sb = new StringBuilder();
		
		// Fix case of first letter
		char start = input.charAt(0);
		if (Character.isJavaIdentifierStart(start)) {
			if (initialLowerCase && Character.isUpperCase(start)) {
				sb.append(Character.toLowerCase(start));
			} else if (!initialLowerCase && Character.isLowerCase(start)) {
				sb.append(Character.toUpperCase(start));
			} else {
				sb.append(start);
			}
		} else {
			sb.append('_');
		}
		
		boolean upperCaseNext = false;
		for (int i = 1; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '-') {
				upperCaseNext = true;
				continue;
			}
			if (upperCaseNext) {
				upperCaseNext = false;
				c = Character.toUpperCase(c);
			}
			
			if (Character.isJavaIdentifierPart(c)) {
				sb.append(c);
			} else {
				sb.append('_');
			}
		}
		
		if (SourceVersion.isKeyword(sb)) {
			sb.append("_");
		}
		
		return sb.toString();
	}
}
