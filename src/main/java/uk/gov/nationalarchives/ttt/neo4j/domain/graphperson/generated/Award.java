
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
    private List<AwardAlias> awardAliases = new ArrayList<AwardAlias>();
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
    public List<AwardAlias> getAwardAliases() {
        return awardAliases;
    }

    /**
     * award has alias(es)
     * 
     * @param awardAliases
     *     The awardAliases
     */
    @JsonProperty("awardAliases")
    public void setAwardAliases(List<AwardAlias> awardAliases) {
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
