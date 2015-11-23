
package uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * a single month
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "name",
    "value",
    "hasYear"
})
public class Month {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * description of month
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * month
     * (Required)
     * 
     */
    @JsonProperty("value")
    private Double value;
    /**
     * has a single year date
     * 
     */
    @JsonProperty("hasYear")
    private HasYear hasYear;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * notes or comments
     * 
     * @return
     *     The comments
     */
    @JsonProperty("comments")
    public String getComments() {
        return comments;
    }

    /**
     * notes or comments
     * 
     * @param comments
     *     The comments
     */
    @JsonProperty("comments")
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * description of month
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * description of month
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * month
     * (Required)
     * 
     * @return
     *     The value
     */
    @JsonProperty("value")
    public Double getValue() {
        return value;
    }

    /**
     * month
     * (Required)
     * 
     * @param value
     *     The value
     */
    @JsonProperty("value")
    public void setValue(Double value) {
        this.value = value;
    }

    /**
     * has a single year date
     * 
     * @return
     *     The hasYear
     */
    @JsonProperty("hasYear")
    public HasYear getHasYear() {
        return hasYear;
    }

    /**
     * has a single year date
     * 
     * @param hasYear
     *     The hasYear
     */
    @JsonProperty("hasYear")
    public void setHasYear(HasYear hasYear) {
        this.hasYear = hasYear;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(comments).append(name).append(value).append(hasYear).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Month) == false) {
            return false;
        }
        Month rhs = ((Month) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(name, rhs.name).append(value, rhs.value).append(hasYear, rhs.hasYear).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
