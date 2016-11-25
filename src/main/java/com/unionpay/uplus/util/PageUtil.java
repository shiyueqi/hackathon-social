package com.unionpay.uplus.util;

import com.unionpay.uplus.vo.PageVO;

/**
 * date: 2016/11/26 01:04
 * author: yueqi.shi
 */
public class PageUtil {
    public static PageVO getPage(int pageNum, int pageSize, int totalCount) {
        PageVO pageVO = new PageVO();

        pageVO.setPageNum(pageNum);
        pageVO.setPageSize(pageSize);
        pageVO.setTotalSize(totalCount);
        pageVO.setTotalPages(totalCount % pageSize == 0
                ? totalCount / pageSize : (totalCount / pageSize + 1));

        return pageVO;
    }
}
