package com.kh.sseudam.healing.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.healing.dao.HealingDao;
import com.kh.sseudam.healing.vo.HealingVo;

public class HealingService {

    private final HealingDao dao = new HealingDao(); 
    
    public List<HealingVo> InsidePage(){
       
        Connection conn = JDBCTemplate.getConnection();
        
        List<HealingVo> list = new ArrayList<HealingVo>();
        
        List<HealingVo> musicList = dao.InsideMusic(conn);        
        List<HealingVo> movieList = dao.InsideMovie(conn);        
        List<HealingVo> therapyList = dao.InsideTherapy(conn);        
        List<HealingVo> bookList = dao.InsideBook(conn);      
        
        list.addAll(musicList);
        list.addAll(movieList);
        list.addAll(therapyList);
        list.addAll(bookList);
        
        Collections.shuffle(list);
        
        return list;
        
    }
}
