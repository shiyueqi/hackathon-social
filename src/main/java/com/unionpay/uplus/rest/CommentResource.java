package com.unionpay.uplus.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

import com.unionpay.uplus.api.CommentService;
import com.unionpay.uplus.api.UserService;
import com.unionpay.uplus.service.CommentServiceImpl;
import com.unionpay.uplus.service.UserServiceImpl;
import com.unionpay.uplus.util.DecodeUtil;
import com.unionpay.uplus.util.PageUtil;
import com.unionpay.uplus.vo.CodeVO;
import com.unionpay.uplus.vo.CommentVO;
import com.unionpay.uplus.vo.CommentsVO;
import com.unionpay.uplus.vo.UserVO;

/**
 * date: 2016/11/26 3:01
 * author: Aeon
 */
@Path("/comments")
@Produces("application/json;charset=UTF-8")
public class CommentResource {
    private CommentService commentService = new CommentServiceImpl();
    private UserService userService = new UserServiceImpl();

    @GET
    @Path("/content/{contentId}")
    @Produces("application/json;charset=UTF-8")
    public CommentsVO getComments(@PathParam(value = "contentId") int contentId , @QueryParam(value = "pageNum") @DefaultValue("1")int pageNum
            , @QueryParam(value = "pageSize") @DefaultValue("5")int pageSize
            , @Context HttpServletRequest request) {
        CommentsVO commentsVO = new CommentsVO();

        List<CommentVO> commentVOs = commentService.getComments(contentId
                , pageNum
                , pageSize);
        int commentsCount = commentService.queryCommentAmount(contentId);

        for(CommentVO commentVO : commentVOs) {
            UserVO userVO = userService.getUser(commentVO.getUser().getUserId());
            commentVO.setUser(userVO);
        }

        commentsVO.setComments(commentVOs);
        commentsVO.setPage(PageUtil.getPage(pageNum, pageSize, commentsCount));

        return commentsVO;
    }

    @POST
    @Path("/content/{contentId}")
    @Produces("application/json;charset=UTF-8")
    public CodeVO createComment(@PathParam(value = "contentId") int contentId
            , @FormParam(value = "userId") int userId
            , @FormParam(value = "comment") String comment
            , @Context HttpServletRequest request) {
        CommentVO commentVO = new CommentVO();

        UserVO userVO = new UserVO();
        userVO.setUserId(userId);
        commentVO.setUser(userVO);

        commentVO.setContentId(contentId);
        commentVO.setComment(DecodeUtil.decode(comment));

        boolean res = commentService.addComments(commentVO);
        return res == true ? CodeVO.SUCCESS : CodeVO.ERROR;
    }
}
