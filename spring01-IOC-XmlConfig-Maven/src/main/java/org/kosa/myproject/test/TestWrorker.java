package org.kosa.myproject.test;

import org.kosa.myproject.model.Hammer;
import org.kosa.myproject.model.Spade;
import org.kosa.myproject.model.Tool;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestWrorker {
	public static void main(String[] args) {
//		기존 제어 방식 : 필요 시 객체를 만들어서 이용
//		Tool tool = new Hammer();
//		tool.work();
//		Hammer에서 Spade로 툴을 변경
//		객체 생성부를 변경
//		Tool tool = new Spade();
//		tool.work();
//		위의 제어 방식은 도구 객체가 변경 될 때마다 코드를 수정, 변경해야 하는 구조
//		-> 생산성, 유지보수성을 향상할 수 있는 방안
//		직전에는 객체 생성을 전담하는 Factory를 정의했고, 동적으로 객체를 생성하는 Reflection API를 이용했음
//		그 역할을 하는 것이 Spring Container!
//		Spring Container는 IOC Container로서의 역할을 함
//		IOC : Inversion Of Control 제어의 역전, 소프트웨어 설계원리이자 디자인 패턴
//		필요한 객체를 직접 생성하지 않고 컨테이너에 위임, 생성주기를 관리하는 디자인 패턴
		
		
//		Spring Container 역할 : ApplicationContext 계열 => IOC / DI, AOP 등을 지원
//		applicationContext.xml : 스프링 설정 파일
//		ClassPathXmlApplicationContext는 시작시점에 xml의 설정 내용을 로드함
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Spring IOC Container에 저장된 tool 객체를 반환받는다 => IOC
		Tool iocTool = (Tool)factory.getBean("tool");	// 무엇을 bean에 등록한지 모르니까 Object로 반환
//		반환받은 객체를 사용한다 =>IOC
//		기존 방식과 무슨 차이? 필요 시 직접 생성하지 않고 스프링 컨테이너에서 만들어진 객체(Bean)을 받아서 사용한다.
//		IOC를 적용하면 어떤 면이 좋을까? Loose Coupling 느슨한 결합도
		iocTool.work();
		System.out.println(factory.getBean("tool"));
		System.out.println(factory.getBean("tool"));
		System.out.println(factory.getBean("tool"));	// 동일한 객ㅊㅔ를 반환한다.
//		Spring Container는 Singleton으로 Bean을 관리한다.
		
		factory.close();
	}
}
