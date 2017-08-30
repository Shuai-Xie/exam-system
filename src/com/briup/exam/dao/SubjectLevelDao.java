package com.briup.exam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.briup.exam.bean.SubjectLevel;

@Repository
public class SubjectLevelDao extends BaseDao<SubjectLevel> {
    @Override
    public List<SubjectLevel> findByName(String name) {
        // TODO Auto-generated method stub
        Criteria criteria = getSession().createCriteria(getEntityClass());
        return criteria.add(Restrictions.eq("realName", name)).list();
    }
}
