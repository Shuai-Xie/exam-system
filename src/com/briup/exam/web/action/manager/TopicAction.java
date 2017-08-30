package com.briup.exam.web.action.manager;

import java.util.List;
import java.util.Map;

import com.briup.exam.service.impl.TopicServiceImpl;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.briup.exam.bean.Topic;
import com.briup.exam.service.IDepartmentService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class TopicAction extends ActionSupport implements RequestAware {

    @Autowired
    private TopicServiceImpl topicService;

    @Autowired
    private IDepartmentService departmentService;

    private Order[] orders = {Order.asc("id")};
    private List<Long> list;
    private List<Topic> topicList;

    private Map<String, Object> reqMap;

    @Action(value = "/showTopic", results = {
            @Result(location = "/WEB-INF/jsp/manager/topicManager.jsp")})
    public String showTopic() {
        System.out.println("in showTopic...");
        topicList = topicService.findAll(orders);
        reqMap.put("topicList", topicList);
        return SUCCESS;
    }

    @Action(value = "/deleteTopic", results = {
            @Result(location = "/showTopic.action", type = "redirectAction")})
    public String deleteTopic() {
        System.out.println("in deleteTopic...");
        if (list.isEmpty()) {
            System.out.println("error!");
        } else {
            topicService.batchDelete(list);
        }
        return SUCCESS;
    }

    @Action(value = "/saveTopic", results = {
            @Result(location = "/showTopic.action", type = "redirectAction")})
    public String saveTopic() {
        System.out.println("in saveTopic...");

        System.out.println(topicList);

        if (!topicList.isEmpty()) {
            for (Topic topic : topicList) {
                if (topicService.findById(topic.getId()) != null) {
                    // System.out.println("1");
                    Topic tmp = topicService.findById(topic.getId());
                    tmp.setTitle(topic.getTitle());
                    tmp.setDepartment(departmentService.findByName(topic.getDepartment().getName()).get(0));
                    topicService.update(tmp);
                } else {
                    topic.setDepartment(departmentService.findByName(topic.getDepartment().getName()).get(0));
                    topicService.save(topic);
                }
            }
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

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }
}
