
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
 * has a time
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "type",
    "time"
})
public class HasTime {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * exactness of time
     * 
     */
    @JsonProperty("type")
    private HasTime.Type type = HasTime.Type.fromValue("APPROX");
    /**
     * a single time
     * 
     */
    @JsonProperty("time")
    private Time time;
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
     * exactness of time
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public HasTime.Type getType() {
        return type;
    }

    /**
     * exactness of time
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(HasTime.Type type) {
        this.type = type;
    }

    /**
     * a single time
     * 
     * @return
     *     The time
     */
    @JsonProperty("time")
    public Time getTime() {
        return time;
    }

    /**
     * a single time
     * 
     * @param time
     *     The time
     */
    @JsonProperty("time")
    public void setTime(Time time) {
        this.time = time;
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
        return new HashCodeBuilder().append(comments).append(type).append(time).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HasTime) == false) {
            return false;
        }
        HasTime rhs = ((HasTime) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(type, rhs.type).append(time, rhs.time).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum Type {

        APPROX("APPROX"),
        EXACT("EXACT");
        private final String value;
        private static Map<String, HasTime.Type> constants = new HashMap<String, HasTime.Type>();

        static {
            for (HasTime.Type c: values()) {
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
        public static HasTime.Type fromValue(String value) {
            HasTime.Type constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
