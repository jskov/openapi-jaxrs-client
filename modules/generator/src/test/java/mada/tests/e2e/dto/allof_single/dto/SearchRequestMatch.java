/*
 * jboss-helloworld
 *
 * The version of the OpenAPI document: 1.0
 */

package mada.tests.e2e.dto.allof_single.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Model containing manifest request match schema.
 */
@Schema(description = "Model containing manifest request match schema.")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SearchRequestMatch {
  public static final String JSON_PROPERTY_KEY_WORD = "KeyWord";
  @JsonbProperty(JSON_PROPERTY_KEY_WORD)
  private String keyWord;

  public static final String JSON_PROPERTY_MATCH_TYPE = "MatchType";
  @JsonbProperty(JSON_PROPERTY_MATCH_TYPE)
  private String matchType;

  public SearchRequestMatch keyWord(String keyWord) {
    this.keyWord = keyWord;
    return this;
  }

  /**
   * Get keyWord
   * @return keyWord
   **/
  public String getKeyWord() {
    return keyWord;
  }

  public void setKeyWord(String keyWord) {
    this.keyWord = keyWord;
  }

  public SearchRequestMatch matchType(String matchType) {
    this.matchType = matchType;
    return this;
  }

  /**
   * Get matchType
   * @return matchType
   **/
  public String getMatchType() {
    return matchType;
  }

  public void setMatchType(String matchType) {
    this.matchType = matchType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SearchRequestMatch)) {
      return false;
    }
    SearchRequestMatch other = (SearchRequestMatch) o;
    return Objects.equals(this.keyWord, other.keyWord) &&
        Objects.equals(this.matchType, other.matchType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyWord, matchType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchRequestMatch {");
    sb.append("\n    keyWord: ").append(toIndentedString(keyWord));
    sb.append("\n    matchType: ").append(toIndentedString(matchType));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
