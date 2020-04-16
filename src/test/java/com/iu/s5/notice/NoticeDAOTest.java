package com.iu.s5.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;

public class NoticeDAOTest extends AbstractTestCase{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void daoIsnull() {
		assertNotNull(noticeDAO);
	}
	
	@Test
	public void boardWriteTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("TestTitle");
		noticeVO.setWriter("TestWriter");
		noticeVO.setContents("TestContents");
		int result = noticeDAO.boardWrite(noticeVO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void boardDelete() throws Exception{
		int result = noticeDAO.boardDelete(6);
		assertNotEquals(0, result);
	}
	
	@Test
	public void boardUpdate() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setHit(5);
		noticeVO.setNum(2);
		int result = noticeDAO.boardUpdate(noticeVO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void boardUpdateHit() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setHit(4);
		noticeVO.setNum(2);
		int result = noticeDAO.boardUpdate(noticeVO);
		
		assertEquals(1, result);
	}

}
