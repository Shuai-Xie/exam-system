package com.briup.exam.web.action.manager;

import java.util.*;

import com.briup.exam.service.impl.*;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ApplicationAware;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.briup.exam.bean.Paper;
import com.briup.exam.bean.PaperSubject;
import com.briup.exam.bean.Subject;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class PaperAction extends ActionSupport implements ApplicationAware {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private SubjectServiceImpl subjectService;

    @Autowired
    private PaperServiceImpl paperService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PaperSubjectServiceImpl paperSubjectService;

    private static String departmentName;

    private Paper paper; // 接收试卷


    private List<PaperSubject> paperSubjectList;

    private List<Long> subjectIDArray;


    private Order[] orders = {Order.asc("id")};
    private Long previewID;
    private List<Long> deleteIDArray;

    private Map<String, Object> appMap;


    // 添加试卷
    @Action(value = "/savePaper", results = {
            @Result(location = "/paperList.action", type = "redirect")})
    public String savePaper() {
        System.out.println("to savePaper...");

        paper.setType("闭卷");
        paper.setCreateTime(new Date());

        paper.setDepartment(departmentService.findByName(departmentName).get(0));
        paper.setUser(userService.findById(1L));
        System.out.println(paper);
        paperService.save(paper); // 保存新添加的paper

        for (int i = 0; i < subjectIDArray.size(); i++) {
            paperSubjectList.get(i).setSubject(subjectService.findById(subjectIDArray.get(i)));
            paperSubjectList.get(i).setPaper(paper);
        }
        paperSubjectService.batchSave(paperSubjectList); // 保存桥表
        return SUCCESS;
    }

    @Action(value = "/dsDetail", results = {
            @Result(location = "/WEB-INF/jsp/paper/dsDetail.jsp")})
    public String dsDetail() {
        return SUCCESS;
    }


    // 根据方向查找题目（包含在了添加题目之中）
    @Action(value = "/departmentSubject", results = {
            @Result(location = "/makePaperByHand.action", type = "redirect")})
    public String departmentSubject() {
        System.out.println(departmentName);

        List<Subject> paperSubjectList;
        if (departmentName.equals("综合")){
            paperSubjectList = subjectService.findAll(orders);
        } else {
            paperSubjectList = findBySubjectDepartment(departmentName);
        }
        appMap.put("paperSubjectList", paperSubjectList);
        return SUCCESS;
    }

    // 根据部门查找
    public List<Subject> findBySubjectDepartment(String department) {
        Subject subject = new Subject();
        subject.setDepartment(departmentService.findByName(department).get(0));
        return subjectService.findByExample(subject, orders);
    }


    // 试卷列表
    @Action(value = "/paperList", results = {
            @Result(location = "/WEB-INF/jsp/paper/paperList.jsp")})
    public String paperList() {
        System.out.println("in paperList...");
        List<Paper> paperList = paperService.findAll(orders);
        appMap.put("paperList", paperList);
        return SUCCESS;
    }


    // 删除试卷
    @Action(value = "/deletePaper", results = {
            @Result(location = "paperList.action", type = "redirect")})
    public String deletePaper() {
        System.out.println("in deletePaper...");
        System.out.println(deleteIDArray);
        if (!deleteIDArray.isEmpty()) {
            paperService.batchDelete(deleteIDArray);
        }
        return SUCCESS;
    }


    // 预览试卷
    // 大页面加载小页面
    // 小页面需要另一个Action的值，所以不能用RequestMap
    @Action(value = "/paperDetail", results = {
            @Result(location = "/WEB-INF/jsp/paper/paperPreview.jsp")})
    public String paperDetail() {
        return SUCCESS;
    }

    @Action(value = "/paperPreview", results = {
            @Result(location = "/WEB-INF/jsp/paper/paperList.jsp")})
    public String paperPreview() {
        System.out.println("to paperPreview...");

        if (previewID != null) {
            Paper paper = paperService.findById(previewID); // 拿到对应试卷

            Set<PaperSubject> paperSubjects = paper.getPaperSubjects(); // 拿到试卷的题目

            List<PaperSubject> radioPSList = new ArrayList<>();     // 单选
            List<PaperSubject> checkPSList = new ArrayList<>();     // 多选
            List<PaperSubject> questionPSList = new ArrayList<>();  // 简答

            // 类型分值
            Integer radioPoints = 0;
            Integer checkPoints = 0;
            Integer questionPoints = 0;

            for (PaperSubject ps : paperSubjects) {
                // todo 用hibernate初始化先拿到choice值，解决后面双层forEach @OneToMany(fetch = FetchType.LAZY)拿不到choice异常
                Hibernate.initialize(ps.getSubject().getChoices());
                switch (ps.getSubject().getSubjectType().getRealName()) {
                    case "单选题":
                        radioPSList.add(ps);
                        radioPoints += ps.getScore();
                        break;
                    case "复选题":
                        checkPSList.add(ps);
                        checkPoints += ps.getScore();
                        break;
                    case "简答题":
                        questionPSList.add(ps);
                        questionPoints += ps.getScore();
                        break;
                    default:
                        break;
                }
                System.out.println("adding subjects...");
            }

            // 难度分值
            Integer easyPoints = 0;
            Integer middlePoints = 0;
            Integer hardPoints = 0;

            for (PaperSubject ps : paperSubjects) {
                switch (ps.getSubject().getSubjectLevel().getRealName()) {
                    case "简单":
                        easyPoints += ps.getScore();
                        break;
                    case "中等":
                        middlePoints += ps.getScore();
                        break;
                    case "难":
                        hardPoints += ps.getScore();
                        break;
                    default:
                        break;
                }
            }

            System.out.println(easyPoints);
            System.out.println(middlePoints);
            System.out.println(hardPoints);

            // 试卷和各类题目集合
            appMap.put("paper", paper); // todo 用 Application 传递使得 paperPreview.jsp 可以加载
            appMap.put("radioPSList", radioPSList); // todo 分开传递，为了在jsp得到合适的index
            appMap.put("checkPSList", checkPSList);
            appMap.put("questionPSList", questionPSList);

            // 题目类型分值
            appMap.put("radioPoints", radioPoints);
            appMap.put("checkPoints", checkPoints);
            appMap.put("questionPoints", questionPoints);

            // 题目难度分值
            appMap.put("easyPoints", easyPoints);
            appMap.put("middlePoints", middlePoints);
            appMap.put("hardPoints", hardPoints);
        }

        return SUCCESS;
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        this.appMap = map;
    }

    public Long getPreviewID() {
        return previewID;
    }

    public void setPreviewID(Long previewID) {
        this.previewID = previewID;
    }

    public List<Long> getDeleteIDArray() {
        return deleteIDArray;
    }

    public void setDeleteIDArray(List<Long> deleteIDArray) {
        this.deleteIDArray = deleteIDArray;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public List<PaperSubject> getPaperSubjectList() {
        return paperSubjectList;
    }

    public void setPaperSubjectList(List<PaperSubject> paperSubjectList) {
        this.paperSubjectList = paperSubjectList;
    }

    public List<Long> getSubjectIDArray() {
        return subjectIDArray;
    }

    public void setSubjectIDArray(List<Long> subjectIDArray) {
        this.subjectIDArray = subjectIDArray;
    }
}
