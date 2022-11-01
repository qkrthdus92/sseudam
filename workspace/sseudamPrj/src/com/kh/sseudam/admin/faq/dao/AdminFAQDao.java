package com.kh.sseudam.admin.faq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.faq.vo.FAQVo;

public class AdminFAQDao {
    
    private String wtl = "WHERE TITLE LIKE ";

    public int FAQListCount(Connection conn,String search) {                      
        
        if(search.equals("")) {wtl = "";}
        else {search = "'%"+search+"%'";}
        
        String sql = "SELECT COUNT(*) AS CNT FROM FAQ " + wtl + search;
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

    public List<FAQVo> FAQDefaultList(Connection conn, PageVo pv, String search) {
        
        if(search.equals("")) {wtl = "";}
        else {search = "'%"+search+"%'";}
        
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM\r\n"
                + "            ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                F.NO\r\n"
                + "                ,ID\r\n"
                + "                ,WRITER_NO\r\n"
                + "                ,TITLE\r\n"
                + "                ,CONTENT\r\n"
                + "                ,WRITE_DATE\r\n"
                + "                ,DELETE_YN\r\n"
                + "                ,MODIFY_DATE\r\n"
                + "            FROM FAQ F\r\n"
                + "            JOIN ADMIN A ON F.WRITER_NO = A.NO\r\n "+wtl+search
                + "            ORDER BY F.NO DESC\r\n"
                + "            ) T                      \r\n"
                + "    )\r\n"
                + "WHERE RNUM BETWEEN ? AND ?";
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<FAQVo> list = new ArrayList<FAQVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
            int end = start + pv.getBoardLimit() - 1;

            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String adminId = rs.getString("ID");
                String writerNo = rs.getString("WRITER_NO");
                String title = rs.getString("TITLE");
                String content = rs.getString("CONTENT");
                String writeDate = rs.getString("WRITE_DATE");
                String deleteYn = rs.getString("DELETE_YN");
                String modifyDate = rs.getString("MODIFY_DATE");                
                
                FAQVo vo = new FAQVo();
                
                vo.setNo(no);
                vo.setAdminId(adminId);
                vo.setWriterNo(writerNo);
                vo.setTitle(title);
                vo.setContent(content);
                vo.setWriteDate(writeDate);
                vo.setDeleteYn(deleteYn);
                vo.setModifyDate(modifyDate);
                
                list.add(vo);

            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(rs);
        }
        
        
        return list;
    }

    public int InsertFAQOne(Connection conn, FAQVo vo) {
        
        String sql = "INSERT INTO FAQ\r\n"
                + "(\r\n"
                + "NO\r\n"
                + ",WRITER_NO\r\n"
                + ",TITLE\r\n"
                + ",CONTENT\r\n"
                + ")\r\n"
                + "VALUES\r\n"
                + "(\r\n"
                + "    SEQ_FAQ_NO.NEXTVAL\r\n"
                + "    ,?\r\n"
                + "    ,?\r\n"
                + "    ,?\r\n"
                + ")";
        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1,vo.getWriterNo() );
            pstmt.setString(2,vo.getTitle() );
            pstmt.setString(3,vo.getContent() );
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public FAQVo SelectFAQOne(Connection conn, String no) {

        String sql = "SELECT * \r\n"
                + "FROM FAQ F\r\n"
                + "JOIN ADMIN A ON F.WRITER_NO = A.NO\r\n"
                + "WHERE F.NO = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        FAQVo vo = null;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, no);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                String writerNo = rs.getString("WRITER_NO");
                String title = rs.getString("TITLE");
                String adminId = rs.getString("ID");
                String content = rs.getString("CONTENT");
                String writeDate = rs.getString("WRITE_DATE");
                String deleteYn = rs.getString("DELETE_YN");
                String modifyDate = rs.getString("MODIFY_DATE");                
                
                vo = new FAQVo();
                
                vo.setNo(no);
                vo.setAdminId(adminId);
                vo.setWriterNo(writerNo);
                vo.setTitle(title);
                vo.setContent(content);
                vo.setWriteDate(writeDate);
                vo.setDeleteYn(deleteYn);
                vo.setModifyDate(modifyDate);
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        return vo;
    }

    public int UpdateFAQOne(Connection conn, FAQVo vo) {
        
        String sql = "UPDATE FAQ\r\n"
                + "SET\r\n"
                + "    WRITER_NO = ?\r\n"
                + "    ,TITLE = ?\r\n"
                + "    ,CONTENT = ?\r\n"
                + "    ,WRITE_DATE = ?\r\n"
                + "    ,DELETE_YN = ?\r\n"
                + "    ,MODIFY_DATE = SYSDATE\r\n"
                + "WHERE NO = ?";
        
        PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, vo.getWriterNo());
            pstmt.setString(2, vo.getTitle());
            pstmt.setString(3, vo.getContent());
            pstmt.setString(4, vo.getWriteDate());
            pstmt.setString(5, vo.getDeleteYn());
            pstmt.setString(6, vo.getNo());
            
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int DeleteFAQOne(Connection conn, String no) {
 
        String sql = "DELETE FROM FAQ\r\n"
                + "WHERE NO = ?";
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
