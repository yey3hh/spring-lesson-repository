package org.kosa.myproject.model;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	public MemberDao() {
		System.out.println(getClass() + " 생성자 실행 -> 객체 생성");
	}

	public String findMemberById(String id) {
		return id + " 아이디의 회원 정보 출력";
	}

}
