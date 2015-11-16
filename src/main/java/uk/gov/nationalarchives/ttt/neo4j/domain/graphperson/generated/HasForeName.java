
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
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.Transient;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Neo4jObject;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.Neo4jPerson;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "certain",
    "dateEnd",
    "dateStart",
    "order",
    "precedence",
    "preference",
    "foreName"
})
@RelationshipEntity(type="HAS_FORE_NAME")
public class HasForeName extends Neo4jObject {

    @JsonIgnore
    @StartNode
    private Neo4jPerson person;

    /**
     * general notes / comments
     * 
     */
    @JsonProperty("comments")
    @Transient
    private String comments;
    /**
     * certainty of person's possession of a forename
     * 
     */
    @JsonProperty("certain")
    @Transient
    private Boolean certain;
    /**
     * end of person's possession of a forename
     * 
     */
    @JsonProperty("dateEnd")
    @Transient
    private Double dateEnd;
    /**
     * start of person's possession of a forename
     * 
     */
    @JsonProperty("dateStart")
    @Transient
    private Double dateStart;
    /**
     * formal order of person's multiple forenames
     * (Required)
     * 
     */
    @JsonProperty("order")
    @Transient
    private Integer order;
    /**
     * chronological sequence of person's possession of different forenames
     * 
     */
    @JsonProperty("precedence")
    @Transient
    private Integer precedence;
    /**
     * preference of person's usage of a forename
     * 
     */
    @JsonProperty("preference")
    @Transient
    private Integer preference;
    /**
     * person's forename
     * (Required)
     * 
     */
    @EndNode
    @JsonProperty("foreName")
    private ForeName foreName;
    @JsonIgnore
    @Transient
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
     * certainty of person's possession of a forename
     * 
     * @return
     *     The certain
     */
    @JsonProperty("certain")
    public Boolean getCertain() {
        return certain;
    }

    /**
     * certainty of person's possession of a forename
     * 
     * @param certain
     *     The certain
     */
    @JsonProperty("certain")
    public void setCertain(Boolean certain) {
        this.certain = certain;
    }

    /**
     * end of person's possession of a forename
     * 
     * @return
     *     The dateEnd
     */
    @JsonProperty("dateEnd")
    public Double getDateEnd() {
        return dateEnd;
    }

    /**
     * end of person's possession of a forename
     * 
     * @param dateEnd
     *     The dateEnd
     */
    @JsonProperty("dateEnd")
    public void setDateEnd(Double dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * start of person's possession of a forename
     * 
     * @return
     *     The dateStart
     */
    @JsonProperty("dateStart")
    public Double getDateStart() {
        return dateStart;
    }

    /**
     * start of person's possession of a forename
     * 
     * @param dateStart
     *     The dateStart
     */
    @JsonProperty("dateStart")
    public void setDateStart(Double dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * formal order of person's multiple forenames
     * (Required)
     * 
     * @return
     *     The order
     */
    @JsonProperty("order")
    public Integer getOrder() {
        return order;
    }

    /**
     * formal order of person's multiple forenames
     * (Required)
     * 
     * @param order
     *     The order
     */
    @JsonProperty("order")
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * chronological sequence of person's possession of different forenames
     * 
     * @return
     *     The precedence
     */
    @JsonProperty("precedence")
    public Integer getPrecedence() {
        return precedence;
    }

    /**
     * chronological sequence of person's possession of different forenames
     * 
     * @param precedence
     *     The precedence
     */
    @JsonProperty("precedence")
    public void setPrecedence(Integer precedence) {
        this.precedence = precedence;
    }

    /**
     * preference of person's usage of a forename
     * 
     * @return
     *     The preference
     */
    @JsonProperty("preference")
    public Integer getPreference() {
        return preference;
    }

    /**
     * preference of person's usage of a forename
     * 
     * @param preference
     *     The preference
     */
    @JsonProperty("preference")
    public void setPreference(Integer preference) {
        this.preference = preference;
    }

    /**
     * person's forename
     * (Required)
     * 
     * @return
     *     The foreName
     */
    @JsonProperty("foreName")
    public ForeName getForeName() {
        return foreName;
    }

    /**
     * person's forename
     * (Required)
     * 
     * @param foreName
     *     The foreName
     */
    @JsonProperty("foreName")
    public void setForeName(ForeName foreName) {
        this.foreName = foreName;
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
        return new HashCodeBuilder().append(comments).append(certain).append(dateEnd).append(dateStart).append(order).append(precedence).append(preference).append(foreName).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HasForeName) == false) {
            return false;
        }
        HasForeName rhs = ((HasForeName) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(certain, rhs.certain).append(dateEnd, rhs.dateEnd).append(dateStart, rhs.dateStart).append(order, rhs.order).append(precedence, rhs.precedence).append(preference, rhs.preference).append(foreName, rhs.foreName).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public Neo4jPerson getPerson() {
        return person;
    }

    public void setPerson(Neo4jPerson person) {
        this.person = person;
    }
}
