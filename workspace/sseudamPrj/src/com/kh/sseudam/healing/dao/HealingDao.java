package com.kh.sseudam.healing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.healing.vo.HealingVo;

public class HealingDao {

    public List<HealingVo> InsideMusic(Connection conn) {
        
        String sql = "SELECT \r\n"
                + "    NO\r\n"
                + "    ,TITLE\r\n"
                + "    ,ARTIST\r\n"
                + "    ,GENRE\r\n"
                + "    ,STRESS\r\n"
                + "    ,LINK\r\n"
                + "    ,IMG_PATH\r\n"
                + "    ,WRITE_DATE\r\n"
                + "    ,MODIFY_DATE\r\n"
                + "    ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "FROM MUSIC\r\n"
                + "LEFT OUTER JOIN MUSIC_LIKE ON NO = MUSIC_NO \r\n"
                + "WHERE DELETE_YN = 'N'\r\n"
                + "GROUP BY \r\n"
                + "    NO\r\n"
                + "    , TITLE\r\n"
                + "    , ARTIST\r\n"
                + "    , GENRE\r\n"
                + "    , STRESS\r\n"
                + "    , LINK\r\n"
                + "    , IMG_PATH\r\n"
                + "    , WRITE_DATE\r\n"
                + "    , MODIFY_DATE";
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String info1 = rs.getString("ARTIST");
                String info2 = rs.getString("GENRE");
                String stress = rs.getString("STRESS");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");

                HealingVo vo = new HealingVo();
                vo.setNo(no);
                vo.setType("음악");
                vo.setTitle(title);
                vo.setInfo1(info1);
                vo.setInfo2(info2);
                vo.setStress(stress);
                vo.setLink(link);
                vo.setImgPath("music/"+imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                
                list.add(vo);
          
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        
        
        return list;
    }

    public List<HealingVo> InsideMovie(Connection conn) {

        String sql = "SELECT \r\n"
                + "    NO\r\n"
                + "    ,TITLE\r\n"
                + "    ,ACTOR\r\n"
                + "    ,STRESS\r\n"
                + "    ,LINK\r\n"
                + "    ,IMG_PATH\r\n"
                + "    ,WRITE_DATE\r\n"
                + "    ,MODIFY_DATE\r\n"
                + "    ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "FROM MOVIE\r\n"
                + "LEFT OUTER JOIN MOVIE_LIKE ON NO = MOVIE_NO \r\n"
                + "WHERE DELETE_YN = 'N'\r\n"
                + "GROUP BY \r\n"
                + "    NO\r\n"
                + "    , TITLE\r\n"
                + "    , ACTOR\r\n"
                + "    , STRESS\r\n"
                + "    , LINK\r\n"
                + "    , IMG_PATH\r\n"
                + "    , WRITE_DATE\r\n"
                + "    , MODIFY_DATE";
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String info1 = rs.getString("ACTOR");
                String stress = rs.getString("STRESS");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");

                HealingVo vo = new HealingVo();
                vo.setNo(no);
                vo.setType("영화");
                vo.setTitle(title);
                vo.setInfo1(info1);
                vo.setInfo2("-");
                vo.setStress(stress);
                vo.setLink(link);
                vo.setImgPath("movie/"+imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                
                list.add(vo);
          
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        
        
        return list;

    }

    public List<HealingVo> InsideTherapy(Connection conn) {
       
        String sql = "SELECT \r\n"
                + "    NO\r\n"
                + "    ,TITLE\r\n"
                + "    ,STRESS\r\n"
                + "    ,LINK\r\n"
                + "    ,IMG_PATH\r\n"
                + "    ,WRITE_DATE\r\n"
                + "    ,MODIFY_DATE\r\n"
                + "    ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "FROM THERAPY\r\n"
                + "LEFT OUTER JOIN THERAPY_LIKE ON NO = THERAPY_NO \r\n"
                + "WHERE DELETE_YN = 'N'\r\n"
                + "GROUP BY \r\n"
                + "    NO\r\n"
                + "    , TITLE\r\n"
                + "    , STRESS\r\n"
                + "    , LINK\r\n"
                + "    , IMG_PATH\r\n"
                + "    , WRITE_DATE\r\n"
                + "    , MODIFY_DATE";
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String stress = rs.getString("STRESS");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");

                HealingVo vo = new HealingVo();
                vo.setNo(no);
                vo.setType("명상");
                vo.setTitle("명상");
                vo.setInfo1("-");
                vo.setInfo2(title);
                vo.setStress(stress);
                vo.setLink(link);
                vo.setImgPath("therapy/"+imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                
                list.add(vo);
          
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        
        
        return list;
    }

    public List<HealingVo> InsideBook(Connection conn) {
        
        String sql = "SELECT \r\n"
                + "    NO\r\n"
                + "    ,TITLE\r\n"
                + "    ,WRITER\r\n"
                + "    ,PUBLISHER\r\n"
                + "    ,STRESS\r\n"
                + "    ,LINK\r\n"
                + "    ,IMG_PATH\r\n"
                + "    ,WRITE_DATE\r\n"
                + "    ,MODIFY_DATE\r\n"
                + "    ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "FROM BOOK\r\n"
                + "LEFT OUTER JOIN BOOK_LIKE ON NO = BOOK_NO \r\n"
                + "WHERE DELETE_YN = 'N'\r\n"
                + "GROUP BY \r\n"
                + "    NO\r\n"
                + "    , TITLE\r\n"
                + "    , WRITER\r\n"
                + "    , PUBLISHER\r\n"
                + "    , STRESS\r\n"
                + "    , LINK\r\n"
                + "    , IMG_PATH\r\n"
                + "    , WRITE_DATE\r\n"
                + "    , MODIFY_DATE";
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String info1 = rs.getString("WRITER");
                String info2 = rs.getString("PUBLISHER");
                String stress = rs.getString("STRESS");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");

                HealingVo vo = new HealingVo();
                vo.setNo(no);
                vo.setType("책");
                vo.setTitle(title);
                vo.setInfo1(info1);
                vo.setInfo2(info2);
                vo.setStress(stress);
                vo.setLink(link);
                vo.setImgPath("book/"+imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                
                list.add(vo);
          
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        
        
        return list;      
    }

}
