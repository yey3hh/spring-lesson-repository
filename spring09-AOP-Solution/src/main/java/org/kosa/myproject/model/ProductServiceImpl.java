package org.kosa.myproject.model;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Override
	public void updateProduct() {
		System.out.println(getClass() + " core concern updateProduct");
	}
	@Override
	public void findProductById() {
		System.out.println(getClass() + " core concern findProductById");
	}
	@Override
	public void findProductByName() {
		System.out.println(getClass() + " core concern findProductByName");
	}
	@Override
	public void findProductListByMaker() {
		System.out.println(getClass() + " core concern findProductListByMaker");
	}
}
