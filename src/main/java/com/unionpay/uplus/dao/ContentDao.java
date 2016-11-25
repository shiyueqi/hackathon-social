package com.unionpay.uplus.dao;

import com.unionpay.uplus.util.DataSourceUtil;
import com.unionpay.uplus.vo.ContentVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * date: 2016/11/25 22:53
 * author: yueqi.shi
 */
public class ContentDao {
    private static final String SQL_GET_CONTENT = "SELECT "
            + "id, "
            + "user_id, "
            + "title, "
            + "content, "
            + "pics, "
            + "praise_count, "
            + "comments_count, "
            + "vote_id, "
            + "votes_count, "
            + "type_main, "
            + "type_sub, "
            + "create_at, "
            + "last_modified, "
            + " FROM "
            + "uplus_content"
            + " WHERE "
            + "id=?";

    private static final String SQL_GET_CONTENTS = "SELECT "
            + "id, "
            + "user_id, "
            + "title, "
            + "content, "
            + "pics, "
            + "praise_count, "
            + "comments_count, "
            + "vote_id, "
            + "votes_count, "
            + "type_main, "
            + "type_sub, "
            + "create_at, "
            + "last_modified "
            + " FROM "
            + " uplus_content "
            + " WHERE "
            + " type_main=? "
            + " and type_sub=? "
            + " ORDER BY "
            + " create_at "
            + " DESC "
            + " LIMIT "
            + " ? , ? ";

    public List<ContentVO> getContents(int typeMain, int typeSub, int offset, int limit) {

        Connection co = DataSourceUtil.getConnection();

        try {
            PreparedStatement ps = co.prepareStatement(SQL_GET_CONTENTS);
            ps.setInt(1, typeMain);
            ps.setInt(2, typeSub);
            ps.setInt(3, offset);
            ps.setInt(4, limit);
            ResultSet rs = ps.executeQuery();

            List<ContentVO> results = new ArrayList<ContentVO>();

            while (rs.next()) {
                ContentVO contentVO = new ContentVO();

                contentVO.setId(rs.getInt(1));
                contentVO.setUserId(rs.getInt(2));
                contentVO.setTitle(rs.getString(3));
                contentVO.setContent(rs.getString(4));
                contentVO.setPics(rs.getString(5));
                contentVO.setPraiseCount(rs.getInt(6));
                contentVO.setCommentsCount(rs.getInt(7));
                contentVO.setVoteId(rs.getInt(8));
                contentVO.setVotesCount(rs.getInt(9));
                contentVO.setTypeMain(rs.getInt(10));
                contentVO.setTypeSub(rs.getInt(11));
                contentVO.setCreateAt(rs.getInt(12));
                contentVO.setLastModified(rs.getInt(13));

                results.add(contentVO);
            }

            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<ContentVO>();
    }
}
