package museum.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * State entity. @author MyEclipse Persistence Tools
 */

public class State implements java.io.Serializable {

	// Fields

	private Integer stateId;
	private String stateType;
	private Set exhibitses = new HashSet(0);

	// Constructors

	/** default constructor */
	public State() {
	}

	/** minimal constructor */
	public State(String stateType) {
		this.stateType = stateType;
	}

	/** full constructor */
	public State(String stateType, Set exhibitses) {
		this.stateType = stateType;
		this.exhibitses = exhibitses;
	}

	// Property accessors

	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateType() {
		return this.stateType;
	}

	public void setStateType(String stateType) {
		this.stateType = stateType;
	}

	public Set getExhibitses() {
		return this.exhibitses;
	}

	public void setExhibitses(Set exhibitses) {
		this.exhibitses = exhibitses;
	}

}