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
 * 题目选项
 */
@Entity
@Table(name = "tbl_exam_choice")
public class Choice implements Serializable {

    // 自有属性
    private Long id;            // 选项ID
    private String content;     // 选项内容
    private Boolean correct;    // 是否正确

    // 外键类
    private Subject subject;    // 所属题目

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
    // 多个 Choice 对应一个 Subject
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


    /**
     * 自有属性
     */
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Choice c = (Choice) obj;
        return c.getId() == this.id;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", correct=" + correct +
                '}';
    }
}
