package com.eleapp.model;

import java.util.Date;

public class EleStudent {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_student.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_student.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_student.sertId
     *
     * @mbggenerated
     */
    private String sertId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_student.sex
     *
     * @mbggenerated
     */
    private Integer sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_student.passWord
     *
     * @mbggenerated
     */
    private String passWord;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_student.validatePwd
     *
     * @mbggenerated
     */
    private String validatePwd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_student.parentMobile
     *
     * @mbggenerated
     */
    private String parentMobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_student.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_student.birthDay
     *
     * @mbggenerated
     */
    private Date birthDay;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_student.imgUrl
     *
     * @mbggenerated
     */
    private String imgUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_student.createTime
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_student.motifyTime
     *
     * @mbggenerated
     */
    private Date motifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_student.isDel
     *
     * @mbggenerated
     */
    private Integer isDel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_student.id
     *
     * @return the value of ele_student.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_student.id
     *
     * @param id the value for ele_student.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_student.name
     *
     * @return the value of ele_student.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_student.name
     *
     * @param name the value for ele_student.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_student.sertId
     *
     * @return the value of ele_student.sertId
     *
     * @mbggenerated
     */
    public String getSertId() {
        return sertId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_student.sertId
     *
     * @param sertId the value for ele_student.sertId
     *
     * @mbggenerated
     */
    public void setSertId(String sertId) {
        this.sertId = sertId == null ? null : sertId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_student.sex
     *
     * @return the value of ele_student.sex
     *
     * @mbggenerated
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_student.sex
     *
     * @param sex the value for ele_student.sex
     *
     * @mbggenerated
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_student.passWord
     *
     * @return the value of ele_student.passWord
     *
     * @mbggenerated
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_student.passWord
     *
     * @param passWord the value for ele_student.passWord
     *
     * @mbggenerated
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_student.validatePwd
     *
     * @return the value of ele_student.validatePwd
     *
     * @mbggenerated
     */
    public String getValidatePwd() {
        return validatePwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_student.validatePwd
     *
     * @param validatePwd the value for ele_student.validatePwd
     *
     * @mbggenerated
     */
    public void setValidatePwd(String validatePwd) {
        this.validatePwd = validatePwd == null ? null : validatePwd.trim();
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_student.parentMobile
     *
     * @return the value of ele_student.parentMobile
     *
     * @mbggenerated
     */
    public String getParentMobile() {
        return parentMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_student.parentMobile
     *
     * @param parentMobile the value for ele_student.parentMobile
     *
     * @mbggenerated
     */
    public void setParentMobile(String parentMobile) {
        this.parentMobile = parentMobile == null ? null : parentMobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_student.email
     *
     * @return the value of ele_student.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_student.email
     *
     * @param email the value for ele_student.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_student.imgUrl
     *
     * @return the value of ele_student.imgUrl
     *
     * @mbggenerated
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_student.imgUrl
     *
     * @param imgUrl the value for ele_student.imgUrl
     *
     * @mbggenerated
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_student.createTime
     *
     * @return the value of ele_student.createTime
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_student.createTime
     *
     * @param createTime the value for ele_student.createTime
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_student.motifyTime
     *
     * @return the value of ele_student.motifyTime
     *
     * @mbggenerated
     */
    public Date getMotifyTime() {
        return motifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_student.motifyTime
     *
     * @param motifyTime the value for ele_student.motifyTime
     *
     * @mbggenerated
     */
    public void setMotifyTime(Date motifyTime) {
        this.motifyTime = motifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_student.isDel
     *
     * @return the value of ele_student.isDel
     *
     * @mbggenerated
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_student.isDel
     *
     * @param isDel the value for ele_student.isDel
     *
     * @mbggenerated
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}