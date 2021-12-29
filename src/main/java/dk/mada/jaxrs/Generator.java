package dk.mada.jaxrs;

import java.nio.file.Path;
import java.util.Properties;

import dk.mada.jaxrs.generator.ApiGenerator;
import dk.mada.jaxrs.generator.DtoGenerator;
import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.generator.Templates;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.openapi.Parser;
import dk.mada.jaxrs.openapi.ParserOpts;

public class Generator {
	
	public void generate(Path input, Properties options, Path outputDir) {
		var parserOpts = new ParserOpts(options);
	    Model model = new Parser(parserOpts).parse(input);
	    
	    try {
	    	Path apiDir = outputDir.resolve("api");
		    Path dtoDir = outputDir.resolve("dto");
		    
		    GeneratorOpts genOpts = new GeneratorOpts(options);
		    
		    var templates = new Templates(genOpts);
		    new DtoGenerator(genOpts, templates, model).generateDtoClasses(dtoDir);
		    new ApiGenerator(templates, model).generateApiClasses(apiDir);
		    
	    } catch (Exception e) {
	    	throw new GeneratorException("Failed", e);
	    }
	}
}
