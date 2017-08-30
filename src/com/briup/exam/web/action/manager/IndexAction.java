package com.briup.exam.web.action.manager;

import com.briup.exam.bean.*;
import com.briup.exam.service.impl.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class IndexAction extends ActionSupport implements ApplicationAware, RequestAware {

    @Autowired
    private SubjectTypeServiceImpl subjectTypeService;
    @Autowired
    private SubjectLevelServiceImpl subjectLevelService;
    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private TopicServiceImpl topicService;
    @Autowired
    private SubjectServiceImpl subjectService;

    private Order[] orders = {Order.asc("id")};

    private Map<String, Object> reqMap;
    private Map<String, Object> appMap;

    // 主页 todo 保存并关闭按钮跳转到这里
    @Action(value = "/toIndex", results = {
            @Result(location = "/index.jsp")})
    public String toIndex() {
        System.out.println("index...");
        return SUCCESS;
    }

    @Action(value = "/toAbout", results = {
            @Result(location = "/about.jsp")})
    public String toAbout() {
        System.out.println("index...");
        return SUCCESS;
    }

    // 题目列表
    @Action(value = "/subjectList", results = {
            @Result(location = "/WEB-INF/jsp/subject/subjectList.jsp")})
    public String subjectList() {
        System.out.println("subject list...");

        // 题目类型
        List<SubjectType> subjectTypes = subjectTypeService.findAll(Order.asc("id"));
        List<String> typeList = new ArrayList<>();
        for (SubjectType t : subjectTypes) {
            typeList.add(t.getRealName());
        }
        appMap.put("typeList", typeList);

        // 题目难度
        List<SubjectLevel> subjectLevels = subjectLevelService.findAll(Order.asc("id"));
        List<String> levelList = new ArrayList<>();
        for (SubjectLevel l : subjectLevels) {
            levelList.add(l.getRealName());
        }
        appMap.put("levelList", levelList);

        // 所属方向
        List<Department> departments = departmentService.findAll(Order.asc("id"));
        List<String> departmentList = new ArrayList<>();
        for (Department d : departments) {
            departmentList.add(d.getName());
        }
        appMap.put("departmentList", departmentList);

        // 所属知识点
        List<Topic> topics = topicService.findAll(Order.asc("id"));
        List<String> topicList = new ArrayList<>();
        for (Topic t : topics) {
            topicList.add(t.getTitle());
        }
        appMap.put("topicList", topicList);
        return SUCCESS;
    }

    // 手工组卷
    @Action(value = "/makePaperByHand", results = {
            @Result(location = "/WEB-INF/jsp/paper/makePaperByHand.jsp")})
    public String makePaperByHand() {
        System.out.println("make paper by hand...");
        List<Department> departments = departmentService.findAll(Order.asc("id"));
        List<String> paperDepartmentList = new ArrayList<>();
        for (Department d : departments) {
            paperDepartmentList.add(d.getName());
        }
        reqMap.put("paperDepartmentList", paperDepartmentList); // todo 防止后面不更新

        List<Subject> paperSubjectList = findBySubjectDepartment(departmentService.findById(1L).getName());
        reqMap.put("paperSubjectList", paperSubjectList);

        return SUCCESS;
    }

    // 根据部门查找
    public List<Subject> findBySubjectDepartment(String department) {
        Subject subject = new Subject();
        subject.setDepartment(departmentService.findByName(department).get(0));
        return subjectService.findByExample(subject, orders);
    }


    // 题型管理
    @Action(value = "/subjectTypeManage", results = {
            @Result(location = "/showSubjectType.action", type = "redirect")})
    public String subjectTypeManage() {
        System.out.println("type manage...");


        List<Subject> allSubject = subjectService.findAll();

        Set<Long> typeIDArray = new HashSet<>();

        for (Subject s : allSubject) {
            typeIDArray.add(s.getSubjectType().getId());
        }

        System.out.println(typeIDArray);

        appMap.put("typeIDArray", typeIDArray);

        return SUCCESS;
    }


    // 难度管理
    @Action(value = "/subjectLevelManage", results = {
            @Result(location = "/showSubjectLevel.action", type = "redirect")})
    public String subjectLevelManage() {
        System.out.println("level manage...");
        return SUCCESS;
    }


    // 方向管理
    @Action(value = "/departmentManage", results = {
            @Result(location = "/showDepartment.action", type = "redirect")})
    public String departmentManage() {
        System.out.println("department manage...");
        return SUCCESS;
    }


    // 知识点管理
    @Action(value = "/topicManage", results = {
            @Result(location = "/showTopic.action", type = "redirect")})
    public String topicManage() {
        System.out.println("topic manage...");

        // 所属知识点
        List<Topic> topics = topicService.findAll(Order.asc("id"));
        List<String> topicList = new ArrayList<>();
        for (Topic t : topics) {
            topicList.add(t.getTitle());
        }
        appMap.put("topicList", topicList);

        // 所属方向
        List<Department> departments = departmentService.findAll(Order.asc("id"));
        List<String> departmentList = new ArrayList<>();
        for (Department d : departments) {
            departmentList.add(d.getName());
        }
        appMap.put("departmentList", departmentList);
        return SUCCESS;
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        this.appMap = map;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.reqMap = map;
    }
}
