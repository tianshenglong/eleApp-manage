package com.eleapp.dao;

import com.eleapp.model.EleWebSchoolcase;

public interface EleWebSchoolcaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_web_schoolcase
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_web_schoolcase
     *
     * @mbggenerated
     */
    int insert(EleWebSchoolcase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_web_schoolcase
     *
     * @mbggenerated
     */
    int insertSelective(EleWebSchoolcase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_web_schoolcase
     *
     * @mbggenerated
     */
    EleWebSchoolcase selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_web_schoolcase
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(EleWebSchoolcase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_web_schoolcase
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(EleWebSchoolcase record);
}