package dk.mada.jaxrs.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Model;

public class ApiGenerator {
	private static final Logger logger = LoggerFactory.getLogger(ApiGenerator.class);

	private final Templates templates;
	private final Model model;

	public ApiGenerator(Templates templates, Model model) {
		this.templates = templates;
		this.model = model;
	}
	
	public void generateApiClasses(Path apiDir) throws IOException {
		Files.createDirectories(apiDir);
		
		model.operations().getApiNames()
			.forEach(name -> {
				Path f = apiDir.resolve(name + ".java");
				logger.info(" generate API {}", name);
				templates.touch(f);
			});
	}
}
