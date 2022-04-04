package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Execise {

	@Test
	public void TC_01() {
		int a = 6;
		int b = 2;
		
		System.out.println("Tổng =" + (a + b));
		System.out.println("Hiệu =" + (a - b));
		System.out.println("Tích =" + (a * b));
		System.out.println("Thương =" + (a / b));
	}
	
	@Test
	public void TC_02() {
		float d = 7.5f;
		float r = 3.8f;
		
		System.out.println("Area =" + (d * r));
	}
	
	@Test
	public void TC_03() {
		String name = "Nam Nguyễn";
		
		System.out.println("Hello " + name);
	}
}
