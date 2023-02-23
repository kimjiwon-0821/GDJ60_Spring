package com.iu.s1.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.util.Pager;

public class NoticeDAOTest extends MyTestCase {
	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void getBoardList() throws Exception{
		Pager pager = new Pager();
		pager.setNum(125L);
		pager.setKind("title");
		pager.setSearch("공지");
		pager.makeRow();
		List<BbsDTO> ar = noticeDAO.getBoardList(pager);
		assertNotEquals(0, ar.size());
	}
}
