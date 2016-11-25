package com.unionpay.uplus.vo;

/**
 * date: 2016/11/26 00:28
 * author: yueqi.shi
 */
public class PageVO {
    private int pageNum;

    private int pageSize;

    private int totalPages;

    private int totalSize;

    public PageVO() {
    }

    public PageVO(int pageNum, int pageSize, int totalPages, int totalSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalSize = totalSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                ", totalSize=" + totalSize +
                '}';
    }
}
