package org.kosa.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/home"})
	public String home(Model model) {
		model.addAttribute("message", "Hello Spring Boot");
		return "index";	// viewResolver에 의해 src/main/resource/templates/index.html 실행
	}
}
