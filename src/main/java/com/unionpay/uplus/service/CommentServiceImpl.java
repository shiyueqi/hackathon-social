package com.unionpay.uplus.service;

import java.util.List;

import com.unionpay.uplus.api.CommentService;
import com.unionpay.uplus.dao.CommentDao;
import com.unionpay.uplus.vo.CommentVO;

/**
 * date: 2016/11/25 23:47 author: yueqi.shi
 */
public class CommentServiceImpl implements CommentService {

	private CommentDao commentDao = new CommentDao();

	public List<CommentVO> getComments(int contentId, int page, int pageSize) {
		// TODO Auto-generated method stub
		int offset = (page - 1) * pageSize;
		int limit = pageSize;
		List<CommentVO> commentVOs = commentDao.getComments(contentId, offset, limit);

		return commentVOs;
	}

	public void addComments(CommentVO commentVo) {
		// TODO Auto-generated method stub
		if (commentVo == null) {
			return;
		}

		commentDao.addComments(commentVo);

		return;
	}

	public int queryCommentAmount(int contentId) {
		// TODO Auto-generated method stub
		commentDao.getCommentsCount(contentId);
		return 0;
	}

	public Boolean deleteComment(String contentId, String comentId) {
		// TODO Auto-generated method stub
		return null;
	}
}
