package com.unionpay.uplus.vo;

import java.util.Set;

/**
 * date: 2016/11/25 14:51 author: yueqi.shi
 */
public class CommentVO {
	int commentId;
	int contentId;
	UserVO user;
	String comment;
	String createAt;
	String lastModified;

	public CommentVO() {
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "CommentVO{" +
				"commentId=" + commentId +
				", contentId=" + contentId +
				", user=" + user +
				", comment='" + comment + '\'' +
				", createAt=" + createAt +
				", lastModified=" + lastModified +
				'}';
	}
}
