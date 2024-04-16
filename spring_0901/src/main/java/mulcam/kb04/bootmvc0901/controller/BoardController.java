package mulcam.kb04.bootmvc0901.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mulcam.kb04.bootmvc0901.entity.BoardDto;
import mulcam.kb04.bootmvc0901.mapper.BoardMapper;

@Controller
public class BoardController {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@GetMapping("/board/list")
	public String board_list(Model model) {
		List<BoardDto> list = boardMapper.list();
		model.addAttribute("board_list", list);
		return "board/list";
	}
	
}
