package org.kosa.myproject.controller;

import org.kosa.myproject.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// @RequestMapping : 클래스 레벨에서 공통 URL 경로를 정의
// 해당 컨트롤러의 모든 메서드 URL 앞에 "/member"가 자동으로 붙음
@RequestMapping("/member")
public class MemberController {
	
	@GetMapping("/member-test")
	public String memberTest() {
		// 아래의 return value는 view name을 반환하는 것이다.
		// view name -> thymeleaf template engine의 ViewResolver가 동작됨.
		// src/main/resource/templates/viewName(컨트롤러 반환 view 이름).html을 찾아서 
		// Thymeleaf Parser가 동작, 클라이언트가 응답받은 일반 html을 생성해 응답함
		// 아래의 view name은 src/main/resource/templates/member/member-test.html을 찾아서 파싱한다.
		return "member/member-test";
	}
	
	@GetMapping("/find-by-id")	// url pattern
	// client에서 보낸 텍스트 입력 폼의 name과 매개변수 명이 일치하면 request.getParameter("memberId")를 처리 해준다.
	// @RequestParam : name이 매개변수 명과 일치하면 생략 가능
	public String findMemberById(@RequestParam String memberId, Model model) {
		System.out.println(memberId);
		// Service or Mapper 계층과 연동 후 회원 정보를 반환
		// view에 전달할 데이터를 담는 객체 : request.setAttribute(name, value);와 동일
		model.addAttribute("member", new Member(memberId, "a", "손흥민", "런던"));
		
		
		// src/main/resource/templates/member/findbyid-result.html로 Thymeleaf ViewResolver가 찾아서 파싱하고 랜더링함
		return "member/findbyid-result";	// view name
	}
	
	@GetMapping("/find-by-id2")
	public String findMemById(String memId, Model model) {
		
		if (memId.equals("java")) {
			model.addAttribute("memberInfo", "이강인 파리 생제르맹");
			return "member/findbyid-ok";
		} else {
			return "member/findbyid-fail";
		}
	}
	
	@GetMapping("/param-test")
	public String paramTest(@RequestParam String nick, @RequestParam int age, Model model) {	// int로 자동 형변환 : HandlerAdapter가 변환해 전달 
		String type = null;
		
		if (age <= 18 ) {
			type = "미성년";
		} else {
			type = "성인";
		}
		model.addAttribute("type", type);
		return "member/param-result";
	}
	
	@PostMapping("/register")
	public String register(Member member) {	// form에서 전송한 회원 정보가 객체로 생서되어 매개변수로 전달된다. : HandlerAdapter
		System.out.println("회원 가입 정보 : " + member);
		
//		return "member/register-result"; // forward 방식 : request 유지, 재동작 O
		return "redirect:/member/register-result";	// redirect 방식 : request 유지 X, 재동작 X
	} // 위 코드는 클라이언트에게 localhost:8080/member/register-result에 가서 응답 받아라
	// 아래 메서드는 그 요청에 응답하는 컨트롤러 메서드
	@GetMapping("/register-result")
	public String registerResult() {
		return "member/register-result";
	}
}	
