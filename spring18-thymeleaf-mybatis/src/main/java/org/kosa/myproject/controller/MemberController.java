package org.kosa.myproject.controller;

import org.kosa.myproject.mapper.MemberMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	private final MemberMapper memberMapper;
	// @Autowired 생략
	public MemberController(MemberMapper memberMapper) {	// IOC/DI (Constructor Injection)
		super();
		this.memberMapper = memberMapper;
	}
	
	@GetMapping("/member-totalcount")
	public String getTotalMemberCount(Model model) {
		int memberTotalCount = memberMapper.getTotalMemberCount();
		
		model.addAttribute("memberTotalCount", memberTotalCount);
//		model.addAttribute("memberTotalCount", memberMapper.getTotalMemberCount());
		
		return "member/total-count";
	}
	
 
	 
}
