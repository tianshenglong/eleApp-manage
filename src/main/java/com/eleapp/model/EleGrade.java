package com.eleapp.model;

import java.util.Date;

public class EleGrade {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_grade.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_grade.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_grade.schoolId
     *
     * @mbggenerated
     */
    private Integer schoolId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_grade.createTime
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_grade.motifyTime
     *
     * @mbggenerated
     */
    private Date motifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ele_grade.isDel
     *
     * @mbggenerated
     */
    private Integer isDel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_grade.id
     *
     * @return the value of ele_grade.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_grade.id
     *
     * @param id the value for ele_grade.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_grade.name
     *
     * @return the value of ele_grade.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_grade.name
     *
     * @param name the value for ele_grade.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_grade.schoolId
     *
     * @return the value of ele_grade.schoolId
     *
     * @mbggenerated
     */
    public Integer getSchoolId() {
        return schoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_grade.schoolId
     *
     * @param schoolId the value for ele_grade.schoolId
     *
     * @mbggenerated
     */
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_grade.createTime
     *
     * @return the value of ele_grade.createTime
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_grade.createTime
     *
     * @param createTime the value for ele_grade.createTime
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_grade.motifyTime
     *
     * @return the value of ele_grade.motifyTime
     *
     * @mbggenerated
     */
    public Date getMotifyTime() {
        return motifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_grade.motifyTime
     *
     * @param motifyTime the value for ele_grade.motifyTime
     *
     * @mbggenerated
     */
    public void setMotifyTime(Date motifyTime) {
        this.motifyTime = motifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ele_grade.isDel
     *
     * @return the value of ele_grade.isDel
     *
     * @mbggenerated
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ele_grade.isDel
     *
     * @param isDel the value for ele_grade.isDel
     *
     * @mbggenerated
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}