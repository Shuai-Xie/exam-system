package com.briup.exam.service.impl;

import java.util.List;

import com.briup.exam.dao.PaperSubjectDao;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.PaperSubject;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.service.IPaperSubjectService;

@Service
public class PaperSubjectServiceImpl implements IPaperSubjectService {

    @Autowired
    private PaperSubjectDao paperSubjectDao;

    @Override
    public PaperSubject findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PaperSubject> findAll(Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PaperSubject> findAll(IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PaperSubject> findByExample(PaperSubject model, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PaperSubject> findByExample(PaperSubject model, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PaperSubject> findByCriteria(Criteriable criteriaObj, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PaperSubject> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PaperSubject findUnique(PaperSubject model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(PaperSubject model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void batchSave(List<PaperSubject> models) {
        // TODO Auto-generated method stub
        paperSubjectDao.batchSave(models);
    }

    @Override
    public void saveOrUpdate(PaperSubject model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(PaperSubject model) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteObject(PaperSubject model) {
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
    public void batchDeleteModel(List<PaperSubject> models) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<PaperSubject> findByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

}
