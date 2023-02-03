package com.iu.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemeberService memeberService;
	
	@RequestMapping(value="join")
	public String getmemberJoin() {
		List<MemberDTO> ar;
		memeberService.memberJoin(ar);
	}
	
	@RequestMapping(value="memberLogin")
	public void memberLogin() {
		System.out.println("member Login");
	}
	
	@RequestMapping(value="mypage")
	public ModelAndView memberMypage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		return mv;
	}

}
