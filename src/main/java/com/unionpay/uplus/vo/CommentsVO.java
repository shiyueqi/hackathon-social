package com.unionpay.uplus.vo;

import java.util.List;

/**
 * date: 2016/11/26 00:28
 * author: yueqi.shi
 */
public class CommentsVO {
    private List<CommentVO> Comments;

    private PageVO page;

    public CommentsVO() {
    }

    public CommentsVO(List<CommentVO> Comments, PageVO page) {
        this.Comments = Comments;
        this.page = page;
    }

    public PageVO getPage() {
        return page;
    }

    public void setPage(PageVO page) {
        this.page = page;
    }

    public List<CommentVO> getComments() {
        return Comments;
    }

    public void setComments(List<CommentVO> Comments) {
        this.Comments = Comments;
    }

    @Override
    public String toString() {
        return "CommentsVO{" +
                "Comments=" + Comments +
                ", page=" + page +
                '}';
    }
}
