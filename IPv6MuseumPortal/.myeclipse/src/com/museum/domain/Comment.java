package com.museum.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Integer topicType;
	private Integer topicId;
	private String commentContent;
	private String fromUid;
	private Date commentTime;
	private Set replies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(Integer topicType, Integer topicId, String commentContent,
			String fromUid, Date commentTime) {
		this.topicType = topicType;
		this.topicId = topicId;
		this.commentContent = commentContent;
		this.fromUid = fromUid;
		this.commentTime = commentTime;
	}

	/** full constructor */
	public Comment(Integer topicType, Integer topicId, String commentContent,
			String fromUid, Date commentTime, Set replies) {
		this.topicType = topicType;
		this.topicId = topicId;
		this.commentContent = commentContent;
		this.fromUid = fromUid;
		this.commentTime = commentTime;
		this.replies = replies;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getTopicType() {
		return this.topicType;
	}

	public void setTopicType(Integer topicType) {
		this.topicType = topicType;
	}

	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getFromUid() {
		return this.fromUid;
	}

	public void setFromUid(String fromUid) {
		this.fromUid = fromUid;
	}

	public Date getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public Set getReplies() {
		return this.replies;
	}

	public void setReplies(Set replies) {
		this.replies = replies;
	}

}