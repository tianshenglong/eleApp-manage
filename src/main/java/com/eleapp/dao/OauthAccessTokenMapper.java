package com.eleapp.dao;

import com.eleapp.model.OauthAccessToken;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OauthAccessTokenMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbggenerated
     */
    int insert(OauthAccessToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbggenerated
     */
    int insertSelective(OauthAccessToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbggenerated
     */
    OauthAccessToken selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OauthAccessToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OauthAccessToken record);

    List<Map> selectAllOauthAccessList(Map param);

    int updateOauthStatus(@Param("status") Integer status,@Param("id") Integer id);
}