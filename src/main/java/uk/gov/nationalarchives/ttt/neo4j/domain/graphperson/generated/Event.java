
package uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * a personal event
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "genre",
    "type",
    "hasDay",
    "hasEndYear",
    "hasMonth",
    "hasOrganisations",
    "hasPlaces",
    "hasStartYear",
    "hasTime",
    "hasYear"
})
public class Event {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * genre of event
     * 
     */
    @JsonProperty("genre")
    private String genre;
    /**
     * name of event
     * (Required)
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * has a day date
     * 
     */
    @JsonProperty("hasDay")
    private HasDay hasDay;
    /**
     * has an end year date
     * 
     */
    @JsonProperty("hasEndYear")
    private HasEndYear hasEndYear;
    /**
     * has a month date
     * 
     */
    @JsonProperty("hasMonth")
    private HasMonth hasMonth;
    /**
     * involves organisation(s)
     * 
     */
    @JsonProperty("hasOrganisations")
    private List<HasOrganisation> hasOrganisations = new ArrayList<HasOrganisation>();
    /**
     * has association with a place
     * 
     */
    @JsonProperty("hasPlaces")
    private List<HasPlace> hasPlaces = new ArrayList<HasPlace>();
    /**
     * has a start year date
     * 
     */
    @JsonProperty("hasStartYear")
    private HasStartYear hasStartYear;
    /**
     * has a time
     * 
     */
    @JsonProperty("hasTime")
    private HasTime hasTime;
    /**
     * has a single year date
     * 
     */
    @JsonProperty("hasYear")
    private HasYear hasYear;
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
     * genre of event
     * 
     * @return
     *     The genre
     */
    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    /**
     * genre of event
     * 
     * @param genre
     *     The genre
     */
    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * name of event
     * (Required)
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * name of event
     * (Required)
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * has a day date
     * 
     * @return
     *     The hasDay
     */
    @JsonProperty("hasDay")
    public HasDay getHasDay() {
        return hasDay;
    }

    /**
     * has a day date
     * 
     * @param hasDay
     *     The hasDay
     */
    @JsonProperty("hasDay")
    public void setHasDay(HasDay hasDay) {
        this.hasDay = hasDay;
    }

    /**
     * has an end year date
     * 
     * @return
     *     The hasEndYear
     */
    @JsonProperty("hasEndYear")
    public HasEndYear getHasEndYear() {
        return hasEndYear;
    }

    /**
     * has an end year date
     * 
     * @param hasEndYear
     *     The hasEndYear
     */
    @JsonProperty("hasEndYear")
    public void setHasEndYear(HasEndYear hasEndYear) {
        this.hasEndYear = hasEndYear;
    }

    /**
     * has a month date
     * 
     * @return
     *     The hasMonth
     */
    @JsonProperty("hasMonth")
    public HasMonth getHasMonth() {
        return hasMonth;
    }

    /**
     * has a month date
     * 
     * @param hasMonth
     *     The hasMonth
     */
    @JsonProperty("hasMonth")
    public void setHasMonth(HasMonth hasMonth) {
        this.hasMonth = hasMonth;
    }

    /**
     * involves organisation(s)
     * 
     * @return
     *     The hasOrganisations
     */
    @JsonProperty("hasOrganisations")
    public List<HasOrganisation> getHasOrganisations() {
        return hasOrganisations;
    }

    /**
     * involves organisation(s)
     * 
     * @param hasOrganisations
     *     The hasOrganisations
     */
    @JsonProperty("hasOrganisations")
    public void setHasOrganisations(List<HasOrganisation> hasOrganisations) {
        this.hasOrganisations = hasOrganisations;
    }

    /**
     * has association with a place
     * 
     * @return
     *     The hasPlaces
     */
    @JsonProperty("hasPlaces")
    public List<HasPlace> getHasPlaces() {
        return hasPlaces;
    }

    /**
     * has association with a place
     * 
     * @param hasPlaces
     *     The hasPlaces
     */
    @JsonProperty("hasPlaces")
    public void setHasPlaces(List<HasPlace> hasPlaces) {
        this.hasPlaces = hasPlaces;
    }

    /**
     * has a start year date
     * 
     * @return
     *     The hasStartYear
     */
    @JsonProperty("hasStartYear")
    public HasStartYear getHasStartYear() {
        return hasStartYear;
    }

    /**
     * has a start year date
     * 
     * @param hasStartYear
     *     The hasStartYear
     */
    @JsonProperty("hasStartYear")
    public void setHasStartYear(HasStartYear hasStartYear) {
        this.hasStartYear = hasStartYear;
    }

    /**
     * has a time
     * 
     * @return
     *     The hasTime
     */
    @JsonProperty("hasTime")
    public HasTime getHasTime() {
        return hasTime;
    }

    /**
     * has a time
     * 
     * @param hasTime
     *     The hasTime
     */
    @JsonProperty("hasTime")
    public void setHasTime(HasTime hasTime) {
        this.hasTime = hasTime;
    }

    /**
     * has a single year date
     * 
     * @return
     *     The hasYear
     */
    @JsonProperty("hasYear")
    public HasYear getHasYear() {
        return hasYear;
    }

    /**
     * has a single year date
     * 
     * @param hasYear
     *     The hasYear
     */
    @JsonProperty("hasYear")
    public void setHasYear(HasYear hasYear) {
        this.hasYear = hasYear;
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
        return new HashCodeBuilder().append(comments).append(genre).append(type).append(hasDay).append(hasEndYear).append(hasMonth).append(hasOrganisations).append(hasPlaces).append(hasStartYear).append(hasTime).append(hasYear).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Event) == false) {
            return false;
        }
        Event rhs = ((Event) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(genre, rhs.genre).append(type, rhs.type).append(hasDay, rhs.hasDay).append(hasEndYear, rhs.hasEndYear).append(hasMonth, rhs.hasMonth).append(hasOrganisations, rhs.hasOrganisations).append(hasPlaces, rhs.hasPlaces).append(hasStartYear, rhs.hasStartYear).append(hasTime, rhs.hasTime).append(hasYear, rhs.hasYear).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
