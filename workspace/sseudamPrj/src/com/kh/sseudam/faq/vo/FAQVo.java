package com.kh.sseudam.faq.vo;

public class FAQVo {
    
    private String no;
    private String writerNo;
    private String adminId;
    private String title;
    private String content;
    private String writeDate;
    private String deleteYn;
    private String modifyDate;
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getWriterNo() {
        return writerNo;
    }
    public void setWriterNo(String writerNo) {
        this.writerNo = writerNo;
    }
    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWriteDate() {
        return writeDate;
    }
    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }
    public String getDeleteYn() {
        return deleteYn;
    }
    public void setDeleteYn(String deleteYn) {
        this.deleteYn = deleteYn;
    }
    public String getModifyDate() {
        return modifyDate;
    }
    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }
    @Override
    public String toString() {
        return "FAQVo [no=" + no + ", writerNo=" + writerNo + ", adminId=" + adminId + ", title=" + title + ", content="
                + content + ", writeDate=" + writeDate + ", deleteYn=" + deleteYn + ", modifyDate=" + modifyDate + "]";
    }
    public FAQVo(String no, String writerNo, String adminId, String title, String content, String writeDate,
            String deleteYn, String modifyDate) {
        super();
        this.no = no;
        this.writerNo = writerNo;
        this.adminId = adminId;
        this.title = title;
        this.content = content;
        this.writeDate = writeDate;
        this.deleteYn = deleteYn;
        this.modifyDate = modifyDate;
    }
    public FAQVo() {
        super();
    }
    
    
    
    
    
}
