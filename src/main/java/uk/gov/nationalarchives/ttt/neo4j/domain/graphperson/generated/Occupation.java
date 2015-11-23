
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
 * person's occupation
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "genre",
    "hasPlaces",
    "name",
    "occupationAliases"
})
public class Occupation {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * field of occupation
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
     * name of occupation
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * occupation has alias(es)
     * 
     */
    @JsonProperty("occupationAliases")
    private List<OccupationAlias> occupationAliases = new ArrayList<OccupationAlias>();
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
     * field of occupation
     * 
     * @return
     *     The genre
     */
    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    /**
     * field of occupation
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
     * name of occupation
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
     * name of occupation
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
     * occupation has alias(es)
     * 
     * @return
     *     The occupationAliases
     */
    @JsonProperty("occupationAliases")
    public List<OccupationAlias> getOccupationAliases() {
        return occupationAliases;
    }

    /**
     * occupation has alias(es)
     * 
     * @param occupationAliases
     *     The occupationAliases
     */
    @JsonProperty("occupationAliases")
    public void setOccupationAliases(List<OccupationAlias> occupationAliases) {
        this.occupationAliases = occupationAliases;
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
        return new HashCodeBuilder().append(comments).append(genre).append(hasPlaces).append(name).append(occupationAliases).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Occupation) == false) {
            return false;
        }
        Occupation rhs = ((Occupation) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(genre, rhs.genre).append(hasPlaces, rhs.hasPlaces).append(name, rhs.name).append(occupationAliases, rhs.occupationAliases).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
