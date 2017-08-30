package com.briup.exam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.briup.exam.bean.Subject;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.criteria.SubjectCriteria;

@Repository
public class SubjectDao extends BaseDao<Subject> {

    public List<Subject> findByExample(Subject model, Order... orders) {
        SubjectCriteria subjectCriteria = new SubjectCriteria();
        subjectCriteria.setSubject(model);
        Criteria criteria = subjectCriteria.getExampleCriteria(getSession());
        for (Order o : orders) criteria.addOrder(o);
        return criteria.list();
    }

    public Subject findUnique(Subject model) {
        SubjectCriteria subjectCriteria = new SubjectCriteria();
        subjectCriteria.setSubject(model);
        Criteria criteria = subjectCriteria.getExampleCriteria(getSession());
        List<Subject> list = criteria.list();
        return list.get(0);
    }

    public List<Subject> findByCriteria(Criteriable criteriaObj, Order... orders) {
        Criteria criteria = criteriaObj.getExampleCriteria(getSession());
        for (Order o : orders) criteria.addOrder(o);
        return criteria.list();
    }
}
