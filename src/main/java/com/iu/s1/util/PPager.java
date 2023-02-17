package com.iu.s1.util;

public class PPager {
	//페이지번호
	private Long page;
	//한페이지에 출력되는 row
	private Long perPage;
	private Long startRow;
	private Long lastRow;
	private Long startNum;
	private Long lastNum;
	
	//table에서 조회할 숫자의 범위
	public void makeRow() {
		this.startRow= 3L;
		this.lastRow= 3L;
	}
	
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getPerPage() {
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	
	
}
