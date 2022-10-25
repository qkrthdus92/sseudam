package com.kh.sseudam.main.vo;

public class MainVo {
    private String no;
    private String title;
    private String imgName;
    private String imgPath;
    private String type;
    private String name;
    private String star;
    
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImgName() {
        return imgName;
    }
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
    public String getImgPath() {
        return imgPath;
    }
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStar() {
        return star;
    }
    public void setStar(String star) {
        this.star = star;
    }
    @Override
    public String toString() {
        return "MainVo [no=" + no + ", title=" + title + ", imgName=" + imgName + ", imgPath=" + imgPath + ", type="
                + type + ", name=" + name + ", star=" + star + "]";
    }
    public MainVo(String no, String title, String imgName, String imgPath, String type, String name, String star) {
        this.no = no;
        this.title = title;
        this.imgName = imgName;
        this.imgPath = imgPath;
        this.type = type;
        this.name = name;
        this.star = star;
    }
    public MainVo() {
    }
    
    
}
