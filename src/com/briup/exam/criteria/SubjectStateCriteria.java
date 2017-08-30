package com.briup.exam.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.briup.exam.bean.Subject;
import com.briup.exam.common.util.Criteriable;

public class SubjectStateCriteria implements Criteriable {
    private Subject subject;

    @Override
    public Criteria getExampleCriteria(Session session) {
        // TODO Auto-generated method stub
        Criteria criteria = session.createCriteria(Subject.class);
        criteria.add(Restrictions.eq("checkState", subject.getCheckState()));
        return criteria;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


}
