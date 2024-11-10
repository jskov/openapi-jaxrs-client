/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.types_special.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * _ResponseApiTypesBitbucketArray
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class _ResponseApiTypesBitbucketArray {
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
    private List<Simple> values;

    public _ResponseApiTypesBitbucketArray isLastPage(Boolean isLastPage) {
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

    public _ResponseApiTypesBitbucketArray limit(BigDecimal limit) {
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

    public _ResponseApiTypesBitbucketArray nextPageStart(Integer nextPageStart) {
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

    public _ResponseApiTypesBitbucketArray size(BigDecimal size) {
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

    public _ResponseApiTypesBitbucketArray start(Integer start) {
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

    public _ResponseApiTypesBitbucketArray values(List<Simple> values) {
        this.values = values;
        return this;
    }

    public _ResponseApiTypesBitbucketArray addValuesItem(Simple valuesItem) {
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
    @Valid
    public List<Simple> getValues() {
        return values;
    }

    public void setValues(List<Simple> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof _ResponseApiTypesBitbucketArray)) {
            return false;
        }
        _ResponseApiTypesBitbucketArray other = (_ResponseApiTypesBitbucketArray) o;
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
        sb.append("class _ResponseApiTypesBitbucketArray {");
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
