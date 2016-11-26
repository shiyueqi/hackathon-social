package com.unionpay.uplus.dao;

import com.unionpay.uplus.util.DataSourceUtil;
import com.unionpay.uplus.util.PicsUtil;
import com.unionpay.uplus.util.TimeUtil;
import com.unionpay.uplus.vo.ContentVO;
import com.unionpay.uplus.vo.UserVO;

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
            + "last_modified "
            + " FROM "
            + "uplus_content "
            + " WHERE "
            + " id=? ";
    
    private static final String SQL_GET_CONTENT_BY_USER = "SELECT "
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
            + "uplus_content "
            + " WHERE "
            + " user_id= ? "
            + " and type_main = ? "
            + " ORDER BY "
            + " create_at "
            + " DESC "
            + " LIMIT "
            + " ? , ? ";

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

    private static final String SQL_GET_CONTENTS_BY_TYPE_MAIN = "SELECT "
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
            + " ORDER BY "
            + " create_at "
            + " DESC "
            + " LIMIT "
            + " ? , ? ";

    private static final String SQL_INSERT_CONTENT = "INSERT INTO uplus_content "
            + "("
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
            + "status) "
            + " VALUES "
            + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?) ";

    private static final String SQL_PRAISE_CONTENT = "UPDATE uplus_content "
            + " SET "
            + " praise_count=praise_count+1 "
            + " WHERE "
            + " id = ?";

    private static final String SQL_COMMENT_CONTENT = "UPDATE uplus_content "
            + " SET "
            + " comments_count=comments_count+1 "
            + " WHERE "
            + " id = ?";


    private static final String SQL_COUNT_CONTENTS = "SELECT "
            + " COUNT(0) "
            + " FROM "
            + " uplus_content "
            + " WHERE "
            + " type_main=? "
            + " and type_sub=? ";
    
    private static final String SQL_COUNT_MY_CONTENTS = "SELECT "
            + " COUNT(0) "
            + " FROM "
            + " uplus_content "
            + " WHERE "
            + " user_id = ? "
            + " and type_main= ? ";
    
    public int getMyContentsCount(int userId,int typeMain) {
        Connection co = DataSourceUtil.getConnection();

        try {
            PreparedStatement ps = co.prepareStatement(SQL_COUNT_MY_CONTENTS);
            ps.setInt(1, userId);
            ps.setInt(2, typeMain);
            
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int contentsCount = rs.getInt(1);

                return contentsCount;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    
    public List<ContentVO> getContentByUserId(int userId, int typeMain, int offset, int limit) {
    	 Connection co = DataSourceUtil.getConnection();
    	 
    	 try {
    		 PreparedStatement ps = co.prepareStatement(SQL_GET_CONTENT_BY_USER);
    		 ps.setInt(1, userId);
    		 ps.setInt(2, typeMain);
    		 ps.setInt(3, offset);
             ps.setInt(4, limit);
             
    		 ResultSet rs = ps.executeQuery();
    		 
    		 List<ContentVO> results = new ArrayList<ContentVO>();
    		 
    		 ContentVO vo = new ContentVO();
    		 
    		 if (rs.next()) {
    			 vo.setContentId(rs.getInt(1));
    			
                 UserVO userVO = new UserVO();
                 userVO.setUserId(userId);
                 vo.setUser(userVO);
                 vo.setTitle(rs.getString(3));
                 vo.setContent(rs.getString(4));
                 vo.setPicUrls(PicsUtil.getPics(rs.getString(5)));
                 vo.setPraiseCount(rs.getInt(6));
                 vo.setCommentsCount(rs.getInt(7));
                 vo.setTypeMain(rs.getInt(10));
                 vo.setTypeSub(rs.getInt(11));
                 vo.setCreateAt(TimeUtil.getDate(rs.getLong(12)));
                 vo.setLastModified(TimeUtil.getDate(rs.getLong(13)));
                 
                 results.add(vo);
             }

             return results;
         } catch (Exception e) {
             e.printStackTrace();
         }

         return new ArrayList<ContentVO>();
      }

    private static final String SQL_COUNT_CONTENTS_BY_TYPE_MAIN = "SELECT "
            + " COUNT(0) "
            + " FROM "
            + " uplus_content "
            + " WHERE "
            + " type_main=? ";

    public ContentVO getContent(int contentId) {

        Connection co = DataSourceUtil.getConnection();

        try {
            PreparedStatement ps = co.prepareStatement(SQL_GET_CONTENT);
            ps.setInt(1, contentId);
            ResultSet rs = ps.executeQuery();

            ContentVO contentVO = new ContentVO();

            if (rs.next()) {
                contentVO.setContentId(rs.getInt(1));

                int userId = rs.getInt(2);
                UserVO userVO = new UserVO();
                userVO.setUserId(userId);
                contentVO.setUser(userVO);

                contentVO.setTitle(rs.getString(3));
                contentVO.setContent(rs.getString(4));
                contentVO.setPicUrls(PicsUtil.getPics(rs.getString(5)));
                contentVO.setPraiseCount(rs.getInt(6));
                contentVO.setCommentsCount(rs.getInt(7));
                contentVO.setTypeMain(rs.getInt(10));
                contentVO.setTypeSub(rs.getInt(11));
                contentVO.setCreateAt(TimeUtil.getDate(rs.getLong(12)));
                contentVO.setLastModified(TimeUtil.getDate(rs.getLong(13)));
            }

            return contentVO;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ContentVO();
    }

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

                contentVO.setContentId(rs.getInt(1));

                int userId = rs.getInt(2);
                UserVO userVO = new UserVO();
                userVO.setUserId(userId);
                contentVO.setUser(userVO);

                contentVO.setTitle(rs.getString(3));
                contentVO.setContent(rs.getString(4));
                contentVO.setPicUrls(PicsUtil.getPics(rs.getString(5)));
                contentVO.setPraiseCount(rs.getInt(6));
                contentVO.setCommentsCount(rs.getInt(7));
                contentVO.setTypeMain(rs.getInt(10));
                contentVO.setTypeSub(rs.getInt(11));
                contentVO.setCreateAt(TimeUtil.getDate(rs.getLong(12)));
                contentVO.setLastModified(TimeUtil.getDate(rs.getLong(13)));

                results.add(contentVO);
            }

            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<ContentVO>();
    }

    public List<ContentVO> getContentsByTypeMain(int typeMain, int offset, int limit) {

        Connection co = DataSourceUtil.getConnection();

        try {
            PreparedStatement ps = co.prepareStatement(SQL_GET_CONTENTS_BY_TYPE_MAIN);
            ps.setInt(1, typeMain);
            ps.setInt(2, offset);
            ps.setInt(3, limit);
            ResultSet rs = ps.executeQuery();

            List<ContentVO> results = new ArrayList<ContentVO>();

            while (rs.next()) {
                ContentVO contentVO = new ContentVO();

                contentVO.setContentId(rs.getInt(1));

                int userId = rs.getInt(2);
                UserVO userVO = new UserVO();
                userVO.setUserId(userId);
                contentVO.setUser(userVO);

                contentVO.setTitle(rs.getString(3));
                contentVO.setContent(rs.getString(4));
                contentVO.setPicUrls(PicsUtil.getPics(rs.getString(5)));
                contentVO.setPraiseCount(rs.getInt(6));
                contentVO.setCommentsCount(rs.getInt(7));
                contentVO.setTypeMain(rs.getInt(10));
                contentVO.setTypeSub(rs.getInt(11));
                contentVO.setCreateAt(TimeUtil.getDate(rs.getLong(12)));
                contentVO.setLastModified(TimeUtil.getDate(rs.getLong(13)));

                results.add(contentVO);
            }

            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<ContentVO>();
    }

    public int getContentsCount(int typeMain, int typeSub) {
        Connection co = DataSourceUtil.getConnection();

        try {
            PreparedStatement ps = co.prepareStatement(SQL_COUNT_CONTENTS);
            ps.setInt(1, typeMain);
            ps.setInt(2, typeSub);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int contentsCount = rs.getInt(1);

                return contentsCount;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int getContentsCountByTypeMain(int typeMain) {
        Connection co = DataSourceUtil.getConnection();

        try {
            PreparedStatement ps = co.prepareStatement(SQL_COUNT_CONTENTS_BY_TYPE_MAIN);
            ps.setInt(1, typeMain);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int contentsCount = rs.getInt(1);

                return contentsCount;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public boolean createContent(ContentVO contentVO) {
        Connection co = DataSourceUtil.getConnection();

        try {
            PreparedStatement ps = co.prepareStatement(SQL_INSERT_CONTENT);
            ps.setInt(1, contentVO.getUser().getUserId());
            ps.setString(2, contentVO.getTitle());
            ps.setString(3, contentVO.getContent());
            ps.setString(4, PicsUtil.getPics(contentVO.getPicUrls()));
            ps.setInt(5, 0);
            ps.setInt(6, 0);
            ps.setInt(7, 0);
            ps.setInt(8, 0);
            ps.setInt(9, contentVO.getTypeMain());
            ps.setInt(10, contentVO.getTypeSub());
            ps.setLong(11, System.currentTimeMillis()/1000);
            ps.setLong(12, System.currentTimeMillis()/1000);
            ps.setInt(13, 1);

            boolean rs = ps.execute();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean praiseContent(int contentId) {
        Connection co = DataSourceUtil.getConnection();

        try {
            PreparedStatement ps = co.prepareStatement(SQL_PRAISE_CONTENT);
            ps.setInt(1, contentId);

            boolean rs = ps.execute();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean commentContent(int contentId) {
        Connection co = DataSourceUtil.getConnection();

        try {
            PreparedStatement ps = co.prepareStatement(SQL_COMMENT_CONTENT);
            ps.setInt(1, contentId);

            boolean rs = ps.execute();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
