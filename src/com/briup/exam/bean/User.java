package com.briup.exam.bean;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用户
 */
@Entity
@Table(name = "tbl_exam_user")
public class User implements Serializable {

    // 自有属性
    private Long id;            // 用户ID
    private String name;        // 用户名
    private String password;    // 密码
    private String telephone;   // 电话
    private String gender;      // 性别
    private Integer age;        // 年龄

    // 外键类
    private Department department;  // 所属部门

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /**
     * 外键属性
     */
    // 多个 User 属于一个 Department
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    /**
     * 自有属性
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", department=" + department +
                '}';
    }
}
