package com.briup.exam.bean;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 题目难度
 *
 * @author lichunyu
 */
@Entity
@Table(name = "tbl_exam_subjectLevel")
public class SubjectLevel implements Serializable {

    // 自有属性
    private Long id;            // 难度ID
    private String name;        // 难度名称 英文
    private String realName;    // 难度名称 中文


    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }


    @Override
    public String toString() {
        return "SubjectLevel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
