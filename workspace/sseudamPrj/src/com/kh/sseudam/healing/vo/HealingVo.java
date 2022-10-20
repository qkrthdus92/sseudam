package com.kh.sseudam.healing.vo;

public class HealingVo {
    
    private String no;
    private String cNum;
    private String name;
    private String date;
    private String title;
    private String writer;
    private String publisher;
    private String actor;
    private String artist;
    private String genre;
    private String address;
    private String phone;
    private String stress;
    private String link;
    private String imgPath;
    private String writeDate;
    private String modifyDate;
    private String deleteYn;
    private String liked;
    
    
    public String getLiked() {
        return liked;
    }
    public void setLiked(String liked) {
        this.liked = liked;
    }
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getActor() {
        return actor;
    }
    public void setActor(String actor) {
        this.actor = actor;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    @Override
    public String toString() {
        return "HealingVo [no=" + no + ", cNum=" + cNum + ", name=" + name + ", date=" + date + ", title=" + title
                + ", writer=" + writer + ", publisher=" + publisher + ", actor=" + actor + ", artist=" + artist
                + ", genre=" + genre + ", address=" + address + ", phone=" + phone + ", stress=" + stress + ", link="
                + link + ", imgPath=" + imgPath + ", writeDate=" + writeDate + ", modifyDate=" + modifyDate
                + ", deleteYn=" + deleteYn + ", liked=" + liked + "]";
    }
    public HealingVo(String no, String cNum, String name, String date, String title, String writer, String publisher,
            String actor, String artist, String genre, String address, String phone, String stress, String link,
            String imgPath, String writeDate, String modifyDate, String deleteYn, String liked) {
        this.no = no;
        this.cNum = cNum;
        this.name = name;
        this.date = date;
        this.title = title;
        this.writer = writer;
        this.publisher = publisher;
        this.actor = actor;
        this.artist = artist;
        this.genre = genre;
        this.address = address;
        this.phone = phone;
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
