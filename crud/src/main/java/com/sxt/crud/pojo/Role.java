package com.sxt.crud.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ouyangjie
 * @createTime 2019-12-12 14:34
 * role_menu是多对多
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(length = 36)
    //jpa (hibernate实现)的UUID生成主键策略
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "jpa-uuid") //使用jpa-uuid的生成策略
    private String id;
    @Column(length = 36,name = "name")
    private String name;
    @Column(name = "work")
    private String work;
    //解决问题，延迟加载改成立即加载
    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinTable(name="role_menu",joinColumns = @JoinColumn(name="role_id"),inverseJoinColumns = @JoinColumn(name="menu_id"))
    private Set<Menu> menus=new HashSet<>();

    public Role(String name, String work) {
        this.name = name;
        this.work = work;
    }

    public Role() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
