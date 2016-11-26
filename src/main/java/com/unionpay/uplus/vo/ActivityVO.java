package com.unionpay.uplus.vo;

import java.util.List;

/**
 * date: 2016/11/26 09:16
 * author: yueqi.shi
 */
public class ActivityVO extends ContentVO{

    private List<UserVO> activityUsers;

    private int activityUsersCount;

    public List<UserVO> getActivityUsers() {
        return activityUsers;
    }

    public void setActivityUsers(List<UserVO> activityUsers) {
        this.activityUsers = activityUsers;
    }

    public int getActivityUsersCount() {
        return activityUsersCount;
    }

    public void setActivityUsersCount(int activityUsersCount) {
        this.activityUsersCount = activityUsersCount;
    }
}
