package com.unionpay.uplus.rest;

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
@Path("/activity")
@Produces("application/json;charset=UTF-8")
public class ActivityResource {

    private ContentService contentService = new ContentServiceImpl();

    private UserService userService = new UserServiceImpl();

    @GET
    @Path("/activities")
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
            int contentsCount = contentService.getContentsCount(TypeMain.activityType
                , TypeSub.activityDefaultType);

        for(ContentVO contentVO : contentVOs) {
            UserVO userVO = userService.getUser(contentVO.getUser().getUserId());
            contentVO.setUser(userVO);
        }

        contentsVO.setContents(contentVOs);
        contentsVO.setPage(PageUtil.getPage(pageNum, pageSize, contentsCount));

        return contentsVO;
    }

    @GET
    @Path("/{activityId}")
    @Produces("application/json;charset=UTF-8")
    public ContentVO getContent(@PathParam(value = "activityId") int activityId
            , @Context HttpServletRequest request) {
        ContentVO contentVO = contentService.getContent(activityId);

        UserVO userVO = userService.getUser(contentVO.getUser().getUserId());
        contentVO.setUser(userVO);

        return contentVO;
    }

    @POST
    @Path("/")
    @Produces("application/json;charset=UTF-8")
    public CodeVO createActivity(@FormParam(value = "userId")int userId
            , @FormParam(value = "title")String title
            , @FormParam(value = "content")String content
            , @FormParam(value = "pics")String pics
            , @FormParam(value = "typeSub") int typeSub) {

        UserVO userVO = new UserVO();
        userVO.setUserId(userId);

        List<String> picList = PicsUtil.getPics(DecodeUtil.decode(pics));

        ContentVO contentVO = new ContentVO();
        contentVO.setUser(userVO);
        contentVO.setTitle(DecodeUtil.decode(title));
        contentVO.setContent(DecodeUtil.decode(content));
        contentVO.setPicUrls(picList);
        contentVO.setPraiseCount(0);
        contentVO.setCommentsCount(0);
        contentVO.setTypeMain(TypeMain.activityType);
        contentVO.setTypeSub(typeSub == 0 ? TypeSub.activityDefaultType : typeSub);
        contentVO.setCreateAt("");
        contentVO.setLastModified("");

        boolean res = contentService.createContent(contentVO);

        return res == true ? CodeVO.SUCCESS : CodeVO.ERROR;
    }

    @POST
    @Path("/{activityId}")
    @Produces("application/json;charset=UTF-8")
    public CodeVO praiseActivity(@PathParam(value = "activityId")int activityId) {

        boolean res = contentService.praiseContent(activityId);

        return res == true ? CodeVO.SUCCESS : CodeVO.ERROR;
    }


}
