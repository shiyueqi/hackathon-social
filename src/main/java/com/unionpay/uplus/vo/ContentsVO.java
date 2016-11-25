package com.unionpay.uplus.vo;

import java.util.List;

/**
 * date: 2016/11/26 00:28
 * author: yueqi.shi
 */
public class ContentsVO {
    private List<ContentVO> contents;

    private PageVO page;

    public ContentsVO() {
    }

    public ContentsVO(List<ContentVO> contents, PageVO page) {
        this.contents = contents;
        this.page = page;
    }

    public PageVO getPage() {
        return page;
    }

    public void setPage(PageVO page) {
        this.page = page;
    }

    public List<ContentVO> getContents() {
        return contents;
    }

    public void setContents(List<ContentVO> contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "ContentsVO{" +
                "contents=" + contents +
                ", page=" + page +
                '}';
    }
}
