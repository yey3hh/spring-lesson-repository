package org.kosa.myproject.model.board;

import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	public String find() {
		try {
			Thread.sleep(100);	// 0.1초 소요
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 	
		
		System.out.println("Core find post");
		return "게시판 정보";
	}
	
	public String findAllList() {	// warn으로 출력되어야 함
		try {
			Thread.sleep(700);	// 0.7초 소요
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Core findList post");
		return "게시물 리스트 정보";
	}
}
