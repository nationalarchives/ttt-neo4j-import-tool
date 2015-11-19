
package uk.gov.nationalarchives.ttt.linker.model.graphperson.generated;

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
 * an organisation or group
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "genre",
    "hasPlaces",
    "name",
    "organisationAliases",
    "ref",
    "type"
})
public class Organisation {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * genre of organisation
     * 
     */
    @JsonProperty("genre")
    private String genre;
    /**
     * has association with a place
     * 
     */
    @JsonProperty("hasPlaces")
    private List<HasPlace> hasPlaces = new ArrayList<HasPlace>();
    /**
     * name of organisation
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * organisation has alias(es)
     * 
     */
    @JsonProperty("organisationAliases")
    private List<OrganisationAlias> organisationAliases = new ArrayList<OrganisationAlias>();
    /**
     * organisation identifier
     * 
     */
    @JsonProperty("ref")
    private String ref;
    /**
     * type of organisation
     * 
     */
    @JsonProperty("type")
    private String type;
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
     * genre of organisation
     * 
     * @return
     *     The genre
     */
    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    /**
     * genre of organisation
     * 
     * @param genre
     *     The genre
     */
    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
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
     * name of organisation
     * (Required)
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name of organisation
     * (Required)
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * organisation has alias(es)
     * 
     * @return
     *     The organisationAliases
     */
    @JsonProperty("organisationAliases")
    public List<OrganisationAlias> getOrganisationAliases() {
        return organisationAliases;
    }

    /**
     * organisation has alias(es)
     * 
     * @param organisationAliases
     *     The organisationAliases
     */
    @JsonProperty("organisationAliases")
    public void setOrganisationAliases(List<OrganisationAlias> organisationAliases) {
        this.organisationAliases = organisationAliases;
    }

    /**
     * organisation identifier
     * 
     * @return
     *     The ref
     */
    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    /**
     * organisation identifier
     * 
     * @param ref
     *     The ref
     */
    @JsonProperty("ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * type of organisation
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type of organisation
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
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
        return new HashCodeBuilder().append(comments).append(genre).append(hasPlaces).append(name).append(organisationAliases).append(ref).append(type).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Organisation) == false) {
            return false;
        }
        Organisation rhs = ((Organisation) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(genre, rhs.genre).append(hasPlaces, rhs.hasPlaces).append(name, rhs.name).append(organisationAliases, rhs.organisationAliases).append(ref, rhs.ref).append(type, rhs.type).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
