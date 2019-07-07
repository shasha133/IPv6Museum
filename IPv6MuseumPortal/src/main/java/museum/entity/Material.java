package museum.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Material entity. @author MyEclipse Persistence Tools
 */

public class Material implements java.io.Serializable {

	// Fields

	private Integer materialId;
	private String materialType;
	private Set exhibitses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Material() {
	}

	/** minimal constructor */
	public Material(String materialType) {
		this.materialType = materialType;
	}

	/** full constructor */
	public Material(String materialType, Set exhibitses) {
		this.materialType = materialType;
		this.exhibitses = exhibitses;
	}

	// Property accessors

	public Integer getMaterialId() {
		return this.materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	public String getMaterialType() {
		return this.materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public Set getExhibitses() {
		return this.exhibitses;
	}

	public void setExhibitses(Set exhibitses) {
		this.exhibitses = exhibitses;
	}

}