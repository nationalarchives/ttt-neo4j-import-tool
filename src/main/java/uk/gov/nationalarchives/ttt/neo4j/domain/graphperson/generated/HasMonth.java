
package uk.gov.nationalarchives.ttt.linker.model.graphperson.generated;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;


/**
 * has a month date
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "type",
    "month"
})
public class HasMonth {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * exactness of month date
     * 
     */
    @JsonProperty("type")
    private HasMonth.Type type = HasMonth.Type.fromValue("APPROX");
    /**
     * a single month
     * 
     */
    @JsonProperty("month")
    private Month month;
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
     * exactness of month date
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public HasMonth.Type getType() {
        return type;
    }

    /**
     * exactness of month date
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(HasMonth.Type type) {
        this.type = type;
    }

    /**
     * a single month
     * 
     * @return
     *     The month
     */
    @JsonProperty("month")
    public Month getMonth() {
        return month;
    }

    /**
     * a single month
     * 
     * @param month
     *     The month
     */
    @JsonProperty("month")
    public void setMonth(Month month) {
        this.month = month;
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
        return new HashCodeBuilder().append(comments).append(type).append(month).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HasMonth) == false) {
            return false;
        }
        HasMonth rhs = ((HasMonth) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(type, rhs.type).append(month, rhs.month).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum Type {

        APPROX("APPROX"),
        EXACT("EXACT");
        private final String value;
        private static Map<String, HasMonth.Type> constants = new HashMap<String, HasMonth.Type>();

        static {
            for (HasMonth.Type c: values()) {
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
        public static HasMonth.Type fromValue(String value) {
            HasMonth.Type constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
