package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeberService {
	@Autowired
	private MemberDAO memberDAO;
	public int setMemberAdd(MemberDTO memberDTO) throws Exception {
		return memberDAO.setMemberAdd(memberDTO);
		
	}
	
//	
//	//getList
//	public void getMemberList() throws Exception{
//		return 
//	}

}
