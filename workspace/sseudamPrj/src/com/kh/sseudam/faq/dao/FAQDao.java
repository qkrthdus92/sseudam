package com.kh.sseudam.faq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.faq.vo.FAQVo;

public class FAQDao {

    public List<FAQVo> FAQListSelect(Connection conn) {
        
        String sql = "SELECT TITLE, CONTENT\r\n"
                + "FROM FAQ\r\n"
                + "ORDER BY WRITE_DATE";
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<FAQVo> list = new ArrayList<FAQVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String title = rs.getString("TITLE");
                String content = rs.getString("CONTENT");
                
                FAQVo vo = new FAQVo();
                vo.setTitle(title);
                vo.setContent(content);
                
                list.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        
        return list;
    }

}
