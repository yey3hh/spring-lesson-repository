package org.kosa.myproject;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect	// AOP 담당 클래스임을 알림. AOP Cross Cutting Logic을 담당하는 클래스
@Component
public class LoggingAspect {
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@After("execution(public * org.kosa.myproject.model.*Service.*(..))")
	public void logging(JoinPoint point) {	// JoinPoint : 대상 클래스와 메서드 정보를 저장
		String className = point.getTarget().getClass().getName();	// 실제 누가 실행되느냐!
		String methodName = point.getSignature().getName();	// 실제 메서드 명 누구냐!
		// AOP 적용 대상 메서드의 매개변수가 있다면 매개 변수의 정보를 함께 로깅한다.
		Object params[] = point.getArgs();	// obejct 타입의 배열 (뭐가 올지 모르니까)
		StringBuilder paramList = new StringBuilder();
		
		for (int i = 0; i < params.length; i++) {
			paramList.append(params[i]).append(" ");
		}
		logger.debug("*** AOP cross cutting concern 공통기능 class:{} method:{} param:{} ***", className, methodName, paramList);
	}
	
}
