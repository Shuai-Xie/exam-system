package com.briup.exam.web.action.manager;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import com.briup.exam.bean.Department;
import com.briup.exam.bean.SubjectLevel;
import com.briup.exam.bean.Topic;
import com.briup.exam.service.IDepartmentService;
import com.briup.exam.service.ISubjectLevelService;
import com.briup.exam.service.ISubjectTypeService;
import com.briup.exam.service.ITopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 基础action
 */
public class BaseAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ISubjectLevelService service1;
    @Autowired
    private ISubjectTypeService service2;
    @Autowired
    private ITopicService service3;
    @Autowired
    private IDepartmentService service4;

    /**
     * 回写JSON
     */
    public void responseJSON(String json) {
        HttpServletResponse response = ServletActionContext.getResponse();
        //response.addHeader("Accept-Control-Allow-Origin", "http://172.18.8.1");
        //http://127.0.0.1
        //同源策略
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改 level department topic 后更新application中的数据
     */
    public void updateApplication() {
        ActionContext ac = ActionContext.getContext();

        Map<String, Object> app = ac.getApplication();
        List<SubjectLevel> level = service1.findAll(Order.asc("id"));
        List<Topic> topic = service3.findAll(Order.asc("id"));
        List<Department> department = service4.findAll(Order.asc("id"));

        app.put("level", level);
        app.put("topic", topic);
        app.put("department", department);
    }


    public ISubjectLevelService getService1() {
        return service1;
    }

    public void setService1(ISubjectLevelService service1) {
        this.service1 = service1;
    }

    public ISubjectTypeService getService2() {
        return service2;
    }

    public void setService2(ISubjectTypeService service2) {
        this.service2 = service2;
    }

    public ITopicService getService3() {
        return service3;
    }

    public void setService3(ITopicService service3) {
        this.service3 = service3;
    }

    public IDepartmentService getService4() {
        return service4;
    }

    public void setService4(IDepartmentService service4) {
        this.service4 = service4;
    }
}
