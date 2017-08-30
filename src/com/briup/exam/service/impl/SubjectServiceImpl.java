package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.Subject;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.criteria.SubjectCriteria;
import com.briup.exam.dao.SubjectDao;
import com.briup.exam.service.ISubjectService;

@Service
public class SubjectServiceImpl implements ISubjectService {
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public Subject findById(Long id) {
        // TODO Auto-generated method stub
        return subjectDao.findById(id);
    }

    @Override
    public List<Subject> findByName(String name) {
        // TODO Auto-generated method stub
        return subjectDao.findByName(name);
    }

    @Override
    public List<Subject> findAll(Order... orders) {
        // TODO Auto-generated method stub
        return subjectDao.findAll(orders);
    }

    @Override
    public List<Subject> findAll(IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Subject> findByExample(Subject model, Order... orders) {
        // TODO Auto-generated method stub
        return subjectDao.findByExample(model, orders);
    }

    @Override
    public List<Subject> findByExample(Subject model, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Subject> findByCriteria(Criteriable criteriaObj, Order... orders) {
        // TODO Auto-generated method stub
        return subjectDao.findByCriteria(criteriaObj, orders);
    }

    @Override
    public List<Subject> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Subject findUnique(Subject model) {
        // TODO Auto-generated method stub
        return subjectDao.findUnique(model);
    }

    @Override
    public void save(Subject model) {
        // TODO Auto-generated method stub
        subjectDao.save(model);
    }

    @Override
    public void batchSave(List<Subject> models) {
        // TODO Auto-generated method stub
        subjectDao.batchSave(models);
    }

    @Override
    public void saveOrUpdate(Subject model) {
        // TODO Auto-generated method stub
        subjectDao.saveOrUpdate(model);
    }

    @Override
    public void update(Subject model) {
        // TODO Auto-generated method stub
        subjectDao.update(model);
    }

    @Override
    public void deleteObject(Subject model) {
        // TODO Auto-generated method stub
        subjectDao.delete(model);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        subjectDao.delete(subjectDao.findById(id));
    }

    @Override
    public void batchDelete(List<Long> ids) {
        // TODO Auto-generated method stub
        subjectDao.batchDelete(ids);
    }

    @Override
    public void batchDelete(Long[] ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void batchDeleteModel(List<Subject> models) {
        // TODO Auto-generated method stub
        subjectDao.batchDeleteModel(models);
    }

}
