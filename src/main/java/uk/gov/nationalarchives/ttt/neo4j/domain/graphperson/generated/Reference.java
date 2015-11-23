
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


/**
 * reference number of person
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "genre",
    "name",
    "type"
})
public class Reference {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * genre of reference number of person
     * 
     */
    @JsonProperty("genre")
    private String genre;
    /**
     * name of reference number of person
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * type of reference number of person
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
     * genre of reference number of person
     * 
     * @return
     *     The genre
     */
    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    /**
     * genre of reference number of person
     * 
     * @param genre
     *     The genre
     */
    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * name of reference number of person
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
     * name of reference number of person
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
     * type of reference number of person
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type of reference number of person
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
        return new HashCodeBuilder().append(comments).append(genre).append(name).append(type).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Reference) == false) {
            return false;
        }
        Reference rhs = ((Reference) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(genre, rhs.genre).append(name, rhs.name).append(type, rhs.type).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
