package com.kh.sseudam.healing.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.healing.dao.HealingDao;
import com.kh.sseudam.healing.vo.HealingLikeVo;
import com.kh.sseudam.healing.vo.HealingVo;

public class HealingService {

    private final HealingDao dao = new HealingDao();    
    
    //뒹굴 리스트 갯수
    public int selectInsideCount(String tNum) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        int count = dao.InsideListCount(conn, tNum);
        
        JDBCTemplate.close(conn);
       
        return count;
    }
    
    //뚜벅 리스트 갯수
    public int selectOutsideCount(String tNum) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        int count = dao.OutsideListCount(conn, tNum);
        
        JDBCTemplate.close(conn);
       
        return count;
    }
    
    //냠냠 리스트 갯수
    public int selectNyamCount(String tNum) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        int count = dao.NyamListCount(conn, tNum);
        
        JDBCTemplate.close(conn);
       
        return count;
    }
    
    //뒹굴 기본 페이지
    public List<HealingVo> InsidePage(PageVo pv, String sort, int mNo, String tNum){
       
        Connection conn = JDBCTemplate.getConnection();
        
        List<HealingVo> list = dao.InsideDefaultList(conn, pv, mNo, sort, tNum);

        JDBCTemplate.close(conn);

        return list;
        
    }
    //뚜벅 기본 페이지
    public List<HealingVo> OutsidePage(PageVo pv, String sort, int mNo, String tNum) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        List<HealingVo> list = dao.OutsideDefaultList(conn, pv, mNo, sort, tNum);
   
        JDBCTemplate.close(conn);

        return list;
    }
    //냠냠 기본 페이지
    public List<HealingVo> NyamPage(PageVo pv, String sort, int mNo, String tNum) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        List<HealingVo> list = dao.NyamDefaultList(conn, pv, mNo, sort, tNum);
        
        JDBCTemplate.close(conn);

        return list;
    }



    //뒹굴 좋아요 체크
    public HealingLikeVo InsideLikeCnt(int no, int mNo) {
        
        HealingLikeVo vo = new HealingLikeVo();
        Connection conn = JDBCTemplate.getConnection();
        int likeCheck = dao.IsInsideLike(conn,no,mNo);
        
        if(likeCheck == 0) {
            dao.InsideLikeUpdate(conn,no,mNo);
            int likeCount = dao.InsideLikeSelect(conn,no);
            
            vo.setLikeCheck(likeCheck);
            vo.setLikeCount(likeCount);           
            
            JDBCTemplate.close(conn);
            return vo;
        }else {
            dao.InsideLikeDelete(conn,no,mNo);
            int likeCount = dao.InsideLikeSelect(conn,no);
            
            vo.setLikeCheck(likeCheck);
            vo.setLikeCount(likeCount);           
            
            JDBCTemplate.close(conn);
            
            return vo;            
        }
        
    }
    
    //뚜벅 좋아요 체크
    public HealingLikeVo OutsideLikeCnt(int no, int mNo) {
       
        HealingLikeVo vo = new HealingLikeVo();
        Connection conn = JDBCTemplate.getConnection();
        int likeCheck = dao.IsOutsideLike(conn,no,mNo);
        
        
        if(likeCheck == 0) {
            dao.OutsideLikeUpdate(conn,no,mNo);
            int likeCount = dao.OutsideLikeSelect(conn,no);
            
            vo.setLikeCheck(likeCheck);
            vo.setLikeCount(likeCount);           
            
            JDBCTemplate.close(conn);
            return vo;
        }else {
            dao.OutsideLikeDelete(conn,no,mNo);
            int likeCount = dao.OutsideLikeSelect(conn,no);
            
            vo.setLikeCheck(likeCheck);
            vo.setLikeCount(likeCount);           
            
            JDBCTemplate.close(conn);
            
            return vo;            
        }
    }
  
    //뚜벅 좋아요 체크
    public HealingLikeVo NyamLikeCnt(int no, int mNo) {
        
        HealingLikeVo vo = new HealingLikeVo();
        Connection conn = JDBCTemplate.getConnection();
        int likeCheck = dao.IsNyamLike(conn,no,mNo);
        
        
        if(likeCheck == 0) {
            dao.NyamLikeUpdate(conn,no,mNo);
            int likeCount = dao.NyamLikeSelect(conn,no);
            
            vo.setLikeCheck(likeCheck);
            vo.setLikeCount(likeCount);           
            
            JDBCTemplate.close(conn);
            return vo;
        }else {
            dao.NyamLikeDelete(conn,no,mNo);
            int likeCount = dao.NyamLikeSelect(conn,no);
            
            vo.setLikeCheck(likeCheck);
            vo.setLikeCount(likeCount);           
            
            JDBCTemplate.close(conn);
            
            return vo;            
        }
    }

 
    
}
