package com.javalec.twice_fan.controller.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.twice_fan.model.board.dto.BoardVO;
import com.javalec.twice_fan.service.board.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService boardService;

	@RequestMapping("list.do")
	public ModelAndView list(){
		
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = boardService.list();
		int count = list.size();
		ModelAndView mav = new ModelAndView();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list",list);
		map.put("count", count);
		mav.addObject("map",map);
		mav.setViewName("board/list");
		return mav;
	}
	
	@RequestMapping(value="write.do",method=RequestMethod.GET)
	public String write(){		
		return "board/write";
	}
	
	@RequestMapping(value="write.do" ,method=RequestMethod.POST)
	public String write(@ModelAttribute BoardVO vo){
		boardService.write(vo);
		
		return "redirect:/board/list.do";
	}
	
	@RequestMapping("view.do")
	public ModelAndView view(@RequestParam int bno){
		BoardVO dto = new BoardVO();
		dto = boardService.view(bno);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/view");
		mav.addObject("dto",dto);
		return mav;
	}
	

}
