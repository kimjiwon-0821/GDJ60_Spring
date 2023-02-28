package com.iu.s1.board;

import org.springframework.web.multipart.MultipartFile;

public interface BoardService extends BbsService{
	//detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;
	
	//BoardFileDetail
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception;

}
