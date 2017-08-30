package com.briup.exam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.briup.exam.bean.Topic;

@Repository
public class TopicDao extends BaseDao<Topic> {

    // 因为属性名不一样，所以重写findByName方法
    @Override
    public List<Topic> findByName(String name) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        return criteria.add(Restrictions.eq("title", name)).list();
    }
}
