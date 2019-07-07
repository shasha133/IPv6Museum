package museum.entity;

/**
 * Advice entity. @author MyEclipse Persistence Tools
 */

public class Advice implements java.io.Serializable {

	// Fields

	private Integer adviceId;
	private String adviceState;
	private Integer commentId;
	private Integer replyId;
	private String adviceCheckState;

	// Constructors

	/** default constructor */
	public Advice() {
	}

	/** full constructor */
	public Advice(String adviceState, Integer commentId, Integer replyId,
			String adviceCheckState) {
		this.adviceState = adviceState;
		this.commentId = commentId;
		this.replyId = replyId;
		this.adviceCheckState = adviceCheckState;
	}

	// Property accessors

	public Integer getAdviceId() {
		return this.adviceId;
	}

	public void setAdviceId(Integer adviceId) {
		this.adviceId = adviceId;
	}

	public String getAdviceState() {
		return this.adviceState;
	}

	public void setAdviceState(String adviceState) {
		this.adviceState = adviceState;
	}

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getReplyId() {
		return this.replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getAdviceCheckState() {
		return this.adviceCheckState;
	}

	public void setAdviceCheckState(String adviceCheckState) {
		this.adviceCheckState = adviceCheckState;
	}

}