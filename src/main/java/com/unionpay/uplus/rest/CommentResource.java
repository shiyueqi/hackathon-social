package com.unionpay.uplus.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

import com.unionpay.uplus.api.CommentService;
import com.unionpay.uplus.service.CommentServiceImpl;
import com.unionpay.uplus.util.PageUtil;
import com.unionpay.uplus.vo.CommentVO;
import com.unionpay.uplus.vo.CommentsVO;

/**
 * date: 2016/11/26 3:01
 * author: Aeon
 */
@Path("/comments")
@Produces("application/json;charset=UTF-8")
public class CommentResource {
    private CommentService CommentService = new CommentServiceImpl();


    @GET
    @Path("/content/{contentId}")
    @Produces("application/json;charset=UTF-8")
    public CommentsVO getComments(@PathParam(value = "contentId") int contentId , @QueryParam(value = "pageNum") @DefaultValue("1")int pageNum
            , @QueryParam(value = "pageSize") @DefaultValue("5")int pageSize
            , @Context HttpServletRequest request) {
        CommentsVO CommentsVO = new CommentsVO();

        List<CommentVO> CommentVOs = CommentService.getComments(contentId
                , pageNum
                , pageSize);
        int CommentsCount = CommentService.queryCommentAmount(contentId);	

        CommentsVO.setComments(CommentVOs);
        CommentsVO.setPage(PageUtil.getPage(pageNum, pageSize, CommentsCount));

        return CommentsVO;
    }
}
