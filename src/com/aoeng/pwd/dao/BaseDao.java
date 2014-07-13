package com.aoeng.pwd.dao;

import java.util.List;
@SuppressWarnings("unchecked")
public interface BaseDao<T> {
	void saveEntity(T t);

	void updateEntity(T t);

	void delEntity(T t);

	void saveOrUpdateEntity(T t);

	T findEntity(Integer id);

	T loadEntity(Integer id);

	List<T> findEntityByHql(String hql, Object... objs);

	// hql 批处理实体
	void batchEntityByHql(String hql, Object... objs);

	List<T> findEntityByHqlTop(String hql, Object... objs);
}
