package org.kosa.myproject;	// @SpringBootApplication이 명시된 클래스의 패키지가 ComponentScan의 base package가 된다.

import org.kosa.myproject.model.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링 부트 설정 애너테이션 : 설정 클래스임을 알림, 컴포넌트 스캔, 자동 설정 지원
@SpringBootApplication	// @SpringBootConfiguration + @ComponentScan + @EnableAutoConfiguration
public class Spring06SpringBootCommandLineRunnerApplication implements CommandLineRunner {
	@Autowired	// DI 의존성 주입 애너테이션
	private FoodService foodService;	// field 불변성 보장 => 멀티 스레딩 시 안전
	// 아래와 같이 생성자 주입을 가장 권장함
	public Spring06SpringBootCommandLineRunnerApplication(FoodService foodService) {
		super();
		this.foodService = foodService;
		System.out.println(foodService + " 객체 : 의존성 주입 Dependency Injection");
	}

	public static void main(String[] args) {
		System.out.println("SpringBoot App 시작");
		// 실제 스프링 부트의 스프링 컨테이너가 시작시키는 코드 라인
		// ApplicationContext가 실행되며 설정에 의거하여 Bean 생성, DI처리 등을 실행
		SpringApplication.run(Spring06SpringBootCommandLineRunnerApplication.class, args);
		System.out.println("SpringBoot App 종료");
	}
	// CommandLineRunner는 Spring의 컨테이너가 실행 준비를 완료한 직후에 실행됨
	// 설정 로딩 및 Bean 생성과 DI 처리와 같은 작업이 이미 완료된 후 실행됨
	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner 실행");
		foodService.register("냉면");
		
	}
}
