package com.eleapp.model;

import java.util.Date;

public class SysRbacDataaccess {
    private Integer id;

    private Integer userId;

    private Integer areaType;

    private String areaIds;

    private String trainingNatureIds;

    private String trainingSiteIds;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUserId() {
        return userId;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getAreaType() {
        return areaType;
    }


    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }


    public String getAreaIds() {
        return areaIds;
    }

    public void setAreaIds(String areaIds) {
        this.areaIds = areaIds == null ? null : areaIds.trim();
    }

    public String getTrainingNatureIds() {
        return trainingNatureIds;
    }

    public void setTrainingNatureIds(String trainingNatureIds) {
        this.trainingNatureIds = trainingNatureIds == null ? null : trainingNatureIds.trim();
    }

    public String getTrainingSiteIds() {
        return trainingSiteIds;
    }

    public void setTrainingSiteIds(String trainingSiteIds) {
        this.trainingSiteIds = trainingSiteIds == null ? null : trainingSiteIds.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}