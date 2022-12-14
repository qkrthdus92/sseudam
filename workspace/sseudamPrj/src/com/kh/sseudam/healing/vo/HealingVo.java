package com.kh.sseudam.healing.vo;

public class HealingVo {
    
    private String no;
    private String cNum;
    private String title;
    private String infoA;
    private String infoB;
    private String infoC;
    private String stress;
    private String link;
    private String imgPath;
    private String writeDate;
    private String modifyDate;
    private String deleteYn;
    private String liked;
    private String memberLike;
    
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getcNum() {
        return cNum;
    }
    public void setcNum(String cNum) {
        this.cNum = cNum;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getInfoA() {
        return infoA;
    }
    public void setInfoA(String infoA) {
        this.infoA = infoA;
    }
    public String getInfoB() {
        return infoB;
    }
    public void setInfoB(String infoB) {
        this.infoB = infoB;
    }
    public String getInfoC() {
        return infoC;
    }
    public void setInfoC(String infoC) {
        this.infoC = infoC;
    }
    public String getStress() {
        return stress;
    }
    public void setStress(String stress) {
        this.stress = stress;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getImgPath() {
        return imgPath;
    }
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    public String getWriteDate() {
        return writeDate;
    }
    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }
    public String getModifyDate() {
        return modifyDate;
    }
    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }
    public String getDeleteYn() {
        return deleteYn;
    }
    public void setDeleteYn(String deleteYn) {
        this.deleteYn = deleteYn;
    }
    public String getLiked() {
        return liked;
    }
    public void setLiked(String liked) {
        this.liked = liked;
    }
    public String getMemberLike() {
        return memberLike;
    }
    public void setMemberLike(String memberLike) {
        this.memberLike = memberLike;
    }
  

    @Override
    public String toString() {
        return "HealingVo [no=" + no + ", cNum=" + cNum + ", title=" + title + ", infoA=" + infoA + ", infoB=" + infoB
                + ", infoC=" + infoC + ", stress=" + stress + ", link=" + link + ", imgPath=" + imgPath + ", writeDate="
                + writeDate + ", modifyDate=" + modifyDate + ", deleteYn=" + deleteYn + ", liked=" + liked
                + ", memberLike=" + memberLike + "]";
    }
    
    
    public HealingVo(String no, String cNum, String title, String infoA, String infoB, String infoC, String stress,
            String link, String imgPath, String writeDate, String modifyDate, String deleteYn, String liked,
            String memberLike) {
        this.no = no;
        this.cNum = cNum;
        this.title = title;
        this.infoA = infoA;
        this.infoB = infoB;
        this.infoC = infoC;
        this.stress = stress;
        this.link = link;
        this.imgPath = imgPath;
        this.writeDate = writeDate;
        this.modifyDate = modifyDate;
        this.deleteYn = deleteYn;
        this.liked = liked;
        this.memberLike = memberLike;
    }
    public HealingVo() {
    }
  
    
}
