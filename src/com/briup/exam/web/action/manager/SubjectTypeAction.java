package com.briup.exam.web.action.manager;

import java.util.List;
import java.util.Map;

import com.briup.exam.service.impl.SubjectTypeServiceImpl;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.briup.exam.bean.SubjectType;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class SubjectTypeAction extends ActionSupport implements RequestAware {

    @Autowired
    private SubjectTypeServiceImpl subjectTypeService;

    private Order[] orders = {Order.asc("id")};
    private List<Long> list;
    private List<SubjectType> subjectTypeList;

    private Map<String, Object> reqMap;

    @Action(value = "/showSubjectType", results = {
            @Result(location = "/WEB-INF/jsp/manager/subjectTypeManager.jsp")})
    public String showSubjectType() {
        System.out.println("in showST...");
        subjectTypeList = subjectTypeService.findAll(orders);
        reqMap.put("subjectTypeList", subjectTypeList);
        return SUCCESS;
    }

    @Action(value = "/deleteSubjectType", results = {
            @Result(location = "/showSubjectType.action", type = "redirectAction")})
    public String deleteSubjectType() {
        if (list != null && !list.isEmpty()) {
            subjectTypeService.batchDelete(list);
        }
        return SUCCESS;
    }

    @Action(value = "/saveSubjectType", results = {
            @Result(location = "/showSubjectType.action", type = "redirectAction")})
    public String saveSubjectType() {
        System.out.println("in saveSubjectType...");
        for (SubjectType subjectType : subjectTypeList) {
            System.out.println(subjectType);
            if (subjectTypeService.findById(subjectType.getId()) != null) {
                SubjectType tmp = subjectTypeService.findById(subjectType.getId());
                tmp.setName(subjectType.getName());
                tmp.setRealName(subjectType.getRealName());
                subjectTypeService.update(tmp);
            } else
                subjectTypeService.save(subjectType);
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

    public List<SubjectType> getSubjectTypeList() {
        return subjectTypeList;
    }

    public void setSubjectTypeList(List<SubjectType> subjectTypeList) {
        this.subjectTypeList = subjectTypeList;
    }
}
