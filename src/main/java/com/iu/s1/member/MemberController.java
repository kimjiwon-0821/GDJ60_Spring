package com.iu.s1.member;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemeberService memeberService;
	@PostMapping("memberIdCheck")
	public ModelAndView getMemberIdCheck(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boolean check = memeberService.getMemberIdCheck(memberDTO);
		mv.addObject("result",check);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@RequestMapping(value="memberAgree")
	public ModelAndView setMemberAgree() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	//list
	@RequestMapping(value="memberlist", method=RequestMethod.GET)
	public ModelAndView getMemeberList() throws Exception{
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
	public ModelAndView memberAdd(MemberDTO memberDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = memeberService.setMemberAdd(memberDTO);
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.GET)
	public ModelAndView getMemberLogin(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberLogin");
//		Cookie [] cookies = request.getCookies();
//		for(Cookie cookie : cookies) {
//			System.out.println(cookie.getName());
//			System.out.println(cookie.getValue());
//			System.out.println(cookie.getDomain());
//			System.out.println(cookie.getPath());
//			System.out.println("------------------");
//			if(cookie.getName().equals("rememberId")) {
//				mv.addObject("rememberId", cookie.getValue());
//				break;
//			}
//		}
		return mv;
	}
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpServletRequest request, String remember, HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("remember:"+remember);
		if(remember!=null && remember.equals("remember")) {
			Cookie cookie = new Cookie("rememberId",memberDTO.getId());
			cookie.setMaxAge(60*60*24*7); //cookie 보관 기간 - 초단위 (-1 : 영구히 저장)
			response.addCookie(cookie);
		}else {
			//방법1
			Cookie cookie = new Cookie("rememberId", "");
			response.addCookie(cookie); //value에 공백 넣기
			//방법2
			cookie.setMaxAge(0);
			response.addCookie(cookie); // cookie 아예 삭제
			
			
		}
//		memberDTO = memeberService.getMemberLogin(memberDTO);
//		if(memberDTO!=null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("member", memberDTO);
//		}
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@RequestMapping(value="memberLogout", method = RequestMethod.GET)
	public ModelAndView getMemberLogout(HttpSession session) throws Exception{
		session.invalidate(); // 세션 즉시 삭제
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}
	@RequestMapping(value="memberPage", method=RequestMethod.GET)
	public ModelAndView getMemberPage(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO=memeberService.getMemberPage(memberDTO);
		mv.addObject("dto", memberDTO);
		mv.setViewName("member/memberPage");
		return mv;
	}
	@RequestMapping(value="memberUpdate", method = RequestMethod.GET)
	public ModelAndView setMemberUpdate(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memeberService.getMemberPage(memberDTO);
		mv.addObject("dto", memberDTO);
		mv.setViewName("member/memberUpdate");
		return mv;
	}
	@RequestMapping(value="memberUpdate",method =  RequestMethod.POST)
	public ModelAndView setMemberUpdate(MemberDTO memberDTO,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO sessionMemberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(sessionMemberDTO.getId());
		int result = memeberService.setMemberUpdate(memberDTO);
//		if(result>0) {
//			session.setAttribute("member", memberDTO);
//		}
		mv.setViewName("redirect:./memberPage");
		return mv; 
		
		
	}

}
