package org.kosa.myproject.model;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
//	직접 코드에 입력하는 
//	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	public void findMemberById(String id) {
		System.out.println(getClass() + " core concern findMemberById");
//		logger.debug("cross cutting MemberService findMemberById 검색어 {}", id);
	}
	
	public void findMemberByAddress(String address) {
		System.out.println(getClass() + " core concern findMemberByAddress");
	}
	
	public void findMemberListByDept(String dept) {
		System.out.println(getClass() + " core concern findMemberList");
	}
	
	public void register(String id, String name) {
		System.out.println(getClass() + " core concern register");
	}
}
