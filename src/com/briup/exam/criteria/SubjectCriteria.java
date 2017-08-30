package com.briup.exam.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.briup.exam.bean.Subject;
import com.briup.exam.common.util.Criteriable;

/**
 * 题干模板类9
 */
public class SubjectCriteria implements Criteriable {

    private Subject subject;

    @Override
    public Criteria getExampleCriteria(Session session) {
        Criteria subjectCriteria = session.createCriteria(subject.getClass());

        if (subject.getStem() != null) {
            subjectCriteria.add(Restrictions.like("stem", "%" + subject.getStem() + "%"));
        }
        if (subject.getCheckState() != null) {
            subjectCriteria.add(Restrictions.like("checkState", subject.getCheckState()));
        }
        if (subject.getSubjectLevel() != null) {
            long id = subject.getSubjectLevel().getId();
            subjectCriteria.createCriteria("subjectLevel").add(Restrictions.eq("id", id));
        }
        if (subject.getSubjectType() != null) {
            long id = subject.getSubjectType().getId();
            subjectCriteria.createCriteria("subjectType").add(Restrictions.eq("id", id));
        }
        if (subject.getDepartment() != null) {
            long id = subject.getDepartment().getId();
            subjectCriteria.createCriteria("department").add(Restrictions.eq("id", id));
        }
        if (subject.getTopic() != null) {
            long id = subject.getTopic().getId();
            subjectCriteria.createCriteria("topic").add(Restrictions.eq("id", id));
        }
        return subjectCriteria;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
