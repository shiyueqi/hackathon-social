package com.unionpay.uplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unionpay.uplus.util.DataSourceUtil;
import com.unionpay.uplus.vo.CommentVO;

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
            + "praise_count, "
            + " FROM "
            + "uplus_comments"
            + " WHERE "
            + " content_id=? "
            + " ORDER BY "
            + " create_at "
            + " DESC "
            + " LIMIT "
            + " ? , ? ";

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

                commentVO.setId(rs.getInt(1));
                commentVO.setUserId(rs.getInt(2));
                commentVO.setComment(rs.getString(3));
                commentVO.setContentId(rs.getString(4));
                commentVO.setReferId(rs.getString(5));
                commentVO.setReferUserId(rs.getInt(6));
                commentVO.setReferUserName(rs.getString(7));
                commentVO.setCreateAt(rs.getLong(8));
                commentVO.setLastModified(rs.getLong(9));
                commentVO.setStatus(rs.getString(10));

                results.add(commentVO);
            }

            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<CommentVO>();
    }
}
