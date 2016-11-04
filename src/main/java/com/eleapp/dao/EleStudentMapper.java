package com.eleapp.dao;

import com.eleapp.model.EleStudent;

import java.util.List;
import java.util.Map;

public interface EleStudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_student
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_student
     *
     * @mbggenerated
     */
    int insert(EleStudent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_student
     *
     * @mbggenerated
     */
    int insertSelective(EleStudent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_student
     *
     * @mbggenerated
     */
    EleStudent selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_student
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(EleStudent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_student
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(EleStudent record);

    List<Map> selectAllStudentList(Map param);
}