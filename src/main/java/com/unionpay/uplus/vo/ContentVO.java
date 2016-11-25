package com.unionpay.uplus.vo;

import java.util.List;
import java.util.Set;

/**
 * date: 2016/11/25 23:06
 * author: yueqi.shi
 */
public class ContentVO {

    int contentId;

    UserVO user;

    String title;

    String content;

    List<String> picUrls;

    int praiseCount;

    int commentsCount;

    String createAt;

    String lastModified;

    int typeMain;

    int typeSub;

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

    public List<String> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(List<String> picUrls) {
        this.picUrls = picUrls;
    }

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
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
}
