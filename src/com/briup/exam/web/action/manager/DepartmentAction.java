package com.briup.exam.web.action.manager;

import java.util.List;
import java.util.Map;

import com.briup.exam.service.impl.DepartmentServiceImpl;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.briup.exam.bean.Department;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by shuai
 * on 2017/8/23.
 */
@Controller
public class DepartmentAction extends ActionSupport implements RequestAware {

    @Autowired
    private DepartmentServiceImpl departmentService;

    private Order[] orders = {Order.asc("id")};
    private List<Long> list;
    private List<Department> departmentList;

    private Map<String, Object> reqMap; // 传值


    @Action(value = "/showDepartment", results = {
            @Result(location = "/WEB-INF/jsp/manager/departmentManager.jsp")})
    public String showDepartment() {
        System.out.println("in showDepartment...");
        departmentList = departmentService.findAll(orders);
        reqMap.put("departmentList", departmentList);
        return SUCCESS;
    }

    @Action(value = "/deleteDepartment", results = {
            @Result(location = "/showDepartment", type = "redirectAction")})
    public String deleteDepartment() {
        System.out.println("in deleteDepartment...");
        if (list.isEmpty()) System.out.println("error!");
        else departmentService.batchDelete(list);
        return SUCCESS;
    }

    @Action(value = "/saveDepartment", results = {
            @Result(location = "/showDepartment", type = "redirectAction")})
    public String saveDepartment() {
        System.out.println("in saveDepartment...");

        System.out.println(departmentList);

        if (!departmentList.isEmpty()) {

            for (Department department : departmentList) {
                if (departmentService.findById(department.getId()) != null) { // 数据
                    // System.out.println("1");
                    Department tmp = departmentService.findById(department.getId());
                    tmp.setName(department.getName());
                    departmentService.update(tmp);
                } else
                    departmentService.save(department);
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

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

}
