package com.aoeng.pwd.service;

import java.util.List;

public interface BaseService<T> {
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
