package com.aoeng.pwd.action;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>,
		Preparable {

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	private static final long serialVersionUID = 6725295240069040763L;
	protected T model;

	public BaseAction() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class<T> clazz = (Class) type.getActualTypeArguments()[0];
			model = clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */

	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	public void ret(String msg) {
		print(msg);
	}

	/**
	 * @param msg
	 */
	private void print(String msg) {
		// TODO Auto-generated method stub
		// try {
		// ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		// ServletActionContext.getResponse().getWriter().print(msg);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}
}
