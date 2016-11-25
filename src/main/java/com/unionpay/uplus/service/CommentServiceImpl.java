package com.unionpay.uplus.service;

import java.util.List;

import com.unionpay.uplus.api.CommentService;
import com.unionpay.uplus.dao.CommentDao;
import com.unionpay.uplus.dao.ContentDao;
import com.unionpay.uplus.vo.CommentVO;

/**
 * date: 2016/11/25 23:47 author: yueqi.shi
 */
public class CommentServiceImpl implements CommentService {

	private CommentDao commentDao = new CommentDao();

	private ContentDao contentDao = new ContentDao();

	public List<CommentVO> getComments(int contentId, int page, int pageSize) {
		// TODO Auto-generated method stub
		int offset = (page - 1) * pageSize;
		int limit = pageSize;
		List<CommentVO> commentVOs = commentDao.getComments(contentId, offset, limit);

		return commentVOs;
	}

	public boolean addComments(CommentVO commentVo) {
		// TODO Auto-generated method stub
		if (commentVo == null) {
			return false;
		}

		boolean res = commentDao.addComments(commentVo);

		if (res == true) {
			contentDao.commentContent(commentVo.getContentId());
		}

		return res;
	}

	public int queryCommentAmount(int contentId) {
		return commentDao.getCommentsCount(contentId);
	}

	public Boolean deleteComment(String contentId, String comentId) {
		// TODO Auto-generated method stub
		return null;
	}
}
