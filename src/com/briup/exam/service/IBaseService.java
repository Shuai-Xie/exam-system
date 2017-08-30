package com.briup.exam.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Order;

import com.briup.exam.common.util.Criteriable;
import com.briup.exam.common.util.IPageInfo;


public interface IBaseService<M extends Serializable> {

    /**
     * 根据id查询唯一对象
     *
     * @param id
     * @return
     */
    M findById(Long id);

    /**
     * 查询所有
     *
     * @return
     */
    List<M> findAll(Order... orders);

    /**
     * 查询所有（带分页、排序）
     *
     * @param pageInfo
     * @param orders
     * @return
     */
    List<M> findAll(IPageInfo pageInfo, Order... orders);

    /**
     * 根据对象查询
     *
     * @param model
     * @return
     */
    List<M> findByExample(M model, Order... orders);

    /**
     * 根据对象查询（带分页、排序）
     *
     * @param model
     * @return
     */
    List<M> findByExample(M model, IPageInfo pageInfo, Order... orders);

    /**
     * 根据Criteria查询
     *
     * @param criteriaObj
     * @return
     */
    List<M> findByCriteria(Criteriable criteriaObj, Order... orders);

    /**
     * 根据Criteria查询（带分页、排序）
     *
     * @param criteriaObj
     * @return
     */
    List<M> findByCriteria(Criteriable criteriaObj, IPageInfo pageInfo, Order... orders);

    /**
     * 根据对象查询唯一对象
     *
     * @param model
     * @return
     */
    M findUnique(M model);

    /**
     * 保存
     *
     * @param model
     */
    void save(M model);

    /**
     * 批量保存
     *
     * @param model
     */
    void batchSave(List<M> models);

    /**
     * 保存或者更新
     *
     * @param model
     */
    void saveOrUpdate(M model);

    /**
     * 更新
     *
     * @param model
     */
    void update(M model);

    /**
     * 根据对象删除
     *
     * @param model
     */
    void deleteObject(M model);

    /**
     * 根据id查询
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void batchDelete(List<Long> ids);

    /**
     * 批量删除
     *
     * @param ids
     */
    void batchDelete(Long[] ids);

    /**
     * 批量删除
     *
     * @param models
     */
    void batchDeleteModel(List<M> models);

    List<M> findByName(String name);

}
