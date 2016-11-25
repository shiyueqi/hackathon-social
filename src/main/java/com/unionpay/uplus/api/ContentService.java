package com.unionpay.uplus.api;

import com.unionpay.uplus.vo.ContentVO;

import java.util.List;

/**
 * date: 2016/11/25 23:47
 * author: yueqi.shi
 */
public interface ContentService {
    public ContentVO getContent(int contentId);

    public List<ContentVO> getContents(int typeMain, int typeSub, int page, int pageSize);

    public int getContentsCount(int typeMain, int typeSub);

    public boolean createContent(ContentVO contentVO);

    public boolean praiseContent(int contentId);

}
