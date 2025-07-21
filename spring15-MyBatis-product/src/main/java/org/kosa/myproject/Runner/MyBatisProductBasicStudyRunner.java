package org.kosa.myproject.Runner;

import org.kosa.myproject.mapper.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//@Order(2)	// 기본 mybatis 테스트는 마무리되었으므로 
public class MyBatisProductBasicStudyRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(MyBatisProductBasicStudyRunner.class);
	private final ProductMapper productMapper;
	
	public MyBatisProductBasicStudyRunner(ProductMapper productMapper) {
		super();
		this.productMapper = productMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.debug("className {} run.. DI {}", getClass(), productMapper);
//		int totalProductCount = productMapper.getTotalProductCount();
//		logger.debug("총 상품 수 : {}", totalProductCount);
		/*
		 * 	현 러너에서 DI - ProductMapper
		 * 	org.koda.myproject.mapper.ProductMapper interface 정의
		 * 	src/main/resource 아래에 동일한 패키지에 ProductMapper.xml 정의
		 */
		
//		List<Product> list = productMapper.findAllProductList();
//		for (Product p : list) {
//			System.out.println(p);
//		}
		
		// 상품 아이디로 개별 상품 조회
//		Long productId = 1L;
//		Product product = productMapper.findProductById(productId);
//		logger.debug("상품 정보 : {}", product);
		
		// 상품 정보 수정 : 상품 명 productName, 제조사 maker, 가격 price
//		Product param = new Product();
//		param.setProductId(1L); // 상품 아이디가 1인 상품 정보를 수정
//		param.setProductName("갤럭시 북");
//		param.setMaker("삼성");
//		param.setPrice(new BigDecimal("1500000"));
//		int updateResult =  productMapper.updateProduct(param);
//		logger.debug("상품 정보 수정 결과 : {}", updateResult);
//		
//		Product product2 = productMapper.findProductById(productId);
//		logger.debug("수정된 상품 정보 확인 : {}", product2);
		
		// 상품 등록 후 primary key product_id에 자동생성된 정보를 확보했는지 확인
//		Product newProduct =  new Product("갤럭시 26", "삼성", new BigDecimal("1400000"));
//		int insertResult = productMapper.registerProduct(newProduct);
//		logger.debug("등록 상품 수 : {}", insertResult);	// 1
//		logger.debug("총 상품 수 : {}", productMapper.getTotalProductCount());	// 11
//		logger.debug("등록된 상품의 productId 정보 : {}", newProduct.getProductId());	// null
		
		// 가격대별 검색(낮은 가격 이상 ~ 높은 가격 이하)
//		BigDecimal minPrice = new BigDecimal("500000");
//		BigDecimal maxPrice = new BigDecimal("1000000");
//		
//		List<Product> list =  productMapper.findByPriceRange(minPrice, maxPrice);
//		
//		for (Product p : list) {
//			logger.debug("상품 정보 : {}", p);
//		}
		
	}

}
