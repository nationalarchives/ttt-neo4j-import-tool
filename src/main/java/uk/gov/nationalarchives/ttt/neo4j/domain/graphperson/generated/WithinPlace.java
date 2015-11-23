
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
    "place"
})
public class WithinPlace {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
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
        return new HashCodeBuilder().append(comments).append(place).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WithinPlace) == false) {
            return false;
        }
        WithinPlace rhs = ((WithinPlace) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(place, rhs.place).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
