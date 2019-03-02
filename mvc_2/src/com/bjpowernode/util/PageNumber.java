package com.bjpowernode.util;

public class PageNumber {
	private int pageCount;
	private int pageNum;
	private int pageSize;
	private int pageSum;
	public PageNumber() {
		super();
	}
	
	public PageNumber(int pageCount, int pageNum, int pageSize, int pageSum) {
		super();
		this.pageCount = pageCount;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pageSum = pageSum;
	}

	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageSum() {
		return pageSum;
	}
	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}
	
}
