package com.eleapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by An0nymous on 15/9/15.
 */
public class UserAccess {
    private long userId;
    private String userName;
    private UserRole userRole;
	private String realName;//用户昵称

	private ArrayList<HashMap<String, Object>> listProvince;

	private Map<String,List> listCity ;
	private Map<String,List> listCounty;
	private List listRural ;
    private Map<String,List> listCompany;

	public SysRbacDataaccess getSysRbacDataAccess() {
		return sysRbacDataAccess;
	}

	public void setSysRbacDataAccess(SysRbacDataaccess sysRbacDataAccess) {
		this.sysRbacDataAccess = sysRbacDataAccess;
	}

	private SysRbacDataaccess sysRbacDataAccess;//new 数据权限
	public long getUserId() {
		return userId;
	}


	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public ArrayList<HashMap<String, Object>> getListProvince() {
		return listProvince;
	}

	public void setListProvince(ArrayList<HashMap<String, Object>> listProvince) {
		this.listProvince = listProvince;
	}

	public Map<String, List> getListCity() {
		return listCity;
	}

	public void setListCity(Map<String, List> listCity) {
		this.listCity = listCity;
	}

	public Map<String, List> getListCounty() {
		return listCounty;
	}

	public void setListCounty(Map<String, List> listCounty) {
		this.listCounty = listCounty;
	}


	public Map<String, List> getListCompany() {
		return listCompany;
	}

	public void setListCompany(Map<String, List> listCompany) {
		this.listCompany = listCompany;
	}


}
