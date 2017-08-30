package com.briup.exam.dao;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


/**
 * 基本dao类，其他dao可以继承该基础类，然后调用现有的增删改查方法
 */
@Repository("baseDao")
@SuppressWarnings("unchecked")
public class BaseDao<M extends java.io.Serializable> {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 根据 IBaseService 接口中声明的方法编写 BaseDao 要实现的方法
     * 这些方法将在 实体 Service 实现类 中被 实体 Dao 类 调用
     */

    // 获得 实体的 Class 类对象
    // Class<?> c = customer.getClass();
    public Class<M> getEntityClass() {
        // getClass()不是BaseDao调用，而是继承了BaseDao的其他Dao，如SubjectDao
        // SubjectDao extends BaseDao<Subject>
        // pt = BaseDao<Subject>
        // (Class<M>)pt.getActualTypeArguments()[0] = Subject (Type -> Class类型)
        ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass(); // 泛型类 参数化类型
        return (Class<M>) pt.getActualTypeArguments()[0]; // 只有一个泛型类
    }

    public M findById(long id) {
        Criteria criteria = getSession().createCriteria(getEntityClass()); // 泛型拿到类的Class对象
        List<M> list = criteria.add(Restrictions.eq("id", id)).list();
        return list.isEmpty() ? null : list.get(0); // 防爆装置
    }

    public List<M> findByName(String name) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        return criteria.add(Restrictions.eq("name", name)).list();
    }

    public List<M> findAll(Order... orders) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        for (Order o : orders) {
            criteria.addOrder(o);
        }
        return criteria.list();
    }

    public void batchSave(List<M> list) {
        for (M m : list) save(m);
    }

    public void batchDelete(List<Long> list) {
        for (Long l : list) deleteById(l);
    }

    public void saveOrUpdate(M m) {
        getSession().saveOrUpdate(m);
    }

    public void save(M m) {
        getSession().save(m);
    }

    public void update(M m) {
        getSession().update(m);
    }

    public void delete(M m) {
        getSession().delete(m);
    }

    public void deleteById(long id) {
        delete(findById(id));
    }

    public void batchDeleteModel(List<M> models) {
        for (M m : models) delete(m);
    }


}
