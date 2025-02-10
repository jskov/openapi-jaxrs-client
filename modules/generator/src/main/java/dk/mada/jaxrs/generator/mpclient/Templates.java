package dk.mada.jaxrs.generator.mpclient;

import dk.mada.jaxrs.generator.mpclient.GeneratorOpts.LineEnding;
import dk.mada.jaxrs.generator.mpclient.api.tmpl.CtxApi;
import dk.mada.jaxrs.generator.mpclient.api.tmpl.CtxApiRenderer;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxDto;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxDtoRenderer;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxExtraDateSerializer;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxExtraDateSerializerRenderer;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxInterface;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxInterfaceRenderer;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Templates processor.
 */
public class Templates {
    private static final Logger logger = LoggerFactory.getLogger(Templates.class);

    /** Directory to write DTO classes to. */
    private final Path dtoDir;
    /** The line ending to use when rendering templates. */
    private final LineEnding lineEnding;

    /**
     * Creates templates.
     *
     * @param opts   the generator options
     * @param dtoDir the directory to generate DTO classes in
     */
    public Templates(GeneratorOpts opts, Path dtoDir) {
        this.dtoDir = dtoDir;

        lineEnding = opts.getLineEnding();
    }

    /**
     * Renders and writes an extra template.
     *
     * The context contains the information to render the template.
     *
     * @param tmpl    the template to generate output from
     * @param context the rendering context
     */
    public void renderExtraTemplate(ExtraTemplate tmpl, CtxExtraDateSerializer context) {
        String classname = tmpl.classname();
        Path output = toDtoFile(classname);

        logger.info("Generating ExtraDateSerializer {}", classname);
        String code = CtxExtraDateSerializerRenderer.of().execute(context);
        writeTemplateCode(output, code);
    }

    /**
     * Renders and writes the DTO template.
     *
     * The context contains the information to render the template for a given DTO class.
     *
     * @param context the rendering context
     */
    public void renderDtoTemplate(CtxDto context) {
        String classname = context.classname();
        Path output = toDtoFile(classname);

        logger.info("Generating DTO {}", classname);
        String code = CtxDtoRenderer.of().execute(context);
        writeTemplateCode(output, code);
    }

    /**
     * Renders and writes the interface template.
     *
     * The context contains the information to render the template for a given interface class.
     *
     * @param context the rendering context
     */
    public void renderInterfaceTemplate(CtxInterface context) {
        String classname = context.classname();
        Path output = toDtoFile(classname);

        logger.info("Generating Interface {}", classname);
        String code = CtxInterfaceRenderer.of().execute(context);
        writeTemplateCode(output, code);
    }

    /**
     * Renders and writes the API template.
     *
     * The context contains the information to render the template for a given API class.
     *
     * @param apiDir  the directory to generate API classes in
     * @param context the rendering context
     */
    public void renderApiTemplate(Path apiDir, CtxApi context) {
        String classname = context.classname();
        Path output = apiDir.resolve(classname + ".java");

        logger.info("Generating API {}", classname);
        String code = CtxApiRenderer.of().execute(context);
        writeTemplateCode(output, code);
    }

    private void writeTemplateCode(Path output, String code) {
        try {
            // remove trailing spaces on a line.
            // if the line is all spaces, remove the full line (include the preceding newline)
            String text = code.replaceAll("(?m)(" + System.lineSeparator() + ")? +$", "")
                            .lines()
                            .collect(Collectors.joining(lineEnding.lineBreak()))
                    + lineEnding.lineBreak();

            Files.writeString(output, text);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to render template to " + output, e);
        }
    }

    private Path toDtoFile(String name) {
        return dtoDir.resolve(name + ".java");
    }
}
