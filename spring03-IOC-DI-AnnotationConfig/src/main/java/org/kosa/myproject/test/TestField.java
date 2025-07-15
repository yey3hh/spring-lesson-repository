package org.kosa.myproject.test;

public class TestField {
	private final String id;
	
	public TestField(String id) {	// 생성자를 통한 할당은 가능
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	// final field 일 때 아래 방식 할당은 불가능. 컴파일 에러, 이유는 final은 재할당이 안되기 때문에
//	public void setId() {
//		this.id = id;
//	}
}
