package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.SubjectLevel;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.SubjectLevelDao;
import com.briup.exam.service.ISubjectLevelService;

@Service
public class SubjectLevelServiceImpl implements ISubjectLevelService {

    @Autowired
    private SubjectLevelDao subjectLevelDao;

    @Override
    public SubjectLevel findById(Long id) {
        // TODO Auto-generated method stub
        return subjectLevelDao.findById(id);
    }

    @Override
    public List<SubjectLevel> findByName(String name) {
        // TODO Auto-generated method stub
        return subjectLevelDao.findByName(name);
    }

    @Override
    public List<SubjectLevel> findAll(Order... orders) {
        // TODO Auto-generated method stub
        return subjectLevelDao.findAll(orders);
    }

    @Override
    public List<SubjectLevel> findAll(IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SubjectLevel> findByExample(SubjectLevel model, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SubjectLevel> findByExample(SubjectLevel model, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SubjectLevel> findByCriteria(Criteriable criteriaObj, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SubjectLevel> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SubjectLevel findUnique(SubjectLevel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(SubjectLevel model) {
        // TODO Auto-generated method stub
        subjectLevelDao.save(model);
    }

    @Override
    public void batchSave(List<SubjectLevel> models) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveOrUpdate(SubjectLevel model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(SubjectLevel model) {
        // TODO Auto-generated method stub
        subjectLevelDao.update(model);
    }

    @Override
    public void deleteObject(SubjectLevel model) {
        // TODO Auto-generated method stub
        subjectLevelDao.delete(model);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        subjectLevelDao.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> ids) {
        // TODO Auto-generated method stub
        subjectLevelDao.batchDelete(ids);
    }

    @Override
    public void batchDelete(Long[] ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void batchDeleteModel(List<SubjectLevel> models) {
        // TODO Auto-generated method stub
        subjectLevelDao.batchDeleteModel(models);
    }

}
