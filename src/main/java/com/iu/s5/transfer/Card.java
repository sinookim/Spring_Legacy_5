package com.iu.s5.transfer;

import org.aspectj.lang.ProceedingJoinPoint;

public class Card {
	
	public void cardAfter() {
		System.out.println("카드결제");
		System.out.println("=============");
	}
	
	public Object cardCheck(ProceedingJoinPoint join) throws Throwable {
		System.out.println(join);
		System.out.println("=============");
		System.out.println("카드찍기 in");
		Object[] ar = join.getArgs();
		for (Object o : ar) {
			System.out.println(o);
		}
		Object obj = join.proceed();
		System.out.println("카드찍기 out");
		System.out.println("=============");
		
		return obj;
	}

}
