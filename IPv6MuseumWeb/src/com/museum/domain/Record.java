package com.museum.domain;

import java.util.Date;

/**
 * Record entity. @author MyEclipse Persistence Tools
 */

public class Record implements java.io.Serializable {

	// Fields

	private Integer recordId;
	private User user;
	private Integer recordExhibitId;
	private Date recordTime;

	// Constructors

	/** default constructor */
	public Record() {
	}

	/** full constructor */
	public Record(User user, Integer recordExhibitId, Date recordTime) {
		this.user = user;
		this.recordExhibitId = recordExhibitId;
		this.recordTime = recordTime;
	}

	// Property accessors

	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getRecordExhibitId() {
		return this.recordExhibitId;
	}

	public void setRecordExhibitId(Integer recordExhibitId) {
		this.recordExhibitId = recordExhibitId;
	}

	public Date getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

}