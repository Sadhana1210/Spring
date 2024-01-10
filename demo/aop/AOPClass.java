package com.example.demo.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPClass {
Logger l=LoggerFactory.getLogger(AOPClass.class);
	@Pointcut(value="execution(* com.example.demo.*.*.*(..))")
	public void methodAop() {
}
	@After("methodAop()")
	public void methodDisplay() {
		l.warn("sadjan");
	}
	
	@AfterReturning(pointcut="methodAop()",returning="o")
	public void method1(JoinPoint j,Object o) {
		l.warn("here "+j.getSignature().getName()+ " class :"+j.getTarget().getClass()+" here result "+o);
	}
	}
