
package uk.gov.nationalarchives.ttt.linker.model.graphperson.generated;

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
 * has a start year date
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "type",
    "year"
})
public class HasStartYear {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * exactness of start year date
     * 
     */
    @JsonProperty("type")
    private HasStartYear.Type type = HasStartYear.Type.fromValue("APPROX");
    /**
     * a single year
     * 
     */
    @JsonProperty("year")
    private Year year;
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
     * exactness of start year date
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public HasStartYear.Type getType() {
        return type;
    }

    /**
     * exactness of start year date
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(HasStartYear.Type type) {
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
        if ((other instanceof HasStartYear) == false) {
            return false;
        }
        HasStartYear rhs = ((HasStartYear) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(type, rhs.type).append(year, rhs.year).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum Type {

        APPROX("APPROX"),
        EXACT("EXACT");
        private final String value;
        private static Map<String, HasStartYear.Type> constants = new HashMap<String, HasStartYear.Type>();

        static {
            for (HasStartYear.Type c: values()) {
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
        public static HasStartYear.Type fromValue(String value) {
            HasStartYear.Type constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
