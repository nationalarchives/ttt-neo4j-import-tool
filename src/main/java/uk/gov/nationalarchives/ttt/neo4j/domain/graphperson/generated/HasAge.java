
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
 * person has an age
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "certain",
    "dateEnd",
    "dateStart",
    "type",
    "age"
})
public class HasAge {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * certainty of age identification
     * 
     */
    @JsonProperty("certain")
    private Boolean certain;
    /**
     * end of dates covering age identification
     * 
     */
    @JsonProperty("dateEnd")
    private Double dateEnd;
    /**
     * start of date(s) covering age identification
     * 
     */
    @JsonProperty("dateStart")
    private Double dateStart;
    /**
     * exactness of age identification
     * 
     */
    @JsonProperty("type")
    private HasAge.Type type = HasAge.Type.fromValue("APPROX");
    /**
     * age of person
     * 
     */
    @JsonProperty("age")
    private Age age;
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
     * certainty of age identification
     * 
     * @return
     *     The certain
     */
    @JsonProperty("certain")
    public Boolean getCertain() {
        return certain;
    }

    /**
     * certainty of age identification
     * 
     * @param certain
     *     The certain
     */
    @JsonProperty("certain")
    public void setCertain(Boolean certain) {
        this.certain = certain;
    }

    /**
     * end of dates covering age identification
     * 
     * @return
     *     The dateEnd
     */
    @JsonProperty("dateEnd")
    public Double getDateEnd() {
        return dateEnd;
    }

    /**
     * end of dates covering age identification
     * 
     * @param dateEnd
     *     The dateEnd
     */
    @JsonProperty("dateEnd")
    public void setDateEnd(Double dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * start of date(s) covering age identification
     * 
     * @return
     *     The dateStart
     */
    @JsonProperty("dateStart")
    public Double getDateStart() {
        return dateStart;
    }

    /**
     * start of date(s) covering age identification
     * 
     * @param dateStart
     *     The dateStart
     */
    @JsonProperty("dateStart")
    public void setDateStart(Double dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * exactness of age identification
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public HasAge.Type getType() {
        return type;
    }

    /**
     * exactness of age identification
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(HasAge.Type type) {
        this.type = type;
    }

    /**
     * age of person
     * 
     * @return
     *     The age
     */
    @JsonProperty("age")
    public Age getAge() {
        return age;
    }

    /**
     * age of person
     * 
     * @param age
     *     The age
     */
    @JsonProperty("age")
    public void setAge(Age age) {
        this.age = age;
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
        return new HashCodeBuilder().append(comments).append(certain).append(dateEnd).append(dateStart).append(type).append(age).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HasAge) == false) {
            return false;
        }
        HasAge rhs = ((HasAge) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(certain, rhs.certain).append(dateEnd, rhs.dateEnd).append(dateStart, rhs.dateStart).append(type, rhs.type).append(age, rhs.age).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum Type {

        APPROX("APPROX"),
        EXACT("EXACT");
        private final String value;
        private static Map<String, HasAge.Type> constants = new HashMap<String, HasAge.Type>();

        static {
            for (HasAge.Type c: values()) {
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
        public static HasAge.Type fromValue(String value) {
            HasAge.Type constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
