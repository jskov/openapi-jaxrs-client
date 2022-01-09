package dk.mada.jaxrs.generator;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.GeneratorException;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;

/**
 * Uses default naming, but provides alternatives in case of naming conflicts.
 * 
 * First tries to append the non-upper-cased value to the default naming.
 * This allows the client to make (some) sense of the enumeration values
 * 
 * If this fails, falls back to numbering of conflicting names.
 */
public class EnumNamer {
	private static final Logger logger = LoggerFactory.getLogger(EnumNamer.class);
	
	private final Identifiers identifiers = new Identifiers();
	private final Type enumValueType;
	private final Map<String, AtomicInteger> nameNumbering = new HashMap<>();
	private final List<EnumNameValue> nameToValues = new ArrayList<>();
	private final List<String> values;
	private final Set<String> assignedNames = new HashSet<>();

	private final String numberPrefix;

	public record EnumNameValue(String name, String value) {};
	
	public EnumNamer(GeneratorOpts opts, Type enumValueType, List<String> values) {
		this.enumValueType = enumValueType;
		this.values = values;

		this.numberPrefix = opts.getEnumNumberPrefix();
		
		assignNames();
	}
	
	public List<EnumNameValue> getEntries() {
		return nameToValues;
	}

	private void assignNames() {
		// Group by default names to detect conflicts
		Map<String, List<String>> conflicts = values.stream()
				.collect(groupingBy(this::simpleNamer));

		for (String v : values) {
			final String defaultName = simpleNamer(v);
			String name;
			
			List<String> cfn = conflicts.get(defaultName);
			if (cfn.size() == 1) {
				// no conflict
				name = defaultName;
			} else {
				// conflict
				// first try if case sensitive variant works
				long uniquelyNamed = cfn.stream()
					.map(n -> caseSensitiveNamer(n, defaultName))
					.distinct()
					.collect(counting());
				if (uniquelyNamed == cfn.size()) {
					name = caseSensitiveNamer(v, defaultName);
				} else {
					// if not, fall back to numbering
					name = numberingNamer(defaultName);
				}
			}

			logger.trace(" {} -> {} -> {}", v, defaultName, name);
			
			nameToValues.add(new EnumNameValue(name, v));
			
			if (!assignedNames.add(name)) {
				logger.error("Conflicts when assigning enum names from: {}", values);
				logger.error("Name {} assigned twice", name);
				throw new GeneratorException("Enum name conflict on " + name + " from "  + values);
			}
		}
		
		logger.debug("CONFLICTS: {}", conflicts);
		logger.debug("Assigned: {}", nameToValues);
	}
	
	private String simpleNamer(String n) {
		if (enumValueType == Primitive.INT) {
			return numberPrefix + n;
		}

		return identifiers.makeValidTypeName(n).toUpperCase();
	}
	
	/**
	 * Provides a case sensitive renaming.
	 * 
	 * Still has to map non-chars to _, so may still result in conflicts.
	 */
	private String caseSensitiveNamer(String v, String defaultName) {
		String simplified = v.replaceAll("[^a-zA-Z0-9]", "_");
		
		return defaultName + "_" + simplified;
	}

	/**
	 * Assign numbers to conflicting names.
	 */
	private String numberingNamer(String defaultName) {
		nameNumbering.computeIfAbsent(defaultName, n -> new AtomicInteger(0));
		return defaultName + "_" + nameNumbering.get(defaultName).incrementAndGet();
	}
}
