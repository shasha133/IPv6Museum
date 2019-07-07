package museum.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Value entity. @author MyEclipse Persistence Tools
 */

public class Value implements java.io.Serializable {

	// Fields

	private Integer valueId;
	private String valueType;
	private Set exhibitses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Value() {
	}

	/** minimal constructor */
	public Value(String valueType) {
		this.valueType = valueType;
	}

	/** full constructor */
	public Value(String valueType, Set exhibitses) {
		this.valueType = valueType;
		this.exhibitses = exhibitses;
	}

	// Property accessors

	public Integer getValueId() {
		return this.valueId;
	}

	public void setValueId(Integer valueId) {
		this.valueId = valueId;
	}

	public String getValueType() {
		return this.valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public Set getExhibitses() {
		return this.exhibitses;
	}

	public void setExhibitses(Set exhibitses) {
		this.exhibitses = exhibitses;
	}

}