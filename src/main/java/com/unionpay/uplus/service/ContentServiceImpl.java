package com.unionpay.uplus.service;

import com.unionpay.uplus.api.ContentService;
import com.unionpay.uplus.dao.ContentDao;
import com.unionpay.uplus.vo.ContentVO;

import java.util.List;

/**
 * date: 2016/11/25 23:47
 * author: yueqi.shi
 */
public class ContentServiceImpl implements ContentService {

    private ContentDao contentDao = new ContentDao();

    @Override
    public List<ContentVO> getContents(int typeMain, int typeSub, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        int limit = pageSize;

        List<ContentVO> contentVOs = contentDao.getContents(typeMain, typeSub, offset, limit);

        return contentVOs;
    }

    @Override
    public int getContentsCount(int typeMain, int typeSub) {
        return contentDao.getContentsCount(typeMain, typeSub);
    }
}
