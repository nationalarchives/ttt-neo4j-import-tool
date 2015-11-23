
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
 * a place or location
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "name",
    "type",
    "hasPlaces",
    "placeAliases",
    "withinPlaces"
})
public class Place {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * name of place
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * type of place
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * has association with a place
     * 
     */
    @JsonProperty("hasPlaces")
    private HasPlace hasPlaces;
    /**
     * place has alias(es)
     * 
     */
    @JsonProperty("placeAliases")
    private List<PlaceAlias> placeAliases = new ArrayList<PlaceAlias>();
    /**
     * place is wholly or partially contained by another place
     * 
     */
    @JsonProperty("withinPlaces")
    private List<WithinPlace> withinPlaces = new ArrayList<WithinPlace>();
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
     * name of place
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
     * name of place
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
     * type of place
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type of place
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * has association with a place
     * 
     * @return
     *     The hasPlaces
     */
    @JsonProperty("hasPlaces")
    public HasPlace getHasPlaces() {
        return hasPlaces;
    }

    /**
     * has association with a place
     * 
     * @param hasPlaces
     *     The hasPlaces
     */
    @JsonProperty("hasPlaces")
    public void setHasPlaces(HasPlace hasPlaces) {
        this.hasPlaces = hasPlaces;
    }

    /**
     * place has alias(es)
     * 
     * @return
     *     The placeAliases
     */
    @JsonProperty("placeAliases")
    public List<PlaceAlias> getPlaceAliases() {
        return placeAliases;
    }

    /**
     * place has alias(es)
     * 
     * @param placeAliases
     *     The placeAliases
     */
    @JsonProperty("placeAliases")
    public void setPlaceAliases(List<PlaceAlias> placeAliases) {
        this.placeAliases = placeAliases;
    }

    /**
     * place is wholly or partially contained by another place
     * 
     * @return
     *     The withinPlaces
     */
    @JsonProperty("withinPlaces")
    public List<WithinPlace> getWithinPlaces() {
        return withinPlaces;
    }

    /**
     * place is wholly or partially contained by another place
     * 
     * @param withinPlaces
     *     The withinPlaces
     */
    @JsonProperty("withinPlaces")
    public void setWithinPlaces(List<WithinPlace> withinPlaces) {
        this.withinPlaces = withinPlaces;
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
        return new HashCodeBuilder().append(comments).append(name).append(type).append(hasPlaces).append(placeAliases).append(withinPlaces).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Place) == false) {
            return false;
        }
        Place rhs = ((Place) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(name, rhs.name).append(type, rhs.type).append(hasPlaces, rhs.hasPlaces).append(placeAliases, rhs.placeAliases).append(withinPlaces, rhs.withinPlaces).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
