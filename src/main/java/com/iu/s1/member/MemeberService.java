package com.iu.s1.member;

import java.util.List;

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
	//getList
	public List<MemberDTO> getMemberList() throws Exception{
		return memberDAO.getMemberList();
	}

}
