package org.jrue.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAnnotatedAspect {

	@Pointcut("execution(* org.jrue.spring.model.Statistics.get*())")
	public void getPointcut() {}
	
	@Before("getPointcut()")
	public void beforeAdvice(){
		System.out.println("Annotated before called"); 
	}
	
	@After("getPointcut()")
	public void afterAdvice() {
		System.out.println("Annotated after called"); 
	}
	
	@Around("getPointcut()")
	public Object aroundAdvice(ProceedingJoinPoint point){
		try {
			System.out.println("Annotation based Calculating statistics");
			long s = System.currentTimeMillis();
			Object o = point.proceed();
			long e = System.currentTimeMillis();
			System.out.println("Annotation based Statistics finished. in " + (e - s ));
			return o;
		} catch(Exception e) {
			System.out.println("Annotation based Throws an exception");
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	
	@Pointcut("execution(* org.jrue.spring.model.Customer.getFullName())")
	public void customergetNamepointCut() {}
	
	@Around("customergetNamepointCut()")
	public Object logGetName(ProceedingJoinPoint point) throws Throwable {
		Object o = point.proceed();
		System.out.println(">>>>>>>>>>>>>>>New customer is " +  o);
		return o;
	}
	
	@Pointcut("execution(* org.jrue.spring.model.Student.setName(String))"
			+ "&& args(name)")
	public void studentPointCut(String name) {}
	
	@Before("studentPointCut(name)")
	public void welcomeNewStudent(String name) {
		System.out.printf("Welcome %s! :) \n",name);
	}
}
