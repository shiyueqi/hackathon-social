package com.unionpay.uplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unionpay.uplus.util.DataSourceUtil;
import com.unionpay.uplus.util.TimeUtil;
import com.unionpay.uplus.vo.CommentVO;
import com.unionpay.uplus.vo.UserVO;

/**
 * date: 2016/11/25 22:53
 * author: yueqi.shi
 */
public class CommentDao {

    private static final String SQL_GET_COMMENTS = "SELECT "
    		+ "id, "
            + "user_id, "
            + "comment, "
            + "content_id, "
            + "refer_id, "
            + "refer_user_id, "
            + "refer_user_name, "
            + "create_at, "
            + "last_modified, "
            + "status, "
            + "praise_count "
            + " FROM "
            + "uplus_comments"
            + " WHERE "
            + " content_id=? "
            + " ORDER BY "
            + " create_at "
            + " DESC "
            + " LIMIT "
            + " ? , ? ";
    
    private static final String SQL_ADD_COMMENTS = " INSERT INTO "
    		+ " uplus_comments "
    		+ "( "
            + "user_id , "
            + "comment , "
            + "content_id , "
            + "refer_id , "
            + "refer_user_id , "
            + "refer_user_name , "
            + "create_at , "
            + "last_modified , "
            + "status , "
            + "praise_count "
            + " ) values ("
            + "?,?,?,?,?,?,?,?,?,? )";
    
    private static final String SQL_COUNT_COMMENTS = "SELECT "
            + " COUNT(0) "
            + " FROM "
            + " uplus_comments "
            + " WHERE "
            + " content_id=? ";
    
    public boolean addComments(CommentVO commentVo) {
    	Connection co = DataSourceUtil.getConnection();
    	
    	try {
    		PreparedStatement ps = co.prepareStatement(SQL_ADD_COMMENTS);
    		ps.setInt(1, commentVo.getUser().getUserId());
    		ps.setString(2, commentVo.getComment());
    		ps.setInt(3, commentVo.getContentId());
    		ps.setInt(4, 0);
    		ps.setInt(5, 0);
    		ps.setString(6, "");
    		ps.setLong(7, System.currentTimeMillis()/1000);
    		ps.setLong(8, System.currentTimeMillis()/1000);
    		ps.setInt(9, 1);
    		ps.setInt(10, 0);
    		ps.execute();

            return true;
    	}catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<CommentVO> getComments(int contentId, int offset, int limit) {

        Connection co = DataSourceUtil.getConnection();

        try {
            PreparedStatement ps = co.prepareStatement(SQL_GET_COMMENTS);
            ps.setInt(1, contentId);
            ps.setInt(2, offset);
            ps.setInt(3, limit);
            ResultSet rs = ps.executeQuery();

            List<CommentVO> results = new ArrayList<CommentVO>();

            while (rs.next()) {
            	CommentVO commentVO = new CommentVO();

                commentVO.setCommentId(rs.getInt(1));

                int userId = rs.getInt(2);
                UserVO userVO = new UserVO();
                userVO.setUserId(userId);
                commentVO.setUser(userVO);

                commentVO.setComment(rs.getString(3));
                commentVO.setContentId(rs.getInt(4));
                commentVO.setCreateAt(TimeUtil.getDate(rs.getLong(8)));
                commentVO.setLastModified(TimeUtil.getDate(rs.getLong(9)));

                results.add(commentVO);
            }

            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<CommentVO>();
    }
    
    public int getCommentsCount(int contentId) {
        Connection co = DataSourceUtil.getConnection();

        try {
            PreparedStatement ps = co.prepareStatement(SQL_COUNT_COMMENTS);
            ps.setInt(1, contentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int commentsCount = rs.getInt(1);

                return commentsCount;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
