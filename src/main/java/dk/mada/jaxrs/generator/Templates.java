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

/**
 * Templates processor.
 */
public class Templates {
    private static final Logger logger = LoggerFactory.getLogger(Templates.class);

    /** Directory to write API classes to. */
    private final Path apiDir;
    /** Directory to write DTO classes to. */
    private final Path dtoDir;

    /** The API template. */
    private final Template apiTemplate;
    /** The DTO template. */
    private final Template dtoTemplate;

    /**
     * Creates templates.
     *
     * @param apiDir the directory to generate API classes in
     * @param dtoDir the directory to generate DTO classes in
     */
    public Templates(Path apiDir, Path dtoDir) {
        this.apiDir = apiDir;
        this.dtoDir = dtoDir;

        dtoTemplate = compileTemplate("model");
        apiTemplate = compileTemplate("api");
    }

    /**
     * Renders and writes an extra template.
     *
     * The context contains the information to render the template.
     *
     * @param tmpl the template to generate output from
     * @param context the rendering context
     */
    public void renderExtraTemplate(ExtraTemplate tmpl, CtxExtra context) {
        String tmplName = tmpl.classname();
        Path outputFile = toDtoFile(tmplName);

        try (Writer w = Files.newBufferedWriter(outputFile, StandardCharsets.UTF_8)) {
            compileTemplate(tmplName).execute(context, w);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to generate Extra " + outputFile, e);
        }
    }

    /**
     * Renders and writes the DTO template.
     *
     * The context contains the information to render the template
     * for a given DTO class.
     *
     * @param context the rendering context
     */
    public void renderDtoTemplate(CtxDto context) {
        Path outputFile = toDtoFile(context.classname());
        try (Writer w = Files.newBufferedWriter(outputFile, StandardCharsets.UTF_8)) {
            dtoTemplate.execute(context, w);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to generate DTO " + outputFile, e);
        }
    }

    /**
     * Renders and writes the API template.
     *
     * The context contains the information to render the template
     * for a given API class.
     *
     * @param context the rendering context
     */
    public void renderApiTemplate(CtxApi context) {
        String classname = context.classname();
        Path outputFile = toApiFile(classname);
        logger.info(" generate API {}", classname);

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
                    .withLoader(this::openReader)
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

    private Path toApiFile(String name) {
        return apiDir.resolve(name + ".java");
    }

    private Path toDtoFile(String name) {
        return dtoDir.resolve(name + ".java");
    }
}
