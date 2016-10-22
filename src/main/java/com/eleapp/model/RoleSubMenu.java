package com.eleapp.model;

/**
 * Created by An0nymous on 15/9/15.
 */
public class RoleSubMenu {
    private Integer menuId;
    private String menuName;
    private String url;
    private String authButtons;
    private String logo;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthButtons() {
        return authButtons;
    }

    public void setAuthButtons(String authButtons) {
        this.authButtons = authButtons;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
