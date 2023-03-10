package com.iu.s1.util;

public class Pager {
	
	private Long bookNum;
	private Long num;
	
	
	//검색 종류(사용할 column)
	private String kind;
	//검색어
	private String search;
	
	//한페이지에 출력할 row의 갯수
	private Long perPage;
	
	//한블럭당 출력할 번호의 갯수
	private Long perBlock;
	
	//전체 페이지 갯수 --> setter을 만들지 않음으로 밖에서 값을 받지 않음.
	private Long totalPage;
	
	//client가 보고싶은 페이지 번호(parameter)
	private Long page;
	
	//Table에서 조회할 시작번호 
	private Long startRow;
	//Table에서 조회할 끝번호
	private Long lastRow;
	
	//전체 row의 갯수를 담을 변수
//	private Long totalCount;
	
	private Long startNum;
	private Long lastNum;
	
	private boolean before;
	private boolean after;
	
//	public Pager() {
//		this.perPage=10L;
//	}
	
	//startRow, lastRow 계산하는 메서드
	public void makeRow() {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	//startNum, lastNum
	public void makeNum(Long totalCount) {
		//1.전체 row 갯수 구하기
		//2.총 page 갯수 구하기
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			totalPage++;
		}
//		//3.한블럭에 출력할 번호의 갯수
//		Long perBlock = 5L; ->멤버변수로 변경
		//4.총 블럭의 수 구하기
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock()!=0) {
			totalBlock++;
		}
		//5.page 번호로 현재 블럭 번호 구하기
		//page 1-5 curBlock 1
		//page 6-10 curBlock 2
		//page 11-15 curBlock 3
		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock() !=0) {
			curBlock++;
		}
		//6.curBlock의 시작번호와 끝번호를 계산
		/**	curBlock	startNum	lastNum
		 *		1			1			5
		 *		2			6			10
		 *		3			11			15
		 */
		this.startNum=(curBlock-1)*this.getPerBlock()+1;
		this.lastNum=curBlock*this.getPerBlock();
		
		this.after=true;
		if(curBlock==totalBlock) {
			this.lastNum = totalPage;
			this.after=false;
		}
		if(curBlock==1) {
			this.before=true;
		}
	}
	
	public Long getPerPage() {
		if(this.perPage==null || this.perPage==0)
			this.perPage=10L;
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPage() {
		if(this.page==null || this.page<=0)
			this.page=1L;
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
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

//	public Long getTotalCount() {
//		return totalCount;
//	}
//
//	public void setTotalCount(Long totalCount) {
//		this.totalCount = totalCount;
//	}

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

	public boolean isAfter() {
		return after;
	}

	public void setAfter(boolean after) {
		this.after = after;
	}

	public boolean isBefore() {
		return before;
	}

	public void setBefore(boolean before) {
		this.before = before;
	}

	public Long getPerBlock() {
		if(this.perBlock==null || this.perBlock<1) {
			this.perBlock=5L;
		}
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public Long getTotalPage() { //밖에서 값을 받을 필요가 없기 때문에 getter만 만듬.
		return totalPage;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(search==null) {
			search="";
		}
		return search;//"%"+search+"%";
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getBookNum() {
		return bookNum;
	}

	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
	
	
	
}
