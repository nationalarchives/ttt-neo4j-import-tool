
package uk.gov.nationalarchives.ttt.linker.model.graphperson.generated;

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
 * document or data source in which person is found
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "context",
    "document",
    "source"
})
public class InContainer {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * immediate data context in which person is found
     * 
     */
    @JsonProperty("context")
    private Context context;
    /**
     * parent data structure (eg. webpage or spreadsheet) or a smaller, discrete unit within such a data structure (eg. paragraph or row)
     * 
     */
    @JsonProperty("document")
    private Document document;
    /**
     * a wider document container (eg. website or folder)
     * 
     */
    @JsonProperty("source")
    private Source source;
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
     * immediate data context in which person is found
     * 
     * @return
     *     The context
     */
    @JsonProperty("context")
    public Context getContext() {
        return context;
    }

    /**
     * immediate data context in which person is found
     * 
     * @param context
     *     The context
     */
    @JsonProperty("context")
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * parent data structure (eg. webpage or spreadsheet) or a smaller, discrete unit within such a data structure (eg. paragraph or row)
     * 
     * @return
     *     The document
     */
    @JsonProperty("document")
    public Document getDocument() {
        return document;
    }

    /**
     * parent data structure (eg. webpage or spreadsheet) or a smaller, discrete unit within such a data structure (eg. paragraph or row)
     * 
     * @param document
     *     The document
     */
    @JsonProperty("document")
    public void setDocument(Document document) {
        this.document = document;
    }

    /**
     * a wider document container (eg. website or folder)
     * 
     * @return
     *     The source
     */
    @JsonProperty("source")
    public Source getSource() {
        return source;
    }

    /**
     * a wider document container (eg. website or folder)
     * 
     * @param source
     *     The source
     */
    @JsonProperty("source")
    public void setSource(Source source) {
        this.source = source;
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
        return new HashCodeBuilder().append(comments).append(context).append(document).append(source).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InContainer) == false) {
            return false;
        }
        InContainer rhs = ((InContainer) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(context, rhs.context).append(document, rhs.document).append(source, rhs.source).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
