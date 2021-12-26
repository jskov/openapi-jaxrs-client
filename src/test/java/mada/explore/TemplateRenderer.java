package mada.explore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
//import org.openapitools.codegen.auth.AuthParser;
import org.slf4j.LoggerFactory;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import dk.mada.jaxrs.model.CtxModel;
import dk.mada.jaxrs.model.ImmutableCtxModel;
import dk.mada.jaxrs.model.ImmutableInfo;
import dk.mada.jaxrs.model.ImmutableType;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Type;

public class TemplateRenderer {
	private static final Logger logger = LoggerFactory.getLogger(TemplateRenderer.class);
	@Test
	public void go() {
		Path output = Paths.get("/tmp/a");
		try (Reader r = openReader("model");
			Writer w = Files.newBufferedWriter(output, StandardCharsets.UTF_8)) {

			Template m = Mustache.compiler()
				.withLoader(n -> openReader(n))
				.compile(r);

			Type t = ImmutableType.builder()
					.name("foo")
					.build(); 

			Info info = ImmutableInfo.builder()
					.title("title text")
					.version("1.0.0")
					.build();
			
			CtxModel ctx = ImmutableCtxModel.builder()
					.type(t)
					.info(info)
					.build();
			
			
			m.execute(ctx, w);

			w.flush();
			System.out.println("------");
			System.out.println(Files.readString(output));
			System.out.println("------");
		} catch (IOException e) {
			logger.error("Failed ", e);
		}

	}

	private Reader openReader(String templateName) {
		String resource = "/templates/" + templateName + ".mustache";
		InputStream is = this.getClass().getResourceAsStream(resource);
		if (is == null) {
			throw new IllegalArgumentException("Failed to find template " + resource);
		}
		Reader r = new InputStreamReader(is, StandardCharsets.UTF_8);
		return new BufferedReader(r);

	}
}
