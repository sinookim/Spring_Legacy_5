package com.iu.s5.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s5.board.BoardVO;
import com.iu.s5.board.page.Pager;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@ModelAttribute("board")
	public String getBoard() throws Exception {
		return "member";
	}

	@RequestMapping(value = "memberDelete", method = RequestMethod.GET)
	public ModelAndView boardDelete(ModelAndView mv) throws Exception {
		int result = memberService.boardDelete(id);
		if(result>0) {
			mv.addObject("result", "Delete Success");
		}else {
			mv.addObject("result", "Delete Fail");
		}
		mv.addObject("path", "./memberList");
		mv.setViewName("common/result");
		return mv;
	}
}
