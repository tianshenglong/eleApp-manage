package com.eleapp.dao;

import com.eleapp.model.EleApptype;

import java.util.List;

public interface EleApptypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_apptype
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_apptype
     *
     * @mbggenerated
     */
    int insert(EleApptype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_apptype
     *
     * @mbggenerated
     */
    int insertSelective(EleApptype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_apptype
     *
     * @mbggenerated
     */
    EleApptype selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_apptype
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(EleApptype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_apptype
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(EleApptype record);

    List<EleApptype> getALlTypes();
}