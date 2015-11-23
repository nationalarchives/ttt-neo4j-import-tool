
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
    "certain",
    "dateEnd",
    "dateStart",
    "reference"
})
public class HasReference {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * certainty of possession of reference number
     * 
     */
    @JsonProperty("certain")
    private Boolean certain;
    /**
     * end of possession of reference number
     * 
     */
    @JsonProperty("dateEnd")
    private Double dateEnd;
    /**
     * start of possession of reference number
     * 
     */
    @JsonProperty("dateStart")
    private Double dateStart;
    /**
     * reference number of person
     * 
     */
    @JsonProperty("reference")
    private Reference reference;
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
     * certainty of possession of reference number
     * 
     * @return
     *     The certain
     */
    @JsonProperty("certain")
    public Boolean getCertain() {
        return certain;
    }

    /**
     * certainty of possession of reference number
     * 
     * @param certain
     *     The certain
     */
    @JsonProperty("certain")
    public void setCertain(Boolean certain) {
        this.certain = certain;
    }

    /**
     * end of possession of reference number
     * 
     * @return
     *     The dateEnd
     */
    @JsonProperty("dateEnd")
    public Double getDateEnd() {
        return dateEnd;
    }

    /**
     * end of possession of reference number
     * 
     * @param dateEnd
     *     The dateEnd
     */
    @JsonProperty("dateEnd")
    public void setDateEnd(Double dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * start of possession of reference number
     * 
     * @return
     *     The dateStart
     */
    @JsonProperty("dateStart")
    public Double getDateStart() {
        return dateStart;
    }

    /**
     * start of possession of reference number
     * 
     * @param dateStart
     *     The dateStart
     */
    @JsonProperty("dateStart")
    public void setDateStart(Double dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * reference number of person
     * 
     * @return
     *     The reference
     */
    @JsonProperty("reference")
    public Reference getReference() {
        return reference;
    }

    /**
     * reference number of person
     * 
     * @param reference
     *     The reference
     */
    @JsonProperty("reference")
    public void setReference(Reference reference) {
        this.reference = reference;
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
        return new HashCodeBuilder().append(comments).append(certain).append(dateEnd).append(dateStart).append(reference).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HasReference) == false) {
            return false;
        }
        HasReference rhs = ((HasReference) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(certain, rhs.certain).append(dateEnd, rhs.dateEnd).append(dateStart, rhs.dateStart).append(reference, rhs.reference).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
