package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.User;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.UserDao;
import com.briup.exam.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findById(Long id) {
        // TODO Auto-generated method stub
        return userDao.findById(id);
    }

    @Override
    public List<User> findByName(String name) {
        // TODO Auto-generated method stub
        return userDao.findByName(name);
    }

    @Override
    public List<User> findAll(Order... orders) {
        // TODO Auto-generated method stub
        return userDao.findAll(orders);
    }

    @Override
    public List<User> findAll(IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findByExample(User model, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findByExample(User model, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findByCriteria(Criteriable criteriaObj, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findUnique(User model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(User model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void batchSave(List<User> models) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveOrUpdate(User model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(User model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteObject(User model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void batchDelete(List<Long> ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void batchDelete(Long[] ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void batchDeleteModel(List<User> models) {
        // TODO Auto-generated method stub

    }

}
