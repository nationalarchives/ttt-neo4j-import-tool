/** 
 * Copyright (c) 2015, The National Archives <digitalpreservation@nationalarchives.gov.uk> 
 * http://www.nationalarchives.gov.uk 
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public 
 * License, v. 2.0. If a copy of the MPL was not distributed with this 
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. 
 */
package uk.gov.nationalarchives.ttt.neo4j.domain;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author knagaraj
 *
 */
@Document(collection = "#{linkRepository.getCollectionName()}")
public class Link implements Comparable<Link>{

	@Id
	private String id;
	private String refA;
	private String refB;
	private Number score;
    private ScoreDetails scoreDetails = new ScoreDetails();

    @Transient
    private String sourceFile;

    public class ScoreDetails{
        private Double scoreOnForeNames;
        private Double scoreOnFamilyNames;
        private Double scoreOnDateOfBirth;
        private Double scoreOnServiceReference;
        public void setScoreOnForeNames(Double scoreOnForeNames) {
            this.scoreOnForeNames = scoreOnForeNames;
        }

        public double getScoreOnForeNames() {
            return scoreOnForeNames;
        }

        public void setScoreOnFamilyNames(Double scoreOnFamilyNames) {
            this.scoreOnFamilyNames = scoreOnFamilyNames;
        }

        public double getScoreOnFamilyNames() {
            return scoreOnFamilyNames;
        }

        public void setScoreOnDateOfBirth(Double scoreOnDateOfBirth) {
            this.scoreOnDateOfBirth = scoreOnDateOfBirth;
        }

        public double getScoreOnDateOfBirth() {
            return scoreOnDateOfBirth;
        }

        public void setScoreOnServiceReference(Double scoreOnServiceReference) {
            this.scoreOnServiceReference = scoreOnServiceReference;
        }

        public double getScoreOnServiceReference() {
            return scoreOnServiceReference;
        }
    }

    public Link() {
    }

    public Link(String refA, String refB) {
        this.refA = refA;
        this.refB = refB;
    }

    /**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public final void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the refA
	 */
	public final String getRefA() {
		return refA;
	}
	/**
	 * @param refA the refA to set
	 */
	public final void setRefA(String refA) {
		this.refA = refA;
	}
	/**
	 * @return the refB
	 */
	public final String getRefB() {
		return refB;
	}
	/**
	 * @param refB the refB to set
	 */
	public final void setRefB(String refB) {
		this.refB = refB;
	}
	/**
	 * @return the score
	 */
	public final Number getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public final void setScore(Number score) {
		this.score = score;
	}
	
	@Override
	public int compareTo(Link o) {
		int result = this.refA.compareTo(o.refA);
		return result == 0 ? refB.compareTo(o.refB) : result;	
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
        Link sf = (Link) o;
		boolean result = this.refA.equalsIgnoreCase(sf.refA);
		return result == Boolean.TRUE ? refB.equalsIgnoreCase(sf.refB) : result;	
	}

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(refA)
                .append(refB)
                .toHashCode();
    }


    public ScoreDetails getScoreDetails() {
        return scoreDetails;
    }

    public void setScoreDetails(ScoreDetails scoreDetails) {
        this.scoreDetails = scoreDetails;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }
}