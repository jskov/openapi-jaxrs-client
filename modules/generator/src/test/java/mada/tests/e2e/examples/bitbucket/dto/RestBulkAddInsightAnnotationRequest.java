/*
 * Bitbucket Data Center
 * This is the reference document for the Atlassian Bitbucket REST API. The REST API is for developers who want to:

 - integrate Bitbucket with other applications;

 - create scripts that interact with Bitbucket; or

 - develop plugins that enhance the Bitbucket UI, using REST to interact with the backend.

 You can read more about developing Bitbucket plugins in the [Bitbucket Developer Documentation](https://developer.atlassian.com/bitbucket/server/docs/latest/).
 *
 * The version of the OpenAPI document: 8.19
 */

package mada.tests.e2e.examples.bitbucket.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * RestBulkAddInsightAnnotationRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestBulkAddInsightAnnotationRequest {
    public static final String JSON_PROPERTY_ANNOTATIONS = "annotations";
    @JsonbProperty(JSON_PROPERTY_ANNOTATIONS)
    private List<RestSingleAddInsightAnnotationRequest> annotations;

    public RestBulkAddInsightAnnotationRequest annotations(List<RestSingleAddInsightAnnotationRequest> annotations) {
        this.annotations = annotations;
        return this;
    }

    public RestBulkAddInsightAnnotationRequest addAnnotationsItem(RestSingleAddInsightAnnotationRequest annotationsItem) {
        if (this.annotations == null) {
            this.annotations = new ArrayList<>();
        }
        this.annotations.add(annotationsItem);
        return this;
    }

    /**
     * Get annotations
     *
     * @return annotations
     **/
    @Valid
    @Size(min = 1, max = 2147483647)
    public List<RestSingleAddInsightAnnotationRequest> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<RestSingleAddInsightAnnotationRequest> annotations) {
        this.annotations = annotations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestBulkAddInsightAnnotationRequest)) {
            return false;
        }
        RestBulkAddInsightAnnotationRequest other = (RestBulkAddInsightAnnotationRequest) o;
        return Objects.equals(this.annotations, other.annotations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annotations);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestBulkAddInsightAnnotationRequest {");
        sb.append("\n    annotations: ").append(toIndentedString(annotations));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
