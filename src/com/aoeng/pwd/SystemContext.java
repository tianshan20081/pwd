package com.aoeng.pwd;

import org.apache.commons.lang3.StringUtils;

public class SystemContext {
	private static ThreadLocal offSet = new ThreadLocal();
	private static ThreadLocal pageSize = new ThreadLocal();

	/**
	 * @return the offSet
	 */
	public static int getOffSet() {
		Integer _offSet = (Integer) offSet.get();
		if (null == _offSet) {
			return 0;
		}
		return _offSet;
	}

	/**
	 * @param offSet
	 *            the offSet to set
	 */
	public static void setOffSet(String _offSet) {
		offSet.set(StringUtils.isEmpty(_offSet) ? 0 : Integer.valueOf(_offSet));
	}

	/**
	 * @return the pageSize
	 */
	public static int getPageSize() {
		Integer _pageSize = (Integer) pageSize.get();
		if (null == _pageSize) {
			return 0;
		}
		return _pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public static void setPageSize(String _pageSize) {
		pageSize.set(StringUtils.isEmpty(_pageSize)
				|| Integer.valueOf(_pageSize) == 0 ? 10 : Integer
				.valueOf(_pageSize));
	}

	public static void removeOffSet() {
		offSet.remove();
	}

	public static void removePageSize() {
		pageSize.remove();
	}

}
