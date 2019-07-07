package museum.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * ActivityType entity. @author MyEclipse Persistence Tools
 */

public class ActivityType {

	// Fields

	private Integer activityTypeId;
	private String activityTypeName;
	private Set activities = new HashSet(0);

	// Constructors

	/** default constructor */
	public ActivityType() {
	}

	/** minimal constructor */
	public ActivityType(String activityTypeName) {
		this.activityTypeName = activityTypeName;
	}

	/** full constructor */
	public ActivityType(String activityTypeName, Set activities) {
		this.activityTypeName = activityTypeName;
		this.activities = activities;
	}

	// Property accessors

	public Integer getActivityTypeId() {
		return this.activityTypeId;
	}

	public void setActivityTypeId(Integer activityTypeId) {
		this.activityTypeId = activityTypeId;
	}

	public String getActivityTypeName() {
		return this.activityTypeName;
	}

	public void setActivityTypeName(String activityTypeName) {
		this.activityTypeName = activityTypeName;
	}

	public Set getActivities() {
		return this.activities;
	}

	public void setActivities(Set activities) {
		this.activities = activities;
	}

}