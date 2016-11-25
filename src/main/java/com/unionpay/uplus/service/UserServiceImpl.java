package com.unionpay.uplus.service;

import com.unionpay.uplus.api.UserService;
import com.unionpay.uplus.dao.UserDao;
import com.unionpay.uplus.vo.UserVO;

/**
 * date: 2016/11/25 14:27
 * author: yueqi.shi
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();

    @Override
    public UserVO getUser(int userId) {
        UserVO userVO = userDao.getUser(userId);
        return userVO;
    }
}
