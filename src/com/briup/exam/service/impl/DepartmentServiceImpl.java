package com.briup.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.exam.bean.Department;
import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.dao.DepartmentDao;
import com.briup.exam.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Department findById(Long id) {
        // TODO Auto-generated method stub
        return departmentDao.findById(id);
    }

    @Override
    public List<Department> findByName(String name) {
        // TODO Auto-generated method stub
        return departmentDao.findByName(name);
    }

    @Override
    public List<Department> findAll(Order... orders) {
        // TODO Auto-generated method stub
        return departmentDao.findAll(orders);
    }

    @Override
    public List<Department> findAll(IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Department> findByExample(Department model, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Department> findByExample(Department model, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Department> findByCriteria(Criteriable criteriaObj, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Department> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Department findUnique(Department model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Department model) {
        // TODO Auto-generated method stub
        departmentDao.save(model);
    }

    @Override
    public void batchSave(List<Department> models) {
        // TODO Auto-generated method stub
        departmentDao.batchSave(models);
    }

    @Override
    public void saveOrUpdate(Department model) {
        // TODO Auto-generated method stub
        departmentDao.saveOrUpdate(model);
    }

    @Override
    public void update(Department model) {
        // TODO Auto-generated method stub
        departmentDao.update(model);
    }

    @Override
    public void deleteObject(Department model) {
        // TODO Auto-generated method stub
        departmentDao.delete(model);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        departmentDao.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> ids) {
        // TODO Auto-generated method stub
        departmentDao.batchDelete(ids);
    }

    @Override
    public void batchDelete(Long[] ids) {
        // TODO Auto-generated method stub
    }

    @Override
    public void batchDeleteModel(List<Department> models) {
        // TODO Auto-generated method stub
        departmentDao.batchDeleteModel(models);
    }
}
