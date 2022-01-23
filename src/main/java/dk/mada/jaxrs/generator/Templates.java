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

import dk.mada.jaxrs.generator.api.tmpl.CtxApi;
import dk.mada.jaxrs.generator.dto.tmpl.CtxDto;
import dk.mada.jaxrs.generator.dto.tmpl.CtxExtra;

public class Templates {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(Templates.class);
	
	@SuppressWarnings("unused")
	private final GeneratorOpts opts;

	private final Template dtoTemplate;
	private final Template apiTemplate;

	public Templates(GeneratorOpts opts) {
		this.opts = opts;

		dtoTemplate = compileTemplate("model");
		apiTemplate = compileTemplate("api");
	}
	
	public void touch(Path file) {
		try {
			Files.createFile(file);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	public void writeExtra(String tmplName, CtxExtra context, Path outputFile) {
		try (Writer w = Files.newBufferedWriter(outputFile, StandardCharsets.UTF_8)) {
			compileTemplate(tmplName).execute(context, w);
		} catch (IOException e) {
			throw new UncheckedIOException("Failed to generate Extra " + outputFile, e);
		}
	}
	
	public void writeDto(CtxDto context, Path outputFile) {
		try (Writer w = Files.newBufferedWriter(outputFile, StandardCharsets.UTF_8)) {
			dtoTemplate.execute(context, w);
		} catch (IOException e) {
			throw new UncheckedIOException("Failed to generate DTO " + outputFile, e);
		}
	}

	public void writeApi(CtxApi context, Path outputFile) {
		try (Writer w = Files.newBufferedWriter(outputFile, StandardCharsets.UTF_8)) {
			apiTemplate.execute(context, w);
		} catch (IOException e) {
			throw new UncheckedIOException("Failed to generate API " + outputFile, e);
		}
	}

	private Template compileTemplate(String resourceName) {
		try (Reader r = openReader(resourceName)) {
			return Mustache.compiler()
					.defaultValue("")
					.withLoader(n -> openReader(n))
					.compile(r);
		} catch (IOException e) {
			throw new UncheckedIOException("Failed to read template " + resourceName, e);
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
