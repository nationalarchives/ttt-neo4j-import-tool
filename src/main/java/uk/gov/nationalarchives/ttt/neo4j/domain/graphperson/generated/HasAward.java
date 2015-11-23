
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
    "origin",
    "award"
})
public class HasAward {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * certainty of award
     * 
     */
    @JsonProperty("certain")
    private Boolean certain;
    /**
     * end of dates with award
     * 
     */
    @JsonProperty("dateEnd")
    private Double dateEnd;
    /**
     * start of date(s) with award
     * 
     */
    @JsonProperty("dateStart")
    private Double dateStart;
    /**
     * location or campaign where an individual award was won
     * 
     */
    @JsonProperty("origin")
    private String origin;
    /**
     * person's award
     * 
     */
    @JsonProperty("award")
    private Award award;
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
     * certainty of award
     * 
     * @return
     *     The certain
     */
    @JsonProperty("certain")
    public Boolean getCertain() {
        return certain;
    }

    /**
     * certainty of award
     * 
     * @param certain
     *     The certain
     */
    @JsonProperty("certain")
    public void setCertain(Boolean certain) {
        this.certain = certain;
    }

    /**
     * end of dates with award
     * 
     * @return
     *     The dateEnd
     */
    @JsonProperty("dateEnd")
    public Double getDateEnd() {
        return dateEnd;
    }

    /**
     * end of dates with award
     * 
     * @param dateEnd
     *     The dateEnd
     */
    @JsonProperty("dateEnd")
    public void setDateEnd(Double dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * start of date(s) with award
     * 
     * @return
     *     The dateStart
     */
    @JsonProperty("dateStart")
    public Double getDateStart() {
        return dateStart;
    }

    /**
     * start of date(s) with award
     * 
     * @param dateStart
     *     The dateStart
     */
    @JsonProperty("dateStart")
    public void setDateStart(Double dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * location or campaign where an individual award was won
     * 
     * @return
     *     The origin
     */
    @JsonProperty("origin")
    public String getOrigin() {
        return origin;
    }

    /**
     * location or campaign where an individual award was won
     * 
     * @param origin
     *     The origin
     */
    @JsonProperty("origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * person's award
     * 
     * @return
     *     The award
     */
    @JsonProperty("award")
    public Award getAward() {
        return award;
    }

    /**
     * person's award
     * 
     * @param award
     *     The award
     */
    @JsonProperty("award")
    public void setAward(Award award) {
        this.award = award;
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
        return new HashCodeBuilder().append(comments).append(certain).append(dateEnd).append(dateStart).append(origin).append(award).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HasAward) == false) {
            return false;
        }
        HasAward rhs = ((HasAward) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(certain, rhs.certain).append(dateEnd, rhs.dateEnd).append(dateStart, rhs.dateStart).append(origin, rhs.origin).append(award, rhs.award).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
