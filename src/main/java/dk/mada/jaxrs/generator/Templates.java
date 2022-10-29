package dk.mada.jaxrs.generator;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
import dk.mada.jaxrs.generator.dto.tmpl.CtxInterface;

/**
 * Templates processor.
 */
public class Templates {
    /** Marker in templates to trigger space/newline trimming. */
    private static final String TRIM_MARKER = "@TRIM_EMPTY_LINE@";

    private static final Logger logger = LoggerFactory.getLogger(Templates.class);

    /** Directory to write DTO classes to. */
    private final Path dtoDir;

    /** The API template. */
    private final Template apiTemplate;
    /** The DTO template. */
    private final Template dtoTemplate;
    /** The interface template. */
    private final Template interfaceTemplate;

    /**
     * Creates templates.
     *
     * @param dtoDir the directory to generate DTO classes in
     */
    public Templates(Path dtoDir) {
        this.dtoDir = dtoDir;

        dtoTemplate = compileTemplate("model");
        apiTemplate = compileTemplate("api");
        interfaceTemplate = compileTemplate("interface");
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
        Path outputFile = toModelFile(tmplName);
        Template template = compileTemplate(tmplName);
        renderTemplate(template, context, outputFile);
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
        Path outputFile = toModelFile(context.classname());
        renderTemplate(dtoTemplate, context, outputFile);
    }

    /**
     * Renders and writes the interface template.
     *
     * The context contains the information to render the template
     * for a given interface class.
     *
     * @param context the rendering context
     */
    public void renderInterfaceTemplate(CtxInterface context) {
        Path outputFile = toModelFile(context.classname());
        renderTemplate(interfaceTemplate, context, outputFile);
    }

    /**
     * Renders and writes the API template.
     *
     * The context contains the information to render the template
     * for a given API class.
     *
     * @param apiDir the directory to generate API classes in
     * @param context the rendering context
     */
    public void renderApiTemplate(Path apiDir, CtxApi context) {
        String classname = context.classname();
        Path outputFile = apiDir.resolve(classname + ".java");
        logger.info(" generate API {}", classname);
        renderTemplate(apiTemplate, context, outputFile);
    }

    private void renderTemplate(Template template, Object context, Path output) {
        try {
            String text = render(template, context);
            text = text.replaceAll("(" + System.lineSeparator() + ")?" + " *" + TRIM_MARKER, "");
            Files.writeString(output, text);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to render template to " + output, e);
        }
    }

    private String render(Template template, Object context) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                Writer w = new OutputStreamWriter(bos, StandardCharsets.UTF_8)) {
            template.execute(context, w);
            w.flush();
            return bos.toString(StandardCharsets.UTF_8);
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

    private Path toModelFile(String name) {
        return dtoDir.resolve(name + ".java");
    }
}
