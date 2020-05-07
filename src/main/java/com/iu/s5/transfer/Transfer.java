package com.iu.s5.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	public void bus(int money) {
		System.out.println("=============");
		System.out.println("Bus타기");
		System.out.println("음악듣기");
		System.out.println("=============");
	}
	
	public void subway(int money, String line) {
		System.out.println("=============");
		System.out.println("Subway타기");
		System.out.println("핸드폰보기");
		System.out.println("=============");
	}
	
	public void taxi() {
		System.out.println("=============");
		System.out.println("taxi타기");
		System.out.println("=============");
	}
}
