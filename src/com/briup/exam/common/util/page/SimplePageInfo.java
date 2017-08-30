package com.briup.exam.common.util.page;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.briup.exam.common.util.IPageInfo;
import com.briup.exam.common.util.WebUtil;



public class SimplePageInfo implements IPageInfo {
	public SimplePageInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.currentPage = WebUtil.getParameter(request, "pageNo", 0);
		this.offset = WebUtil.getParameter(request, "offset", 0);
	}

	public SimplePageInfo(HttpServletRequest request) {
		this.currentPage = WebUtil.getParameter(request, "pageNo", 0);
	}

	private int currentPage = 0;// 当前页码
	private long totalCount;// 总条数
	private int pageSize = 10;// 每页显示的大小
	private int offset;

	public int getPageNo() {
		return currentPage;
	}

	public void setPageNo(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return (int) Math.ceil((0.0 + this.totalCount) / this.pageSize);
	}

	public int getOffset() {
		if(offset != 0){
			return offset;
		}
		return this.pageSize*this.currentPage;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
}
