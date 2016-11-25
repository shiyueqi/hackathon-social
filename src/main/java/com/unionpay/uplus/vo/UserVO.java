package com.unionpay.uplus.vo;

/**
 * date: 2016/11/25 14:28
 * author: yueqi.shi
 */
public class UserVO {
    /**
     * 用户id
     */
    private int userId;

    /**
     * 用户 昵称
     */
    private String userName;

    /**
     * 头像
     */
    private String userPic;

    /**
     * 性别
     */
    private String userGender;

    /**
     * 年龄
     */
    private int userAge;

    /**
     * 部门
     */
    private String department;

    /**
     * 科室
     */
    private String office;

    public UserVO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPic='" + userPic + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userAge=" + userAge +
                ", department='" + department + '\'' +
                ", office='" + office + '\'' +
                '}';
    }
}

