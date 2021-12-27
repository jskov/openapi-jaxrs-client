package dk.mada.jaxrs.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Model;

public class DtoGenerator {
	private static final Logger logger = LoggerFactory.getLogger(DtoGenerator.class);

	private final Templates templates;
	private final Model model;

	public DtoGenerator(Templates templates, Model model) {
		this.templates = templates;
		this.model = model;
	}
	
	public void generateDtoClasses(Path dtoDir) throws IOException {
		Files.createDirectories(dtoDir);
		model.types().get()
			.forEach(type -> {
				String name = type.name();
				Path f = dtoDir.resolve(name + ".java");
				logger.info(" generate type {}", name);
				templates.writeDto(model, type, f);
			});
	}

}
