package mada.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Test;

/**
 * Simple can-apply test.
 *
 * Works from gradle, but not from Eclipse. Not sure it is worth the effort to get working.
 */
class ApplyTest {

    @Test
    void canApply() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply("dk.mada.jaxrs");

        Object ext = project.getExtensions().findByName("jaxrs");

        assertThat(ext)
                .isNotNull();
    }
}
