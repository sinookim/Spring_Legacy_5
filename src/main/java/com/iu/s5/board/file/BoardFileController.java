package com.iu.s5.board.file;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s5.util.FileSaver;

@Controller
@RequestMapping("/boardFile/**")
public class BoardFileController {
	@Autowired
	private BoardFileService boardFileService;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileSaver filesaver;
	
	@PostMapping("fileDelete")
	public ModelAndView fileDelete(BoardFileVO boardFileVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardFileService.fileDelete(boardFileVO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView fileDown(BoardFileVO boardFileVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardFileVO = boardFileService.fileSelect(boardFileVO);
		mv.addObject("file", boardFileVO);
		mv.setViewName("fileDown");
		System.out.println("test");
		return mv;
	}
	
	@PostMapping("fileInsert")
	public ModelAndView fileInsert(MultipartFile files)throws Exception {
		ModelAndView mv = new ModelAndView();
		String fileName = boardFileService.fileInsert(files);
		System.out.println(files.getOriginalFilename());
		mv.addObject("result", fileName);
		mv.setViewName("commmon/ajaxResult");
		return mv;
	}
	
	@PostMapping("summerDelete")
	public ModelAndView fileDelete(String fileName)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardFileService.fileDelete(fileName);
		mv.addObject("result", result);
		mv.setViewName("commmon/ajaxResult");
		return mv;
	}
	
}

