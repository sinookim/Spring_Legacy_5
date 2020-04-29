package com.iu.s5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s5.board.BoardVO;
import com.iu.s5.notice.NoticeService;
import com.iu.s5.util.Pager;

@RestController
@RequestMapping("/json/**")
public class JsonController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "json1") //get
	@ResponseBody
	public List<BoardVO> json1(Pager pager)throws Exception {
		BoardVO boardVO = noticeService.boardSelect(30);
		List<BoardVO> ar = noticeService.boardList(pager);
		
		
//		ModelAndView mv = new ModelAndView();
//		BoardVO boardVO = noticeService.boardSelect(30);
//		String json = "{";
//		json = json + "\"num\":\""+boardVO.getNum()+"\",";
//		json = json + "\"title\":\""+boardVO.getTitle()+"\"}";
//		mv.addObject("result", json);
//		mv.setViewName("common/ajaxResult");
		
		return ar;
	}
	
}
