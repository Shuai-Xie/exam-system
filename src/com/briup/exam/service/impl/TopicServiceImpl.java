package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.Topic;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.TopicDao;
import com.briup.exam.service.ITopicService;

@Service
public class TopicServiceImpl implements ITopicService {
    @Autowired
    private TopicDao topicDao;

    @Override
    public Topic findById(Long id) {
        // TODO Auto-generated method stub
        return topicDao.findById(id);
    }

    @Override
    public List<Topic> findByName(String name) {
        // TODO Auto-generated method stub
        return topicDao.findByName(name);
    }

    @Override
    public List<Topic> findAll(Order... orders) {
        // TODO Auto-generated method stub
        return topicDao.findAll(orders);
    }

    @Override
    public List<Topic> findAll(IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Topic> findByExample(Topic model, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Topic> findByExample(Topic model, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Topic> findByCriteria(Criteriable criteriaObj, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Topic> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Topic findUnique(Topic model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Topic model) {
        // TODO Auto-generated method stub
        topicDao.save(model);
    }

    @Override
    public void batchSave(List<Topic> models) {
        // TODO Auto-generated method stub
        topicDao.batchSave(models);
    }

    @Override
    public void saveOrUpdate(Topic model) {
        // TODO Auto-generated method stub
        topicDao.saveOrUpdate(model);
    }

    @Override
    public void update(Topic model) {
        // TODO Auto-generated method stub
        topicDao.update(model);
    }

    @Override
    public void deleteObject(Topic model) {
        // TODO Auto-generated method stub
        topicDao.delete(model);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        topicDao.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> ids) {
        // TODO Auto-generated method stub
        topicDao.batchDelete(ids);
    }

    @Override
    public void batchDelete(Long[] ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void batchDeleteModel(List<Topic> models) {
        // TODO Auto-generated method stub
        topicDao.batchDeleteModel(models);
    }

}
