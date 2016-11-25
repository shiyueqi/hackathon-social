package com.unionpay.uplus.social.vo;

/**
 * date: 2016/11/25 14:53 author: yueqi.shi
 */
public class CommentVO {
	String id;
	String user_id;
	String comment;
	String content_id;
	String refer_id;
	String refer_user_name;
	String create_at;
	String last_modified;
	String status;
	String praise_count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getContent_id() {
		return content_id;
	}

	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}

	public String getRefer_id() {
		return refer_id;
	}

	public void setRefer_id(String refer_id) {
		this.refer_id = refer_id;
	}

	public String getRefer_user_name() {
		return refer_user_name;
	}

	public void setRefer_user_name(String refer_user_name) {
		this.refer_user_name = refer_user_name;
	}

	public String getCreate_at() {
		return create_at;
	}

	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}

	public String getLast_modified() {
		return last_modified;
	}

	public void setLast_modified(String last_modified) {
		this.last_modified = last_modified;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPraise_count() {
		return praise_count;
	}

	public void setPraise_count(String praise_count) {
		this.praise_count = praise_count;
	}

}
