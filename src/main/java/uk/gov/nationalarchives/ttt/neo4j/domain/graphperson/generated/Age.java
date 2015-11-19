
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
 * age of person
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "end",
    "name",
    "start",
    "type"
})
public class Age {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * end of age range
     * 
     */
    @JsonProperty("end")
    private Double end;
    /**
     * description of age
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * start of age range
     * (Required)
     * 
     */
    @JsonProperty("start")
    private Double start;
    /**
     * exactness of age
     * 
     */
    @JsonProperty("type")
    private Age.Type type = Age.Type.fromValue("APPROX");
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
     * end of age range
     * 
     * @return
     *     The end
     */
    @JsonProperty("end")
    public Double getEnd() {
        return end;
    }

    /**
     * end of age range
     * 
     * @param end
     *     The end
     */
    @JsonProperty("end")
    public void setEnd(Double end) {
        this.end = end;
    }

    /**
     * description of age
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * description of age
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * start of age range
     * (Required)
     * 
     * @return
     *     The start
     */
    @JsonProperty("start")
    public Double getStart() {
        return start;
    }

    /**
     * start of age range
     * (Required)
     * 
     * @param start
     *     The start
     */
    @JsonProperty("start")
    public void setStart(Double start) {
        this.start = start;
    }

    /**
     * exactness of age
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public Age.Type getType() {
        return type;
    }

    /**
     * exactness of age
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(Age.Type type) {
        this.type = type;
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
        return new HashCodeBuilder().append(comments).append(end).append(name).append(start).append(type).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Age) == false) {
            return false;
        }
        Age rhs = ((Age) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(end, rhs.end).append(name, rhs.name).append(start, rhs.start).append(type, rhs.type).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum Type {

        APPROX("APPROX"),
        EXACT("EXACT");
        private final String value;
        private static Map<String, Age.Type> constants = new HashMap<String, Age.Type>();

        static {
            for (Age.Type c: values()) {
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
        public static Age.Type fromValue(String value) {
            Age.Type constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
