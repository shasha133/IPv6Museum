package museum.entity;

import java.util.Date;

/**
 * Collect entity. @author MyEclipse Persistence Tools
 */

public class Collect{

	// Fields

	private Integer collectId;
	private User user;
	private Integer collectExhibitId;
	private Date collectTime;

	// Constructors

	/** default constructor */
	public Collect() {
	}

	/** full constructor */
	public Collect(User user, Integer collectExhibitId, Date collectTime) {
		this.user = user;
		this.collectExhibitId = collectExhibitId;
		this.collectTime = collectTime;
	}

	// Property accessors

	public Integer getCollectId() {
		return this.collectId;
	}

	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getCollectExhibitId() {
		return this.collectExhibitId;
	}

	public void setCollectExhibitId(Integer collectExhibitId) {
		this.collectExhibitId = collectExhibitId;
	}

	public Date getCollectTime() {
		return this.collectTime;
	}

	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}

}