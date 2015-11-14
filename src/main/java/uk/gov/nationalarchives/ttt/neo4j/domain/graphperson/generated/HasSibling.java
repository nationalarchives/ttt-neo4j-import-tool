
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
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Person;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "certain",
    "dateEnd",
    "dateStart",
    "precedence",
    "score",
    "type",
    "person"
})
public class HasSibling {

    /**
     * general notes / comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * certainty of having sibling
     * 
     */
    @JsonProperty("certain")
    private Boolean certain;
    /**
     * end of having sibling
     * 
     */
    @JsonProperty("dateEnd")
    private Double dateEnd;
    /**
     * start of having sibling
     * 
     */
    @JsonProperty("dateStart")
    private Double dateStart;
    /**
     * relative order of siblings where -1 etc. is younger and +1 etc. is older
     * 
     */
    @JsonProperty("precedence")
    private Integer precedence;
    /**
     * confidence weighting for the relationship assertion
     * 
     */
    @JsonProperty("score")
    private Double score;
    /**
     * relationship to sibling
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * Person
     * <p>
     * TTT JSON Schema, v2.0. A person identified in a Traces Through Time dataset
     * 
     */
    @JsonProperty("person")
    private Person person;
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
     * certainty of having sibling
     * 
     * @return
     *     The certain
     */
    @JsonProperty("certain")
    public Boolean getCertain() {
        return certain;
    }

    /**
     * certainty of having sibling
     * 
     * @param certain
     *     The certain
     */
    @JsonProperty("certain")
    public void setCertain(Boolean certain) {
        this.certain = certain;
    }

    /**
     * end of having sibling
     * 
     * @return
     *     The dateEnd
     */
    @JsonProperty("dateEnd")
    public Double getDateEnd() {
        return dateEnd;
    }

    /**
     * end of having sibling
     * 
     * @param dateEnd
     *     The dateEnd
     */
    @JsonProperty("dateEnd")
    public void setDateEnd(Double dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * start of having sibling
     * 
     * @return
     *     The dateStart
     */
    @JsonProperty("dateStart")
    public Double getDateStart() {
        return dateStart;
    }

    /**
     * start of having sibling
     * 
     * @param dateStart
     *     The dateStart
     */
    @JsonProperty("dateStart")
    public void setDateStart(Double dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * relative order of siblings where -1 etc. is younger and +1 etc. is older
     * 
     * @return
     *     The precedence
     */
    @JsonProperty("precedence")
    public Integer getPrecedence() {
        return precedence;
    }

    /**
     * relative order of siblings where -1 etc. is younger and +1 etc. is older
     * 
     * @param precedence
     *     The precedence
     */
    @JsonProperty("precedence")
    public void setPrecedence(Integer precedence) {
        this.precedence = precedence;
    }

    /**
     * confidence weighting for the relationship assertion
     * 
     * @return
     *     The score
     */
    @JsonProperty("score")
    public Double getScore() {
        return score;
    }

    /**
     * confidence weighting for the relationship assertion
     * 
     * @param score
     *     The score
     */
    @JsonProperty("score")
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * relationship to sibling
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * relationship to sibling
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Person
     * <p>
     * TTT JSON Schema, v2.0. A person identified in a Traces Through Time dataset
     * 
     * @return
     *     The person
     */
    @JsonProperty("person")
    public Person getPerson() {
        return person;
    }

    /**
     * Person
     * <p>
     * TTT JSON Schema, v2.0. A person identified in a Traces Through Time dataset
     * 
     * @param person
     *     The person
     */
    @JsonProperty("person")
    public void setPerson(Person person) {
        this.person = person;
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
        return new HashCodeBuilder().append(comments).append(certain).append(dateEnd).append(dateStart).append(precedence).append(score).append(type).append(person).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HasSibling) == false) {
            return false;
        }
        HasSibling rhs = ((HasSibling) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(certain, rhs.certain).append(dateEnd, rhs.dateEnd).append(dateStart, rhs.dateStart).append(precedence, rhs.precedence).append(score, rhs.score).append(type, rhs.type).append(person, rhs.person).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
