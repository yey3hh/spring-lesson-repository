package org.kosa.myproject.model;

import org.kosa.myproject.common.CommonOutputLogging;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	// 공통 로그 컴포넌트를 사용하기 위해 객체를 생성
	private CommonOutputLogging logger = new CommonOutputLogging();
	
	@Override
	public void findMemberById() {
		logger.log(getClass().getName(), "findMemberById");
		System.out.println(getClass() + " core concern findMemberById");
	}
	
	@Override
	public void findMemberByAddress() {
		logger.log(getClass().getName(), "findMemberByAddress");
		System.out.println(getClass() + " core concern findMemberByAddress");
	}
	
	@Override
	public void findMemberList() {
		logger.log(getClass().getName(), "findMemberList");
		System.out.println(getClass() + " core concern findMemberList");
	}
	
	@Override
	public void register() {
		System.out.println(getClass() + " core concern register");
	}
}
