package dk.mada.jaxrs.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import dk.mada.jaxrs.GeneratorException;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.Type;

public class Templates {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(Templates.class);
	
	private final GeneratorOpts opts;

	public Templates(GeneratorOpts opts) {
		this.opts = opts;
	}
	
	public void touch(Path file) {
		try {
			Files.createFile(file);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	public void writeDto(Model model, Type type, Path outputFile) {
		try (Reader r = openReader("model");
			Writer w = Files.newBufferedWriter(outputFile, StandardCharsets.UTF_8)) {

			Template m = Mustache.compiler()
				.withLoader(n -> openReader(n))
				.compile(r);

			CtxModel ctx = ImmutableCtxModel.builder()
					.type(type)
					.info(model.info())
					.packageName(opts.dtoPackage())
					.build();
			
			m.execute(ctx, w);
		} catch (IOException e) {
			throw new GeneratorException("Failed to generate DTO " + outputFile, e);
		}
	}
	
	private Reader openReader(String templateName) {
		String resource = "/templates/" + templateName + ".mustache";
		InputStream is = this.getClass().getResourceAsStream(resource);
		if (is == null) {
			throw new IllegalArgumentException("Failed to find template " + resource);
		}
		return new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
	}
}
