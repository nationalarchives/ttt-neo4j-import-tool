
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
 * person's family name
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "name",
    "type",
    "familyNameAliases",
    "hasParticle"
})
public class FamilyName {

    /**
     * general notes / comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * name of person's family name
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * type of person's family name
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * person's family name has alias(es)
     * 
     */
    @JsonProperty("familyNameAliases")
    private List<FamilyNameAlias> familyNameAliases = new ArrayList<FamilyNameAlias>();
    /**
     * alias has nobiliary or other descriptive/prepositional particle(s)
     * 
     */
    @JsonProperty("hasParticle")
    private HasParticle hasParticle;
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
     * name of person's family name
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
     * name of person's family name
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
     * type of person's family name
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type of person's family name
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * person's family name has alias(es)
     * 
     * @return
     *     The familyNameAliases
     */
    @JsonProperty("familyNameAliases")
    public List<FamilyNameAlias> getFamilyNameAliases() {
        return familyNameAliases;
    }

    /**
     * person's family name has alias(es)
     * 
     * @param familyNameAliases
     *     The familyNameAliases
     */
    @JsonProperty("familyNameAliases")
    public void setFamilyNameAliases(List<FamilyNameAlias> familyNameAliases) {
        this.familyNameAliases = familyNameAliases;
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
        return new HashCodeBuilder().append(comments).append(name).append(type).append(familyNameAliases).append(hasParticle).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FamilyName) == false) {
            return false;
        }
        FamilyName rhs = ((FamilyName) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(name, rhs.name).append(type, rhs.type).append(familyNameAliases, rhs.familyNameAliases).append(hasParticle, rhs.hasParticle).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
