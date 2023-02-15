package com.iu.s1.bankBook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class BankBookDAOTest extends MyTestCase{
	
	@Autowired //주입
	private BankBookDAO bankBookDAO;

	@Test
	public void setBankBookAddTest() throws Exception{
		for(int i=0;i<30;i++) {
		BankBookDTO bankBookDTO = new BankBookDTO();
		Random r = new Random();
		double d = r.nextDouble();
		int num = (int)(d*1000);
		d=num/100.0;
		bankBookDTO.setBookName("콩 적금"+i);
		bankBookDTO.setBookDetail("kong"+i);
		bankBookDTO.setBookRate(d);
		bankBookDTO.setBookSale(1);
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		}
	}
}
