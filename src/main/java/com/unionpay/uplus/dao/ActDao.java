package com.unionpay.uplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unionpay.uplus.util.DataSourceUtil;
import com.unionpay.uplus.vo.ActivityRegVO;
import com.unionpay.uplus.vo.UserVO;

/**
 * date: 2016/11/26 4:56 author: Aeon
 */
public class ActDao {

	private static final String SQL_GET_ACTIVITY = "SELECT " 
			+ "id, " 
			+ "content_id, " 
			+ "user_id, " 
			+ "create_at, "
			+ "last_modified "
			+ " FROM " 
			+ " uplus_act " 
			+ " WHERE " 
			+ " content_id=? " ;

	private static final String SQL_REG_ACTIVITY = " INSERT INTO " 
			+ " uplus_act " 
			+ "( " 
			+ "content_id , "
			+ "user_id , " 
			+ "create_at , " 
			+ "last_modified "
			+ " ) values (" 
			+ "?,?,?,? )";

	private static final String SQL_COUNT_ACTIVITIES = "SELECT " 
			+ " COUNT(0) " 
			+ " FROM " 
			+ " uplus_act " 
			+ " WHERE "
			+ " content_id=? ";

	public List<ActivityRegVO> getActivity(int contentId) {
		Connection co = DataSourceUtil.getConnection();
		try {
			PreparedStatement ps = co.prepareStatement(SQL_GET_ACTIVITY);
			ps.setInt(1, contentId);

			ResultSet rs = ps.executeQuery();
			List<ActivityRegVO> results = new ArrayList<ActivityRegVO>();

			while (rs.next()) {
				ActivityRegVO activityRegVO = new ActivityRegVO();

				activityRegVO.setId(rs.getInt(1));
				activityRegVO.setContentId(rs.getInt(2));

				UserVO userVO = new UserVO();
				userVO.setUserId(rs.getInt(3));
				activityRegVO.setUser(userVO);

				activityRegVO.setCreateAt(rs.getLong(4));
				activityRegVO.setLastModified(rs.getLong(5));

				results.add(activityRegVO);
			}

			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<ActivityRegVO>();
	}
	
	
	public boolean regActivity(int contentId, UserVO user) {
		Connection co = DataSourceUtil.getConnection();

		try {
			PreparedStatement ps = co.prepareStatement(SQL_REG_ACTIVITY);
			ps.setInt(1, contentId);
			ps.setInt(2, user.getUserId());
			ps.setLong(3, System.currentTimeMillis() / 1000);
			ps.setLong(4, System.currentTimeMillis() / 1000);
		ps.execute();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public int getActivitiesCount(int contentId) {
		Connection co = DataSourceUtil.getConnection();

		try {
			PreparedStatement ps = co.prepareStatement(SQL_COUNT_ACTIVITIES);
			ps.setInt(1, contentId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int activitieCount = rs.getInt(1);

				return activitieCount;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
}
