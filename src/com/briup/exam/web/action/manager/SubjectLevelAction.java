package com.briup.exam.web.action.manager;

import java.util.List;
import java.util.Map;

import com.briup.exam.service.impl.SubjectLevelServiceImpl;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.briup.exam.bean.SubjectLevel;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class SubjectLevelAction extends ActionSupport implements RequestAware {

    @Autowired
    private SubjectLevelServiceImpl subjectLevelService;

    private Order[] orders = {Order.asc("id")};
    private List<Long> list;
    private List<SubjectLevel> subjectLevelList;

    private Map<String, Object> reqMap;

    @Action(value = "/showSubjectLevel", results = {
            @Result(location = "/WEB-INF/jsp/manager/subjectLevelManager.jsp")})
    public String showSubjectLevel() {
        System.out.println("in showSubjectLevel...");
        subjectLevelList = subjectLevelService.findAll(orders);
        reqMap.put("subjectLevelList", subjectLevelList);
        return SUCCESS;
    }

    @Action(value = "/deleteSubjectLevel", results = {
            @Result(location = "/showSubjectLevel.action", type = "redirectAction")})
    public String deleteSubjectLevel() {
        if (!list.isEmpty()) {
            subjectLevelService.batchDelete(list);
        }
        return SUCCESS;
    }

    @Action(value = "/saveSubjectLevel", results = {
            @Result(location = "/showSubjectLevel.action", type = "redirectAction")})
    public String saveSubjectLevel() {
        System.out.println("in saveSubjectLevel...");
        for (SubjectLevel subjectLevel : subjectLevelList) {
            if (subjectLevelService.findById(subjectLevel.getId()) != null) {
                // System.out.println("1");
                SubjectLevel tmp = subjectLevelService.findById(subjectLevel.getId());
                tmp.setName(subjectLevel.getName());
                tmp.setRealName(subjectLevel.getRealName());
                subjectLevelService.update(tmp);
            } else
                subjectLevelService.save(subjectLevel);
        }
        return SUCCESS;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.reqMap = map;
    }

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }

    public List<SubjectLevel> getSubjectLevelList() {
        return subjectLevelList;
    }

    public void setSubjectLevelList(List<SubjectLevel> subjectLevelList) {
        this.subjectLevelList = subjectLevelList;
    }

}
