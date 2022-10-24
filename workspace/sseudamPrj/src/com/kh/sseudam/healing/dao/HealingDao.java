package com.kh.sseudam.healing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.healing.vo.HealingVo;

public class HealingDao {

    //뒹굴 페이지 갯수 조회
    public int InsideListCount(Connection conn) {

        String sql = "SELECT COUNT(*) AS CNT FROM INSIDE WHERE DELETE_YN = 'N'";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("CNT");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }              
        
        return result;
    }
    
    //뚜벅 페이지 갯수 조회
    public int OutsideListCount(Connection conn) {

        String sql = "SELECT COUNT(*) AS CNT FROM OUTSIDE WHERE DELETE_YN = 'N'";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("CNT");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }              
        
        return result;
    }
    
    //냠냠 페이지 갯수 조회
    public int NyamListCount(Connection conn) {

        String sql = "SELECT COUNT(*) AS CNT FROM EAT_ALONE WHERE DELETE_YN = 'N'";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("CNT");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }              
        
        return result;
    }
    
    //뒹굴 페이지 조회1
    public List<HealingVo> InsideDefaultList(Connection conn, PageVo pv, int mNo) {
        
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "        ,NVL2(MEMBER_NO, 1, 0) IS_LIKE        \r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,C_NUM\r\n"
                + "                ,TITLE\r\n"
                + "                ,INFO_A\r\n"
                + "                ,INFO_B\r\n"
                + "                ,STRESS\r\n"
                + "                ,LINK\r\n"
                + "                ,IMG_PATH\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM INSIDE\r\n"
                + "            LEFT OUTER JOIN INSIDE_LIKE ON NO = INSIDE_NO\r\n"
                + "            WHERE DELETE_YN = 'N'\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                TITLE, \r\n"
                + "                INFO_A, \r\n"
                + "                INFO_B, \r\n"
                + "                STRESS, \r\n"
                + "                LINK, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE\r\n"
                + "            ORDER BY WRITE_DATE DESC\r\n"
                + "            ) T\r\n"
                + "        LEFT OUTER JOIN INSIDE_LIKE L ON T.NO = L.INSIDE_NO\r\n"
                + "        WHERE L.MEMBER_NO = ? OR L.MEMBER_NO IS NULL\r\n"
                + "    )\r\n"
                + "   \r\n"
                + "WHERE RNUM BETWEEN ? AND ?";
        
        
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, mNo);
            pstmt.setInt(2, start);
            pstmt.setInt(3, end);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String cNum = rs.getString("C_NUM");
                String infoA = rs.getString("INFO_A");
                String infoB = rs.getString("INFO_B");
                String stress = rs.getString("STRESS");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");
                String memberLike = rs.getString("IS_LIKE");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                
                if(cNum.equals("4")) { vo.setcNum("음악");}
                else if(cNum.equals("5")) { vo.setcNum("영화");}
                else if(cNum.equals("6")) { vo.setcNum("명상");}               
                else  { vo.setcNum("책");}                             
                
                vo.setTitle(title);

                if(infoA == null) {vo.setInfoA("-");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("-");}
                else{vo.setInfoB(infoB);}
                
                vo.setStress(stress);
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                vo.setMemberLike(memberLike);
                
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
  //뒹굴 페이지 조회2
    public List<HealingVo> InsideLikeList(Connection conn, PageVo pv, int mNo) {
        
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "        ,NVL2(MEMBER_NO, 1, 0) IS_LIKE        \r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,C_NUM\r\n"
                + "                ,TITLE\r\n"
                + "                ,INFO_A\r\n"
                + "                ,INFO_B\r\n"
                + "                ,STRESS\r\n"
                + "                ,LINK\r\n"
                + "                ,IMG_PATH\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM INSIDE\r\n"
                + "            LEFT OUTER JOIN INSIDE_LIKE ON NO = INSIDE_NO\r\n"
                + "            WHERE DELETE_YN = 'N'\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                TITLE, \r\n"
                + "                INFO_A, \r\n"
                + "                INFO_B, \r\n"
                + "                STRESS, \r\n"
                + "                LINK, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE\r\n"
                + "            ORDER BY LIKED DESC\r\n"
                + "            ) T\r\n"
                + "        LEFT OUTER JOIN INSIDE_LIKE L ON T.NO = L.INSIDE_NO\r\n"
                + "        WHERE L.MEMBER_NO = ? OR L.MEMBER_NO IS NULL\r\n"
                + "    )\r\n"
                + "   \r\n"
                + "WHERE RNUM BETWEEN ? AND ?";
        
        
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, mNo);
            pstmt.setInt(2, start);
            pstmt.setInt(3, end);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String cNum = rs.getString("C_NUM");
                String infoA = rs.getString("INFO_A");
                String infoB = rs.getString("INFO_B");
                String stress = rs.getString("STRESS");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");
                String memberLike = rs.getString("IS_LIKE");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                
                if(cNum.equals("4")) { vo.setcNum("음악");}
                else if(cNum.equals("5")) { vo.setcNum("영화");}
                else if(cNum.equals("6")) { vo.setcNum("명상");}               
                else  { vo.setcNum("책");}                             
                
                vo.setTitle(title);

                if(infoA == null) {vo.setInfoA("-");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("-");}
                else{vo.setInfoB(infoB);}
                
                vo.setStress(stress);
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                vo.setMemberLike(memberLike);
                
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

  //뒹굴 페이지 조회3
    public List<HealingVo> InsideRandomList(Connection conn, PageVo pv, int mNo) {
        
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "        ,NVL2(MEMBER_NO, 1, 0) IS_LIKE        \r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,C_NUM\r\n"
                + "                ,TITLE\r\n"
                + "                ,INFO_A\r\n"
                + "                ,INFO_B\r\n"
                + "                ,STRESS\r\n"
                + "                ,LINK\r\n"
                + "                ,IMG_PATH\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM INSIDE\r\n"
                + "            LEFT OUTER JOIN INSIDE_LIKE ON NO = INSIDE_NO\r\n"
                + "            WHERE DELETE_YN = 'N'\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                TITLE, \r\n"
                + "                INFO_A, \r\n"
                + "                INFO_B, \r\n"
                + "                STRESS, \r\n"
                + "                LINK, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE\r\n"
                + "                order by dbms_random.value\r\n"
                + "            ) T\r\n"
                + "        LEFT OUTER JOIN INSIDE_LIKE L ON T.NO = L.INSIDE_NO\r\n"
                + "        WHERE L.MEMBER_NO = ? OR L.MEMBER_NO IS NULL\r\n"
                + "    )\r\n"
                + "   \r\n"
                + "WHERE RNUM BETWEEN ? AND ?";
        
        
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, mNo);
            pstmt.setInt(2, start);
            pstmt.setInt(3, end);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String cNum = rs.getString("C_NUM");
                String infoA = rs.getString("INFO_A");
                String infoB = rs.getString("INFO_B");
                String stress = rs.getString("STRESS");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");
                String memberLike = rs.getString("IS_LIKE");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                
                if(cNum.equals("4")) { vo.setcNum("음악");}
                else if(cNum.equals("5")) { vo.setcNum("영화");}
                else if(cNum.equals("6")) { vo.setcNum("명상");}               
                else  { vo.setcNum("책");}                             
                
                vo.setTitle(title);

                if(infoA == null) {vo.setInfoA("-");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("-");}
                else{vo.setInfoB(infoB);}
                
                vo.setStress(stress);
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                vo.setMemberLike(memberLike);
                
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

  //뒹굴 페이지 조회4
    public List<HealingVo> InsideTitleList(Connection conn, PageVo pv, int mNo) {
        
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "        ,NVL2(MEMBER_NO, 1, 0) IS_LIKE        \r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,C_NUM\r\n"
                + "                ,TITLE\r\n"
                + "                ,INFO_A\r\n"
                + "                ,INFO_B\r\n"
                + "                ,STRESS\r\n"
                + "                ,LINK\r\n"
                + "                ,IMG_PATH\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM INSIDE\r\n"
                + "            LEFT OUTER JOIN INSIDE_LIKE ON NO = INSIDE_NO\r\n"
                + "            WHERE DELETE_YN = 'N'\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                TITLE, \r\n"
                + "                INFO_A, \r\n"
                + "                INFO_B, \r\n"
                + "                STRESS, \r\n"
                + "                LINK, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE\r\n"
                + "            ORDER BY TITLE\r\n"
                + "            ) T\r\n"
                + "        LEFT OUTER JOIN INSIDE_LIKE L ON T.NO = L.INSIDE_NO\r\n"
                + "        WHERE L.MEMBER_NO = ? OR L.MEMBER_NO IS NULL\r\n"
                + "    )\r\n"
                + "   \r\n"
                + "WHERE RNUM BETWEEN ? AND ?";
        
        
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, mNo);
            pstmt.setInt(2, start);
            pstmt.setInt(3, end);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String cNum = rs.getString("C_NUM");
                String infoA = rs.getString("INFO_A");
                String infoB = rs.getString("INFO_B");
                String stress = rs.getString("STRESS");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");
                String memberLike = rs.getString("IS_LIKE");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                
                if(cNum.equals("4")) { vo.setcNum("음악");}
                else if(cNum.equals("5")) { vo.setcNum("영화");}
                else if(cNum.equals("6")) { vo.setcNum("명상");}               
                else  { vo.setcNum("책");}                             
                
                vo.setTitle(title);

                if(infoA == null) {vo.setInfoA("-");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("-");}
                else{vo.setInfoB(infoB);}
                
                vo.setStress(stress);
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                vo.setMemberLike(memberLike);
                
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
    
  //냠냠 페이지 조회1
    public List<HealingVo> NyamDefaultList(Connection conn, PageVo pv, int mNo) {
        
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "        ,NVL2(MEMBER_NO, 1, 0) IS_LIKE        \r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,C_NUM\r\n"
                + "                ,NAME\r\n"
                + "                ,ADDRESS\r\n"
                + "                ,PHONE\r\n"
                + "                ,LINK\r\n"
                + "                ,IMG_PATH\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM EAT_ALONE\r\n"
                + "            LEFT OUTER JOIN EAT_LIKE ON NO = EAT_ALONE_NO\r\n"
                + "            WHERE DELETE_YN = 'N'\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                NAME,  \r\n"
                + "                ADDRESS,\r\n"
                + "                PHONE,\r\n"
                + "                LINK, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE\r\n"
                + "            ORDER BY WRITE_DATE DESC\r\n"
                + "            ) T\r\n"
                + "        LEFT OUTER JOIN EAT_LIKE L ON T.NO = L.EAT_ALONE_NO\r\n"
                + "        WHERE L.MEMBER_NO = ? OR L.MEMBER_NO IS NULL\r\n"
                + "    )\r\n"
                + "   \r\n"
                + "WHERE RNUM BETWEEN ? AND ?";
        
        
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, mNo);
            pstmt.setInt(2, start);
            pstmt.setInt(3, end);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("NAME");
                String cNum = rs.getString("C_NUM");
                String infoA = rs.getString("ADDRESS");
                String infoB = rs.getString("PHONE");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");
                String memberLike = rs.getString("IS_LIKE");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                
                if(cNum.equals("1")) { vo.setcNum("맛집");}
                else if(cNum.equals("2")) { vo.setcNum("카페");}
                else{ vo.setcNum("술집");}               
                           
                
                vo.setTitle(title);

                if(infoA == null) {vo.setInfoA("-");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("-");}
                else{vo.setInfoB(infoB);}
                
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                vo.setMemberLike(memberLike);
                
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
  //냠냠 페이지 조회2
    public List<HealingVo> NyamLikeList(Connection conn, PageVo pv, int mNo) {
        
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "        ,NVL2(MEMBER_NO, 1, 0) IS_LIKE        \r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,C_NUM\r\n"
                + "                ,NAME\r\n"
                + "                ,ADDRESS\r\n"
                + "                ,PHONE\r\n"
                + "                ,LINK\r\n"
                + "                ,IMG_PATH\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM EAT_ALONE\r\n"
                + "            LEFT OUTER JOIN EAT_LIKE ON NO = EAT_ALONE_NO\r\n"
                + "            WHERE DELETE_YN = 'N'\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                NAME,  \r\n"
                + "                ADDRESS,\r\n"
                + "                PHONE,\r\n"
                + "                LINK, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE\r\n"
                + "            ORDER BY LIKED DESC\r\n"
                + "            ) T\r\n"
                + "        LEFT OUTER JOIN EAT_LIKE L ON T.NO = L.EAT_ALONE_NO\r\n"
                + "        WHERE L.MEMBER_NO = ? OR L.MEMBER_NO IS NULL\r\n"
                + "    )\r\n"
                + "   \r\n"
                + "WHERE RNUM BETWEEN ? AND ?";
        
        
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, mNo);
            pstmt.setInt(2, start);
            pstmt.setInt(3, end);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("NAME");
                String cNum = rs.getString("C_NUM");
                String infoA = rs.getString("ADDRESS");
                String infoB = rs.getString("PHONE");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");
                String memberLike = rs.getString("IS_LIKE");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                
                if(cNum.equals("1")) { vo.setcNum("맛집");}
                else if(cNum.equals("2")) { vo.setcNum("카페");}
                else{ vo.setcNum("술집");}               
                           
                
                vo.setTitle(title);

                if(infoA == null) {vo.setInfoA("-");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("-");}
                else{vo.setInfoB(infoB);}
                
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                vo.setMemberLike(memberLike);
                
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

  //냠냠 페이지 조회3
    public List<HealingVo> NyamRandomList(Connection conn, PageVo pv, int mNo) {
        
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "        ,NVL2(MEMBER_NO, 1, 0) IS_LIKE        \r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,C_NUM\r\n"
                + "                ,NAME\r\n"
                + "                ,ADDRESS\r\n"
                + "                ,PHONE\r\n"
                + "                ,LINK\r\n"
                + "                ,IMG_PATH\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM EAT_ALONE\r\n"
                + "            LEFT OUTER JOIN EAT_LIKE ON NO = EAT_ALONE_NO\r\n"
                + "            WHERE DELETE_YN = 'N'\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                NAME,  \r\n"
                + "                ADDRESS,\r\n"
                + "                PHONE,\r\n"
                + "                LINK, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE\r\n"
                + "            order by dbms_random.value\r\n"
                + "            ) T\r\n"
                + "        LEFT OUTER JOIN EAT_LIKE L ON T.NO = L.EAT_ALONE_NO\r\n"
                + "        WHERE L.MEMBER_NO = ? OR L.MEMBER_NO IS NULL\r\n"
                + "    )\r\n"
                + "   \r\n"
                + "WHERE RNUM BETWEEN ? AND ?";
        
        
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, mNo);
            pstmt.setInt(2, start);
            pstmt.setInt(3, end);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("NAME");
                String cNum = rs.getString("C_NUM");
                String infoA = rs.getString("ADDRESS");
                String infoB = rs.getString("PHONE");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");
                String memberLike = rs.getString("IS_LIKE");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                
                if(cNum.equals("1")) { vo.setcNum("맛집");}
                else if(cNum.equals("2")) { vo.setcNum("카페");}
                else{ vo.setcNum("술집");}               
                           
                
                vo.setTitle(title);

                if(infoA == null) {vo.setInfoA("-");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("-");}
                else{vo.setInfoB(infoB);}
                
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                vo.setMemberLike(memberLike);
                
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

  //냠냠 페이지 조회4
    public List<HealingVo> NyamTitleList(Connection conn, PageVo pv, int mNo) {
        
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "        ,NVL2(MEMBER_NO, 1, 0) IS_LIKE        \r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,C_NUM\r\n"
                + "                ,NAME\r\n"
                + "                ,ADDRESS\r\n"
                + "                ,PHONE\r\n"
                + "                ,LINK\r\n"
                + "                ,IMG_PATH\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM EAT_ALONE\r\n"
                + "            LEFT OUTER JOIN EAT_LIKE ON NO = EAT_ALONE_NO\r\n"
                + "            WHERE DELETE_YN = 'N'\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                NAME,  \r\n"
                + "                ADDRESS,\r\n"
                + "                PHONE,\r\n"
                + "                LINK, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE\r\n"
                + "            ORDER BY NAME\r\n"
                + "            ) T\r\n"
                + "        LEFT OUTER JOIN EAT_LIKE L ON T.NO = L.EAT_ALONE_NO\r\n"
                + "        WHERE L.MEMBER_NO = ? OR L.MEMBER_NO IS NULL\r\n"
                + "    )\r\n"
                + "   \r\n"
                + "WHERE RNUM BETWEEN ? AND ?";
        
        
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, mNo);
            pstmt.setInt(2, start);
            pstmt.setInt(3, end);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("NAME");
                String cNum = rs.getString("C_NUM");
                String infoA = rs.getString("ADDRESS");
                String infoB = rs.getString("PHONE");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");
                String memberLike = rs.getString("IS_LIKE");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                
                if(cNum.equals("1")) { vo.setcNum("맛집");}
                else if(cNum.equals("2")) { vo.setcNum("카페");}
                else{ vo.setcNum("술집");}               
                           
                
                vo.setTitle(title);

                if(infoA == null) {vo.setInfoA("-");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("-");}
                else{vo.setInfoB(infoB);}
                
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                vo.setMemberLike(memberLike);
                
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
  
    //뚜벅 페이지 조회 1
    public List<HealingVo> OutsideDefaultList(Connection conn, PageVo pv, int mNo) {
        
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "        ,NVL2(MEMBER_NO, 1, 0) IS_LIKE        \r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,C_NUM\r\n"
                + "                ,TITLE\r\n"
                + "                ,PERIOD\r\n"
                + "                ,ADDRESS\r\n"
                + "                ,PHONE\r\n"
                + "                ,STRESS\r\n"
                + "                ,LINK\r\n"
                + "                ,IMG_PATH\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM OUTSIDE\r\n"
                + "            LEFT OUTER JOIN OUTSIDE_LIKE ON NO = OUTSIDE_NO\r\n"
                + "            WHERE DELETE_YN = 'N'\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                TITLE, \r\n"
                + "                PERIOD, \r\n"
                + "                ADDRESS,\r\n"
                + "                PHONE,\r\n"
                + "                STRESS, \r\n"
                + "                LINK, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE\r\n"
                + "            ORDER BY WRITE_DATE DESC\r\n"
                + "            ) T\r\n"
                + "        LEFT OUTER JOIN OUTSIDE_LIKE L ON T.NO = L.OUTSIDE_NO\r\n"
                + "        WHERE L.MEMBER_NO = ? OR L.MEMBER_NO IS NULL\r\n"
                + "    )\r\n"
                + "   \r\n"
                + "WHERE RNUM BETWEEN ? AND ?";
        
        
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, mNo);
            pstmt.setInt(2, start);
            pstmt.setInt(3, end);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String cNum = rs.getString("C_NUM");
                String infoA = rs.getString("PERIOD");
                String infoB = rs.getString("ADDRESS");
                String infoC = rs.getString("PHONE");                
                String stress = rs.getString("STRESS");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");
                String memberLike = rs.getString("IS_LIKE");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                
                if(cNum.equals("8")) { vo.setcNum("문화");}
                else if(cNum.equals("9")) { vo.setcNum("산책");}
                else{ vo.setcNum("등산");}               
                            
                
                vo.setTitle(title);

                if(infoA == null) {vo.setInfoA("-");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("-");}
                else{vo.setInfoB(infoB);}
                
                if(infoC == null) {vo.setInfoC("-");}
                else{vo.setInfoC(infoC);}
                
                vo.setStress(stress);
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                vo.setMemberLike(memberLike);
                
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

    //뚜벅 페이지 조회 2
    public List<HealingVo> OutsideLikeList(Connection conn, PageVo pv, int mNo) {
        
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "        ,NVL2(MEMBER_NO, 1, 0) IS_LIKE        \r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,C_NUM\r\n"
                + "                ,TITLE\r\n"
                + "                ,PERIOD\r\n"
                + "                ,ADDRESS\r\n"
                + "                ,PHONE\r\n"
                + "                ,STRESS\r\n"
                + "                ,LINK\r\n"
                + "                ,IMG_PATH\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM OUTSIDE\r\n"
                + "            LEFT OUTER JOIN OUTSIDE_LIKE ON NO = OUTSIDE_NO\r\n"
                + "            WHERE DELETE_YN = 'N'\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                TITLE, \r\n"
                + "                PERIOD, \r\n"
                + "                ADDRESS,\r\n"
                + "                PHONE,\r\n"
                + "                STRESS, \r\n"
                + "                LINK, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE\r\n"
                + "            ORDER BY LIKED DESC\r\n"
                + "            ) T\r\n"
                + "        LEFT OUTER JOIN OUTSIDE_LIKE L ON T.NO = L.OUTSIDE_NO\r\n"
                + "        WHERE L.MEMBER_NO = ? OR L.MEMBER_NO IS NULL\r\n"
                + "    )\r\n"
                + "   \r\n"
                + "WHERE RNUM BETWEEN ? AND ?";
        
        
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, mNo);
            pstmt.setInt(2, start);
            pstmt.setInt(3, end);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String cNum = rs.getString("C_NUM");
                String infoA = rs.getString("PERIOD");
                String infoB = rs.getString("ADDRESS");
                String infoC = rs.getString("PHONE");                
                String stress = rs.getString("STRESS");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");
                String memberLike = rs.getString("IS_LIKE");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                
                if(cNum.equals("8")) { vo.setcNum("문화");}
                else if(cNum.equals("9")) { vo.setcNum("산책");}
                else{ vo.setcNum("등산");}               
                            
                
                vo.setTitle(title);

                if(infoA == null) {vo.setInfoA("-");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("-");}
                else{vo.setInfoB(infoB);}
                
                if(infoC == null) {vo.setInfoC("-");}
                else{vo.setInfoC(infoC);}
                
                vo.setStress(stress);
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                vo.setMemberLike(memberLike);
                
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

  //뚜벅 페이지 조회 3
    public List<HealingVo> OutsideRandomList(Connection conn, PageVo pv, int mNo) {
        
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "        ,NVL2(MEMBER_NO, 1, 0) IS_LIKE        \r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,C_NUM\r\n"
                + "                ,TITLE\r\n"
                + "                ,PERIOD\r\n"
                + "                ,ADDRESS\r\n"
                + "                ,PHONE\r\n"
                + "                ,STRESS\r\n"
                + "                ,LINK\r\n"
                + "                ,IMG_PATH\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM OUTSIDE\r\n"
                + "            LEFT OUTER JOIN OUTSIDE_LIKE ON NO = OUTSIDE_NO\r\n"
                + "            WHERE DELETE_YN = 'N'\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                TITLE, \r\n"
                + "                PERIOD, \r\n"
                + "                ADDRESS,\r\n"
                + "                PHONE,\r\n"
                + "                STRESS, \r\n"
                + "                LINK, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE\r\n"
                + "            order by dbms_random.value\r\n"
                + "            ) T\r\n"
                + "        LEFT OUTER JOIN OUTSIDE_LIKE L ON T.NO = L.OUTSIDE_NO\r\n"
                + "        WHERE L.MEMBER_NO = ? OR L.MEMBER_NO IS NULL\r\n"
                + "    )\r\n"
                + "   \r\n"
                + "WHERE RNUM BETWEEN ? AND ?";
        
        
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, mNo);
            pstmt.setInt(2, start);
            pstmt.setInt(3, end);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String cNum = rs.getString("C_NUM");
                String infoA = rs.getString("PERIOD");
                String infoB = rs.getString("ADDRESS");
                String infoC = rs.getString("PHONE");                
                String stress = rs.getString("STRESS");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");
                String memberLike = rs.getString("IS_LIKE");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                
                if(cNum.equals("8")) { vo.setcNum("문화");}
                else if(cNum.equals("9")) { vo.setcNum("산책");}
                else{ vo.setcNum("등산");}               
                            
                
                vo.setTitle(title);

                if(infoA == null) {vo.setInfoA("-");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("-");}
                else{vo.setInfoB(infoB);}
                
                if(infoC == null) {vo.setInfoC("-");}
                else{vo.setInfoC(infoC);}
                
                vo.setStress(stress);
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                vo.setMemberLike(memberLike);
                
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

  //뚜벅 페이지 조회 4
    public List<HealingVo> OutsideTitleList(Connection conn, PageVo pv, int mNo) {
        
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "        ,NVL2(MEMBER_NO, 1, 0) IS_LIKE        \r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,C_NUM\r\n"
                + "                ,TITLE\r\n"
                + "                ,PERIOD\r\n"
                + "                ,ADDRESS\r\n"
                + "                ,PHONE\r\n"
                + "                ,STRESS\r\n"
                + "                ,LINK\r\n"
                + "                ,IMG_PATH\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM OUTSIDE\r\n"
                + "            LEFT OUTER JOIN OUTSIDE_LIKE ON NO = OUTSIDE_NO\r\n"
                + "            WHERE DELETE_YN = 'N'\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                TITLE, \r\n"
                + "                PERIOD, \r\n"
                + "                ADDRESS,\r\n"
                + "                PHONE,\r\n"
                + "                STRESS, \r\n"
                + "                LINK, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE\r\n"
                + "            ORDER BY TITLE DESC\r\n"
                + "            ) T\r\n"
                + "        LEFT OUTER JOIN OUTSIDE_LIKE L ON T.NO = L.OUTSIDE_NO\r\n"
                + "        WHERE L.MEMBER_NO = ? OR L.MEMBER_NO IS NULL\r\n"
                + "    )\r\n"
                + "   \r\n"
                + "WHERE RNUM BETWEEN ? AND ?";
        
        
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, mNo);
            pstmt.setInt(2, start);
            pstmt.setInt(3, end);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String cNum = rs.getString("C_NUM");
                String infoA = rs.getString("PERIOD");
                String infoB = rs.getString("ADDRESS");
                String infoC = rs.getString("PHONE");                
                String stress = rs.getString("STRESS");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String liked = rs.getString("LIKED");
                String memberLike = rs.getString("IS_LIKE");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                
                if(cNum.equals("8")) { vo.setcNum("문화");}
                else if(cNum.equals("9")) { vo.setcNum("산책");}
                else{ vo.setcNum("등산");}               
                            
                
                vo.setTitle(title);

                if(infoA == null) {vo.setInfoA("-");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("-");}
                else{vo.setInfoB(infoB);}
                
                if(infoC == null) {vo.setInfoC("-");}
                else{vo.setInfoC(infoC);}
                
                vo.setStress(stress);
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setLiked(liked);
                vo.setMemberLike(memberLike);
                
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

    //뒹굴 좋아요 기능
    public int InsideLikeDelete(Connection conn, int no, int mNo) {
        
        String sql = "DELETE FROM INSIDE_LIKE\r\n"
                + "WHERE MEMBER_NO = ?\r\n"
                + "AND INSIDE_NO = ?";

        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mNo);
            pstmt.setInt(2, no);
            
            result = pstmt.executeUpdate();
         
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {            
            JDBCTemplate.close(pstmt);
        }
        return result;

    }

    public int InsideLikeUpdate(Connection conn, int no, int mNo) {

        String sql = "INSERT INTO INSIDE_LIKE\r\n"
                + "(\r\n"
                + "    MEMBER_NO\r\n"
                + "    ,INSIDE_NO\r\n"
                + ")VALUES\r\n"
                + "(\r\n"
                + "    ?\r\n"
                + "    ,?\r\n"
                + ")";

        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mNo);
            pstmt.setInt(2, no);
            
            result = pstmt.executeUpdate();
         
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {            
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int IsInsideLike(Connection conn, int no, int mNo) {
        
        String sql = "SELECT MEMBER_NO\r\n"
                + "FROM INSIDE_LIKE\r\n"
                + "WHERE MEMBER_NO = ?\r\n"
                + "AND INSIDE_NO = ?";

        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mNo);
            pstmt.setInt(2, no);
            
            result = pstmt.executeUpdate();
         
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {            
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int InsideLikeSelect(Connection conn, int no) {

        String sql = "SELECT NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "FROM INSIDE\r\n"
                + "LEFT OUTER JOIN INSIDE_LIKE ON NO = INSIDE_NO\r\n"
                + "WHERE NO = ?\r\n"
                + "GROUP BY NO";

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int liked = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                liked = rs.getInt("LIKED");
                
            }
                
         
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {            
            JDBCTemplate.close(pstmt);
        }
        return liked;
        
    } 
    
    
  //뚜벅 좋아요 기능
    public int OutsideLikeDelete(Connection conn, int no, int mNo) {
        
        String sql = "DELETE FROM OUTSIDE_LIKE\r\n"
                + "WHERE MEMBER_NO = ?\r\n"
                + "AND OUTSIDE_NO = ?";

        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mNo);
            pstmt.setInt(2, no);
            
            result = pstmt.executeUpdate();
         
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {            
            JDBCTemplate.close(pstmt);
        }
        return result;

    }

    public int OutsideLikeUpdate(Connection conn, int no, int mNo) {

        String sql = "INSERT INTO OUTSIDE_LIKE\r\n"
                + "(\r\n"
                + "    MEMBER_NO\r\n"
                + "    ,OUTSIDE_NO\r\n"
                + ")VALUES\r\n"
                + "(\r\n"
                + "    ?\r\n"
                + "    ,?\r\n"
                + ")";

        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mNo);
            pstmt.setInt(2, no);
            
            result = pstmt.executeUpdate();
         
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {            
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int IsOutsideLike(Connection conn, int no, int mNo) {
        
        String sql = "SELECT MEMBER_NO\r\n"
                + "FROM OUTSIDE_LIKE\r\n"
                + "WHERE MEMBER_NO = ?\r\n"
                + "AND OUTSIDE_NO = ?";

        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mNo);
            pstmt.setInt(2, no);
            
            result = pstmt.executeUpdate();
         
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {            
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int OutsideLikeSelect(Connection conn, int no) {

        String sql = "SELECT NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "FROM OUTSIDE\r\n"
                + "LEFT OUTER JOIN OUTSIDE_LIKE ON NO = OUTSIDE_NO\r\n"
                + "WHERE NO = ?\r\n"
                + "GROUP BY NO";

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int liked = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                liked = rs.getInt("LIKED");
                
            }
                
         
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {            
            JDBCTemplate.close(pstmt);
        }
        return liked;
        
    } 
    
    //냠냠 좋아요 기능
    public int NyamLikeDelete(Connection conn, int no, int mNo) {
        
        String sql = "DELETE FROM EAT_LIKE\r\n"
                + "WHERE MEMBER_NO = ?\r\n"
                + "AND EAT_ALONE_NO = ?";

        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mNo);
            pstmt.setInt(2, no);
            
            result = pstmt.executeUpdate();
         
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {            
            JDBCTemplate.close(pstmt);
        }
        return result;

    }

    public int NyamLikeUpdate(Connection conn, int no, int mNo) {

        String sql = "INSERT INTO EAT_LIKE\r\n"
                + "(\r\n"
                + "    MEMBER_NO\r\n"
                + "    ,EAT_ALONE_NO\r\n"
                + ")VALUES\r\n"
                + "(\r\n"
                + "    ?\r\n"
                + "    ,?\r\n"
                + ")";

        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mNo);
            pstmt.setInt(2, no);
            
            result = pstmt.executeUpdate();
         
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {            
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int IsNyamLike(Connection conn, int no, int mNo) {
        
        String sql = "SELECT MEMBER_NO\r\n"
                + "FROM EAT_LIKE\r\n"
                + "WHERE MEMBER_NO = ?\r\n"
                + "AND EAT_ALONE_NO = ?";

        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mNo);
            pstmt.setInt(2, no);
            
            result = pstmt.executeUpdate();
         
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {            
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int NyamLikeSelect(Connection conn, int no) {

        String sql = "SELECT NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "FROM EAT_ALONE\r\n"
                + "LEFT OUTER JOIN EAT_LIKE ON NO = EAT_ALONE_NO\r\n"
                + "WHERE NO = ?\r\n"
                + "GROUP BY NO";

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int liked = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                liked = rs.getInt("LIKED");               
            }
                
         
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {            
            JDBCTemplate.close(pstmt);
        }
        return liked;
        
    } 
    

}
