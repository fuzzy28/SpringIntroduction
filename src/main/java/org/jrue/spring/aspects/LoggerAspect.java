package org.jrue.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggerAspect {
	
	public Object calculateElapseTime(ProceedingJoinPoint point) {
		try {
			System.out.println("Calculating statistics");
			long s = System.currentTimeMillis();
			Object o = point.proceed();
			long e = System.currentTimeMillis();
			System.out.println("Statistics finished. in " + (e - s ));
			return o;
		} catch(Exception e) {
			System.out.println("Throws an exception");
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
}
