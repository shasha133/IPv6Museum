package museum.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Apply entity. @author MyEclipse Persistence Tools
 */

public class Apply implements java.io.Serializable {

	// Fields

	private Integer applyId;
	private String applylType;
	private Set exhibitses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Apply() {
	}

	/** minimal constructor */
	public Apply(String applylType) {
		this.applylType = applylType;
	}

	/** full constructor */
	public Apply(String applylType, Set exhibitses) {
		this.applylType = applylType;
		this.exhibitses = exhibitses;
	}

	// Property accessors

	public Integer getApplyId() {
		return this.applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public String getApplylType() {
		return this.applylType;
	}

	public void setApplylType(String applylType) {
		this.applylType = applylType;
	}

	public Set getExhibitses() {
		return this.exhibitses;
	}

	public void setExhibitses(Set exhibitses) {
		this.exhibitses = exhibitses;
	}

}