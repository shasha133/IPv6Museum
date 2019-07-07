package museum.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Dynasty entity. @author MyEclipse Persistence Tools
 */

public class Dynasty{

	// Fields

	private Integer dynastylId;
	private String dynastyType;
	private Set exhibitses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Dynasty() {
	}

	/** minimal constructor */
	public Dynasty(String dynastyType) {
		this.dynastyType = dynastyType;
	}

	/** full constructor */
	public Dynasty(String dynastyType, Set exhibitses) {
		this.dynastyType = dynastyType;
		this.exhibitses = exhibitses;
	}

	// Property accessors

	public Integer getDynastylId() {
		return this.dynastylId;
	}

	public void setDynastylId(Integer dynastylId) {
		this.dynastylId = dynastylId;
	}

	public String getDynastyType() {
		return this.dynastyType;
	}

	public void setDynastyType(String dynastyType) {
		this.dynastyType = dynastyType;
	}

	public Set getExhibitses() {
		return this.exhibitses;
	}

	public void setExhibitses(Set exhibitses) {
		this.exhibitses = exhibitses;
	}

}