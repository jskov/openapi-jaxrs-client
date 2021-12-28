package dk.mada.jaxrs;

import java.nio.file.Path;
import java.util.Properties;

import dk.mada.jaxrs.generator.ApiGenerator;
import dk.mada.jaxrs.generator.DtoGenerator;
import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.generator.ImmutableGeneratorOpts;
import dk.mada.jaxrs.generator.Templates;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.openapi.Parser;

public class Generator {
	
	private static final String OPT_API_PACKAGE = "apiPackage";
	private static final String OPT_MODEL_PACKAGE = "modelPackage";
	
	public void generate(Path input, Properties options, Path outputDir) {
	    Model model = new Parser().parse(input);
	    
	    try {
	    	Path apiDir = outputDir.resolve("api");
		    Path dtoDir = outputDir.resolve("dto");
		    
		    GeneratorOpts genOpts = ImmutableGeneratorOpts.builder()
		    	.apiPackage(options.getProperty(OPT_API_PACKAGE, "api"))
		    	.dtoPackage(options.getProperty(OPT_MODEL_PACKAGE, "dto"))
		    	.build();
		    
		    var templates = new Templates(genOpts);
		    new DtoGenerator(genOpts, templates, model).generateDtoClasses(dtoDir);
		    new ApiGenerator(templates, model).generateApiClasses(apiDir);
		    
	    } catch (Exception e) {
	    	throw new GeneratorException("Failed", e);
	    }
	}
}
