package com.unionpay.uplus.rest;

import com.unionpay.uplus.api.ActService;
import com.unionpay.uplus.api.ContentService;
import com.unionpay.uplus.api.UserService;
import com.unionpay.uplus.service.ActServiceImpl;
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
@Path("/qa")
@Produces("application/json;charset=UTF-8")
public class QaResource {

    private ContentService contentService = new ContentServiceImpl();

    private UserService userService = new UserServiceImpl();
    
    @GET
    @Path("/qas")
    @Produces("application/json;charset=UTF-8")
    public ContentsVO getContentsByTypeSub(@QueryParam(value = "pageNum") @DefaultValue("1")int pageNum
            , @QueryParam(value = "pageSize") @DefaultValue("5")int pageSize
            , @QueryParam(value = "typeSub") int typeSub
            , @Context HttpServletRequest request) {
        ContentsVO contentsVO = new ContentsVO();

        if(!TypeSub.qaTypes.contains(typeSub)) {
            typeSub = TypeSub.qaDefaultType;
        }

        List<ContentVO> contentVOs = contentService.getContents(
                TypeMain.qaType
                , typeSub
                , pageNum
                , pageSize);
            int contentsCount = contentService.getContentsCount(TypeMain.qaType
                , typeSub);

        for(ContentVO contentVO : contentVOs) {
            UserVO userVO = userService.getUser(contentVO.getUser().getUserId());
            contentVO.setUser(userVO);
        }

        contentsVO.setContents(contentVOs);
        contentsVO.setPage(PageUtil.getPage(pageNum, pageSize, contentsCount));

        return contentsVO;
    }

    @GET
    @Path("/{qaId}")
    @Produces("application/json;charset=UTF-8")
    public ContentVO getContent(@PathParam(value = "qaId") int qaId
            , @Context HttpServletRequest request) {
        ContentVO contentVO = contentService.getContent(qaId);

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

        if(!TypeSub.qaTypes.contains(typeSub)) {
            typeSub = TypeSub.qaDefaultType;
        }

        List<String> picList = PicsUtil.getPics(DecodeUtil.decode(pics));

        ContentVO contentVO = new ContentVO();
        contentVO.setUser(userVO);
        contentVO.setTitle(DecodeUtil.decode(title));
        contentVO.setContent(DecodeUtil.decode(content));
        contentVO.setPicUrls(picList);
        contentVO.setPraiseCount(0);
        contentVO.setCommentsCount(0);
        contentVO.setTypeMain(TypeMain.qaType);
        contentVO.setTypeSub(typeSub);
        contentVO.setCreateAt("");
        contentVO.setLastModified("");

        boolean res = contentService.createContent(contentVO);

        return res == true ? CodeVO.SUCCESS : CodeVO.ERROR;
    }

    @POST
    @Path("/{qaId}")
    @Produces("application/json;charset=UTF-8")
    public CodeVO praiseActivity(@PathParam(value = "qaId")int qaId) {

        boolean res = contentService.praiseContent(qaId);

        return res == true ? CodeVO.SUCCESS : CodeVO.ERROR;
    }

}
