package com.iu.s1.bankBook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.bankBook.BankBookDAO;
import com.iu.s1.bankBook.BankBookDTO;

public class BankBookDAOTest {
	@Autowired
	private BankBookDAO bankBookDAO;

	@Test
	public void getBankBookList() throws Exception {
		List<BankBookDTO> ar = bankBookDAO.getBankBookList();
		assertNotEquals(0, ar.size());
	}
	@Test
	public void getBankBookDetail() throws Exception {
		
	}
}
