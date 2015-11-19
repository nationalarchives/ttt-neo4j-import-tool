
package uk.gov.nationalarchives.ttt.linker.model.graphperson.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Person
 * <p>
 * TTT JSON Schema, v2.0. A person identified in a Traces Through Time dataset
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "comments",
    "aliveYear",
    "aliveYearEnd",
    "aliveYearStart",
    "deadYear",
    "hasAge",
    "hasAliases",
    "hasAwards",
    "hasChilds",
    "hasEvents",
    "hasFamilyNames",
    "hasForeNames",
    "hasNationalities",
    "hasOccupations",
    "hasOrigin",
    "hasParents",
    "hasPlaces",
    "hasReferences",
    "hasRelations",
    "hasRoles",
    "hasSiblings",
    "hasSpouses",
    "hasTitles",
    "inContainer",
    "links",
    "ref",
    "timestamp",
    "type"
})
public class Person {

    /**
     * notes or comments
     * 
     */
    @JsonProperty("comments")
    private String comments;
    /**
     * single 'floruit' date for a person inferred from the data
     * 
     */
    @JsonProperty("aliveYear")
    private AliveYear aliveYear;
    /**
     * end of 'floruit' date range for a person inferred from the data
     * 
     */
    @JsonProperty("aliveYearEnd")
    private AliveYearEnd aliveYearEnd;
    /**
     * start of 'floruit' date range for a person inferred from the data
     * 
     */
    @JsonProperty("aliveYearStart")
    private AliveYearStart aliveYearStart;
    /**
     * single deceased date for a person inferred from the data
     * 
     */
    @JsonProperty("deadYear")
    private DeadYear deadYear;
    /**
     * person has an age
     * 
     */
    @JsonProperty("hasAge")
    private HasAge hasAge;
    /**
     * person has alias(es)
     * 
     */
    @JsonProperty("hasAliases")
    private List<HasAlias> hasAliases = new ArrayList<HasAlias>();
    /**
     * person has award(s)
     * 
     */
    @JsonProperty("hasAwards")
    private List<HasAward> hasAwards = new ArrayList<HasAward>();
    /**
     * person has children
     * 
     */
    @JsonProperty("hasChilds")
    private List<HasChild> hasChilds = new ArrayList<HasChild>();
    /**
     * person experiences event(s)
     * 
     */
    @JsonProperty("hasEvents")
    private List<HasEvent> hasEvents = new ArrayList<HasEvent>();
    /**
     * person has a family name
     * 
     */
    @JsonProperty("hasFamilyNames")
    private List<HasFamilyName> hasFamilyNames = new ArrayList<HasFamilyName>();
    /**
     * person has forename(s)
     * 
     */
    @JsonProperty("hasForeNames")
    private List<HasForeName> hasForeNames = new ArrayList<HasForeName>();
    /**
     * person has nationality/ies
     * 
     */
    @JsonProperty("hasNationalities")
    private List<HasNationality> hasNationalities = new ArrayList<HasNationality>();
    /**
     * person has occupation(s)
     * 
     */
    @JsonProperty("hasOccupations")
    private List<HasOccupation> hasOccupations = new ArrayList<HasOccupation>();
    /**
     * person has a place of origin or birth
     * 
     */
    @JsonProperty("hasOrigin")
    private HasOrigin hasOrigin;
    /**
     * person has parent(s)
     * 
     */
    @JsonProperty("hasParents")
    private List<HasParent> hasParents = new ArrayList<HasParent>();
    /**
     * has association with a place
     * 
     */
    @JsonProperty("hasPlaces")
    private List<HasPlace> hasPlaces = new ArrayList<HasPlace>();
    /**
     * person has reference number(s)
     * 
     */
    @JsonProperty("hasReferences")
    private List<HasReference> hasReferences = new ArrayList<HasReference>();
    /**
     * person has non-immediate family relation(s)
     * 
     */
    @JsonProperty("hasRelations")
    private List<HasRelation> hasRelations = new ArrayList<HasRelation>();
    /**
     * person has role(s) in or regarding something
     * 
     */
    @JsonProperty("hasRoles")
    private List<HasRole> hasRoles = new ArrayList<HasRole>();
    /**
     * person has siblings
     * 
     */
    @JsonProperty("hasSiblings")
    private List<HasSibling> hasSiblings = new ArrayList<HasSibling>();
    /**
     * person has spouse(s)
     * 
     */
    @JsonProperty("hasSpouses")
    private List<HasSpouse> hasSpouses = new ArrayList<HasSpouse>();
    /**
     * person has title(s)
     * 
     */
    @JsonProperty("hasTitles")
    private List<HasTitle> hasTitles = new ArrayList<HasTitle>();
    /**
     * document or data source in which person is found
     * (Required)
     * 
     */
    @JsonProperty("inContainer")
    private InContainer inContainer;
    /**
     * another person that might be the 'same as' this person
     * 
     */
    @JsonProperty("links")
    private List<Link> links = new ArrayList<Link>();
    /**
     * person identifier
     * (Required)
     * 
     */
    @JsonProperty("ref")
    private String ref;
    /**
     * date/time person identified
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    private String timestamp;
    /**
     * person gender
     * (Required)
     * 
     */
    @JsonProperty("type")
    private Person.Type type = Person.Type.fromValue("UNKNOWN");
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
     * single 'floruit' date for a person inferred from the data
     * 
     * @return
     *     The aliveYear
     */
    @JsonProperty("aliveYear")
    public AliveYear getAliveYear() {
        return aliveYear;
    }

    /**
     * single 'floruit' date for a person inferred from the data
     * 
     * @param aliveYear
     *     The aliveYear
     */
    @JsonProperty("aliveYear")
    public void setAliveYear(AliveYear aliveYear) {
        this.aliveYear = aliveYear;
    }

    /**
     * end of 'floruit' date range for a person inferred from the data
     * 
     * @return
     *     The aliveYearEnd
     */
    @JsonProperty("aliveYearEnd")
    public AliveYearEnd getAliveYearEnd() {
        return aliveYearEnd;
    }

    /**
     * end of 'floruit' date range for a person inferred from the data
     * 
     * @param aliveYearEnd
     *     The aliveYearEnd
     */
    @JsonProperty("aliveYearEnd")
    public void setAliveYearEnd(AliveYearEnd aliveYearEnd) {
        this.aliveYearEnd = aliveYearEnd;
    }

    /**
     * start of 'floruit' date range for a person inferred from the data
     * 
     * @return
     *     The aliveYearStart
     */
    @JsonProperty("aliveYearStart")
    public AliveYearStart getAliveYearStart() {
        return aliveYearStart;
    }

    /**
     * start of 'floruit' date range for a person inferred from the data
     * 
     * @param aliveYearStart
     *     The aliveYearStart
     */
    @JsonProperty("aliveYearStart")
    public void setAliveYearStart(AliveYearStart aliveYearStart) {
        this.aliveYearStart = aliveYearStart;
    }

    /**
     * single deceased date for a person inferred from the data
     * 
     * @return
     *     The deadYear
     */
    @JsonProperty("deadYear")
    public DeadYear getDeadYear() {
        return deadYear;
    }

    /**
     * single deceased date for a person inferred from the data
     * 
     * @param deadYear
     *     The deadYear
     */
    @JsonProperty("deadYear")
    public void setDeadYear(DeadYear deadYear) {
        this.deadYear = deadYear;
    }

    /**
     * person has an age
     * 
     * @return
     *     The hasAge
     */
    @JsonProperty("hasAge")
    public HasAge getHasAge() {
        return hasAge;
    }

    /**
     * person has an age
     * 
     * @param hasAge
     *     The hasAge
     */
    @JsonProperty("hasAge")
    public void setHasAge(HasAge hasAge) {
        this.hasAge = hasAge;
    }

    /**
     * person has alias(es)
     * 
     * @return
     *     The hasAliases
     */
    @JsonProperty("hasAliases")
    public List<HasAlias> getHasAliases() {
        return hasAliases;
    }

    /**
     * person has alias(es)
     * 
     * @param hasAliases
     *     The hasAliases
     */
    @JsonProperty("hasAliases")
    public void setHasAliases(List<HasAlias> hasAliases) {
        this.hasAliases = hasAliases;
    }

    /**
     * person has award(s)
     * 
     * @return
     *     The hasAwards
     */
    @JsonProperty("hasAwards")
    public List<HasAward> getHasAwards() {
        return hasAwards;
    }

    /**
     * person has award(s)
     * 
     * @param hasAwards
     *     The hasAwards
     */
    @JsonProperty("hasAwards")
    public void setHasAwards(List<HasAward> hasAwards) {
        this.hasAwards = hasAwards;
    }

    /**
     * person has children
     * 
     * @return
     *     The hasChilds
     */
    @JsonProperty("hasChilds")
    public List<HasChild> getHasChilds() {
        return hasChilds;
    }

    /**
     * person has children
     * 
     * @param hasChilds
     *     The hasChilds
     */
    @JsonProperty("hasChilds")
    public void setHasChilds(List<HasChild> hasChilds) {
        this.hasChilds = hasChilds;
    }

    /**
     * person experiences event(s)
     * 
     * @return
     *     The hasEvents
     */
    @JsonProperty("hasEvents")
    public List<HasEvent> getHasEvents() {
        return hasEvents;
    }

    /**
     * person experiences event(s)
     * 
     * @param hasEvents
     *     The hasEvents
     */
    @JsonProperty("hasEvents")
    public void setHasEvents(List<HasEvent> hasEvents) {
        this.hasEvents = hasEvents;
    }

    /**
     * person has a family name
     * 
     * @return
     *     The hasFamilyNames
     */
    @JsonProperty("hasFamilyNames")
    public List<HasFamilyName> getHasFamilyNames() {
        return hasFamilyNames;
    }

    /**
     * person has a family name
     * 
     * @param hasFamilyNames
     *     The hasFamilyNames
     */
    @JsonProperty("hasFamilyNames")
    public void setHasFamilyNames(List<HasFamilyName> hasFamilyNames) {
        this.hasFamilyNames = hasFamilyNames;
    }

    /**
     * person has forename(s)
     * 
     * @return
     *     The hasForeNames
     */
    @JsonProperty("hasForeNames")
    public List<HasForeName> getHasForeNames() {
        return hasForeNames;
    }

    /**
     * person has forename(s)
     * 
     * @param hasForeNames
     *     The hasForeNames
     */
    @JsonProperty("hasForeNames")
    public void setHasForeNames(List<HasForeName> hasForeNames) {
        this.hasForeNames = hasForeNames;
    }

    /**
     * person has nationality/ies
     * 
     * @return
     *     The hasNationalities
     */
    @JsonProperty("hasNationalities")
    public List<HasNationality> getHasNationalities() {
        return hasNationalities;
    }

    /**
     * person has nationality/ies
     * 
     * @param hasNationalities
     *     The hasNationalities
     */
    @JsonProperty("hasNationalities")
    public void setHasNationalities(List<HasNationality> hasNationalities) {
        this.hasNationalities = hasNationalities;
    }

    /**
     * person has occupation(s)
     * 
     * @return
     *     The hasOccupations
     */
    @JsonProperty("hasOccupations")
    public List<HasOccupation> getHasOccupations() {
        return hasOccupations;
    }

    /**
     * person has occupation(s)
     * 
     * @param hasOccupations
     *     The hasOccupations
     */
    @JsonProperty("hasOccupations")
    public void setHasOccupations(List<HasOccupation> hasOccupations) {
        this.hasOccupations = hasOccupations;
    }

    /**
     * person has a place of origin or birth
     * 
     * @return
     *     The hasOrigin
     */
    @JsonProperty("hasOrigin")
    public HasOrigin getHasOrigin() {
        return hasOrigin;
    }

    /**
     * person has a place of origin or birth
     * 
     * @param hasOrigin
     *     The hasOrigin
     */
    @JsonProperty("hasOrigin")
    public void setHasOrigin(HasOrigin hasOrigin) {
        this.hasOrigin = hasOrigin;
    }

    /**
     * person has parent(s)
     * 
     * @return
     *     The hasParents
     */
    @JsonProperty("hasParents")
    public List<HasParent> getHasParents() {
        return hasParents;
    }

    /**
     * person has parent(s)
     * 
     * @param hasParents
     *     The hasParents
     */
    @JsonProperty("hasParents")
    public void setHasParents(List<HasParent> hasParents) {
        this.hasParents = hasParents;
    }

    /**
     * has association with a place
     * 
     * @return
     *     The hasPlaces
     */
    @JsonProperty("hasPlaces")
    public List<HasPlace> getHasPlaces() {
        return hasPlaces;
    }

    /**
     * has association with a place
     * 
     * @param hasPlaces
     *     The hasPlaces
     */
    @JsonProperty("hasPlaces")
    public void setHasPlaces(List<HasPlace> hasPlaces) {
        this.hasPlaces = hasPlaces;
    }

    /**
     * person has reference number(s)
     * 
     * @return
     *     The hasReferences
     */
    @JsonProperty("hasReferences")
    public List<HasReference> getHasReferences() {
        return hasReferences;
    }

    /**
     * person has reference number(s)
     * 
     * @param hasReferences
     *     The hasReferences
     */
    @JsonProperty("hasReferences")
    public void setHasReferences(List<HasReference> hasReferences) {
        this.hasReferences = hasReferences;
    }

    /**
     * person has non-immediate family relation(s)
     * 
     * @return
     *     The hasRelations
     */
    @JsonProperty("hasRelations")
    public List<HasRelation> getHasRelations() {
        return hasRelations;
    }

    /**
     * person has non-immediate family relation(s)
     * 
     * @param hasRelations
     *     The hasRelations
     */
    @JsonProperty("hasRelations")
    public void setHasRelations(List<HasRelation> hasRelations) {
        this.hasRelations = hasRelations;
    }

    /**
     * person has role(s) in or regarding something
     * 
     * @return
     *     The hasRoles
     */
    @JsonProperty("hasRoles")
    public List<HasRole> getHasRoles() {
        return hasRoles;
    }

    /**
     * person has role(s) in or regarding something
     * 
     * @param hasRoles
     *     The hasRoles
     */
    @JsonProperty("hasRoles")
    public void setHasRoles(List<HasRole> hasRoles) {
        this.hasRoles = hasRoles;
    }

    /**
     * person has siblings
     * 
     * @return
     *     The hasSiblings
     */
    @JsonProperty("hasSiblings")
    public List<HasSibling> getHasSiblings() {
        return hasSiblings;
    }

    /**
     * person has siblings
     * 
     * @param hasSiblings
     *     The hasSiblings
     */
    @JsonProperty("hasSiblings")
    public void setHasSiblings(List<HasSibling> hasSiblings) {
        this.hasSiblings = hasSiblings;
    }

    /**
     * person has spouse(s)
     * 
     * @return
     *     The hasSpouses
     */
    @JsonProperty("hasSpouses")
    public List<HasSpouse> getHasSpouses() {
        return hasSpouses;
    }

    /**
     * person has spouse(s)
     * 
     * @param hasSpouses
     *     The hasSpouses
     */
    @JsonProperty("hasSpouses")
    public void setHasSpouses(List<HasSpouse> hasSpouses) {
        this.hasSpouses = hasSpouses;
    }

    /**
     * person has title(s)
     * 
     * @return
     *     The hasTitles
     */
    @JsonProperty("hasTitles")
    public List<HasTitle> getHasTitles() {
        return hasTitles;
    }

    /**
     * person has title(s)
     * 
     * @param hasTitles
     *     The hasTitles
     */
    @JsonProperty("hasTitles")
    public void setHasTitles(List<HasTitle> hasTitles) {
        this.hasTitles = hasTitles;
    }

    /**
     * document or data source in which person is found
     * (Required)
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
     * (Required)
     * 
     * @param inContainer
     *     The inContainer
     */
    @JsonProperty("inContainer")
    public void setInContainer(InContainer inContainer) {
        this.inContainer = inContainer;
    }

    /**
     * another person that might be the 'same as' this person
     * 
     * @return
     *     The links
     */
    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    /**
     * another person that might be the 'same as' this person
     * 
     * @param links
     *     The links
     */
    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    /**
     * person identifier
     * (Required)
     * 
     * @return
     *     The ref
     */
    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    /**
     * person identifier
     * (Required)
     * 
     * @param ref
     *     The ref
     */
    @JsonProperty("ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * date/time person identified
     * (Required)
     * 
     * @return
     *     The timestamp
     */
    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * date/time person identified
     * (Required)
     * 
     * @param timestamp
     *     The timestamp
     */
    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * person gender
     * (Required)
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public Person.Type getType() {
        return type;
    }

    /**
     * person gender
     * (Required)
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(Person.Type type) {
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
        return new HashCodeBuilder().append(comments).append(aliveYear).append(aliveYearEnd).append(aliveYearStart).append(deadYear).append(hasAge).append(hasAliases).append(hasAwards).append(hasChilds).append(hasEvents).append(hasFamilyNames).append(hasForeNames).append(hasNationalities).append(hasOccupations).append(hasOrigin).append(hasParents).append(hasPlaces).append(hasReferences).append(hasRelations).append(hasRoles).append(hasSiblings).append(hasSpouses).append(hasTitles).append(inContainer).append(links).append(ref).append(timestamp).append(type).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Person) == false) {
            return false;
        }
        Person rhs = ((Person) other);
        return new EqualsBuilder().append(comments, rhs.comments).append(aliveYear, rhs.aliveYear).append(aliveYearEnd, rhs.aliveYearEnd).append(aliveYearStart, rhs.aliveYearStart).append(deadYear, rhs.deadYear).append(hasAge, rhs.hasAge).append(hasAliases, rhs.hasAliases).append(hasAwards, rhs.hasAwards).append(hasChilds, rhs.hasChilds).append(hasEvents, rhs.hasEvents).append(hasFamilyNames, rhs.hasFamilyNames).append(hasForeNames, rhs.hasForeNames).append(hasNationalities, rhs.hasNationalities).append(hasOccupations, rhs.hasOccupations).append(hasOrigin, rhs.hasOrigin).append(hasParents, rhs.hasParents).append(hasPlaces, rhs.hasPlaces).append(hasReferences, rhs.hasReferences).append(hasRelations, rhs.hasRelations).append(hasRoles, rhs.hasRoles).append(hasSiblings, rhs.hasSiblings).append(hasSpouses, rhs.hasSpouses).append(hasTitles, rhs.hasTitles).append(inContainer, rhs.inContainer).append(links, rhs.links).append(ref, rhs.ref).append(timestamp, rhs.timestamp).append(type, rhs.type).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum Type {

        FEMALE("FEMALE"),
        MALE("MALE"),
        OTHER("OTHER"),
        UNKNOWN("UNKNOWN");
        private final String value;
        private static Map<String, Person.Type> constants = new HashMap<String, Person.Type>();

        static {
            for (Person.Type c: values()) {
                constants.put(c.value, c);
            }
        }

        private Type(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static Person.Type fromValue(String value) {
            Person.Type constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
