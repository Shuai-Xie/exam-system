package com.briup.exam.common.util.page;

import com.briup.exam.common.util.IPageInfo;



/**
 * 分页信息实现类
 * */
public class PageInfo implements IPageInfo {
	public PageInfo() {
	}

	public PageInfo(int pageNo, int pageSize) {
		super();
		this.offset = pageSize * pageNo;
		this.pageSize = pageSize;
	}


	/**
	 * 每页第一条数据的位置
	 */
	private int offset;

	/**
	 * 记录总条数
	 */
	private long totalCount;

	/**
	 * 每页显示记录最大数
	 */
	private int pageSize = DEFAULT_PAGE_SIZE;

	public int getPageCount() {
		return (int) Math.ceil((0.0 + this.totalCount) / this.pageSize);
	}

	public int getOffset() {
		return this.offset;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置从第几条开始
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
