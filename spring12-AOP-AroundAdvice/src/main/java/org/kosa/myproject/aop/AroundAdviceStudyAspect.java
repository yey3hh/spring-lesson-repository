package org.kosa.myproject.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.kosa.myproject.model.InventoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect	// AOP 담당 클래스임을 컨테이너에게 알려줌
@Component	// Bean으로 생성, 관리되어야 함을 컨테이너에게 알려줌, 관리해줘!
public class AroundAdviceStudyAspect {	
	private static final Logger logger = LoggerFactory.getLogger(AroundAdviceStudyAspect.class);
	/*
	 * 	Around Advice(적용 시점) : 공통 기능을 core 어느 시점에 적용할까, before, after, after-returning, after-throwing 4가지 advice를 모두 around advice로 처리할 수 이씀
	 * 							 - before : 메서드 실행 전
	 * 							 - after : 메서드 실행 후 (예외 발생과 관계 없이), 항상 실행
	 * 							 - after-returning : 메서드 정상 실행 후 값이 return 될 때
	 * 							 - after-throwing : Exception 및 Error 발생될 때
	 */
	@Around("execution(public * org.kosa.myproject.model.*Service.*(..))")
	public Object testAround(ProceedingJoinPoint point) throws Throwable {	// 여기서 JoinPoint 쓰면 에러 - proceed() 없음. 핵심 기능 사용 불가
		// 실제 core를 수행, 만약 AroundAdvice 환경에서 반드시 명시 해야한다. 
		// 아래 코드를 명시하지 않으면 -> core 실행 안됨
		String className = point.getTarget().getClass().getName();
		String methodName = point.getSignature().getName();
		logger.debug("*** AOP Before *** class:{} method:{}", className, methodName);
		Object retValue = null;
		try {
			retValue = point.proceed();	// 실제 core 메서들을 실행! -> 매우 중요한 코드 라인
			if (retValue != null) {	// return 값이 있을 때
				// 테스트 용도로 retValue로 조작해본다.
//			retValue = "집 보내 줘";
				logger.debug("*** AOP After-returning *** return : {}", retValue);	// 정상적으로 리턴할 때 실행하는 advice
			}
		} catch (InventoryException ie) {	// after throwing : 재고 부족으로 예외 발생할 때 대처
			// 공급처에 정보 전달
			logger.error("*** AOP After-Throwing *** message:{}",ie.getMessage(), ie);
			throw ie;
		} finally {	
			logger.error("*** AOP After ***");	// 예외 발생 여부와 상관없이 항상 실행되는 부분
		}
		return retValue;
	}
}	
