package com.kh.sseudam.healing.vo;

public class HealingVo {
    
    private String no;
    private String cNum;
    private String type;
    private String title;
    private String info1;
    private String info2;
    private String info3;
    private String stress;
    private String link;
    private String imgPath;
    private String writeDate;
    private String modifyDate;
    private String deleteYn;
    private String liked;
    
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }  
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getInfo1() {
        return info1;
    }
    public void setInfo1(String info1) {
        this.info1 = info1;
    }
    public String getInfo2() {
        return info2;
    }
    public void setInfo2(String info2) {
        this.info2 = info2;
    }
    public String getInfo3() {
        return info3;
    }
    public void setInfo3(String info3) {
        this.info3 = info3;
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
 
    @Override
    public String toString() {
        return "HealingVo [no=" + no + ", cNum=" + cNum + ", type=" + type + ", title=" + title + ", info1=" + info1
                + ", info2=" + info2 + ", info3=" + info3 + ", stress=" + stress + ", link=" + link + ", imgPath="
                + imgPath + ", writeDate=" + writeDate + ", modifyDate=" + modifyDate + ", deleteYn=" + deleteYn
                + ", liked=" + liked + "]";
    }
    
    public HealingVo(String no, String cNum, String type, String title, String info1, String info2, String info3,
            String stress, String link, String imgPath, String writeDate, String modifyDate, String deleteYn,
            String liked) {
        this.no = no;
        this.cNum = cNum;
        this.type = type;
        this.title = title;
        this.info1 = info1;
        this.info2 = info2;
        this.info3 = info3;
        this.stress = stress;
        this.link = link;
        this.imgPath = imgPath;
        this.writeDate = writeDate;
        this.modifyDate = modifyDate;
        this.deleteYn = deleteYn;
        this.liked = liked;
    }
    public HealingVo() {
    }
  
    

}
