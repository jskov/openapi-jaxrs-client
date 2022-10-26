package dk.mada.jaxrs.generator;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.api.tmpl.CtxApi;
import dk.mada.jaxrs.generator.dto.tmpl.CtxDto;
import dk.mada.jaxrs.generator.dto.tmpl.CtxExtraDateSerializer;
import dk.mada.jaxrs.generator.dto.tmpl.CtxInterface;
import io.jstach.JStachio;

/**
 * Templates processor.
 */
public class Templates {
    private static final Logger logger = LoggerFactory.getLogger(Templates.class);

    /** Directory to write API classes to. */
    private final Path apiDir;
    /** Directory to write DTO classes to. */
    private final Path dtoDir;

    /**
     * Creates templates.
     *
     * @param apiDir the directory to generate API classes in
     * @param dtoDir the directory to generate DTO classes in
     */
    public Templates(Path apiDir, Path dtoDir) {
        this.apiDir = apiDir;
        this.dtoDir = dtoDir;
    }

    /**
     * Renders and writes an extra template.
     *
     * The context contains the information to render the template.
     *
     * @param tmpl the template to generate output from
     * @param context the rendering context
     */
    public void renderExtraTemplate(ExtraTemplate tmpl, CtxExtraDateSerializer context) {
        String tmplName = tmpl.classname();
        Path outputFile = toDtoFile(tmplName);
        renderJstachioTemplate(context, outputFile);
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
        Path output = toDtoFile(context.classname());
        renderJstachioTemplate(context, output);
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
        Path outputFile = toDtoFile(context.classname());
        renderJstachioTemplate(context, outputFile);
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
        Path output = toApiFile(classname);
        logger.info(" generate API {}", classname);

        renderJstachioTemplate(context, output);
    }

    private void renderJstachioTemplate(Object context, Path output) {
        try {
            String text = JStachio.render(context);
            // remove trailing spaces on a line.
            // if the line is all spaces, remove the full line (include the preceding newline)
            text = text.replaceAll("(?m)(" + System.lineSeparator() + ")? +$", "");
            Files.writeString(output, text);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to render template to " + output, e);
        }
    }

    private Path toApiFile(String name) {
        return apiDir.resolve(name + ".java");
    }

    private Path toDtoFile(String name) {
        return dtoDir.resolve(name + ".java");
    }
}
