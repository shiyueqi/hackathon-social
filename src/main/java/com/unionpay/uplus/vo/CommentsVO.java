package com.unionpay.uplus.vo;

import java.util.List;

/**
 * date: 2016/11/26 00:28
 * author: yueqi.shi
 */
public class CommentsVO {
    private List<CommentVO> comments;

    private PageVO page;

    public CommentsVO() {
    }

    public CommentsVO(List<CommentVO> comments, PageVO page) {
        this.comments = comments;
        this.page = page;
    }

    public List<CommentVO> getComments() {
        return comments;
    }

    public void setComments(List<CommentVO> comments) {
        this.comments = comments;
    }

    public PageVO getPage() {
        return page;
    }

    public void setPage(PageVO page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "CommentsVO{" +
                "comments=" + comments +
                ", page=" + page +
                '}';
    }
}
