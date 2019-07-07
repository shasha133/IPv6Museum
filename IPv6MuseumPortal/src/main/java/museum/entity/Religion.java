package museum.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Religion entity. @author MyEclipse Persistence Tools
 */

public class Religion implements java.io.Serializable {

	// Fields

	private Integer religionlId;
	private String religionType;
	private Set exhibitses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Religion() {
	}

	/** minimal constructor */
	public Religion(String religionType) {
		this.religionType = religionType;
	}

	/** full constructor */
	public Religion(String religionType, Set exhibitses) {
		this.religionType = religionType;
		this.exhibitses = exhibitses;
	}

	// Property accessors

	public Integer getReligionlId() {
		return this.religionlId;
	}

	public void setReligionlId(Integer religionlId) {
		this.religionlId = religionlId;
	}

	public String getReligionType() {
		return this.religionType;
	}

	public void setReligionType(String religionType) {
		this.religionType = religionType;
	}

	public Set getExhibitses() {
		return this.exhibitses;
	}

	public void setExhibitses(Set exhibitses) {
		this.exhibitses = exhibitses;
	}

}