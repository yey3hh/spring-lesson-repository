package org.kosa.myproject.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * 	
	org.kosa.myproject.model 패키지 이하의 보든 패키지와 클래스들을 대상으로 스캔 (샅샅이 뒤져본다)
	@Component 계열(@Service, @Controller, @Repository)의 애너테이션이 명시된 Class들을 bean으로 생성, 관리함
	<context:component-scan base-package="org.kosa.myproject.model"></context:component-scan>	
 * 
 * 	직전 프로젝트에서 테스트 했던 Spring 설정 xml의 역할을 아래 클래스에서 함	
 * 	@ComponentScan("org.kosa.myproject.model") 애너테이션의 의미는 
 * 	@Component 계열(@Service, @Controller, @Repository)의 애너테이션이 명시된 Class들을 bean으로 생성, 관리함
 * 
 * 	@Configuration : 해당 클래스가 Spring 설정 클래스임을 Spring Container에게 알리는 어노테이션
 */	
@Configuration
@ComponentScan("org.kosa.myproject.model")
public class AppConfig {

}
