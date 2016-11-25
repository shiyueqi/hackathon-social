package com.unionpay.uplus.rest;

import com.unionpay.uplus.api.ContentService;
import com.unionpay.uplus.service.ContentServiceImpl;
import com.unionpay.uplus.vo.ContentVO;
import com.unionpay.uplus.vo.TypeMain;
import com.unionpay.uplus.vo.TypeSub;
import com.unionpay.uplus.vo.UserVO;

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

    @GET
    @Path("/contents")
    @Produces("application/json;charset=UTF-8")
    public List<ContentVO> getContents(@QueryParam(value = "page") int page
            , @QueryParam(value = "pageSize") int pageSize
            , @Context HttpServletRequest request) {
        List<ContentVO> contentVOs = contentService.getContents(
                TypeMain.contentType
                , TypeSub.contentDefaultType
                , page
                , pageSize);

        return contentVOs;
    }
}
