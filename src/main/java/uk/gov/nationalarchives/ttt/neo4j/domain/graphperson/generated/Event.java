
package uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "hasYear",
    "hasEndYear",
    "hasStartYear",
    "hasOrganisations",
    "hasPlaces"
})
public class Event {

    /**
     * general notes / comments
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
     * has a single year date
     * 
     */
    @JsonProperty("hasYear")
    private HasYear hasYear;
    /**
     * has an end year date
     * 
     */
    @JsonProperty("hasEndYear")
    private HasEndYear hasEndYear;
    /**
     * has a start year date
     * 
     */
    @JsonProperty("hasStartYear")
    private HasStartYear hasStartYear;
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
        return new HashCodeBuilder().append(comments).append(genre).append(type).append(hasYear).append(hasEndYear).append(hasStartYear).append(hasOrganisations).append(hasPlaces).append(additionalProperties).toHashCode();
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
        return new EqualsBuilder().append(comments, rhs.comments).append(genre, rhs.genre).append(type, rhs.type).append(hasYear, rhs.hasYear).append(hasEndYear, rhs.hasEndYear).append(hasStartYear, rhs.hasStartYear).append(hasOrganisations, rhs.hasOrganisations).append(hasPlaces, rhs.hasPlaces).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
