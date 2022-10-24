package com.kh.sseudam.healing.vo;

public class HealingLikeVo {

    private int likeCheck;
    private int likeCount;
    public int getLikeCheck() {
        return likeCheck;
    }
    public void setLikeCheck(int likeCheck) {
        this.likeCheck = likeCheck;
    }
    public int getLikeCount() {
        return likeCount;
    }
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
    @Override
    public String toString() {
        return "HealingLikeVo [likeCheck=" + likeCheck + ", likeCount=" + likeCount + "]";
    }
    public HealingLikeVo(int likeCheck, int likeCount) {
        super();
        this.likeCheck = likeCheck;
        this.likeCount = likeCount;
    }
    public HealingLikeVo() {
        super();
    }
    
}
