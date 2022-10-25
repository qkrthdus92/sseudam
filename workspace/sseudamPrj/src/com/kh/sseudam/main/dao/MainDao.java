package com.kh.sseudam.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.main.vo.MainVo;

public class MainDao {

    public List<MainVo> SelectBestReview(Connection conn) {
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM      \r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                NO\r\n"
                + "                ,TITLE\r\n"
                + "                ,CHANGE_NAME\r\n"
                + "                ,FILE_PATH\r\n"
                + "            FROM REVIEW_BOARD\r\n"
                + "            JOIN REVIEW_BOARD_IMG ON NO = REVIEW_BOARD_NO\r\n"
                + "            WHERE DELETE_YN = 'N'          \r\n"
                + "            ORDER BY WRITE_DATE DESC\r\n"
                + "            ) T\r\n"
                + "    )   \r\n"
                + "WHERE RNUM BETWEEN 1 AND 10";
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<MainVo> list = new ArrayList<MainVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String title = rs.getString("TITLE");
                String imgName = rs.getString("CHANGE_NAME");
                String imgPath = rs.getString("FILE_PATH");
                
                MainVo vo = new MainVo();
                vo.setNo(no);
                vo.setTitle(title);
                vo.setImgName(imgName);
                vo.setImgPath(imgPath);
                
                list.add(vo);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(rs);
        }       
        return list;
    }

    public List<MainVo> SelectPro(Connection conn) {
        String sql = "SELECT * FROM \r\n"
                + "( \r\n"
                + "    SELECT \r\n"
                + "        ROWNUM AS RNUM      \r\n"
                + "        ,T.* FROM( \r\n"
                + "            SELECT \r\n"
                + "                M.NO\r\n"
                + "                ,CLASS AS TYPE\r\n"
                + "                ,NAME\r\n"
                + "                ,IMG\r\n"
                + "                ,ROUND(NVL(AVG(STAR),0)) AS STAR\r\n"
                + "            FROM PRO_MEMBER M \r\n"
                + "            JOIN PRO_APPOINT A ON M.NO = PRO_NO\r\n"
                + "            JOIN COUNSEL_TYPE C ON COUNSEL_TYPE_NO = C.NO\r\n"
                + "            WHERE PRO_STATUS = 'J'          \r\n"
                + "            GROUP BY \r\n"
                + "                M.NO\r\n"
                + "                ,CLASS\r\n"
                + "                ,NAME\r\n"
                + "                ,IMG\r\n"
                + "            ORDER BY STAR DESC\r\n"
                + "            ) T\r\n"
                + "    )   \r\n"
                + "WHERE RNUM BETWEEN 1 AND 10";
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<MainVo> list = new ArrayList<MainVo>();
        
        try {
            pstmt = conn.prepareStatement(sql);           
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                String no = rs.getString("NO");
                String type = rs.getString("TYPE");
                String name = rs.getString("NAME");
                String imgName = rs.getString("IMG");
                String star = rs.getString("STAR");
                
                MainVo vo = new MainVo();
                vo.setNo(no);
                vo.setType(type);
                vo.setName(name);
                vo.setImgName(imgName);
                vo.setStar(star);
                
                list.add(vo);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(rs);
        }       
        return list;

    }

}
