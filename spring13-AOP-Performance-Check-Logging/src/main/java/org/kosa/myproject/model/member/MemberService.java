package org.kosa.myproject.model.member;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	public void findMember() {
		try {
			Thread.sleep(200);	// 0.2초 소요
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Core find member");
		
	}
	
	public void findAllMember() {	// error 대상
		try {
			Thread.sleep(1800);	// 1.8초 소요
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Core findAll Member");
	}
	
	public void register(String id, String name) throws DuplicateIdException {	// warn 대상
		try {
			Thread.sleep(900);	// 0.9초 소요
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (id.equals("java")) {
			throw new DuplicateIdException("회원 아이디가 중복됩니다.");
		}
		
		System.out.println("Core register member");
	}
}
