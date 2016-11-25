package com.unionpay.uplus.api;

import com.unionpay.uplus.vo.ContentVO;

import java.util.List;

/**
 * date: 2016/11/25 23:47
 * author: yueqi.shi
 */
public interface ContentService {
    public List<ContentVO> getContents(int typeMain, int typeSub, int page, int pageSize);
}
