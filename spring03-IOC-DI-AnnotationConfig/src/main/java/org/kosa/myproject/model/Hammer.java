package org.kosa.myproject.model;

import org.springframework.stereotype.Component;

// 스프링 컨테이너에 자신이 컴포넌트임을 알려서 bean(컴포넌트)를 생성하고 관리하게 한다.
//@Component
@Component
public class Hammer implements Tool {

	@Override
	public void work() {
		System.out.println("망치로 일하다");

	}

}
