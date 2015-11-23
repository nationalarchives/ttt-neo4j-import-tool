
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
    "type",
    "foreName"
})
public class ForeNameAlias {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * type of alias
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * person's forename
     * 
     */
    @JsonProperty("foreName")
    private ForeName foreName;
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
     * type of alias
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type of alias
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * person's forename
     * 
     * @return
     *     The foreName
     */
    @JsonProperty("foreName")
    public ForeName getForeName() {
        return foreName;
    }

    /**
     * person's forename
     * 
     * @param foreName
     *     The foreName
     */
    @JsonProperty("foreName")
    public void setForeName(ForeName foreName) {
        this.foreName = foreName;
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
        return new HashCodeBuilder().append(comments).append(type).append(foreName).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ForeNameAlias) == false) {
            return false;
        }
        ForeNameAlias rhs = ((ForeNameAlias) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(type, rhs.type).append(foreName, rhs.foreName).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
