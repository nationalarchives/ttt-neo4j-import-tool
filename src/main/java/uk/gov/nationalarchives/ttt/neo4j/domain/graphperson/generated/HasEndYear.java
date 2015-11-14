
package uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * has an end year date
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "type",
    "year"
})
public class HasEndYear {

    /**
     * general notes / comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * exactness of end year date
     * 
     */
    @JsonProperty("type")
    private HasEndYear.Type type = HasEndYear.Type.fromValue("APPROX");
    /**
     * a single year
     * 
     */
    @JsonProperty("year")
    private Year year;
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
     * exactness of end year date
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public HasEndYear.Type getType() {
        return type;
    }

    /**
     * exactness of end year date
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(HasEndYear.Type type) {
        this.type = type;
    }

    /**
     * a single year
     * 
     * @return
     *     The year
     */
    @JsonProperty("year")
    public Year getYear() {
        return year;
    }

    /**
     * a single year
     * 
     * @param year
     *     The year
     */
    @JsonProperty("year")
    public void setYear(Year year) {
        this.year = year;
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
        return new HashCodeBuilder().append(comments).append(type).append(year).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HasEndYear) == false) {
            return false;
        }
        HasEndYear rhs = ((HasEndYear) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(type, rhs.type).append(year, rhs.year).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum Type {

        APPROX("APPROX"),
        EXACT("EXACT");
        private final String value;
        private static Map<String, HasEndYear.Type> constants = new HashMap<String, HasEndYear.Type>();

        static {
            for (HasEndYear.Type c: values()) {
                constants.put(c.value, c);
            }
        }

        private Type(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static HasEndYear.Type fromValue(String value) {
            HasEndYear.Type constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
