package mulcam.kb04.mvc0829;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.mapper.BoardMapper;
import mybatis.dto.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@GetMapping("/board_list")
	public String board_list(Model model) {
		List<BoardDto> list = boardMapper.list();
		model.addAttribute("board_list", list);
		return "board/list";
	}
	
	@GetMapping("/board_detail")
	public String board_detail(@RequestParam("no") int no, Model model) {
		BoardDto dto = boardMapper.findByNo(no);
		model.addAttribute("dto", dto);
		return "board/detail";
	}

	@GetMapping("/board_insert_form")
	public String board_insert_form() {
		return "board/insert_form";
	}
	
	@PostMapping("/board_insert_action")
	public String board_insert_action(BoardDto dto, Model model) {
		boardMapper.insert(dto);
		model.addAttribute("msg", "게시물 등록 성공");
		return "board/ok";
	}
	
}
