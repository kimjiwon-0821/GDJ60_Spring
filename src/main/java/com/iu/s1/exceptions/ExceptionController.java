package com.iu.s1.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class ExceptionController {
	//예외를 전문 처리하는 controller
	//프로젝트 내에서 발생하는 Exception은 전부 여기서 처리
	@ExceptionHandler(NullPointerException.class) //예외발생클래스명.class
	public ModelAndView fixException() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","잘못된 입력입니다. 관리자에게 문의하세요.");
		mv.setViewName("common/error_500");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class) //예외발생클래스명.class
	public ModelAndView fix2Exception() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","잘못된 접근입니다. 관리자에게 문의하세요.");
		mv.setViewName("common/error_500");
		
		return mv;
	}
	

}
