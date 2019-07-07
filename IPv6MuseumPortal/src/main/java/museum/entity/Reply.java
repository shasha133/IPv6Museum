package museum.entity;

import java.util.Date;

/**
 * Reply entity. @author MyEclipse Persistence Tools
 */

public class Reply implements java.io.Serializable {

	// Fields

	private Integer replyId;
	private Comment comment;
	private String replyContent;
	private String fromUid;
	private String toUid;
	private Date replyTime;

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** full constructor */
	public Reply(Comment comment, String replyContent, String fromUid,
			String toUid, Date replyTime) {
		this.comment = comment;
		this.replyContent = replyContent;
		this.fromUid = fromUid;
		this.toUid = toUid;
		this.replyTime = replyTime;
	}

	// Property accessors

	public Integer getReplyId() {
		return this.replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getFromUid() {
		return this.fromUid;
	}

	public void setFromUid(String fromUid) {
		this.fromUid = fromUid;
	}

	public String getToUid() {
		return this.toUid;
	}

	public void setToUid(String toUid) {
		this.toUid = toUid;
	}

	public Date getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

}