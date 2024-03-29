package com.unionpay.uplus.api;

import com.unionpay.uplus.vo.UserVO;

import java.util.List;

/**
 * date: 2016/11/25 14:25
 * author: yueqi.shi
 */
public interface UserService {
    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    public UserVO getUser(int userId);

    public List<UserVO> getUsersByIds(List<Integer> userIds);

    public List<UserVO> getUsersByUsers(List<UserVO> users);

}

