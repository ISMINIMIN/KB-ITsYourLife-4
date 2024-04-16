package mulcam.kb04.bootmvc0901.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(@RequestParam("name") String name, Model model) {
		model.addAttribute("msg", "반갑습니다. " + name + "님.");
		return "hello";
	}
	
}
