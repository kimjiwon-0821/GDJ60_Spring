package com.iu.s1.member;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class MemberDAOTest extends MyTestCase{
	
	@Autowired //주입
	private MemberDAO memberDAO;

	@Test
	public void setMemberAddTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("idtest");
		memberDTO.setPw("pwtest");
		memberDTO.setName("nametest");
		memberDTO.setPhone("phonetest");
		memberDTO.setEmail("emailtest");
		int result = memberDAO.setMemberAdd(memberDTO);
		assertEquals(1, result);
	}
}
