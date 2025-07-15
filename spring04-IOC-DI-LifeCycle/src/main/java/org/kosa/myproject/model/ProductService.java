package org.kosa.myproject.model;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class ProductService {
	// ProductDao 타입의 productDao final field를 선언하고 생성자를 통해 DI 받도록 정의
	private final ProductDao productDao;

//	@Autowired 생략되어있는 상태
	public ProductService(ProductDao productDao) {
		this.productDao = new ProductDao();
		System.out.println(getClass() + "생성자 실행.." + productDao + " Dependency Injection 후 객체 Bean 생성");
	}
	
//	Bean 생성 직후에 하는 초기화 작업
	@PostConstruct	// 초기화 콜백(호출, 나중에 해줄게!!) 메서드, 나중에 컨테이너에 의해서 콜백되는 메서드
	public void init() {
		System.out.println(getClass() + " Bean 초기화 작업");
	}
//	Bean에서 정의한 비즈니스 메서드
	public String findProductById(String id) {
		System.out.println(getClass() + " findProductById 비즈니스 메서드");
		return productDao.findProjectById(id);
	}
	
	@PreDestroy		// Bean이 소멸 전에 해야하는 작업, 소멸 콜백 메서드
	public void destroy() {
		System.out.println(getClass() + " Bean 소멸 직전 작업");
	}
}
