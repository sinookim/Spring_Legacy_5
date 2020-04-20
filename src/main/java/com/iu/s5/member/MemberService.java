package com.iu.s5.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s5.board.BoardService;
import com.iu.s5.board.BoardVO;
import com.iu.s5.board.page.Pager;

@Service
public class MemberService implements BoardService{

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {

		pager.makeRow();
		long totalCount = memberDAO.boardCount(pager);
		pager.makePage(totalCount);

		return memberDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.hitUpdate(num);
		return memberDAO.boardSelect(num);
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.boardWrite(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.boardDelete(num);
	}

}
