
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
 * alias of person
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "name",
    "hasParticle"
})
public class Alias {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * name of alias
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * alias has nobiliary or other descriptive/prepositional particle(s)
     * 
     */
    @JsonProperty("hasParticle")
    private HasParticle hasParticle;
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
     * name of alias
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
     * name of alias
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
     * alias has nobiliary or other descriptive/prepositional particle(s)
     * 
     * @return
     *     The hasParticle
     */
    @JsonProperty("hasParticle")
    public HasParticle getHasParticle() {
        return hasParticle;
    }

    /**
     * alias has nobiliary or other descriptive/prepositional particle(s)
     * 
     * @param hasParticle
     *     The hasParticle
     */
    @JsonProperty("hasParticle")
    public void setHasParticle(HasParticle hasParticle) {
        this.hasParticle = hasParticle;
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
        return new HashCodeBuilder().append(comments).append(name).append(hasParticle).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Alias) == false) {
            return false;
        }
        Alias rhs = ((Alias) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(name, rhs.name).append(hasParticle, rhs.hasParticle).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
