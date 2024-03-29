package com.unionpay.uplus.rest;

import com.alibaba.fastjson.util.UTF8Decoder;
import com.sun.org.apache.bcel.internal.classfile.Code;
import com.unionpay.uplus.api.ContentService;
import com.unionpay.uplus.api.UserService;
import com.unionpay.uplus.service.ContentServiceImpl;
import com.unionpay.uplus.service.UserServiceImpl;
import com.unionpay.uplus.util.DecodeUtil;
import com.unionpay.uplus.util.PageUtil;
import com.unionpay.uplus.util.PicsUtil;
import com.unionpay.uplus.vo.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

/**
 * date: 2016/11/25 23:51
 * author: yueqi.shi
 */
@Path("/content")
@Produces("application/json;charset=UTF-8")
public class ContentResource {
    private ContentService contentService = new ContentServiceImpl();

    private UserService userService = new UserServiceImpl();

    @GET
    @Path("/contents")
    @Produces("application/json;charset=UTF-8")
    public ContentsVO getContents(@QueryParam(value = "pageNum") @DefaultValue("1")int pageNum
            , @QueryParam(value = "pageSize") @DefaultValue("5")int pageSize
            , @Context HttpServletRequest request) {
        ContentsVO contentsVO = new ContentsVO();

        List<ContentVO> contentVOs = contentService.getContents(
                TypeMain.contentType
                , TypeSub.contentDefaultType
                , pageNum
                , pageSize);
        int contentsCount = contentService.getContentsCount(TypeMain.contentType
                , TypeSub.contentDefaultType);

        for(ContentVO contentVO : contentVOs) {
            UserVO userVO = userService.getUser(contentVO.getUser().getUserId());
            contentVO.setUser(userVO);
        }

        contentsVO.setContents(contentVOs);
        contentsVO.setPage(PageUtil.getPage(pageNum, pageSize, contentsCount));

        return contentsVO;
    }
    
    @GET
    @Path("/mycontents")
    @Produces("application/json;charset=UTF-8")
    public ContentsVO getMyContents(@QueryParam(value = "userId") int userId
            , @QueryParam(value = "typeMain") int typeMain
            , @QueryParam(value = "pageNum") @DefaultValue("1")int pageNum
            , @QueryParam(value = "pageSize") @DefaultValue("5")int pageSize
            , @Context HttpServletRequest request) {
        ContentsVO contentsVO = new ContentsVO();

        List<ContentVO> contentVOs = contentService.getMyContents(
               userId, typeMain, pageNum, pageSize);
        int contentsCount = contentService.getMyContentsCount(userId, typeMain);

        for(ContentVO contentVO : contentVOs) {
            UserVO userVO = userService.getUser(contentVO.getUser().getUserId());
            contentVO.setUser(userVO);
        }

        contentsVO.setContents(contentVOs);
        contentsVO.setPage(PageUtil.getPage(pageNum, pageSize, contentsCount));

        return contentsVO;
    }

    @GET
    @Path("/{contentId}")
    @Produces("application/json;charset=UTF-8")
    public ContentVO getContent(@PathParam(value = "contentId") int contentId
            , @Context HttpServletRequest request) {
        ContentVO contentVO = contentService.getContent(contentId);

        UserVO userVO = userService.getUser(contentVO.getUser().getUserId());
        contentVO.setUser(userVO);

        return contentVO;
    }

    @POST
    @Path("/")
    @Produces("application/json;charset=UTF-8")
    public CodeVO createContent(@FormParam(value = "userId")int userId
            , @FormParam(value = "content")String content
            , @FormParam(value = "pics")String pics) {
        try {

            UserVO userVO = new UserVO();
            userVO.setUserId(userId);

            List<String> picList = PicsUtil.getPics(pics);

            ContentVO contentVO = new ContentVO();
            contentVO.setUser(userVO);
            contentVO.setTitle("");
            contentVO.setContent(DecodeUtil.decode(content));
            contentVO.setPicUrls(picList);
            contentVO.setPraiseCount(0);
            contentVO.setCommentsCount(0);
            contentVO.setTypeMain(TypeMain.contentType);
            contentVO.setTypeSub(TypeSub.contentDefaultType);
            contentVO.setCreateAt("");
            contentVO.setLastModified("");

            boolean res = contentService.createContent(contentVO);

            return res == true ? CodeVO.SUCCESS : CodeVO.ERROR;
        } catch (Exception e) {
            return CodeVO.ERROR;
        }

    }

    @POST
    @Path("/{contentId}")
    @Produces("application/json;charset=UTF-8")
    public CodeVO praiseContent(@PathParam(value = "contentId")int contentId) {

        boolean res = contentService.praiseContent(contentId);

        return res == true ? CodeVO.SUCCESS : CodeVO.ERROR;
    }


}
