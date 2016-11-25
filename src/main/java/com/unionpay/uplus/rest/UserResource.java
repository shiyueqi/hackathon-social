package com.unionpay.uplus.rest;

import com.unionpay.uplus.api.UserService;
import com.unionpay.uplus.service.UserServiceImpl;
import com.unionpay.uplus.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

/**
 * date: 2016/11/25 14:29
 * author: yueqi.shi
 */

@Path("/user")
@Produces("application/json;charset=UTF-8")
public class UserResource {

    private UserService userService = new UserServiceImpl();

    @GET
    @Path("/{userId}")
    @Produces("application/json;charset=UTF-8")
    public UserVO getUser(@PathParam(value = "userId") int userId
            , @Context HttpServletRequest request) {
        UserVO userVO = userService.getUser(userId);
        return userVO;
    }
}
