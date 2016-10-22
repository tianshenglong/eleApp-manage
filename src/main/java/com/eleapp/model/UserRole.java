package com.eleapp.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by An0nymous on 15/9/15.
 */
public class UserRole {
    private long roleId;
    private String roleName;

    public List<RoleTopMenu> getRoleTopMenuList() {
        return roleTopMenuList;
    }

    public void setRoleTopMenuList(List<RoleTopMenu> roleTopMenuList) {
        this.roleTopMenuList = roleTopMenuList;
    }

    private List<RoleTopMenu> roleTopMenuList;
    private Map<String,Set> button;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public Map<String, Set> getButton() {
        return button;
    }

    public void setButton(Map<String, Set> button) {
        this.button = button;
    }
}
