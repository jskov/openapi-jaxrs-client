package dk.mada.jaxrs.generator.mpclient;

import dk.mada.jaxrs.generator.mpclient.imports.Imports;
import dk.mada.jaxrs.generator.mpclient.imports.JaxRs;
import java.util.Map;

/**
 * Handling of media types.
 */
public final class MediaTypes {
    /**
     * Media types supported for now.
     */
    private static final Map<String, String> MEDIA_TYPES = Map.of(
            "*/*", "WILDCARD",
            "application/json", "APPLICATION_JSON",
            "application/octet-stream", "APPLICATION_OCTET_STREAM",
            "application/x-www-form-urlencoded", "APPLICATION_FORM_URLENCODED",
            "multipart/form-data", "MULTIPART_FORM_DATA",
            "text/plain", "TEXT_PLAIN");

    /** Only static methods. */
    private MediaTypes() {}

    /**
     * Convert input media type to the render representation.
     *
     * @param imports   the imports for the source file
     * @param mediaType the media type
     * @return a string or a symbol representing the media type
     */
    public static String toMediaType(Imports imports, String mediaType) {
        String mtConstant = MEDIA_TYPES.get(mediaType);
        if (mtConstant == null) {
            return "\"" + mediaType + "\"";
        }

        imports.add(JaxRs.MEDIA_TYPE);

        return "MediaType." + mtConstant;
    }
}
