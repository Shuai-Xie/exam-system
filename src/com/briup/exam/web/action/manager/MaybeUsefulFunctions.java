package com.briup.exam.web.action.manager;

import java.util.List;

import com.briup.exam.service.impl.*;
import org.hibernate.criterion.Order;

import com.briup.exam.bean.Subject;
import com.briup.exam.criteria.SubjectStateCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MaybeUsefulFunctions {

    @Autowired
    private SubjectServiceImpl subjectService;

    @Autowired
    private SubjectTypeServiceImpl subjectTypeService;

    @Autowired
    private SubjectLevelServiceImpl subjectLevelService;

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private TopicServiceImpl topicService;

    private Order[] orders = {Order.asc("department_id"),
            Order.asc("topic_id"),
            Order.asc("subjecttype_id"),
            Order.asc("subjectlevel_id"),
            Order.desc("uploadtime")
    };


    // 根据某类型选择对应的题目们 "全部" 设为0就好了
    public List<Subject> findBySubjectId(long department, long topic, long subjectType, long subjectLevel) {
        Subject subject = new Subject();
        if (department != 0) subject.setDepartment(departmentService.findById(department));
        if (topic != 0) subject.setTopic(topicService.findById(topic));
        if (subjectType != 0) subject.setSubjectType(subjectTypeService.findById(subjectType));
        if (subjectLevel != 0) subject.setSubjectLevel(subjectLevelService.findById(subjectLevel));
        return subjectService.findByExample(subject, orders);

    }

    /**
     * 制造模板，再用通配符查找
     *
     * @param subjectType  realName
     * @param subjectLevel realName
     * @param department   name
     * @param topic        title
     * @return 符合条件的Subject
     */
    public List<Subject> findBySubjectName(String subjectType, String subjectLevel, String department, String topic) {
        Subject subject = new Subject();

        System.out.println("到这里");
        System.out.println(subjectTypeService);

        if (!subjectType.equals("")) subject.setSubjectType(subjectTypeService.findByName(subjectType).get(0));
        if (!subjectType.equals("")) subject.setSubjectLevel(subjectLevelService.findByName(subjectLevel).get(0));
        if (!department.equals("")) subject.setDepartment(departmentService.findByName(department).get(0));
        if (!topic.equals("")) subject.setTopic(topicService.findByName(topic).get(0));
        return subjectService.findByExample(subject, orders);
    }


    //以题搜题
    public List<Subject> findByStem(String stem) {
        Subject subject = new Subject();
        subject.setStem(stem);
        return subjectService.findByExample(subject, orders);
    }

    //查找审核通过/未通过的题目
    public List<Subject> findByCheckState(String checkState) {
        Subject subject = new Subject();
        subject.setCheckState(checkState);
        SubjectStateCriteria stateCriteria = new SubjectStateCriteria();
        stateCriteria.setSubject(subject);
        return subjectService.findByCriteria(stateCriteria, orders);
    }

    //设置题的状态
    public void setSubjectCheckState(String checkState, Subject subject) {
        subject.setCheckState(checkState);
        subjectService.update(subject);
    }


}
