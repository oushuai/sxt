package com.sxt.crud.pojo;


import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author ouyangjie
 * @createTime 2019-12-01 21:13
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    //非空校验
    @NotBlank(message = "姓名不能为空！")
    @Length(min = 2, max = 4, message = "姓名长度不能大于四位，不能少于两位！")
    private String name;
    @NotNull(message = "年龄不能为空！")
    @Min(value = 18)
    private Integer age;
    @NotNull(message = "性别不能为空！")
    private Boolean sex;
    @NotNull(message = "邮箱不能为空！")
    @Email
    private String email;
    @ManyToOne(cascade = CascadeType.PERSIST)
    //外键
    /* 默认值：CascadeType 的空数组。
默认情况下，JPA 不会将任何持续性操作层叠到关联的目标。
如果希望某些或所有持续性操作层叠到关联的目标，请将 cascade 设置为一个或多个 CascadeType 实例，其中包括：
· ALL — 针对拥有实体执行的任何持续性操作均层叠到关联的目标。
· MERGE — 如果合并了拥有实体，则将 merge 层叠到关联的目标。
· PERSIST — 如果持久保存拥有实体，则将 persist 层叠到关联的目标。
· REFRESH — 如果刷新了拥有实体，则 refresh 为关联的层叠目标。
· REMOVE — 如果删除了拥有实体，则还删除关联的目标。
*/
    @JoinColumn(name = "role_id")
    private Role role;

    public Integer getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(@NotBlank(message = "姓名不能为空！") @Length(min = 2, max = 4, message = "姓名长度不能大于四位，不能少于两位！") String name, @NotNull(message = "年龄不能为空！") @Min(value = 18) Integer age, @NotNull(message = "性别不能为空！") Boolean sex, @NotNull(message = "邮箱不能为空！") @Email String email, Role role) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.role = role;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.isEmpty(null) == true);
        System.out.println(StringUtils.isEmpty("") == true);
        System.out.println(StringUtils.isEmpty(" ") == true);
        System.out.println(StringUtils.isBlank(null) == true);
        System.out.println(StringUtils.isBlank("") == true);
        System.out.println(StringUtils.isBlank(" ") == true);
    }
}
