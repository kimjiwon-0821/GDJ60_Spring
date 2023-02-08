package com.iu.s1.bankBook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class BankBookDAOTest extends MyTestCase{
	
	@Autowired //주입
	private BankBookDAO bankBookDAO;

	@Test
	public void setBankBookAddTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNum(200L);
		bankBookDTO.setBookName("pwtest");
		bankBookDTO.setBookDetail("nametest");
		bankBookDTO.setBookRate(2.0);
		bankBookDTO.setBookSale(1);
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		assertEquals(1, result);
	}
}
