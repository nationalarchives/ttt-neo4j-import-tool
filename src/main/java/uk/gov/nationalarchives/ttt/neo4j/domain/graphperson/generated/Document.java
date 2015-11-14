
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
 * parent data structure (eg. webpage or spreadsheet) or a smaller, discrete unit within such a data structure (eg. paragraph or row)
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "filepath",
    "name",
    "quality",
    "ref",
    "type",
    "URL",
    "hasYear",
    "hasEndYear",
    "hasStartYear",
    "heldBy",
    "inContainer"
})
public class Document {

    /**
     * general notes / comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * local file system path to any file that is the origin of the source data
     * 
     */
    @JsonProperty("filepath")
    private String filepath;
    /**
     * an original document reference no.
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * indication of the quality and/or reliability of the source data
     * 
     */
    @JsonProperty("quality")
    private String quality;
    /**
     * original machine-readable or system identifier
     * 
     */
    @JsonProperty("ref")
    private String ref;
    /**
     * format of the container data structure
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * container webpage (or sub-section thereof if identified by a '#' fragment identifier)
     * 
     */
    @JsonProperty("URL")
    private String URL;
    /**
     * has a single year date
     * 
     */
    @JsonProperty("hasYear")
    private HasYear hasYear;
    /**
     * has an end year date
     * 
     */
    @JsonProperty("hasEndYear")
    private HasEndYear hasEndYear;
    /**
     * has a start year date
     * 
     */
    @JsonProperty("hasStartYear")
    private HasStartYear hasStartYear;
    /**
     * repository or institution which curates the source document, catalogue, dataset, website etc
     * 
     */
    @JsonProperty("heldBy")
    private HeldBy heldBy;
    /**
     * document or data source in which person is found
     * 
     */
    @JsonProperty("inContainer")
    private InContainer inContainer;
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
     * local file system path to any file that is the origin of the source data
     * 
     * @return
     *     The filepath
     */
    @JsonProperty("filepath")
    public String getFilepath() {
        return filepath;
    }

    /**
     * local file system path to any file that is the origin of the source data
     * 
     * @param filepath
     *     The filepath
     */
    @JsonProperty("filepath")
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    /**
     * an original document reference no.
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * an original document reference no.
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * indication of the quality and/or reliability of the source data
     * 
     * @return
     *     The quality
     */
    @JsonProperty("quality")
    public String getQuality() {
        return quality;
    }

    /**
     * indication of the quality and/or reliability of the source data
     * 
     * @param quality
     *     The quality
     */
    @JsonProperty("quality")
    public void setQuality(String quality) {
        this.quality = quality;
    }

    /**
     * original machine-readable or system identifier
     * 
     * @return
     *     The ref
     */
    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    /**
     * original machine-readable or system identifier
     * 
     * @param ref
     *     The ref
     */
    @JsonProperty("ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * format of the container data structure
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * format of the container data structure
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * container webpage (or sub-section thereof if identified by a '#' fragment identifier)
     * 
     * @return
     *     The URL
     */
    @JsonProperty("URL")
    public String getURL() {
        return URL;
    }

    /**
     * container webpage (or sub-section thereof if identified by a '#' fragment identifier)
     * 
     * @param URL
     *     The URL
     */
    @JsonProperty("URL")
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * has a single year date
     * 
     * @return
     *     The hasYear
     */
    @JsonProperty("hasYear")
    public HasYear getHasYear() {
        return hasYear;
    }

    /**
     * has a single year date
     * 
     * @param hasYear
     *     The hasYear
     */
    @JsonProperty("hasYear")
    public void setHasYear(HasYear hasYear) {
        this.hasYear = hasYear;
    }

    /**
     * has an end year date
     * 
     * @return
     *     The hasEndYear
     */
    @JsonProperty("hasEndYear")
    public HasEndYear getHasEndYear() {
        return hasEndYear;
    }

    /**
     * has an end year date
     * 
     * @param hasEndYear
     *     The hasEndYear
     */
    @JsonProperty("hasEndYear")
    public void setHasEndYear(HasEndYear hasEndYear) {
        this.hasEndYear = hasEndYear;
    }

    /**
     * has a start year date
     * 
     * @return
     *     The hasStartYear
     */
    @JsonProperty("hasStartYear")
    public HasStartYear getHasStartYear() {
        return hasStartYear;
    }

    /**
     * has a start year date
     * 
     * @param hasStartYear
     *     The hasStartYear
     */
    @JsonProperty("hasStartYear")
    public void setHasStartYear(HasStartYear hasStartYear) {
        this.hasStartYear = hasStartYear;
    }

    /**
     * repository or institution which curates the source document, catalogue, dataset, website etc
     * 
     * @return
     *     The heldBy
     */
    @JsonProperty("heldBy")
    public HeldBy getHeldBy() {
        return heldBy;
    }

    /**
     * repository or institution which curates the source document, catalogue, dataset, website etc
     * 
     * @param heldBy
     *     The heldBy
     */
    @JsonProperty("heldBy")
    public void setHeldBy(HeldBy heldBy) {
        this.heldBy = heldBy;
    }

    /**
     * document or data source in which person is found
     * 
     * @return
     *     The inContainer
     */
    @JsonProperty("inContainer")
    public InContainer getInContainer() {
        return inContainer;
    }

    /**
     * document or data source in which person is found
     * 
     * @param inContainer
     *     The inContainer
     */
    @JsonProperty("inContainer")
    public void setInContainer(InContainer inContainer) {
        this.inContainer = inContainer;
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
        return new HashCodeBuilder().append(comments).append(filepath).append(name).append(quality).append(ref).append(type).append(URL).append(hasYear).append(hasEndYear).append(hasStartYear).append(heldBy).append(inContainer).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Document) == false) {
            return false;
        }
        Document rhs = ((Document) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(filepath, rhs.filepath).append(name, rhs.name).append(quality, rhs.quality).append(ref, rhs.ref).append(type, rhs.type).append(URL, rhs.URL).append(hasYear, rhs.hasYear).append(hasEndYear, rhs.hasEndYear).append(hasStartYear, rhs.hasStartYear).append(heldBy, rhs.heldBy).append(inContainer, rhs.inContainer).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
