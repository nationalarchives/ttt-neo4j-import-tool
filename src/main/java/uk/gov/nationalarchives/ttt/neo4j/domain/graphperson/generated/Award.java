
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
 * person's award
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "name",
    "awardAliases"
})
public class Award {

    /**
     * general notes / comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * name of award
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * award has alias(es)
     * 
     */
    @JsonProperty("awardAliases")
    private List<uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.AwardAlias> awardAliases = new ArrayList<uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.AwardAlias>();
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
     * name of award
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
     * name of award
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
     * award has alias(es)
     * 
     * @return
     *     The awardAliases
     */
    @JsonProperty("awardAliases")
    public List<uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.AwardAlias> getAwardAliases() {
        return awardAliases;
    }

    /**
     * award has alias(es)
     * 
     * @param awardAliases
     *     The awardAliases
     */
    @JsonProperty("awardAliases")
    public void setAwardAliases(List<uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.generated.AwardAlias> awardAliases) {
        this.awardAliases = awardAliases;
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
        return new HashCodeBuilder().append(comments).append(name).append(awardAliases).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Award) == false) {
            return false;
        }
        Award rhs = ((Award) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(name, rhs.name).append(awardAliases, rhs.awardAliases).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
