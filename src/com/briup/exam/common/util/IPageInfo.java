package com.briup.exam.common.util;

/**
 * 分页信息接口
 */
public interface IPageInfo {
	/**
	 * 默认每页显示最大数
	 */
	public static final int DEFAULT_PAGE_SIZE = 10;

	/**
	 * 获取记录总条数
	 */
	long getTotalCount();

	/**
	 * 获取每页显示记录最大数
	 */
	int getPageSize();

	/**
	 * 获取每页起始数据的位置
	 */
	int getOffset();
	
	/**
	 * 设置记录总条数
	 */
	void setTotalCount(long totalCount);

	/**
	 * 设置每页显示记录最大数
	 */
	void setPageSize(int pageSize);
	
	/**
	 * 获取每页起始数据的位置
	 */
	void setOffset(int offset);
}
