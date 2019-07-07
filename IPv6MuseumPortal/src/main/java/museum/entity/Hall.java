package museum.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Hall entity. @author MyEclipse Persistence Tools
 */

public class Hall implements java.io.Serializable {

	// Fields

	private Integer hallId;
	private String hallState;
	private String hallImage;
	private String hallInfo;
	private Set exhibitses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Hall() {
	}

	/** minimal constructor */
	public Hall(String hallState, String hallImage, String hallInfo) {
		this.hallState = hallState;
		this.hallImage = hallImage;
		this.hallInfo = hallInfo;
	}

	/** full constructor */
	public Hall(String hallState, String hallImage, String hallInfo,
			Set exhibitses) {
		this.hallState = hallState;
		this.hallImage = hallImage;
		this.hallInfo = hallInfo;
		this.exhibitses = exhibitses;
	}

	// Property accessors

	public Integer getHallId() {
		return this.hallId;
	}

	public void setHallId(Integer hallId) {
		this.hallId = hallId;
	}

	public String getHallState() {
		return this.hallState;
	}

	public void setHallState(String hallState) {
		this.hallState = hallState;
	}

	public String getHallImage() {
		return this.hallImage;
	}

	public void setHallImage(String hallImage) {
		this.hallImage = hallImage;
	}

	public String getHallInfo() {
		return this.hallInfo;
	}

	public void setHallInfo(String hallInfo) {
		this.hallInfo = hallInfo;
	}

	public Set getExhibitses() {
		return this.exhibitses;
	}

	public void setExhibitses(Set exhibitses) {
		this.exhibitses = exhibitses;
	}

}