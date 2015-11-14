
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
    "hasDay"
})
public class Month {

    /**
     * general notes / comments
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
     * has a day date
     * 
     */
    @JsonProperty("hasDay")
    private HasDay hasDay;
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
     * has a day date
     * 
     * @return
     *     The hasDay
     */
    @JsonProperty("hasDay")
    public HasDay getHasDay() {
        return hasDay;
    }

    /**
     * has a day date
     * 
     * @param hasDay
     *     The hasDay
     */
    @JsonProperty("hasDay")
    public void setHasDay(HasDay hasDay) {
        this.hasDay = hasDay;
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
        return new HashCodeBuilder().append(comments).append(name).append(value).append(hasDay).append(additionalProperties).toHashCode();
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
        return new EqualsBuilder().append(comments, rhs.comments).append(name, rhs.name).append(value, rhs.value).append(hasDay, rhs.hasDay).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
