package com.sxt.crud.pojo;

import javax.persistence.*;

/**
 * @author ouyangjie
 * @createTime 2019-12-08 23:11
 */
@Entity
@Table(name = "pig")
public class Pig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="folk_name")
    private String folkName;
    @Column(name="sex")
    private boolean sex;
    @Column(name="age")
    private Integer age;

    public Integer getId() {
        return id;
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

    public String getFolkName() {
        return folkName;
    }

    public void setFolkName(String folkName) {
        this.folkName = folkName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Pig(String name, String folkName, boolean sex, Integer age) {
        this.name = name;
        this.folkName = folkName;
        this.sex = sex;
        this.age = age;
    }

    public Pig() {
    }

    @Override
    public String toString() {
        return "Pig{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", folkName='" + folkName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
