package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.Choice;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.ChoiceDao;
import com.briup.exam.service.IChoiceService;

@Service
public class ChoiceServiceImpl implements IChoiceService {
    @Autowired
    private ChoiceDao choiceDao;

    @Override
    public Choice findById(Long id) {
        // TODO Auto-generated method stub
        return choiceDao.findById(id);
    }

    @Override
    public List<Choice> findByName(String name) {
        // TODO Auto-generated method stub
        return choiceDao.findByName(name);
    }

    @Override
    public List<Choice> findAll(Order... orders) {
        // TODO Auto-generated method stub
        return choiceDao.findAll(orders);
    }

    @Override
    public List<Choice> findAll(IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Choice> findByExample(Choice model, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Choice> findByExample(Choice model, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Choice> findByCriteria(Criteriable criteriaObj, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Choice> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Choice findUnique(Choice model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Choice model) {
        // TODO Auto-generated method stub
        choiceDao.save(model);
    }

    @Override
    public void batchSave(List<Choice> models) {
        // TODO Auto-generated method stub
    }

    @Override
    public void saveOrUpdate(Choice model) {
        // TODO Auto-generated method stub
        choiceDao.saveOrUpdate(model);
    }

    @Override
    public void update(Choice model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteObject(Choice model) {
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
    public void batchDeleteModel(List<Choice> models) {
        // TODO Auto-generated method stub

    }

}
