
package uk.gov.nationalarchives.ttt.neo4j.domain.graphperson;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Neo4jPerson extends Person {
    public Neo4jPerson(Person person) {
        super();
//        this.setHasForeNames(person.getHasForeNames());
//        this.setHasFamilyNames(person.getHasFamilyNames());
        this.setRef(person.getRef());
    }
}
