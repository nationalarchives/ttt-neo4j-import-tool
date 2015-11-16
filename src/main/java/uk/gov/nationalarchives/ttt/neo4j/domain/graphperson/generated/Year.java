
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
 * a single year
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "name",
    "value",
    "hasMonth"
})
public class Year {

    /**
     * general notes / comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * description of year
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * year
     * (Required)
     * 
     */
    @JsonProperty("value")
    private Double value;
    /**
     * has a month date
     * 
     */
    @JsonProperty("hasMonth")
    private HasMonth hasMonth;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * general notes / comments
     * 
     * @return
     *     The comments
     */
    @JsonProperty("comments")
    public String getComments() {
        return comments;
    }

    /**
     * general notes / comments
     * 
     * @param comments
     *     The comments
     */
    @JsonProperty("comments")
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * description of year
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * description of year
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * year
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
     * year
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
     * has a month date
     * 
     * @return
     *     The hasMonth
     */
    @JsonProperty("hasMonth")
    public HasMonth getHasMonth() {
        return hasMonth;
    }

    /**
     * has a month date
     * 
     * @param hasMonth
     *     The hasMonth
     */
    @JsonProperty("hasMonth")
    public void setHasMonth(HasMonth hasMonth) {
        this.hasMonth = hasMonth;
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
        return new HashCodeBuilder().append(comments).append(name).append(value).append(hasMonth).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Year) == false) {
            return false;
        }
        Year rhs = ((Year) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(name, rhs.name).append(value, rhs.value).append(hasMonth, rhs.hasMonth).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}