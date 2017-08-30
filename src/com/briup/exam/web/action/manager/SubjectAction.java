package com.briup.exam.web.action.manager;

import com.briup.exam.bean.Choice;
import com.briup.exam.bean.Subject;
import com.briup.exam.service.impl.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ApplicationAware;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class SubjectAction extends ActionSupport implements ApplicationAware {

    // todo 1.添加题目 接收题目添加页的subject对象
    private Subject subject; // 类中提供了同名变量，接收post值

    // todo 数组接收选择题的选项 对错数组 内容数组
    private List<Boolean> choiceCorrectArray;   // 选项对错 todo Boolean
    private List<String> choiceContentArray;    // 选项内容 todo String

    // todo 2.以题搜题 接收题干
    private String searchStem;

    // todo 3.标签搜题 接收查找页选中的4个标签
    // todo static 类型可以在同一类的其他函数中使用 因为load到其他action时其他函数也要用
    private static String searchType;
    private static String searchLevel;
    private static String searchDepartment;
    private static String searchTopic;

    // todo 4.审核题目 删除题目 接收被操作题目的ID
    // todo subjectDetail.jsp: 审核通过 审核不通过 删除题目
    private String checkYesID;
    private String checkNoID;
    private String deleteID;
    private static int subjectNumber; // todo 审核和删除题目时刷新页面需要这个值 与上面的static同种情况

    // todo 5.Application方式向jsp传值
    private Map<String, Object> appMap;

    // todo 6.拿到Service
    @Autowired
    private UserServiceImpl userService;
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
    @Autowired
    private ChoiceServiceImpl choiceService;

    private Order[] orders = {Order.asc("id")}; // todo 给一个排序顺序

    // 删除题目
    @Action(value = "/deleteSubject", results = {
            @Result(location = "/WEB-INF/jsp/subject/subjectList.jsp")})
    public String deleteSubject() {
        if (deleteID != null) {
            subjectService.delete(Long.parseLong(deleteID)); // 也可以在js里parseInt
        }
        // 更新查找页，传题目和题目数量
        List<Subject> subjectList = findBySubjectName(searchType, searchLevel, searchDepartment, searchTopic, searchStem);
        appMap.put("subjectList", getBetterSubjects(subjectList));
        subjectNumber--; // 每删除一个题目 向前端传递的题目数量需要更新 审核的时候不需要
        appMap.put("subjectNumber", subjectNumber);
        return SUCCESS;
    }


    // 审核题目
    @Action(value = "/checkSubject", results = {
            @Result(location = "/WEB-INF/jsp/subject/subjectList.jsp")})
    public String checkSubject() {

        // 更新审核状态 数据库update对象
        if (checkYesID != null) {
            Subject subject = subjectService.findById(Long.parseLong(checkYesID));
            subject.setCheckState("通过");
            subjectService.update(subject);
        }

        if (checkNoID != null) {
            Subject subject = subjectService.findById(Long.parseLong(checkNoID));
            subject.setCheckState("不通过");
            subjectService.update(subject);
        }

        // 更新查找页，传题目和题目数量
        List<Subject> subjectList = findBySubjectName(searchType, searchLevel, searchDepartment, searchTopic, searchStem);
        appMap.put("subjectList", getBetterSubjects(subjectList));
        appMap.put("subjectNumber", subjectNumber);
        return SUCCESS;
    }

    // 题目详细信息
    @Action(value = "/subjectDetail", results = {
            @Result(location = "/WEB-INF/jsp/subject/subjectDetail.jsp")
    })
    public String subjectDetail() {
        return SUCCESS;
    }


    // 查找题目
    @Action(value = "/searchSubject", results = {
            @Result(location = "/WEB-INF/jsp/subject/subjectList.jsp")
    })
    public String searchSubject() {

        System.out.println("search subject...");

        System.out.println(searchStem);

        System.out.println(searchType);
        System.out.println(searchLevel);
        System.out.println(searchDepartment);
        System.out.println(searchTopic);

        List<Subject> subjectList = findBySubjectName(searchType, searchLevel, searchDepartment, searchTopic, searchStem);

        appMap.put("subjectList", getBetterSubjects(subjectList));
        subjectNumber = subjectList.size();
        appMap.put("subjectNumber", subjectNumber);
        return SUCCESS;
    }

    // 以题搜题
    public List<Subject> findBySubjectStem(String stem) {
        Subject subject = new Subject();
        subject.setStem(stem);
        return subjectService.findByExample(subject, orders);
    }

    // Service 只能在 Action 里接收
    public List<Subject> findBySubjectName(String subjectType, String subjectLevel, String department, String topic, String stem) {
        Subject subject = new Subject();
        if (!subjectType.equals("全部")) subject.setSubjectType(subjectTypeService.findByName(subjectType).get(0));
        if (!subjectLevel.equals("全部")) subject.setSubjectLevel(subjectLevelService.findByName(subjectLevel).get(0));
        if (!department.equals("全部")) subject.setDepartment(departmentService.findByName(department).get(0));
        if (!topic.equals("全部")) subject.setTopic(topicService.findByName(topic).get(0));
        if (stem != null) subject.setStem(stem);
        return subjectService.findByExample(subject, orders);
    }


    // todo 保存题目
    @Action(value = "/saveSubject", results = {
            @Result(location = "/WEB-INF/jsp/subject/subjectAdd.jsp") // 添加页
    })
    public String saveSubject() {

        // 设置5个自有属性 stem, answer, analysis 后端输入
        subject.setUploadTime(new Date());
        subject.setCheckState("未审核");

        // 设置5个外键类
        Random random = new Random();
        subject.setUser(userService.findById((long) (random.nextInt(3) + 1))); // 设置 User
        subject.setTopic(topicService.findByName(subject.getTopic().getTitle()).get(0)); // 4个选项外键
        subject.setDepartment(departmentService.findByName(subject.getDepartment().getName()).get(0));
        subject.setSubjectType(subjectTypeService.findByName(subject.getSubjectType().getRealName()).get(0));
        subject.setSubjectLevel(subjectLevelService.findByName(subject.getSubjectLevel().getRealName()).get(0));
        System.out.println(subject);

        subjectService.save(subject); // 保存Subject到数据库

        if (!subject.getSubjectType().getRealName().equals("简答题")) {
            for (int i = 0; i < choiceContentArray.size(); i++) {
                Choice choice = new Choice();
                choice.setCorrect(choiceCorrectArray.get(i));
                choice.setContent(choiceContentArray.get(i));
                choice.setSubject(subject); // todo Choice设置题目ID 建立外键关系
                System.out.println(choice);
                choiceService.save(choice);
            }
        }

        return SUCCESS;
    }

    private List<Subject> getBetterSubjects(List<Subject> subjectList) {
        List<Subject> tmpSubjectList = new ArrayList<>();
        for (Subject subject : subjectList) {
            // 选择题
            if (!subject.getSubjectType().getRealName().equals("简答题")) {
                String choiceAnswer = "";
                char ch = 'A';
                Set<Choice> choiceSet = subject.getChoices();
                Set<Choice> tmpChoiceSet = new HashSet<>();
                for (Choice choice : choiceSet) {
                    choice.setContent(ch + "、" + choice.getContent());
                    tmpChoiceSet.add(choice); // 存储更新content的choices
                    // 将正确选项转化为String
                    if (choice.getCorrect()) choiceAnswer += ch;
                    ch++;
                }
                subject.setChoices(tmpChoiceSet);
                subject.setAnswer(choiceAnswer);
            }
            tmpSubjectList.add(subject);
        }
        return tmpSubjectList;
    }

    // 跳转添加题目页面
    @Action(value = "/addSubject", results = {
            @Result(location = "/WEB-INF/jsp/subject/subjectAdd.jsp")
    })
    public String addSubject() { // 监听器 向后端 subjectAdd.jsp 选择框传入数据
        System.out.println("add subject...");
        return SUCCESS;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Boolean> getChoiceCorrectArray() {
        return choiceCorrectArray;
    }

    public void setChoiceCorrectArray(List<Boolean> choiceCorrectArray) {
        this.choiceCorrectArray = choiceCorrectArray;
    }

    public List<String> getChoiceContentArray() {
        return choiceContentArray;
    }

    public void setChoiceContentArray(List<String> choiceContentArray) {
        this.choiceContentArray = choiceContentArray;
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        appMap = map;
    }


    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchLevel() {
        return searchLevel;
    }

    public void setSearchLevel(String searchLevel) {
        this.searchLevel = searchLevel;
    }

    public String getSearchDepartment() {
        return searchDepartment;
    }

    public void setSearchDepartment(String searchDepartment) {
        this.searchDepartment = searchDepartment;
    }

    public String getSearchTopic() {
        return searchTopic;
    }

    public void setSearchTopic(String searchTopic) {
        this.searchTopic = searchTopic;
    }

    public String getCheckYesID() {
        return checkYesID;
    }

    public void setCheckYesID(String checkYesID) {
        this.checkYesID = checkYesID;
    }

    public String getCheckNoID() {
        return checkNoID;
    }

    public void setCheckNoID(String checkNoID) {
        this.checkNoID = checkNoID;
    }

    public String getDeleteID() {
        return deleteID;
    }

    public void setDeleteID(String deleteID) {
        this.deleteID = deleteID;
    }

    public String getSearchStem() {
        return searchStem;
    }

    public void setSearchStem(String searchStem) {
        this.searchStem = searchStem;
    }
}
