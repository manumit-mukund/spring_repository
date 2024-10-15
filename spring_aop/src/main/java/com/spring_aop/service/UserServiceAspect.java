package com.spring_aop.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

//@Component -- This is also working
@Service
@Aspect
public class UserServiceAspect {

	@Before("execution(* com.spring_aop.controller.UserController.getAllUsers(..))")
	public void myBeforeAdvice(JoinPoint jp) {

		System.out.println("myBeforeAdvice called.");

	}

	@After("execution(* com.spring_aop.controller.UserController.hello(..))")
	public void myAfterAdvice(JoinPoint jp) {

		System.out.println("myAfterAdvice called.");

	}

	@AfterReturning("execution(* com.spring_aop.controller..*(..))")
	public void myAfterReturning(JoinPoint jp) {

		System.out.println("myAfterReturning called.");

	}

	// @Around("execution(* com.spring_aop.controller..*(..))")
	public void myAroundAdvice(ProceedingJoinPoint jp) {

		System.out.println("myAroundAdvice called.");
		try {

			jp.proceed();

		} catch (Throwable e) {

			System.out.println("Exception occurred : " + e);
		}

	}
}
