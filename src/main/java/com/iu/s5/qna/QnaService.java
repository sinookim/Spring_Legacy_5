package com.iu.s5.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s5.board.BoardService;
import com.iu.s5.board.BoardVO;
import com.iu.s5.board.file.BoardFileDAO;
import com.iu.s5.board.file.BoardFileVO;
import com.iu.s5.util.FileSaver;
import com.iu.s5.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileSaver filesaver;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private BoardFileDAO boardFileDAO;
	
	public int boardReply(BoardVO boardVO)throws Exception{
		int result = qnaDAO.boardReplyUpdate(boardVO);
		result = qnaDAO.boardReply(boardVO);
		return result;
	}
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		
		pager.makeRow();
		
		pager.makePage(qnaDAO.boardCount(pager));
		
		return qnaDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		return qnaDAO.boardSelect(num);
	}

	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile [] files) throws Exception {
		
		//1.sequence num qna table insert
		int result = qnaDAO.boardWrite(boardVO);
		
		//3.hdd에 파일저장하고 board file insert
		String path = servletContext.getRealPath("/resources/uploadQna");
		
		for(MultipartFile file : files) {
			BoardFileVO boardFileVO = new BoardFileVO();
			String fileName = filesaver.saveByTransfer(file, path);
			boardFileVO.setFileName(fileName);
			boardFileVO.setNum(boardVO.getNum());
			boardFileVO.setOriName(file.getOriginalFilename());
			boardFileVO.setBoard(2);
			boardFileDAO.fileInsert(boardFileVO);
		}
		
		return result;//qnaDAO.boardWrite(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(long num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
