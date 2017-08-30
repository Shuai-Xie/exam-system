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
 * 卷子题目
 */
@Entity
@Table(name = "tbl_exam_papersubject")
public class PaperSubject implements Serializable {

    // 自有属性
    private Long id;            // 桥表ID
    private Integer score;      // 试卷分数

    // 外键类
    private Paper paper;        // 试卷
    private Subject subject;    // 题目

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
    // 多个 桥表列 对应一个 Paper
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paper_id")
    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    // 多个 桥表列 对应一个 Subject
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
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "PaperSubject{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }
}
