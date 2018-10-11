package com.demo.exam.util;

public class Page {

	// current page number
	int pageNow = 1;

	// default record number in each page
	int pageSize = 5;

	// total number of records
	int totalCount;

	// total number of pages
	int totalPageCount = -1;

	public Page(int totalCount, int pageNow) {
		this.totalCount = totalCount;
		this.pageNow = pageNow;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;

	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageCount() {
		totalPageCount = getTotalCount() / getPageSize();
		return (totalCount % pageSize == 0) ? totalPageCount : totalPageCount + 1;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

}
