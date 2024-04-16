package com.mulcam.kb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GugudanController {
	
	@GetMapping("/gugudan")
	public String gugudan() {
		return "gugudan/gugudan";
	}
	
	@GetMapping("/gugudan_view")
	public String gugudan_view(
			@RequestParam(value = "num") int num, Model model) {
		String result = "";
		
		for(int i=1; i<10; i++) {
			result += num + " x " + i + " = " + num * i + "<br>";
		}
		
		model.addAttribute("result", result);
		return "gugudan/gugudan";
	}
	
}
