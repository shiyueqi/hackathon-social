package com.unionpay.uplus.vo;

/**
 * date: 2016/11/25 14:51 author: yueqi.shi
 */
public class ActivityRegVO {
	int id;
	int contentId;
	UserVO user;

	long createAt;
	long lastModified;

	public ActivityRegVO() {
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
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

	@Override
	public String toString() {
		return "ActivityRegVO{" + "id=" + id + ", contentId=" + contentId + ", user=" + user + ", createAt=" + createAt
				+ ", lastModified=" + lastModified + '}';
	}
}
