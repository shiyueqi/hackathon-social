package com.unionpay.uplus.vo;

import java.util.Set;

/**
 * date: 2016/11/25 14:51 author: yueqi.shi
 */
public class CommentVO {
	int id;
	int userId;
	String comment;
	int contentId;
	int referId;
	int referUserId;
	String referUserName;
	long createAt;
	long lastModified;
	// boolean praised;
	int status;
	int praiseCount;
	// Set<String> praiseUids;

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public int getReferUserId() {
		return referUserId;
	}

	public void setReferUserId(int referUserId) {
		this.referUserId = referUserId;
	}

	public int getCommentId() {
		return contentId;
	}

	public void setCommentId(int commentId) {
		this.contentId = commentId;
	}

	public int getReferId() {
		return referId;
	}

	public void setReferId(int referId) {
		this.referId = referId;
	}

	public String getReferUserName() {
		return referUserName;
	}

	public void setReferUserName(String referUserName) {
		this.referUserName = referUserName;
	}

	public long getCreateAt() {
		return createAt;
	}

	public void setCreateAt(long createAt) {
		this.createAt = createAt;
	}

	public long getLastModified() {
		return lastModified;
	}

	public void setLastModified(long lastModified) {
		this.lastModified = lastModified;
	}

	// public boolean isPraised() {
	// return praised;
	// }
	//
	// public void setPraised(boolean praised) {
	// this.praised = praised;
	// }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	 public int getPraiseCount() {
	 return praiseCount;
	 }
	
	 public void setPraiseCount(int praiseCount) {
	 this.praiseCount = praiseCount;
	 }
	//
	// public Set<String> getPraiseUids() {
	// return praiseUids;
	// }
	//
	// public void setPraiseUids(Set<String> praiseUids) {
	// this.praiseUids = praiseUids;
	// }

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
