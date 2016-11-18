package com.eleapp.model;

import java.util.Date;

public class Newsinfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newsinfo.AutoID
     *
     * @mbggenerated
     */
    private Integer autoID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newsinfo.NewsName
     *
     * @mbggenerated
     */
    private String newsName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newsinfo.NewsTitle
     *
     * @mbggenerated
     */
    private String newsTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newsinfo.PushTime
     *
     * @mbggenerated
     */
    private Date pushTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newsinfo.KeyWords
     *
     * @mbggenerated
     */
    private String keyWords;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newsinfo.ImgUrl
     *
     * @mbggenerated
     */
    private String imgUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newsinfo.Weight
     *
     * @mbggenerated
     */
    private Integer weight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newsinfo.Description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newsinfo.NewsType
     *
     * @mbggenerated
     */
    private Integer newsType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newsinfo.ReadCount
     *
     * @mbggenerated
     */
    private Integer readCount;

    private Integer IsDel;

    public Integer getIsDel() {
        return IsDel;
    }

    public void setIsDel(Integer isDel) {
        IsDel = isDel;
    }

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newsinfo.CreateDate
     *
     * @mbggenerated
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newsinfo.ModifyDate
     *
     * @mbggenerated
     */
    private Date modifyDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newsinfo.NewsContext
     *
     * @mbggenerated
     */
    private String newsContext;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newsinfo.AutoID
     *
     * @return the value of newsinfo.AutoID
     *
     * @mbggenerated
     */
    public Integer getAutoID() {
        return autoID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newsinfo.AutoID
     *
     * @param autoID the value for newsinfo.AutoID
     *
     * @mbggenerated
     */
    public void setAutoID(Integer autoID) {
        this.autoID = autoID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newsinfo.NewsName
     *
     * @return the value of newsinfo.NewsName
     *
     * @mbggenerated
     */
    public String getNewsName() {
        return newsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newsinfo.NewsName
     *
     * @param newsName the value for newsinfo.NewsName
     *
     * @mbggenerated
     */
    public void setNewsName(String newsName) {
        this.newsName = newsName == null ? null : newsName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newsinfo.NewsTitle
     *
     * @return the value of newsinfo.NewsTitle
     *
     * @mbggenerated
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newsinfo.NewsTitle
     *
     * @param newsTitle the value for newsinfo.NewsTitle
     *
     * @mbggenerated
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newsinfo.PushTime
     *
     * @return the value of newsinfo.PushTime
     *
     * @mbggenerated
     */
    public Date getPushTime() {
        return pushTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newsinfo.PushTime
     *
     * @param pushTime the value for newsinfo.PushTime
     *
     * @mbggenerated
     */
    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newsinfo.KeyWords
     *
     * @return the value of newsinfo.KeyWords
     *
     * @mbggenerated
     */
    public String getKeyWords() {
        return keyWords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newsinfo.KeyWords
     *
     * @param keyWords the value for newsinfo.KeyWords
     *
     * @mbggenerated
     */
    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords == null ? null : keyWords.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newsinfo.ImgUrl
     *
     * @return the value of newsinfo.ImgUrl
     *
     * @mbggenerated
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newsinfo.ImgUrl
     *
     * @param imgUrl the value for newsinfo.ImgUrl
     *
     * @mbggenerated
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newsinfo.Weight
     *
     * @return the value of newsinfo.Weight
     *
     * @mbggenerated
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newsinfo.Weight
     *
     * @param weight the value for newsinfo.Weight
     *
     * @mbggenerated
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newsinfo.Description
     *
     * @return the value of newsinfo.Description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newsinfo.Description
     *
     * @param description the value for newsinfo.Description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newsinfo.NewsType
     *
     * @return the value of newsinfo.NewsType
     *
     * @mbggenerated
     */
    public Integer getNewsType() {
        return newsType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newsinfo.NewsType
     *
     * @param newsType the value for newsinfo.NewsType
     *
     * @mbggenerated
     */
    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newsinfo.ReadCount
     *
     * @return the value of newsinfo.ReadCount
     *
     * @mbggenerated
     */
    public Integer getReadCount() {
        return readCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newsinfo.ReadCount
     *
     * @param readCount the value for newsinfo.ReadCount
     *
     * @mbggenerated
     */
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newsinfo.CreateDate
     *
     * @return the value of newsinfo.CreateDate
     *
     * @mbggenerated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newsinfo.CreateDate
     *
     * @param createDate the value for newsinfo.CreateDate
     *
     * @mbggenerated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newsinfo.ModifyDate
     *
     * @return the value of newsinfo.ModifyDate
     *
     * @mbggenerated
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newsinfo.ModifyDate
     *
     * @param modifyDate the value for newsinfo.ModifyDate
     *
     * @mbggenerated
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newsinfo.NewsContext
     *
     * @return the value of newsinfo.NewsContext
     *
     * @mbggenerated
     */
    public String getNewsContext() {
        return newsContext;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newsinfo.NewsContext
     *
     * @param newsContext the value for newsinfo.NewsContext
     *
     * @mbggenerated
     */
    public void setNewsContext(String newsContext) {
        this.newsContext = newsContext == null ? null : newsContext.trim();
    }
}