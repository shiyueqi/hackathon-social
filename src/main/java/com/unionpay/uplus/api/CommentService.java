package com.unionpay.uplus.api;

import java.util.List;

import com.unionpay.uplus.vo.CommentVO;

/**
 * date: 2016/11/25 23:47
 * author: yueqi.shi
 */
public interface CommentService {
    public List<CommentVO> getComments(int contentId, int page, int pageSize);
    
    public boolean addComments(CommentVO commentVo);
    
    public int queryCommentAmount(int contentId);
	
//	public Boolean praiseOnCommentsByCommentId(String contentId, String commentId);

//	public Boolean praiseOnCommentsByUserId(String contentId, String userId);
	
//	public Boolean cancelPraiseOnCommentsByCommentId(String contentId, String commentId, String userId);
	
//	public Boolean deleteComment(String contentId, String  comentId);
	
//	public Boolean reportComment(String contentId, String commentId, String authurName);
	
//	public List<CommentVO> getCommentsPagination(String contentId, String commentId, int pageNum, int pageSize);

//	public List<CommentVO> getHotComments(String contentId, String commentId, int top5praised);
    
    
}
