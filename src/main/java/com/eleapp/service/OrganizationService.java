package com.eleapp.service;

import com.eleapp.dao.EleRbacOrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 胜龙 on 2016/12/24.
 */
@Service
public class OrganizationService {

    @Autowired
    EleRbacOrganizationMapper eleRbacOrganizationMapper;

    public List<Map> getOrgListByOrgId(String orgId){
        return eleRbacOrganizationMapper.getOrgListByOrgId(orgId);
    }

    public List<Map> getRuralListByOrgId(String orgId){
        return eleRbacOrganizationMapper.getRuralListByOrgId(orgId);
    }
}
