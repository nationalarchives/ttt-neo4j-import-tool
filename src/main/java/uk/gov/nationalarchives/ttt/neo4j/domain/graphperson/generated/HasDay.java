
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
 * has a day date
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "type",
    "day"
})
public class HasDay {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * exactness of day date
     * 
     */
    @JsonProperty("type")
    private HasDay.Type type = HasDay.Type.fromValue("APPROX");
    /**
     * a single day
     * 
     */
    @JsonProperty("day")
    private Day day;
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
     * exactness of day date
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public HasDay.Type getType() {
        return type;
    }

    /**
     * exactness of day date
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(HasDay.Type type) {
        this.type = type;
    }

    /**
     * a single day
     * 
     * @return
     *     The day
     */
    @JsonProperty("day")
    public Day getDay() {
        return day;
    }

    /**
     * a single day
     * 
     * @param day
     *     The day
     */
    @JsonProperty("day")
    public void setDay(Day day) {
        this.day = day;
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
        return new HashCodeBuilder().append(comments).append(type).append(day).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HasDay) == false) {
            return false;
        }
        HasDay rhs = ((HasDay) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(type, rhs.type).append(day, rhs.day).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum Type {

        APPROX("APPROX"),
        EXACT("EXACT");
        private final String value;
        private static Map<String, HasDay.Type> constants = new HashMap<String, HasDay.Type>();

        static {
            for (HasDay.Type c: values()) {
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
        public static HasDay.Type fromValue(String value) {
            HasDay.Type constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
