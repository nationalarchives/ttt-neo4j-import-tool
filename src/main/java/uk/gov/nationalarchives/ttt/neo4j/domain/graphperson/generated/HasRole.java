
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "certain",
    "dateEnd",
    "dateStart",
    "name",
    "precedence",
    "event",
    "organisation",
    "person",
    "place"
})
public class HasRole {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * certainty of involvement with the role
     * 
     */
    @JsonProperty("certain")
    private Boolean certain;
    /**
     * end of involvement with the role
     * 
     */
    @JsonProperty("dateEnd")
    private Double dateEnd;
    /**
     * start of involvement with the role
     * 
     */
    @JsonProperty("dateStart")
    private Double dateStart;
    /**
     * description or nature of the role
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * sequence of involvement with the role
     * 
     */
    @JsonProperty("precedence")
    private Integer precedence;
    /**
     * a personal event
     * 
     */
    @JsonProperty("event")
    private Event event;
    /**
     * an organisation or group
     * 
     */
    @JsonProperty("organisation")
    private Organisation organisation;
    /**
     * Person
     * <p>
     * TTT JSON Schema, v2.0. A person identified in a Traces Through Time dataset
     * 
     */
    @JsonProperty("person")
    private Person person;
    /**
     * a place or location
     * 
     */
    @JsonProperty("place")
    private Place place;
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
     * certainty of involvement with the role
     * 
     * @return
     *     The certain
     */
    @JsonProperty("certain")
    public Boolean getCertain() {
        return certain;
    }

    /**
     * certainty of involvement with the role
     * 
     * @param certain
     *     The certain
     */
    @JsonProperty("certain")
    public void setCertain(Boolean certain) {
        this.certain = certain;
    }

    /**
     * end of involvement with the role
     * 
     * @return
     *     The dateEnd
     */
    @JsonProperty("dateEnd")
    public Double getDateEnd() {
        return dateEnd;
    }

    /**
     * end of involvement with the role
     * 
     * @param dateEnd
     *     The dateEnd
     */
    @JsonProperty("dateEnd")
    public void setDateEnd(Double dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * start of involvement with the role
     * 
     * @return
     *     The dateStart
     */
    @JsonProperty("dateStart")
    public Double getDateStart() {
        return dateStart;
    }

    /**
     * start of involvement with the role
     * 
     * @param dateStart
     *     The dateStart
     */
    @JsonProperty("dateStart")
    public void setDateStart(Double dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * description or nature of the role
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * description or nature of the role
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sequence of involvement with the role
     * 
     * @return
     *     The precedence
     */
    @JsonProperty("precedence")
    public Integer getPrecedence() {
        return precedence;
    }

    /**
     * sequence of involvement with the role
     * 
     * @param precedence
     *     The precedence
     */
    @JsonProperty("precedence")
    public void setPrecedence(Integer precedence) {
        this.precedence = precedence;
    }

    /**
     * a personal event
     * 
     * @return
     *     The event
     */
    @JsonProperty("event")
    public Event getEvent() {
        return event;
    }

    /**
     * a personal event
     * 
     * @param event
     *     The event
     */
    @JsonProperty("event")
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * an organisation or group
     * 
     * @return
     *     The organisation
     */
    @JsonProperty("organisation")
    public Organisation getOrganisation() {
        return organisation;
    }

    /**
     * an organisation or group
     * 
     * @param organisation
     *     The organisation
     */
    @JsonProperty("organisation")
    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
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

    /**
     * a place or location
     * 
     * @return
     *     The place
     */
    @JsonProperty("place")
    public Place getPlace() {
        return place;
    }

    /**
     * a place or location
     * 
     * @param place
     *     The place
     */
    @JsonProperty("place")
    public void setPlace(Place place) {
        this.place = place;
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
        return new HashCodeBuilder().append(comments).append(certain).append(dateEnd).append(dateStart).append(name).append(precedence).append(event).append(organisation).append(person).append(place).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HasRole) == false) {
            return false;
        }
        HasRole rhs = ((HasRole) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(certain, rhs.certain).append(dateEnd, rhs.dateEnd).append(dateStart, rhs.dateStart).append(name, rhs.name).append(precedence, rhs.precedence).append(event, rhs.event).append(organisation, rhs.organisation).append(person, rhs.person).append(place, rhs.place).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
