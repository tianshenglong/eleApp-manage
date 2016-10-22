package com.eleapp.model;

import java.util.List;

/**
 * Created by К¤Бъ on 2016/10/22.
 */
public class RoleTopMenu {
    private Integer id;
    private String menuName;
    private String logo;
    private String buttons;
    private List<RoleSubMenu> roleSubMenuList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getButtons() {
        return buttons;
    }

    public void setButtons(String buttons) {
        this.buttons = buttons;
    }

    public List<RoleSubMenu> getRoleSubMenuList() {
        return roleSubMenuList;
    }

    public void setRoleSubMenuList(List<RoleSubMenu> roleSubMenuList) {
        this.roleSubMenuList = roleSubMenuList;
    }
}
