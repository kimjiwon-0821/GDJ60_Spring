package com.iu.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.bankBook.BankBookDTO;
import com.iu.s1.product.ProductDTO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemeberService memeberService;
	//list
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView getBankBookList() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<MemberDTO> ar = memeberService.getMemberList();
		mv.setViewName("member/memberList");
		mv.addObject("list", ar);
		return mv;
	}
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
