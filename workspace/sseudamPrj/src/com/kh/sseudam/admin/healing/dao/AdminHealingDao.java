package com.kh.sseudam.admin.healing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.healing.vo.HealingVo;

import oracle.jdbc.proxy.annotation.Pre;

public class AdminHealingDao {

    private String andDel = " AND DELETE_YN = ";
    private String ac = " C_NUM = ";
    private String anl = "AND NAME LIKE ";
    private String atl = "AND TITLE LIKE ";
    
    //냠냠 리스트 갯수
    public int NyamListCount(Connection conn, int tNum, int sNo, String search) {
        
        String yn = "";       
        
        if(sNo == 1) { yn = ""; andDel = "";}
        else if(sNo == 2) {yn = "'N'";}
        else {yn = "'Y'";}
        
        if(search.equals("")) {anl = "";}
        else {search = "'%"+search+"%'";}

        String sql = "SELECT COUNT(*) AS CNT FROM EAT_ALONE WHERE " + ac + tNum + andDel + yn +anl +search;
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

    //냠냠 리스트
    public List<HealingVo> NyamDefaultList(Connection conn, PageVo pv, int sNo, int tNum, String search) {
        
        String yn = "";
        
        if(sNo == 1) {yn = "";andDel = "";}
        else if(sNo == 2) {yn = "'N'";}
        else {yn = "'Y'"; }
        
        if(search.equals("")) {anl = "";}
        else {search = "'%"+search+"%'";}

        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
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
                + "                ,DELETE_YN\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM EAT_ALONE\r\n"
                + "            LEFT OUTER JOIN EAT_LIKE ON NO = EAT_ALONE_NO\r\n"
                + "            WHERE"+ ac + tNum + andDel + yn + anl + search+ "\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                NAME,  \r\n"
                + "                ADDRESS,\r\n"
                + "                PHONE,\r\n"
                + "                LINK, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE,\r\n"
                + "                DELETE_YN\r\n"
                + "            ORDER BY NO DESC\r\n"
                + "            ) T\r\n"
                + "    )\r\n"
                + "WHERE RNUM BETWEEN ? AND ?\r\n";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            
            
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
                String deleteYn = rs.getString("DELETE_YN");
                String liked = rs.getString("LIKED");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                vo.setcNum(cNum);                                                        
                vo.setTitle(title);

                if(infoA == null) {vo.setInfoA("-");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("-");}
                else{vo.setInfoB(infoB);}
                
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setDeleteYn(deleteYn);
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

    //냠냠 인서트
    public int InsertNyamOne(Connection conn, HealingVo vo) {
        
        String sql = "INSERT INTO EAT_ALONE\r\n"
                + "( \r\n"
                + "    NO ,\r\n"
                + "    C_NUM ,\r\n"
                + "    NAME ,\r\n"
                + "    ADDRESS ,\r\n"
                + "    PHONE ,\r\n"
                + "    IMG_PATH ,\r\n"
                + "    LINK \r\n"
                + ") \r\n"
                + "VALUES ( \r\n"
                + "    SEQ_EAT_ALONE_NO.NEXTVAL ,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?\r\n"
                + ")";
        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1,vo.getcNum() );
            pstmt.setString(2,vo.getTitle() );
            pstmt.setString(3,vo.getInfoA() );
            pstmt.setString(4,vo.getInfoB() );
            pstmt.setString(5,vo.getImgPath() );
            pstmt.setString(6,vo.getLink() );
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    //냠냠 수정할 때 가져오기
    public HealingVo SelectNyamOne(Connection conn, String no) {
        
        String sql = "SELECT * FROM EAT_ALONE\r\n"
                + "WHERE NO = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        HealingVo vo = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, no);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                String cNum = rs.getString("C_NUM");
                String title = rs.getString("NAME");
                String infoA = rs.getString("ADDRESS");
                String infoB = rs.getString("PHONE");
                String link = rs.getString("LINK");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String deleteYn = rs.getString("DELETE_YN");
                
                vo = new HealingVo();
                
                vo.setNo(no);                
                vo.setcNum(cNum);                                                        
                vo.setTitle(title);
                vo.setInfoA(infoA);
                vo.setInfoB(infoB);               
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setDeleteYn(deleteYn);          

            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        
        
        return vo;
    }

    //냠냠 수정 업데이트
    public int UpdateNyamOne(Connection conn, HealingVo vo) {
        
        String sql = "UPDATE EAT_ALONE\r\n"
                + "SET\r\n"
                + "    C_NUM = ?\r\n"
                + "    ,NAME = ?\r\n"
                + "    ,ADDRESS = ?\r\n"
                + "    ,PHONE = ?\r\n"
                + "    ,LINK = ?\r\n"
                + "    ,IMG_PATH = ?\r\n"
                + "    ,DELETE_YN = ?\r\n"
                + "    ,WRITE_DATE = ?\r\n"
                + "WHERE\r\n"
                + "NO = ?";
        
        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, vo.getcNum());
            pstmt.setString(2, vo.getTitle());
            pstmt.setString(3, vo.getInfoA());
            pstmt.setString(4, vo.getInfoB());
            pstmt.setString(5, vo.getLink());
            pstmt.setString(6, vo.getImgPath());
            pstmt.setString(7, vo.getDeleteYn());
            pstmt.setString(8, vo.getWriteDate());
            pstmt.setString(9, vo.getNo());
            
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    //냠냠 데이터 삭제
    public int DeleteNyamOne(Connection conn, String no) {
        
        String sql = "DELETE FROM EAT_ALONE\r\n"
                + "WHERE\r\n"
                + "NO = ?";
        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1,no);
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }
//--------------------------------------------------------------------------------------------
    //뒹굴뒹굴
//--------------------------------------------------------------------------------------------

    //뒹굴 리스트 수
    public int InsideListCount(Connection conn, int tNum, int sNo, String search) {
        String yn = "";       
        
        if(sNo == 1) { yn = ""; andDel = "";}
        else if(sNo == 2) {yn = "'N'";}
        else {yn = "'Y'";}
        
        if(search.equals("")) {atl = "";}
        else {search = "'%"+search+"%'";}

        String sql = "SELECT COUNT(*) AS CNT FROM INSIDE WHERE " + ac + tNum + andDel + yn +atl +search;
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

  //뒹굴 리스트 페이지
    public List<HealingVo> InsideDefaultList(Connection conn, PageVo pv, int sNo, int tNum, String search) {
        String yn = "";
        
        if(sNo == 1) {yn = "";andDel = "";}
        else if(sNo == 2) {yn = "'N'";}
        else {yn = "'Y'"; }
        
        if(search.equals("")) {atl = "";}
        else {search = "'%"+search+"%'";}

        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,C_NUM\r\n"
                + "                ,TITLE\r\n"
                + "                ,INFO_A\r\n"
                + "                ,INFO_B\r\n"
                + "                ,LINK\r\n"
                + "                ,STRESS\r\n"
                + "                ,IMG_PATH\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "                ,DELETE_YN\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM INSIDE\r\n"
                + "            LEFT OUTER JOIN INSIDE_LIKE ON NO = INSIDE_NO\r\n"
                + "            WHERE"+ ac + tNum + andDel + yn + atl + search+ "\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                TITLE,  \r\n"
                + "                INFO_A,\r\n"
                + "                INFO_B,\r\n"
                + "                LINK, \r\n"
                + "                STRESS, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE,\r\n"
                + "                DELETE_YN\r\n"
                + "            ORDER BY NO DESC\r\n"
                + "            ) T\r\n"
                + "    )\r\n"
                + "WHERE RNUM BETWEEN ? AND ?\r\n";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String cNum = rs.getString("C_NUM");
                String infoA = rs.getString("INFO_A");
                String infoB = rs.getString("INFO_B");
                String link = rs.getString("LINK");
                String stress = rs.getString("STRESS");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String deleteYn = rs.getString("DELETE_YN");
                String liked = rs.getString("LIKED");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                vo.setcNum(cNum);                                                        
                vo.setTitle(title);
                
                System.out.println(infoA);
                System.out.println(infoB);

                if(infoA == null) {vo.setInfoA("");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("");}
                else{vo.setInfoB(infoB);}
                
                vo.setLink(link);
                vo.setStress(stress);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setDeleteYn(deleteYn);
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

    public HealingVo SelectInsideOne(Connection conn, String no) {
        
        String sql = "SELECT * FROM INSIDE\r\n"
                + "WHERE NO = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        HealingVo vo = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, no);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                String cNum = rs.getString("C_NUM");
                String title = rs.getString("TITLE");
                String infoA = rs.getString("INFO_A");
                String infoB = rs.getString("INFO_B");
                String link = rs.getString("LINK");
                String stress = rs.getString("STRESS");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String deleteYn = rs.getString("DELETE_YN");
                
                vo = new HealingVo();
                
                vo.setNo(no);                
                vo.setcNum(cNum);                                                        
                vo.setTitle(title);
                vo.setInfoA(infoA);
                vo.setInfoB(infoB);
                vo.setStress(stress);
                vo.setLink(link);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setDeleteYn(deleteYn);          

            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        
        
        return vo;
    }

    public int UpdateInsideOne(Connection conn, HealingVo vo) {
        
        String sql = "UPDATE INSIDE\r\n"
                + "SET\r\n"
                + "    C_NUM = ?\r\n"
                + "    ,TITLE = ?\r\n"
                + "    ,INFO_A = ?\r\n"
                + "    ,INFO_B = ?\r\n"
                + "    ,LINK = ?\r\n"
                + "    ,IMG_PATH = ?\r\n"
                + "    ,DELETE_YN = ?\r\n"
                + "    ,WRITE_DATE = ?\r\n"
                + "    ,STRESS = ?\r\n"
                + "WHERE\r\n"
                + "NO = ?";
        
        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, vo.getcNum());
            pstmt.setString(2, vo.getTitle());
            pstmt.setString(3, vo.getInfoA());
            pstmt.setString(4, vo.getInfoB());
            pstmt.setString(5, vo.getLink());
            pstmt.setString(6, vo.getImgPath());
            pstmt.setString(7, vo.getDeleteYn());
            pstmt.setString(8, vo.getWriteDate());
            pstmt.setString(9, vo.getStress());
            pstmt.setString(10, vo.getNo());
            
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int InsertInsideOne(Connection conn, HealingVo vo) {
        String sql = "INSERT INTO INSIDE\r\n"
                + "( \r\n"
                + "    NO ,\r\n"
                + "    C_NUM ,\r\n"
                + "    TITLE ,\r\n"
                + "    INFO_A ,\r\n"
                + "    INFO_B ,\r\n"
                + "    IMG_PATH ,\r\n"
                + "    LINK, \r\n"
                + "    STRESS\r\n"
                + ") \r\n"
                + "VALUES ( \r\n"
                + "    SEQ_INSIDE_NO.NEXTVAL ,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?\r\n"
                + ")";
        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1,vo.getcNum() );
            pstmt.setString(2,vo.getTitle() );
            pstmt.setString(3,vo.getInfoA() );
            pstmt.setString(4,vo.getInfoB() );
            pstmt.setString(5,vo.getImgPath() );
            pstmt.setString(6,vo.getLink() );
            pstmt.setString(7,vo.getStress() );
            
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int DeleteInsideOne(Connection conn, String no) {
        
        String sql = "DELETE FROM INSIDE\r\n"
                + "WHERE\r\n"
                + "NO = ?";
        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1,no);
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

//--------------------------------------------------------------------------------------------
    //뚜벅뚜벅
//--------------------------------------------------------------------------------------------
    
    public int OutsideListCount(Connection conn, int tNum, int sNo, String search) {
        String yn = "";       
        
        if(sNo == 1) { yn = ""; andDel = "";}
        else if(sNo == 2) {yn = "'N'";}
        else {yn = "'Y'";}
        
        if(search.equals("")) {atl = "";}
        else {search = "'%"+search+"%'";}

        String sql = "SELECT COUNT(*) AS CNT FROM OUTSIDE WHERE " + ac + tNum + andDel + yn +atl +search;
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

    public List<HealingVo> OutsideDefaultList(Connection conn, PageVo pv, int sNo, int tNum, String search) {
        String yn = "";
        
        if(sNo == 1) {yn = "";andDel = "";}
        else if(sNo == 2) {yn = "'N'";}
        else {yn = "'Y'"; }
        
        if(search.equals("")) {atl = "";}
        else {search = "'%"+search+"%'";}

        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,C_NUM\r\n"
                + "                ,TITLE\r\n"
                + "                ,PERIOD\r\n"
                + "                ,ADDRESS\r\n"
                + "                ,PHONE\r\n"
                + "                ,LINK\r\n"
                + "                ,STRESS\r\n"
                + "                ,IMG_PATH\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "                ,DELETE_YN\r\n"
                + "                ,NVL(COUNT(MEMBER_NO),0) AS LIKED\r\n"
                + "            FROM OUTSIDE\r\n"
                + "            LEFT OUTER JOIN OUTSIDE_LIKE ON NO = OUTSIDE_NO\r\n"
                + "            WHERE"+ ac + tNum + andDel + yn + atl + search+ "\r\n"
                + "            GROUP BY \r\n"
                + "                NO,\r\n"
                + "                C_NUM,\r\n"
                + "                TITLE,  \r\n"
                + "                PERIOD,\r\n"
                + "                ADDRESS,\r\n"
                + "                PHONE,\r\n"
                + "                LINK, \r\n"
                + "                STRESS, \r\n"
                + "                IMG_PATH,\r\n"
                + "                WRITE_DATE, \r\n"
                + "                MODIFY_DATE,\r\n"
                + "                DELETE_YN\r\n"
                + "            ORDER BY NO DESC\r\n"
                + "            ) T\r\n"
                + "    )\r\n"
                + "WHERE RNUM BETWEEN ? AND ?\r\n";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String cNum = rs.getString("C_NUM");
                String infoA = rs.getString("PERIOD");
                String infoB = rs.getString("ADDRESS");
                String infoC = rs.getString("PHONE");
                String link = rs.getString("LINK");
                String stress = rs.getString("STRESS");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String deleteYn = rs.getString("DELETE_YN");
                String liked = rs.getString("LIKED");

                HealingVo vo = new HealingVo();
                vo.setNo(no);                
                vo.setcNum(cNum);                                                        
                vo.setTitle(title);

                if(infoA == null) {vo.setInfoA("-");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("-");}
                else{vo.setInfoB(infoB);}
                
                if(infoC == null) {vo.setInfoC("-");}
                else{vo.setInfoC(infoC);}
                
                vo.setLink(link);
                vo.setStress(stress);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setDeleteYn(deleteYn);
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

    public int InsertOutsideOne(Connection conn, HealingVo vo) {
        String sql = "INSERT INTO OUTSIDE\r\n"
                + "( \r\n"
                + "    NO ,\r\n"
                + "    C_NUM ,\r\n"
                + "    TITLE ,\r\n"
                + "    PERIOD ,\r\n"
                + "    ADDRESS ,\r\n"
                + "    PHONE ,\r\n"
                + "    IMG_PATH ,\r\n"
                + "    LINK, \r\n"
                + "    STRESS\r\n"
                + ") \r\n"
                + "VALUES ( \r\n"
                + "    SEQ_OUTSIDE_NO.NEXTVAL ,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?,\r\n"
                + "    ?\r\n"
                + ")";
        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1,vo.getcNum() );
            pstmt.setString(2,vo.getTitle() );
            pstmt.setString(3,vo.getInfoA() );
            pstmt.setString(4,vo.getInfoB() );
            pstmt.setString(5,vo.getInfoC() );
            pstmt.setString(6,vo.getImgPath() );
            pstmt.setString(7,vo.getLink() );
            pstmt.setString(8,vo.getStress() );
            
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public HealingVo SelectOutsideOne(Connection conn, String no) {
        String sql = "SELECT * FROM OUTSIDE\r\n"
                + "WHERE NO = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        HealingVo vo = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, no);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                String cNum = rs.getString("C_NUM");
                String title = rs.getString("TITLE");
                String infoA = rs.getString("PERIOD");
                String infoB = rs.getString("ADDRESS");
                String infoC = rs.getString("PHONE");
                String link = rs.getString("LINK");
                String stress = rs.getString("STRESS");
                String imgPath = rs.getString("IMG_PATH");
                String writeDate = rs.getString("WRITE_DATE");
                String modifyDate = rs.getString("MODIFY_DATE");
                String deleteYn = rs.getString("DELETE_YN");
                
                vo = new HealingVo();
                
                vo.setNo(no);                
                vo.setcNum(cNum);                                                        
                vo.setTitle(title);
                vo.setInfoA(infoA);
                vo.setInfoB(infoB);               
                vo.setInfoB(infoC);               
                vo.setLink(link);
                vo.setStress(stress);
                vo.setImgPath(imgPath);
                vo.setWriteDate(writeDate);
                vo.setModifyDate(modifyDate);
                vo.setDeleteYn(deleteYn);          

            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        
        
        return vo;
    }

    public int UpdateOutsideOne(Connection conn, HealingVo vo) {
        
        String sql = "UPDATE OUTSIDE\r\n"
                + "SET\r\n"
                + "    C_NUM = ?\r\n"
                + "    ,TITLE = ?\r\n"
                + "    ,PERIOD = ?\r\n"
                + "    ,ADDRESS = ?\r\n"
                + "    ,PHONE = ?\r\n"
                + "    ,LINK = ?\r\n"
                + "    ,IMG_PATH = ?\r\n"
                + "    ,DELETE_YN = ?\r\n"
                + "    ,WRITE_DATE = ?\r\n"
                + "    ,STRESS = ?\r\n"
                + "WHERE\r\n"
                + "NO = ?";
        
        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, vo.getcNum());
            pstmt.setString(2, vo.getTitle());
            pstmt.setString(3, vo.getInfoA());
            pstmt.setString(4, vo.getInfoB());
            pstmt.setString(5, vo.getInfoC());
            pstmt.setString(6, vo.getLink());
            pstmt.setString(7, vo.getImgPath());
            pstmt.setString(8, vo.getDeleteYn());
            pstmt.setString(9, vo.getWriteDate());
            pstmt.setString(10, vo.getStress());
            pstmt.setString(11, vo.getNo());
            
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int DeleteOutsideOne(Connection conn, String no) {
        
        String sql = "DELETE FROM OUTSIDE\r\n"
                + "WHERE\r\n"
                + "NO = ?";
        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1,no);
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }
}
