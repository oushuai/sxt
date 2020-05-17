package com.sxt.crud.pojo;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ouyangjie
 * @createTime 2019-12-12 18:29
 */
@Entity
@Table(name="menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer menuId;
    @Column(name="name")
    private String MenuName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Menu parentId;
    @Column(name="menu_url")
    private String MenuUrl;
    @ManyToMany(mappedBy = "menus")
    private Set<Role> role=new HashSet<>();

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }

    public Menu getParentId() {
        return parentId;
    }

    public void setParentId(Menu parentId) {
        this.parentId = parentId;
    }

    public String getMenuUrl() {
        return MenuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        MenuUrl = menuUrl;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> roles) {
        this.role = roles;
    }

    public Menu(String menuName, Menu parentId, String menuUrl, Set<Role> roles) {
        MenuName = menuName;
        this.parentId = parentId;
        MenuUrl = menuUrl;
        this.role = roles;
    }

    public Menu() {
    }
}
