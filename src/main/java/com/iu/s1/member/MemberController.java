package com.iu.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemeberService memeberService;
	
//	@RequestMapping(value="join")
////	public String getmemberJoin() {
////		List<MemberDTO> ar;
////		memeberService.memberJoin(ar);
////	}
//	
	@RequestMapping(value="memberAdd", method = RequestMethod.GET)
	public void memberAdd() {
		//list.jsp로 돌아가는 메서드
	}
	
	@RequestMapping(value="memberAdd", method = RequestMethod.POST)
	public String memberAdd(MemberDTO memberDTO)throws Exception {
		int result = memeberService.setMemberAdd(memberDTO);
		return "redirect:./list";
	}

}
