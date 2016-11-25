package com.unionpay.uplus.rest;

import com.unionpay.uplus.api.ContentService;
import com.unionpay.uplus.api.UserService;
import com.unionpay.uplus.service.ContentServiceImpl;
import com.unionpay.uplus.service.UserServiceImpl;
import com.unionpay.uplus.util.PageUtil;
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
}
