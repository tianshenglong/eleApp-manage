package com.eleapp.dao;

import com.eleapp.model.EleStuschclass;

public interface EleStuschclassMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_stuschclass
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_stuschclass
     *
     * @mbggenerated
     */
    int insert(EleStuschclass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_stuschclass
     *
     * @mbggenerated
     */
    int insertSelective(EleStuschclass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_stuschclass
     *
     * @mbggenerated
     */
    EleStuschclass selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_stuschclass
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(EleStuschclass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ele_stuschclass
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(EleStuschclass record);
}