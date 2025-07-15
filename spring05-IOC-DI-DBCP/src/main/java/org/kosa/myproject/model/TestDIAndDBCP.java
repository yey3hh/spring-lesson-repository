package org.kosa.myproject.model;

import java.sql.SQLException;

import org.kosa.myproject.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDIAndDBCP {
	public static void main(String[] args) {
		/*
		 * 	org.kosa.myproject.config.AppConfig
		 * 	org.kosa.myproject.model.MemberDao
		 * 	org.kosa.myproject.model.MemberService
		 */
		
		// Spring Container : ApplicationContext, AppConfig : 개발 진영에서 명시한 스프링 설정 정보
		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService memberService = (MemberService) factory.getBean("memberService");
		MemberVo memberInfo;
		try {
			memberInfo = memberService.findMemberById("java");
			System.out.println(memberInfo);	// java 아이디 회원 정보
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		factory.close();
	}
}
