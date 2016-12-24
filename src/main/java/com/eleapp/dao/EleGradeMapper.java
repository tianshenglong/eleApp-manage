package com.eleapp.dao;

import com.eleapp.model.EleGrade;

import java.util.List;
import java.util.Map;

public interface EleGradeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_grade
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_grade
     *
     * @mbggenerated
     */
    int insert(EleGrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_grade
     *
     * @mbggenerated
     */
    int insertSelective(EleGrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_grade
     *
     * @mbggenerated
     */
    EleGrade selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_grade
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(EleGrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_grade
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(EleGrade record);

    List<Map> selectAllGradeList(Map param);
}