package com.briup.exam.web.listener;

import com.briup.exam.bean.Department;
import com.briup.exam.bean.SubjectLevel;
import com.briup.exam.bean.SubjectType;
import com.briup.exam.bean.Topic;
import com.briup.exam.service.impl.DepartmentServiceImpl;
import com.briup.exam.service.impl.SubjectLevelServiceImpl;
import com.briup.exam.service.impl.SubjectTypeServiceImpl;
import com.briup.exam.service.impl.TopicServiceImpl;
import org.hibernate.criterion.Order;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 当应用启动时，加载所有的subjectLevel subjectType	department topic 到application中
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    /**
     * Default constructor.
     */
    public ApplicationListener() {

    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {

//        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
//        ServletContext application = arg0.getServletContext(); // 定义 application 最后不用跳

        // 因为实现类里面有注解，所以new不可以，通过spring注入的方法获取对象

//        // 题目类型
//        SubjectTypeServiceImpl subjectTypeService = (SubjectTypeServiceImpl) webApplicationContext.getBean("subjectTypeServiceImpl");
//        List<SubjectType> subjectTypes = subjectTypeService.findAll(Order.asc("id"));
//        List<String> typeList = new ArrayList<>();
//        for (SubjectType t : subjectTypes) {
//            typeList.add(t.getRealName());
//        }
//        application.setAttribute("typeList", typeList);
//
//
//        // 题目难度
//        SubjectLevelServiceImpl subjectLevelService = (SubjectLevelServiceImpl) webApplicationContext.getBean("subjectLevelServiceImpl");
//        List<SubjectLevel> subjectLevels = subjectLevelService.findAll(Order.asc("id"));
//        List<String> levelList = new ArrayList<>();
//        for (SubjectLevel l : subjectLevels) {
//            levelList.add(l.getRealName());
//        }
//        application.setAttribute("levelList", levelList);
//
//        // 所属方向
//        DepartmentServiceImpl departmentService = (DepartmentServiceImpl) webApplicationContext.getBean("departmentServiceImpl");
//        List<Department> departments = departmentService.findAll(Order.asc("id"));
//        List<String> departmentList = new ArrayList<>();
//        for (Department d : departments) {
//            departmentList.add(d.getName());
//        }
//        application.setAttribute("departmentList", departmentList);
//
//        // 所属知识点
//        TopicServiceImpl topicService = (TopicServiceImpl) webApplicationContext.getBean("topicServiceImpl");
//        List<Topic> topics = topicService.findAll(Order.asc("id"));
//        List<String> topicList = new ArrayList<>();
//        for (Topic t : topics) {
//            topicList.add(t.getTitle());
//        }
//        application.setAttribute("topicList", topicList);

    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {

    }
}
