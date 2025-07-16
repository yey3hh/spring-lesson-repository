package org.kosa.myproject.model;

import org.kosa.myproject.common.CommonOutputLogging;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	// 공통 로그 컴포넌트를 사용하기 위해 객체를 생성
	private CommonOutputLogging logger = new CommonOutputLogging();
	
	@Override
	public void updateProduct() {
		System.out.println(getClass() + " core concern updateProduct");
	}
	@Override
	public void findProductById() {
		logger.log(getClass().getName(), "findProductById");
		System.out.println(getClass() + " core concern findProductById");
	}
	@Override
	public void findProductByName() {
		logger.log(getClass().getName(), "findProductByName");
		System.out.println(getClass() + " core concern findProductByName");
	}
	@Override
	public void findProductListByMaker() {
		logger.log(getClass().getName(), "findProductListByMaker");
		System.out.println(getClass() + " core concern findProductListByMaker");
	}
}
