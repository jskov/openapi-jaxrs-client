package mada.tests.strings;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import dk.mada.jaxrs.generator.mpclient.StringRenderer;

class JavadocRendererTest {
    /**
     * Javadoc needs a sentence (with punctuation) on the first line.
     */
    @Test
    void shouldMakeSentenceOnFirstLine() {
        assertThat(StringRenderer.makeValidDtoJavadocSummary("simple"))
            .contains("simple.");
    }

    /**
     * Try to join short lines as mada-style formatter will do.
     */
    @Test
    void shouldJoinShortLines() {
        assertThat(StringRenderer.makeValidDtoJavadocSummary("Line 1.\nLine 2"))
            .contains("Line 1. Line 2");
    }

    /**
     * Trim hanging spaces on lines.
     */
    @Test
    void shouldDeleteHangingSpaces() {
        assertThat(StringRenderer.makeValidDtoJavadocSummary("Line 1. \nLine 2 \n\nLine 3 "))
            .get()
            .isEqualTo("Line 1. Line 2\n * Line 3");
    }

    /**
     * Try to split long lines as mada-style formatter will do.
     */
    @Test
    void shouldBreakLongLines() {
        assertThat(StringRenderer.makeValidDtoJavadocSummary("Line 1.\nLine 2 one two tree four five Make a summary valid for use in the javadoc section. Make a summary valid for use in the javadoc section. Make a summary valid for use in the javadoc section. Make a summary valid for use in the javadoc section. Make a summary valid for use in the javadoc section. Make a summary valid for use in the javadoc section. Make a summary valid for use in the javadoc section. Make a summary valid for use in the javadoc section.\n"))
            .contains("""
                    Line 1. Line 2 one two tree four five Make a summary valid for use in the javadoc section. Make a summary valid for
                     * use in the javadoc section. Make a summary valid for use in the javadoc section. Make a summary valid for use in the
                     * javadoc section. Make a summary valid for use in the javadoc section. Make a summary valid for use in the javadoc
                     * section. Make a summary valid for use in the javadoc section. Make a summary valid for use in the javadoc section.""");
    }

    // break two long lines, join middle
    
    /**
     * Allow sentence separation with double newlines.
     */
    @Test
    void shouldKeepLineSeparation() {
        assertThat(StringRenderer.makeValidDtoJavadocSummary("Line 1.\n\nLine 2\n\n\n\n\nLine 3"))
            .contains("Line 1.\n * Line 2\n * Line 3");
    }
}
