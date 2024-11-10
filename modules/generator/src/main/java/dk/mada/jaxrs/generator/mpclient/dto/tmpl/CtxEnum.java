package dk.mada.jaxrs.generator.mpclient.dto.tmpl;

import java.util.List;

/**
 * Context passed to Mustache when compiling an enum.
 *
 * @param enumVars list of enumeration entries
 */
public record CtxEnum(List<CtxEnumEntry> enumVars) {

    /**
     * Context describing an enumeration entry.
     *
     * @param name      the name of the entry
     * @param value     the value suitable for rendering
     * @param wireValue the wire-value of the entry
     */
    public record CtxEnumEntry(String name, String value, String wireValue) {
    }
}
