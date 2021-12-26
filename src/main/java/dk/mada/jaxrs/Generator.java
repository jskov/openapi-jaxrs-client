package dk.mada.jaxrs;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.openapi.Parser;

public class Generator {
	private static final Logger logger = LoggerFactory.getLogger(Generator.class);

	public void generate(Path input, Properties options, Path outputDir) {
	    Model model = new Parser().parse(input);
	    
	    try {
	    	Path apiDir = outputDir.resolve("api");
		    Path dtoDir = outputDir.resolve("dto");
		    
		    generateApiClasses(model, apiDir);
		    generateDtoClasses(model, dtoDir);
	    } catch (Exception e) {
	    	throw new GeneratorException("Failed", e);
	    }
	}
		
	private void generateDtoClasses(Model model, Path dtoDir) throws IOException {
		Files.createDirectories(dtoDir);
		model.types().getTypeNames()
			.forEach(name -> {
				Path f = dtoDir.resolve(name + ".java");
				logger.info(" generate type {}", name);
				touch(f);
			});
	}
	
	private void generateApiClasses(Model model, Path apiDir) throws IOException {
		Files.createDirectories(apiDir);
		
		model.operations().getApiNames()
			.forEach(name -> {
				Path f = apiDir.resolve(name + ".java");
				logger.info(" generate API {}", name);
				touch(f);
			});
	}
	
	private void touch(Path file) {
		try {
			Files.createFile(file);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
