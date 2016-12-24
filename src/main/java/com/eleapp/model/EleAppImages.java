package com.eleapp.model;

import java.util.Date;

public class EleAppImages {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_app_images.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_app_images.appId
     *
     * @mbggenerated
     */
    private Integer appId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_app_images.imgUrl
     *
     * @mbggenerated
     */
    private String imgUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_app_images.createTime
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_app_images.motifyTime
     *
     * @mbggenerated
     */
    private Date motifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_app_images.isDel
     *
     * @mbggenerated
     */
    private Integer isDel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_app_images.id
     *
     * @return the value of ele_app_images.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_app_images.id
     *
     * @param id the value for ele_app_images.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_app_images.appId
     *
     * @return the value of ele_app_images.appId
     *
     * @mbggenerated
     */
    public Integer getAppId() {
        return appId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_app_images.appId
     *
     * @param appId the value for ele_app_images.appId
     *
     * @mbggenerated
     */
    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_app_images.imgUrl
     *
     * @return the value of ele_app_images.imgUrl
     *
     * @mbggenerated
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_app_images.imgUrl
     *
     * @param imgUrl the value for ele_app_images.imgUrl
     *
     * @mbggenerated
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_app_images.createTime
     *
     * @return the value of ele_app_images.createTime
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_app_images.createTime
     *
     * @param createTime the value for ele_app_images.createTime
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_app_images.motifyTime
     *
     * @return the value of ele_app_images.motifyTime
     *
     * @mbggenerated
     */
    public Date getMotifyTime() {
        return motifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_app_images.motifyTime
     *
     * @param motifyTime the value for ele_app_images.motifyTime
     *
     * @mbggenerated
     */
    public void setMotifyTime(Date motifyTime) {
        this.motifyTime = motifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_app_images.isDel
     *
     * @return the value of ele_app_images.isDel
     *
     * @mbggenerated
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_app_images.isDel
     *
     * @param isDel the value for ele_app_images.isDel
     *
     * @mbggenerated
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}