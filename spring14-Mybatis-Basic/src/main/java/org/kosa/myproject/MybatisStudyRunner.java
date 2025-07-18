package org.kosa.myproject;

import java.util.List;

import org.kosa.myproject.domain.Member;
import org.kosa.myproject.mapper.MemberMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class MybatisStudyRunner implements CommandLineRunner {
	private final MemberMapper memberMapper;
	
	
	public MybatisStudyRunner(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}


	@Override
	public void run(String... args) throws Exception {
//		int totalCount = memberMapper.getTotalMemberCount();
//		System.out.println("총 회원 수 : " + totalCount);
		
//		// insert test
//		Member member = new Member("mybatis", "a", "이강인", "파리");
//		int registerResult = memberMapper.register(member);
//		System.out.println("회원 등록 " + registerResult); // 등록된 회원 수 출력
		
		// select test
		// Mapper.xml 에서 parameterType="String" resultType="org.kosa.myproject.domain.Member"
//		Member member = memberMapper.findMemberById("mybatis");
//		System.out.println("회원 정보 : " + member); 	// 회원 정보 toString이 출력 : 이강인 정보가 출력
		
		// select List test
//		List<Member> list = memberMapper.findAllMemberList();
//		for (Member m : list) {
//			System.out.println(m);
//		}
		
		// update test
//		System.out.println("수정 전 : " + memberMapper.findMemberById("mybatis"));
//		Member paramVo = new Member("mybatis", "b", "황희찬", "올버햄튼");
//		// id가 mybais인 회원의 password와 name, address를 수정
//		int updateResult = memberMapper.updateMember(paramVo);
//		System.out.println("회원 정보 수정 : " + updateResult);
//		System.out.println("수정 후 : " + memberMapper.findMemberById("mybatis"));
		
		// delete test
		String id = "mybatis";
		System.out.println(memberMapper.findMemberById(id));	// 황희찬 회원 조회됨
		int deleteResult = memberMapper.deleteMember(id);
		System.out.println("삭제 : " + deleteResult);
		System.out.println(memberMapper.findMemberById(id));	// null
		
	}

}
