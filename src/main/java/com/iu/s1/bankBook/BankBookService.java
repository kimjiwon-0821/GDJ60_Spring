package com.iu.s1.bankBook;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class BankBookService {
	@Autowired
	private BankBookDAO bankBookDAO;
//	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	public List<BankBookDTO> getBankBookList(Pager pager) throws Exception {
		pager.makeRow();
		Long totalCount = bankBookDAO.getBankBookCount(pager);
		pager.makeNum(totalCount);
	    return bankBookDAO.getBankBookList(pager);
	}
	
	public BankBookDTO getBankBookDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getBankBookDeail(bankBookDTO);
	}
	
	 public int setBankBookAdd(BankBookDTO bankBookDTO, MultipartFile multipartFile) throws Exception {
	      int result = bankBookDAO.setBankBookAdd(bankBookDTO);
	      
	      if(!multipartFile.isEmpty()) {//multipartFile.getSize()!=0
	      //1. File을 HDD에 저장
	      //   Project 경로가 아닌 OS가 이용하는 경로
	      String path = servletContext.getRealPath("resources/upload/bankBook");
	      System.out.println(path);
	      String fileName = fileManager.fileSave(multipartFile,path);
	      
	      //2. DB에 저장
	      BankBookImgDTO bankBookImgDTO = new BankBookImgDTO();
	      bankBookImgDTO.setFileName(fileName);
	      bankBookImgDTO.setOriName(multipartFile.getOriginalFilename());
	      bankBookImgDTO.setBookNum(bankBookDTO.getBookNum());
	      
	      result = bankBookDAO.setBankBookImgAdd(bankBookImgDTO);
	      }
	      return result;
	 }
	 
	public int setBankBookDelete(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setBankBookDelete(bankBookDTO);
	}
	public int setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setBankBookUpdate(bankBookDTO);
	}

}
