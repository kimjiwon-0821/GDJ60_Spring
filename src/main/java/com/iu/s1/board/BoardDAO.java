package com.iu.s1.board;

import java.util.List;

public interface BoardDAO extends BbsDAO{
	//list - 상속
	
	//detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;
	
	//add - 상속
	
	//fileAdd
	public int setBoardFileAdd(BoardFileDTO boardFileDTO) throws Exception;
	
	
	//update - 상속
	
	
	//delete - 상속
	
	//BoardFileList
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO) throws Exception;
	
	//BoardFileDetail
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception;
}
