package museum.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Nation entity. @author MyEclipse Persistence Tools
 */

public class Nation implements java.io.Serializable {

	// Fields

	private Integer nationId;
	private String nationType;
	private Set exhibitses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Nation() {
	}

	/** minimal constructor */
	public Nation(String nationType) {
		this.nationType = nationType;
	}

	/** full constructor */
	public Nation(String nationType, Set exhibitses) {
		this.nationType = nationType;
		this.exhibitses = exhibitses;
	}

	// Property accessors

	public Integer getNationId() {
		return this.nationId;
	}

	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}

	public String getNationType() {
		return this.nationType;
	}

	public void setNationType(String nationType) {
		this.nationType = nationType;
	}

	public Set getExhibitses() {
		return this.exhibitses;
	}

	public void setExhibitses(Set exhibitses) {
		this.exhibitses = exhibitses;
	}

}