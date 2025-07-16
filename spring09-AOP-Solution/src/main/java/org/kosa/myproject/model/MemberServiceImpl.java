package org.kosa.myproject.model;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Override
	public void findMemberById() {
		System.out.println(getClass() + " core concern findMemberById");
	}
	
	@Override
	public void findMemberByAddress() {
		System.out.println(getClass() + " core concern findMemberByAddress");
	}
	
	@Override
	public void findMemberList() {
		System.out.println(getClass() + " core concern findMemberList");
	}
	
	@Override
	public void register() {
		System.out.println(getClass() + " core concern register");
	}
}
