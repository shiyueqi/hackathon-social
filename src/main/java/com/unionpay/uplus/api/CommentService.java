package com.unionpay.uplus.api;

import java.util.List;

import com.unionpay.uplus.vo.CommentVO;

/**
 * date: 2016/11/25 23:47
 * author: yueqi.shi
 */
public interface CommentService {
    public List<CommentVO> getComments(int contentId, int page, int pageSize);
}
