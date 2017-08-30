package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.Paper;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.PaperDao;
import com.briup.exam.service.IPaperService;

@Service
public class PaperServiceImpl implements IPaperService {

    @Autowired
    private PaperDao paperDao;

    @Override
    public Paper findById(Long id) {
        // TODO Auto-generated method stub
        return paperDao.findById(id);
    }

    @Override
    public List<Paper> findByName(String name) {
        // TODO Auto-generated method stub
        return paperDao.findByName(name);
    }

    @Override
    public List<Paper> findAll(Order... orders) {
        // TODO Auto-generated method stub
        return paperDao.findAll(orders);
    }

    @Override
    public List<Paper> findAll(IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Paper> findByExample(Paper model, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Paper> findByExample(Paper model, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Paper> findByCriteria(Criteriable criteriaObj, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Paper> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Paper findUnique(Paper model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Paper model) {
        // TODO Auto-generated method stub
        paperDao.save(model);
    }

    @Override
    public void batchSave(List<Paper> models) {
        // TODO Auto-generated method stub
        paperDao.batchSave(models);
    }

    @Override
    public void saveOrUpdate(Paper model) {
        // TODO Auto-generated method stub
        paperDao.saveOrUpdate(model);
    }

    @Override
    public void update(Paper model) {
        // TODO Auto-generated method stub
        paperDao.update(model);
    }

    @Override
    public void deleteObject(Paper model) {
        // TODO Auto-generated method stub
        paperDao.delete(model);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        paperDao.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> ids) {
        // TODO Auto-generated method stub
        paperDao.batchDelete(ids);
    }

    @Override
    public void batchDelete(Long[] ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void batchDeleteModel(List<Paper> models) {
        // TODO Auto-generated method stub
        paperDao.batchDeleteModel(models);
    }

}
