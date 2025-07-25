package org.kosa.myproject.controller;

import java.util.List;

import org.kosa.myproject.domain.Member;
import org.kosa.myproject.domain.MyProduct;
import org.kosa.myproject.mapper.MemberMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

// Thymeleaf 연습을 위한 컨트롤러
@Controller
public class HomeController {
	private final MemberMapper memberMapper;
	
	public HomeController(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("messsage", "안녕 백리향");
		model.addAttribute("logo", "thymeleaf-admin.png");
		return "index";
	}
	
	@GetMapping("/study1")
	public String study1(Model model) {
		model.addAttribute("member", new Member("java", "a", "손흥민", "런던"));
		
		return "step01-text-object-expression";
	}
	
	@GetMapping("/study2")
	public String study2(HttpSession session) {
		// request scope에 저장됨
//		model.addAttribute("member", new Member("spring", "A", "이강인", "파리"));
		// session scope에 저장됨
		session.setAttribute("member", new Member("thymeleaf", "A", "황희찬", "울버햄튼"));
		return "step02-form-object-expression";
	}
	
	@GetMapping("/study3")
	public String study3(Model model) {
		model.addAttribute("pageNo", 6);
		model.addAttribute("keyword", "월드컵");
		
		model.addAttribute("orderId", "12");
		model.addAttribute("maker", "애플");
		
		return "step03-link-href-querystring";
	}
	
//	 <a href="/board/list?pageNo=6" >
	@GetMapping("/board/list")
	public String studyResult(int pageNo, String keyword) {	// 왜 매개변수명이 중요할까
		System.out.println("페이지 번호 : " + pageNo + ", 키워드 : " + keyword);
		
		return "step03-result1-param";
	}
	
	@GetMapping("/order/details")
	public String orderDetails(int orderId, String maker) {	// 왜 매개변수명이 중요할까
		System.out.println("주문 번호 : " + orderId + ", 제조사 : " + maker);
		
		return "step03-result2-param";
	}
	
	@GetMapping("/study4")
	public String study4(HttpSession session) {
		session.setAttribute("mvo", new Member("transaction", "a", "제니", "파리"));
		
		return "step04-session-param";
	}
	
	@GetMapping("/study4-test")
	public String study4Test(Member member) {
		System.out.println(member);
		
		return "step04-session-param-result";
	}
	
	@GetMapping("/study5")
	public String study5(Model model) {
		model.addAttribute("product", new MyProduct(1, "카스", "OB", 1700, true));
		model.addAttribute("size", "M");
		
		return "step05-if-unless-switch";	// view name을 리턴 -> dispathcer servlet으로
	}
	
	@GetMapping("/study6")
	public String study6(Model model) {
		List<Member> list = List.of(
				new Member("java", "a", "하니", "시드니"), 
				new Member("spring", "b", "노상현", "뉴욕"), 
				new Member("thymeleaf", "c", "제니", "서울")
		);	// -> List.of() : 불변 리스트를 반환
		model.addAttribute("memberList", list);
		
//		List<Map<String, String>> mlist = memberMapper.findMemberList();
//		model.addAttribute("mList", mlist);
		model.addAttribute("mList", memberMapper.findMemberMapList());
		
		return "step06-loop-each";
	}
	
	@GetMapping("/study7")
	public String study7(Model model) {
		List<MyProduct> productList = List.of(new MyProduct(1, "테라", "하이트진로", 1410, true),
				new MyProduct(2, "카스", "오비", 1410, false),
				new MyProduct(3, "참이슬", "하이트진로", 1300, false),
				new MyProduct(4, "처음처럼", "롯데", 1500, true)
		);
		model.addAttribute("productList", productList);
		model.addAttribute("productCount", productList.size());
		return "step07-loop-each-lists";
	}
	
	@GetMapping("/study8")
	public String study8(Model model) {
		model.addAttribute("startPageNumber", 1);
		model.addAttribute("endPageNumber", 4);
		
		return "step08-loop-each-numbers-pagination";
	}
	
	@GetMapping("/study9")
	public String study9() {
		
		return "step09-javascript";
	}
	
	@GetMapping("/study10")
	public String study10() {
		
		return "step10-main1";
	}
	
	@GetMapping("/study10-2")
	public String study10Two(Model model) {
		model.addAttribute("message", "메인 2 페이지 컨텐트 입니다");
		return "step10-main2";
	}
	
	@GetMapping("/study11")
	public String study11() {
		
		return "step11-main1";
	}
	
	@GetMapping("/study11-2")
	public String study11Two() {
		
		return "step11-main2";
	}
}
