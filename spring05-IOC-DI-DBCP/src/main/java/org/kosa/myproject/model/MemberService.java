package org.kosa.myproject.model;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	private final MemberDao memberDao;

	// @Autowired	// DI 애너테이션 생략 가능 -> 생성자 1개일 경우 자동 DI 의존성 주입
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public String findMemberById(String id) {
		return memberDao.findMemberById(id);
	}

}
