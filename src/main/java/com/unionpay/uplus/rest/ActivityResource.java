package com.unionpay.uplus.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

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

/**
 * date: 2016/11/25 23:51
 * author: yueqi.shi
 */
@Path("/activity")
@Produces("application/json;charset=UTF-8")
public class ActivityResource {

    private ContentService contentService = new ContentServiceImpl();

    private UserService userService = new UserServiceImpl();
    
    private ActService actService = new ActServiceImpl() ;
	

    @GET
    @Path("/activities")
    @Produces("application/json;charset=UTF-8")
    public ContentsVO getContentsByTypeSub(@QueryParam(value = "pageNum") @DefaultValue("1")int pageNum
            , @QueryParam(value = "pageSize") @DefaultValue("5")int pageSize
            , @QueryParam(value = "typeSub") int typeSub
            , @Context HttpServletRequest request) {
        ContentsVO contentsVO = new ContentsVO();

        List<ContentVO> contentVOs;
        int contentsCount = 0;
        if(!TypeSub.activityTypes.contains(typeSub) || typeSub == 0) {
            contentVOs = contentService.getContentsByTypeMain(
                    TypeMain.activityType
                    , pageNum
                    , pageSize);
            contentsCount = contentService.getContentsCountByTypeMain(TypeMain.activityType);
        } else {
            contentVOs = contentService.getContents(
                    TypeMain.activityType
                    , typeSub
                    , pageNum
                    , pageSize);
            contentsCount = contentService.getContentsCount(TypeMain.activityType
                    , typeSub);
        }

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
    public ActivityVO getContent(@PathParam(value = "activityId") int activityId
            , @Context HttpServletRequest request) {
        ActivityVO activityVO = new ActivityVO();

        ContentVO contentVO = contentService.getContent(activityId);
        List<ActivityRegVO> activityRegVOs = actService.queryActivity(activityId);
        UserVO userVO = userService.getUser(contentVO.getUser().getUserId());

        activityVO.setContentId(contentVO.getContentId());
        activityVO.setUser(userVO);
        activityVO.setTitle(contentVO.getTitle());
        activityVO.setContent(contentVO.getContent());
        activityVO.setPicUrls(contentVO.getPicUrls());
        activityVO.setPraiseCount(contentVO.getPraiseCount());
        activityVO.setCommentsCount(contentVO.getCommentsCount());
        activityVO.setCreateAt(contentVO.getCreateAt());
        activityVO.setLastModified(contentVO.getLastModified());
        activityVO.setTypeMain(contentVO.getTypeMain());
        activityVO.setTypeSub(contentVO.getTypeSub());

        List<UserVO> userVOs = new ArrayList<UserVO>();
        for(ActivityRegVO activityRegVO : activityRegVOs) {
            userVOs.add(userService.getUser(activityRegVO.getUser().getUserId()));
        }

        activityVO.setActivityUsers(userVOs);
        activityVO.setActivityUsersCount(userVOs.size());

        return activityVO;
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

        if(!TypeSub.activityTypes.contains(typeSub)) {
            typeSub = TypeSub.activityDefaultType;
        }

        List<String> picList = PicsUtil.getPics(DecodeUtil.decode(pics));

        ContentVO contentVO = new ContentVO();
        contentVO.setUser(userVO);
        contentVO.setTitle(DecodeUtil.decode(title));
        contentVO.setContent(DecodeUtil.decode(content));
        contentVO.setPicUrls(picList);
        contentVO.setPraiseCount(0);
        contentVO.setCommentsCount(0);
        contentVO.setTypeMain(TypeMain.activityType);
        contentVO.setTypeSub(typeSub);
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

    @GET
    @Path("/{activityId}/registries")
    @Produces("application/json;charset=UTF-8")
    public List<ActivityRegVO> queryActivity(@PathParam(value = "activityId") int activityId) {
    	List<ActivityRegVO> activityRegVOs = actService.queryActivity(activityId);

        for(ActivityRegVO activityRegVO : activityRegVOs) {
            activityRegVO.setUser(userService.getUser(activityRegVO.getUser().getUserId()));
        }

        return activityRegVOs;
    }
    
    @POST
    @Path("/{activityId}/newreg")
    @Produces("application/json;charset=UTF-8")
    public CodeVO regActivity(@PathParam(value = "activityId") int activityId
    		,@FormParam(value = "userId")int userId) {
    	UserVO user = new UserVO();
    	user.setUserId(userId);
    	boolean res = actService.regActivity(activityId, user);
    	return res == true ? CodeVO.SUCCESS : CodeVO.ERROR;
    }
    

}
