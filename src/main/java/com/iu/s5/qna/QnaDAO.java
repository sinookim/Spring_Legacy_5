package com.iu.s5.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s5.board.BoardDAO;

@Repository
public class QnaDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSesion;
	private final String NAMESPACE="com.iu.s5.qna.QnaDAO.";
	
	//Delete
	@Override
	public int boardDelete(long num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"boardWrite", num);
	}
	
	
}
