package com.unionpay.uplus.dao;

import com.unionpay.uplus.util.DataSourceUtil;
import com.unionpay.uplus.vo.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * date: 2016/11/25 17:00
 * author: yueqi.shi
 */
public class UserDao {
    private static final String SQL_GET_USER = "SELECT "
            + "id, "
            + "user_name, "
            + "user_pic, "
            + "gender, "
            + "age, "
            + "department, "
            + "office"
            + " FROM "
            + "uplus_user"
            + " WHERE "
            + "id=?";

    public UserVO getUser(int userId) {

        Connection co = DataSourceUtil.getConnection();

        try {
            PreparedStatement ps = co.prepareStatement(SQL_GET_USER);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            UserVO result = new UserVO();

            if (rs.next()) {
                result.setUserId(rs.getInt(1));
                result.setUserName(rs.getString(2));
                result.setUserPic(rs.getString(3));
                int gender = rs.getInt(4);
                result.setUserGender(gender == 1 ? "男" : "女");
                result.setUserAge(rs.getInt(5));
                result.setDepartment(rs.getString(6));
                result.setOffice(rs.getString(7));
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new UserVO();
    }
}
