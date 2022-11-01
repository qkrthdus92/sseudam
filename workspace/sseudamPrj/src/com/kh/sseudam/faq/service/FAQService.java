package com.kh.sseudam.faq.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.faq.dao.FAQDao;
import com.kh.sseudam.faq.vo.FAQVo;

public class FAQService {

    public List<FAQVo> FAQList() {
        
        Connection conn = JDBCTemplate.getConnection();
        
        List<FAQVo> list = new FAQDao().FAQListSelect(conn);
        
        JDBCTemplate.close(conn);
        
        return list;
    }

}
