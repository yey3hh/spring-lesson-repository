package org.kosa.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 웹 요청을 처리하는 스프링의 컨트롤러 역할을 한다는 것을 스프링 컨테이너에게 알려준다.
@Controller
public class HomeController {
	
	@GetMapping({"/", "/home"})
	public String home(Model model) {
//		뷰로 데이터를 공유 : request.setAttribute("result", ""); 와 동일한 역할
		model.addAttribute("result", "Hello SpringBoot Web Thymeleaf");
		return "index";	// viewResolver에 의해 src/main/resource/templates/index.html 실행
	}
}
