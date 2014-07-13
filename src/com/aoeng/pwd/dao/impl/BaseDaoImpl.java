package com.aoeng.pwd.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.aoeng.pwd.SystemContext;
import com.aoeng.pwd.dao.BaseDao;
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource(name = "sessionFactory")
	protected SessionFactory sf;
	private Class<T> clazz;

	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.huigu.service.BaseService#saveEntity(java.lang.Object)
	 */
	@Override
	public void saveEntity(T t) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.huigu.service.BaseService#updateEntity(java.lang.Object)
	 */
	@Override
	public void updateEntity(T t) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.huigu.service.BaseService#delEntity(java.lang.Object)
	 */
	@Override
	public void delEntity(T t) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aoeng.huigu.service.BaseService#saveOrUpdateEntity(java.lang.Object)
	 */
	@Override
	public void saveOrUpdateEntity(T t) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().saveOrUpdate(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.huigu.service.BaseService#findEntity(java.lang.Integer)
	 */
	@Override
	public T findEntity(Integer id) {
		// TODO Auto-generated method stub
		return (T) sf.getCurrentSession().get(clazz, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.huigu.service.BaseService#loadEntity(java.lang.Integer)
	 */
	@Override
	public T loadEntity(Integer id) {
		// TODO Auto-generated method stub
		return (T) sf.getCurrentSession().load(clazz, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aoeng.huigu.service.BaseService#findEntityByHql(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public List<T> findEntityByHql(String hql, Object... objs) {
		// TODO Auto-generated method stub
		Query query = sf.getCurrentSession().createQuery(hql);
		if (null != objs && objs.length > 0) {
			for (int i = 0; i < objs.length; i++) {
				query.setParameter(i, objs[i]);
			}
		}
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aoeng.huigu.service.BaseService#batchEntityByHql(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public void batchEntityByHql(String hql, Object... objs) {
		// TODO Auto-generated method stub
		Query query = sf.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objs.length; i++) {
			query.setParameter(i, objs[i]);
		}
		query.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.huigu.dao.BaseDao#findEntityByHqlLimit(java.lang.String,
	 * int[], java.lang.Object)
	 */
	@Override
	public List<T> findEntityByHqlTop(String hql, Object... objs) {
		// TODO Auto-generated method stub
		Query query = sf.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objs.length; i++) {
			query.setParameter(i, objs[i]);
		}
		query.setFirstResult(SystemContext.getOffSet());
		query.setMaxResults(SystemContext.getPageSize());
		return query.list();
	}

}
