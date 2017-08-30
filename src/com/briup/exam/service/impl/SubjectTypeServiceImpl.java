package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.SubjectType;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.SubjectTypeDao;
import com.briup.exam.service.ISubjectTypeService;

@Service
public class SubjectTypeServiceImpl implements ISubjectTypeService {
    @Autowired
    private SubjectTypeDao subjectTypeDao;

    @Override
    public SubjectType findById(Long id) {
        // TODO Auto-generated method stub
        return subjectTypeDao.findById(id);
    }

    @Override
    public List<SubjectType> findByName(String name) {
        // TODO Auto-generated method stub
        return subjectTypeDao.findByName(name);
    }

    @Override
    public List<SubjectType> findAll(Order... orders) {
        // TODO Auto-generated method stub
        return subjectTypeDao.findAll(orders);
    }

    @Override
    public List<SubjectType> findAll(IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SubjectType> findByExample(SubjectType model, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SubjectType> findByExample(SubjectType model, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SubjectType> findByCriteria(Criteriable criteriaObj, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SubjectType> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SubjectType findUnique(SubjectType model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(SubjectType model) {
        // TODO Auto-generated method stub
        subjectTypeDao.save(model);
    }

    @Override
    public void batchSave(List<SubjectType> models) {
        // TODO Auto-generated method stub
        subjectTypeDao.batchSave(models);
    }

    @Override
    public void saveOrUpdate(SubjectType model) {
        // TODO Auto-generated method stub
        subjectTypeDao.saveOrUpdate(model);
    }

    @Override
    public void update(SubjectType model) {
        // TODO Auto-generated method stub
        subjectTypeDao.update(model);
    }

    @Override
    public void deleteObject(SubjectType model) {
        // TODO Auto-generated method stub
        subjectTypeDao.delete(model);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        subjectTypeDao.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> ids) {
        // TODO Auto-generated method stub
        subjectTypeDao.batchDelete(ids);
    }

    @Override
    public void batchDelete(Long[] ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void batchDeleteModel(List<SubjectType> models) {
        // TODO Auto-generated method stub=
        subjectTypeDao.batchDeleteModel(models);
    }

}
