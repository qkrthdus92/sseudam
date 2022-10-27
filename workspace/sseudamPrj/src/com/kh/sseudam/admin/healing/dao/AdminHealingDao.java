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

public class AdminHealingDao {

    private String andDel = " AND DELETE_YN = ";
    private String ac = " C_NUM = ";
    
    //냠냠 리스트 갯수
    public int NyamListCount(Connection conn, int tNum, int sNo) {
        
        String yn = "";
        
        
        if(sNo == 1) {
            yn = "";
            andDel = "";
        }else if(sNo == 2) {
            yn = "'N'";
        }else {
            yn = "'Y'";
        }

        String sql = "SELECT COUNT(*) AS CNT FROM EAT_ALONE WHERE " + ac + tNum + andDel + yn;
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

    public List<HealingVo> NyamDefaultList(Connection conn, PageVo pv, int sNo, int tNum) {
        
        String yn = "";
        
        if(sNo == 1) {
            yn = "";
            andDel = "";
        }else if(sNo == 2) {
            yn = "'N'";
        }else {
            yn = "'Y'";
        }

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
                + "            WHERE"+ ac + tNum + andDel + yn + "\r\n"
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

                if(infoA == null) {vo.setInfoA("");}
                else{vo.setInfoA(infoA);}
                
                if(infoB == null) {vo.setInfoB("");}
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

}
