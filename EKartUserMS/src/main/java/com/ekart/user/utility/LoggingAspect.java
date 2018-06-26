package com.ekart.user.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	@Before("execution(* com.ekart.user.service.*.*(..)) || execution(* com.ekart.user.repository.*.*(..)) || execution(* com.ekart.user.controller.*.*(..))")
	public void logInfoBeforeMethod(JoinPoint joinPoint) throws Exception {
		logInfo("Entering method: " + joinPoint.getSignature().toShortString());
	}

	@After("execution(* com.ekart.user.service.*.*(..)) || execution(* com.ekart.user.repository.*.*(..)) || execution(* com.ekart.user.controller.*.*(..))")
	public void logInfoAfterMethod(JoinPoint joinPoint) throws Exception {
		logInfo("Exiting method: " + joinPoint.getSignature().toShortString());
	}

	private void logInfo(String msg) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info(msg);
	}

}
