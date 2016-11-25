package com.unionpay.uplus.service;

import com.unionpay.uplus.api.UserService;
import com.unionpay.uplus.dao.UserDao;
import com.unionpay.uplus.vo.UserVO;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<UserVO> getUsersByIds(List<Integer> userIds) {
        List<UserVO> userVOs = new ArrayList<UserVO>();

        for(Integer userId : userIds) {
            UserVO userVO = userDao.getUser(userId);
            userVOs.add(userVO);
        }

        return userVOs;
    }

    @Override
    public List<UserVO> getUsersByUsers(List<UserVO> users) {
        List<UserVO> userVOs = new ArrayList<UserVO>();

        for(int i = 0; i < users.size(); i++) {
            UserVO userVO = userDao.getUser(users.get(i).getUserId());
            userVOs.add(userVO);
        }

        return userVOs;
    }


}
