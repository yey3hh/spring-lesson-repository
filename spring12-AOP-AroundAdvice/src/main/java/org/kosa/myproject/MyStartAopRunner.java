package org.kosa.myproject;

import org.kosa.myproject.model.ProductService;
import org.kosa.myproject.model.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyStartAopRunner implements CommandLineRunner {
	// ProductService와 UserService DI : final 필드 선언 및 생성자 주입
	private final UserService userService;
	private final ProductService productService;
//	@Autowried 생략 : 정의된 생성자가 1개일 때(매개변수 수는 관계없음, 여러개 가능)
	public MyStartAopRunner(UserService userService, ProductService productService) {
		super();
		this.userService = userService;
		this.productService = productService;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(productService);
		System.out.println(productService.getClass().getName());
		// before test
		userService.register();
		productService.register(" 오뚜기");
		// after-returning test
		System.out.println(productService.getMaker());
		System.out.println(userService.getNick());
		// after-throwing test : 특정 Exception 발생될 때 AOP가 동작되도록 처리
		try {
			productService.buyProduct(0);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			productService.sellProduct(7);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
