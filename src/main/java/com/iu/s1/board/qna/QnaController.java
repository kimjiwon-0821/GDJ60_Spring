package com.iu.s1.board.qna;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("boardName")
	public String getBoardName() {
		return "qna";
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView getBoardList(@ModelAttribute Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BbsDTO> ar = qnaService.getBoardList(pager);
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		RestTemplate restTemplate = new RestTemplate();
		//URL, Method, parameter, header
		String result = restTemplate.getForObject("https://dummyjson.com/products/1",String.class);
		System.out.println(result);
		
		//Header
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("header명", "header값");
//		headers.add("Content-Type", "...");
		//headers.set해더명
		
		
		return mv;
	}
	
	@GetMapping("add")
	public ModelAndView setBoardAdd()throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/add");
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(QnaDTO qnaDTO, MultipartFile [] addFiles,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setBoardAdd(qnaDTO,addFiles,session);
		String message = "등록 실패";
		if(result>0) {
			message="글이 등록되었습니다";
		}
		mv.addObject("result",message);
		mv.addObject("url","./list");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getBoardDetail(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO=  qnaService.getBoardDetail(qnaDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@GetMapping("reply")
	public ModelAndView setReplyAdd(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/reply");
		return mv;
	}
	@PostMapping("reply")
	public ModelAndView setReplyAdd(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setReplyAdd(qnaDTO);
		String message = "등록 실패";
		if(result>0) {
			message="글이 등록되었습니다";
		}
		mv.setViewName("common/result");
		mv.addObject("result",message);
		mv.addObject("url", "./detail?num="+qnaDTO.getNum());
		return mv;
	}
	
	@PostMapping("delete")
	public ModelAndView setBoardDelete(BbsDTO bbsDTO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/result");
		int result = qnaService.setBoardDelete(bbsDTO,session);
		String message = "삭제 실패";
		if(result > 0) {
			message = "삭제 성공";
		}
		mv.addObject("result", message);
		mv.addObject("url", "./list");
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFileDTO boardFileDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardFileDTO = qnaService.getBoardFileDetail(boardFileDTO);
		
		mv.addObject("boardFile", boardFileDTO);
		mv.setViewName("fileDownView");
		
		return mv;
	}
	
	//form으로 이동
	@GetMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getBoardDetail(boardDTO);
		mv.addObject("dto",boardDTO);
		mv.setViewName("board/update");
		return mv;
	}
	
	//DB
	@PostMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO,MultipartFile [] addFiles, HttpSession session,Long [] filenum) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(filenum);
		int result = qnaService.setBoardUpdate(boardDTO, addFiles, session, filenum);
		mv.setViewName("common/result");
		mv.addObject("result","수정 성공");
		mv.addObject("url","./list");
		
		return mv;
	}
	
	@PostMapping("boardFileDelete")
	public ModelAndView setBoardFileDelete(Long fileNum) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(fileNum);
		int result = qnaService.setBoardFileDelete(fileNum);
		mv.addObject("result",result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
}
