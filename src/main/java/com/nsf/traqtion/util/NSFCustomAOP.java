package com.nsf.traqtion.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * NSFCustomAOP is Aspect class which is use to for logging , Time tracking etc..
 * This classed implement AspectJ annotations to execute logic at certain point of execution or methods using pattern.
 * @author HTC Global Services
 *  
 */
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Aspect
public class NSFCustomAOP {
	private static final Logger log = LogManager.getLogger(NSFCustomAOP.class);
	/**
	 * selectAll() is the definition for a pointcut to select all the methods
	 * available. So advice will be called for all the methods.
	 */
	@Pointcut("execution(* com.nsf.traqtion..*.*(..))")
	private void selectAll() {
	}

	/**
	 *  This is the method which executes before a selected method
	 * execution.
	 * @param joinPoint
	 */
	@Before("selectAll()")
	public void beforeAdvice(JoinPoint joinPoint) {
		// logging track before entering any method
		log.info("Tracking :: "+joinPoint.getTarget().getClass().getName()+" :: "+joinPoint.getSignature().getName());
		log.info(" ---> ");
	}

	/**
	 * This is the method which executes after a selected method
	 * execution.
	 * @param joinPoint
	 */
	//@After("selectAll()")
	public void afterAdvice(JoinPoint joinPoint) {
		// System.out.println("inside after
		// advice."+joinPoint.getSignature().getName());
	}

	/**
	 * This is the method which executes after a selected method
	 * execution.
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Around("selectAll()")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object retVal = joinPoint.proceed();
		stopWatch.stop();
		//logging class and method names and time take to execute the method
		log.info(joinPoint.getTarget().getClass().getName() + " :: " + joinPoint.getSignature().getName()+" :: "+" Execution Time : " + stopWatch.getTotalTimeMillis());
		return retVal;
	}
	/*
		   *//**
				 * This is the method which executes when any
				 * method returns something.
				 */
	/*
	 * @AfterReturning(pointcut = "selectAll()", returning="retVal") public void
	 * afterReturningAdvice(Object retVal,JoinPoint joinPoint){
	 * System.out.println("Returning:" + retVal.toString() );
	 * System.out.println("inside after returninge."+joinPoint.getSignature().
	 * getName()); }
	 * 
	 *//**
		 * This is the method which execute ifs there is an
		 * exception raised by any method.
		 */
	/*
	 * @AfterThrowing(pointcut = "selectAll()", throwing = "ex") public void
	 * AfterThrowingAdvice(IllegalArgumentException ex,JoinPoint joinPoint){
	 * System.out.println("There has been an exception: " + ex.toString());
	 * System.out.println("inside after returninge."+joinPoint.getSignature().
	 * getName()); }
	 */}
