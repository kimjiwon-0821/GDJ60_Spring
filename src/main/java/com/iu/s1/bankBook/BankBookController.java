package com.iu.s1.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankBook/*")
public class BankBookController {
	@Autowired
	private BankBookService bankBookService;

	//list
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView getBankBookList() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BankBookDTO> ar = bankBookService.getBankBookList();
		mv.setViewName("bankBook/list");
		mv.addObject("list", ar);
		return mv;
	}
	
	//detail
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView getBankBookDetail(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		mv.setViewName("bankBook/detail");
		mv.addObject("dto", bankBookDTO);
		return mv;
	}
	
	//add form 이동
	@RequestMapping(value="add", method = RequestMethod.GET)
	public ModelAndView setBankBookAdd() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bankBook/add");
		return mv;
		//list.jsp로 돌아가는 메서드
	}
	
	//add DB insert
	@RequestMapping(value="add", method = RequestMethod.POST)
	public ModelAndView setBankBookAdd(BankBookDTO bankBookDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setBankBookAdd(bankBookDTO);
		mv.setViewName("redirect:./list"); //경로를 넣어주는 것.
		return mv;
	}
	
	//delete
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public ModelAndView setBankBookDelete(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setBankBookDelete(bankBookDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}

}
