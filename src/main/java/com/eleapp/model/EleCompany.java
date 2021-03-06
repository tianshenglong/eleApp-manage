package com.eleapp.model;

import java.util.Date;

public class EleCompany {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.compName
     *
     * @mbggenerated
     */
    private String compName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.province
     *
     * @mbggenerated
     */
    private Integer province;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.city
     *
     * @mbggenerated
     */
    private Integer city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.postCode
     *
     * @mbggenerated
     */
    private String postCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.compEmail
     *
     * @mbggenerated
     */
    private String compEmail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.compMobile
     *
     * @mbggenerated
     */
    private String compMobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.chatTool
     *
     * @mbggenerated
     */
    private Integer chatTool;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.chatNum
     *
     * @mbggenerated
     */
    private String chatNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.webSite
     *
     * @mbggenerated
     */
    private String webSite;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.urgentMan
     *
     * @mbggenerated
     */
    private String urgentMan;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.urgentMobile
     *
     * @mbggenerated
     */
    private String urgentMobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.auditor
     *
     * @mbggenerated
     */
    private Integer auditor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.auditTime
     *
     * @mbggenerated
     */
    private Date auditTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.createTime
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_company.isDel
     *
     * @mbggenerated
     */
    private Integer isDel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.id
     *
     * @return the value of ele_company.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.id
     *
     * @param id the value for ele_company.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.compName
     *
     * @return the value of ele_company.compName
     *
     * @mbggenerated
     */
    public String getCompName() {
        return compName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.compName
     *
     * @param compName the value for ele_company.compName
     *
     * @mbggenerated
     */
    public void setCompName(String compName) {
        this.compName = compName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.province
     *
     * @return the value of ele_company.province
     *
     * @mbggenerated
     */
    public Integer getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.province
     *
     * @param province the value for ele_company.province
     *
     * @mbggenerated
     */
    public void setProvince(Integer province) {
        this.province = province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.city
     *
     * @return the value of ele_company.city
     *
     * @mbggenerated
     */
    public Integer getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.city
     *
     * @param city the value for ele_company.city
     *
     * @mbggenerated
     */
    public void setCity(Integer city) {
        this.city = city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.address
     *
     * @return the value of ele_company.address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.address
     *
     * @param address the value for ele_company.address
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.postCode
     *
     * @return the value of ele_company.postCode
     *
     * @mbggenerated
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.postCode
     *
     * @param postCode the value for ele_company.postCode
     *
     * @mbggenerated
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.compEmail
     *
     * @return the value of ele_company.compEmail
     *
     * @mbggenerated
     */
    public String getCompEmail() {
        return compEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.compEmail
     *
     * @param compEmail the value for ele_company.compEmail
     *
     * @mbggenerated
     */
    public void setCompEmail(String compEmail) {
        this.compEmail = compEmail == null ? null : compEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.compMobile
     *
     * @return the value of ele_company.compMobile
     *
     * @mbggenerated
     */
    public String getCompMobile() {
        return compMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.compMobile
     *
     * @param compMobile the value for ele_company.compMobile
     *
     * @mbggenerated
     */
    public void setCompMobile(String compMobile) {
        this.compMobile = compMobile == null ? null : compMobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.chatTool
     *
     * @return the value of ele_company.chatTool
     *
     * @mbggenerated
     */
    public Integer getChatTool() {
        return chatTool;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.chatTool
     *
     * @param chatTool the value for ele_company.chatTool
     *
     * @mbggenerated
     */
    public void setChatTool(Integer chatTool) {
        this.chatTool = chatTool;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.chatNum
     *
     * @return the value of ele_company.chatNum
     *
     * @mbggenerated
     */
    public String getChatNum() {
        return chatNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.chatNum
     *
     * @param chatNum the value for ele_company.chatNum
     *
     * @mbggenerated
     */
    public void setChatNum(String chatNum) {
        this.chatNum = chatNum == null ? null : chatNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.webSite
     *
     * @return the value of ele_company.webSite
     *
     * @mbggenerated
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.webSite
     *
     * @param webSite the value for ele_company.webSite
     *
     * @mbggenerated
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite == null ? null : webSite.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.urgentMan
     *
     * @return the value of ele_company.urgentMan
     *
     * @mbggenerated
     */
    public String getUrgentMan() {
        return urgentMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.urgentMan
     *
     * @param urgentMan the value for ele_company.urgentMan
     *
     * @mbggenerated
     */
    public void setUrgentMan(String urgentMan) {
        this.urgentMan = urgentMan == null ? null : urgentMan.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.urgentMobile
     *
     * @return the value of ele_company.urgentMobile
     *
     * @mbggenerated
     */
    public String getUrgentMobile() {
        return urgentMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.urgentMobile
     *
     * @param urgentMobile the value for ele_company.urgentMobile
     *
     * @mbggenerated
     */
    public void setUrgentMobile(String urgentMobile) {
        this.urgentMobile = urgentMobile == null ? null : urgentMobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.status
     *
     * @return the value of ele_company.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.status
     *
     * @param status the value for ele_company.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.auditor
     *
     * @return the value of ele_company.auditor
     *
     * @mbggenerated
     */
    public Integer getAuditor() {
        return auditor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.auditor
     *
     * @param auditor the value for ele_company.auditor
     *
     * @mbggenerated
     */
    public void setAuditor(Integer auditor) {
        this.auditor = auditor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.auditTime
     *
     * @return the value of ele_company.auditTime
     *
     * @mbggenerated
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.auditTime
     *
     * @param auditTime the value for ele_company.auditTime
     *
     * @mbggenerated
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.createTime
     *
     * @return the value of ele_company.createTime
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.createTime
     *
     * @param createTime the value for ele_company.createTime
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_company.isDel
     *
     * @return the value of ele_company.isDel
     *
     * @mbggenerated
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_company.isDel
     *
     * @param isDel the value for ele_company.isDel
     *
     * @mbggenerated
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}