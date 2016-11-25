package com.unionpay.uplus.vo;

import java.util.List;
import java.util.Set;

/**
 * date: 2016/11/25 23:06
 * author: yueqi.shi
 */
public class ContentVO {
    int id;
    int userId;
    String title;
    String content;
    String pics;
    int praiseCount;
    List<String> praiseUids;
    int commentsCount;
    int voteId;
    int votesCount;
    long createAt;
    long lastModified;
    int status;
    int typeMain;
    int typeSub;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }

    public List<String> getPraiseUids() {
        return praiseUids;
    }

    public void setPraiseUids(List<String> praiseUids) {
        this.praiseUids = praiseUids;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(int votesCount) {
        this.votesCount = votesCount;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTypeMain() {
        return typeMain;
    }

    public void setTypeMain(int typeMain) {
        this.typeMain = typeMain;
    }

    public int getTypeSub() {
        return typeSub;
    }

    public void setTypeSub(int typeSub) {
        this.typeSub = typeSub;
    }

    @Override
    public String toString() {
        return "ContentVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pics='" + pics + '\'' +
                ", praiseCount=" + praiseCount +
                ", praiseUids=" + praiseUids +
                ", commentsCount=" + commentsCount +
                ", voteId=" + voteId +
                ", votesCount=" + votesCount +
                ", createAt=" + createAt +
                ", lastModified=" + lastModified +
                ", status=" + status +
                ", typeMain=" + typeMain +
                ", typeSub=" + typeSub +
                '}';
    }
}
