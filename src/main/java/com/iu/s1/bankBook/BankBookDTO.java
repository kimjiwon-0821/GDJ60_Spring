package com.iu.s1.bankBook;

public class BankBookDTO {
	private Long bookNum;
	private String BookName;
	private String bookDetail;
	private Long bookRate;
	private Long bookSale;
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getBookDetail() {
		return bookDetail;
	}
	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}
	public Long getBookRate() {
		return bookRate;
	}
	public void setBookRate(Long bookRate) {
		this.bookRate = bookRate;
	}
	public Long getBookSale() {
		return bookSale;
	}
	public void setBookSale(Long bookSale) {
		this.bookSale = bookSale;
	}
	

}
