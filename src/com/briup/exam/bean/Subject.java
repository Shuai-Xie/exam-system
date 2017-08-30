package com.briup.exam.bean;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

// 题目表
@Entity
@Table(name = "tbl_exam_subject")
public class Subject implements Serializable {

    // 自有属性
    private Long id;            // 题目ID
    private String stem;        // 题干
    private Date uploadTime;    // 上传时间
    private String answer;      // 问答题答案
    private String analysis;    // 解析
    private String checkState;  // 审核状态

    // 外键类
    private User user;                  // 用户
    private Department department;      // 部门
    private Topic topic;                // 知识点
    private SubjectType subjectType;    // 题目类型
    private SubjectLevel subjectLevel;  // 目难易程度

    // 拥有
    // 拥有的选项 一个 Subject 拥有多个 Choice
    private Set<Choice> choices = new HashSet<>();

    // 桥表类
    // Subject 与 Paper 双向关联 一个 Subject 可以属于多个 Paper
    private Set<PaperSubject> paperSubjects = new HashSet<>();


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
    // 多个 Subject 对应一个 User
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") // 对应外键列属性名
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // 多个 Subject 对应一个 Department
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // 多个 Subject 对应一个 Topic
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "topic_id")
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    // 多个 Subject 对应一个 SubjectType
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subjectType_id")
    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    // 多个 Subject 对应一个 SubjectLevel
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subjectLevel_id")
    public SubjectLevel getSubjectLevel() {
        return subjectLevel;
    }

    public void setSubjectLevel(SubjectLevel subjectLevel) {
        this.subjectLevel = subjectLevel;
    }


    /**
     * 拥有属性
     */
    // 一个 Subject 拥有多个 Choice
    @OneToMany(fetch = FetchType.LAZY) // todo (fetch = FetchType.EAGER) 千万不能加，不然会在查询Subjects时因为Choice有4个而添加4次
    @JoinColumn(name = "subject_id")
    @Cascade({CascadeType.REMOVE}) // 删除 Subject 级联删除其拥有的 Choices
    public Set<Choice> getChoices() {
        return choices;
    }

    public void setChoices(Set<Choice> choices) {
        this.choices = choices;
    }


    /**
     * 桥表属性
     */
    // 一个 Subject 对应桥表中的多行
    @OneToMany
    @JoinColumn(name = "subject_id")
    @Cascade({CascadeType.REMOVE}) // 删除 Subject 级联删除其在桥表中的行，并不是删除 Paper
    public Set<PaperSubject> getPaperSubjects() {
        return paperSubjects;
    }

    public void setPaperSubjects(Set<PaperSubject> paperSubjects) {
        this.paperSubjects = paperSubjects;
    }


    /**
     * 自有属性
     */
    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", stem='" + stem + '\'' +
                ", uploadTime=" + uploadTime +
                ", answer='" + answer + '\'' +
                ", analysis='" + analysis + '\'' +
                ", checkState='" + checkState + '\'' +
                ", user=" + user +
                ", department=" + department +
                ", topic=" + topic +
                ", subjectType=" + subjectType +
                ", subjectLevel=" + subjectLevel +
                '}';
    }
}
