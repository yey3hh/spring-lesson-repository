package org.kosa.myproject;

import org.springframework.util.StopWatch;

public class StopWatchUnitTest {
	public String findAllList() throws InterruptedException {
		StopWatch watch = new StopWatch();
		watch.start();
		
		// 시작 구간
		Thread.sleep(700);	// 0.7초
		
		System.out.println("DB에서 List를 조회");
		// 끝 구간

		watch.stop();
		System.out.println(watch.getTotalTimeMillis()); // 밀리 세컨드 단위로 소요 시간을 보여줌
		return "all list";
	}
	
	
	public static void main(String[] args) {
		// StopWatch Test 용도
		System.out.println("StopWatch");
		try {
			new StopWatchUnitTest().findAllList();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
