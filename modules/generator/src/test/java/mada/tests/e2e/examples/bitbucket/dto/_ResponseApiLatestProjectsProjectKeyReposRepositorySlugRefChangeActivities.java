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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities {
    public static final String JSON_PROPERTY_IS_LAST_PAGE = "isLastPage";
    @JsonbProperty(JSON_PROPERTY_IS_LAST_PAGE)
    private Boolean isLastPage;

    public static final String JSON_PROPERTY_LIMIT = "limit";
    @JsonbProperty(JSON_PROPERTY_LIMIT)
    @Schema(example = "25")
    private BigDecimal limit;

    public static final String JSON_PROPERTY_NEXT_PAGE_START = "nextPageStart";
    @JsonbProperty(JSON_PROPERTY_NEXT_PAGE_START)
    private Integer nextPageStart;

    public static final String JSON_PROPERTY_SIZE = "size";
    @JsonbProperty(JSON_PROPERTY_SIZE)
    @Schema(example = "1")
    private BigDecimal size;

    public static final String JSON_PROPERTY_START = "start";
    @JsonbProperty(JSON_PROPERTY_START)
    private Integer start;

    public static final String JSON_PROPERTY_VALUES = "values";
    @JsonbProperty(JSON_PROPERTY_VALUES)
    private List<RestRepositoryRefChangeActivity> values;

    public _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities isLastPage(Boolean isLastPage) {
        this.isLastPage = isLastPage;
        return this;
    }

    /**
     * Get isLastPage
     *
     * @return isLastPage
     **/
    public Boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(Boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities limit(BigDecimal limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Get limit
     *
     * @return limit
     **/
    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities nextPageStart(Integer nextPageStart) {
        this.nextPageStart = nextPageStart;
        return this;
    }

    /**
     * Get nextPageStart
     *
     * @return nextPageStart
     **/
    public Integer getNextPageStart() {
        return nextPageStart;
    }

    public void setNextPageStart(Integer nextPageStart) {
        this.nextPageStart = nextPageStart;
    }

    public _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities size(BigDecimal size) {
        this.size = size;
        return this;
    }

    /**
     * Get size
     *
     * @return size
     **/
    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities start(Integer start) {
        this.start = start;
        return this;
    }

    /**
     * Get start
     *
     * @return start
     **/
    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities values(List<RestRepositoryRefChangeActivity> values) {
        this.values = values;
        return this;
    }

    public _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities addValuesItem(RestRepositoryRefChangeActivity valuesItem) {
        if (this.values == null) {
            this.values = new ArrayList<>();
        }
        this.values.add(valuesItem);
        return this;
    }

    /**
     * Get values
     *
     * @return values
     **/
    @Valid public List<RestRepositoryRefChangeActivity> getValues() {
        return values;
    }

    public void setValues(List<RestRepositoryRefChangeActivity> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities)) {
            return false;
        }
        _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities other = (_ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities) o;
        return Objects.equals(this.isLastPage, other.isLastPage) &&
                Objects.equals(this.limit, other.limit) &&
                Objects.equals(this.nextPageStart, other.nextPageStart) &&
                Objects.equals(this.size, other.size) &&
                Objects.equals(this.start, other.start) &&
                Objects.equals(this.values, other.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isLastPage, limit, nextPageStart, size, start, values);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities {");
        sb.append("\n    isLastPage: ").append(toIndentedString(isLastPage));
        sb.append("\n    limit: ").append(toIndentedString(limit));
        sb.append("\n    nextPageStart: ").append(toIndentedString(nextPageStart));
        sb.append("\n    size: ").append(toIndentedString(size));
        sb.append("\n    start: ").append(toIndentedString(start));
        sb.append("\n    values: ").append(toIndentedString(values));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
