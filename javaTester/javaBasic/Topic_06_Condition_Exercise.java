package javaBasic;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Topic_06_Condition_Exercise {

	Scanner scanner = new Scanner(System.in);
	
	@Test
	public void TC_01() {
		
		int number = scanner.nextInt();
		
		/* dài
		number = number % 2;
		System.out.println("Số dư là " + number);
		
		boolean status = number == 0;
		System.out.println(status);
		
		if(status) {
			System.out.println("Số" + number + " là số chẵn.");
		} else {
			System.out.println("Số" + number + " là số lẻ.");
		} */
		
		if(number % 2 == 0) {
			System.out.println("Số" + number + " là số chẵn.");
		} else {
			System.out.println("Số" + number + " là số lẻ.");
		}
	}
	
	@Test
	public void TC_02() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		if(a > b) {
			System.out.println(a + " lớn hơn " + b);
		} else if(a == b){
			System.out.println(a + " bằng " + b);
		} else {
			System.out.println(a + " nhỏ hơn " + b);
		}
	}
	
	@Test
	public void TC_03() {
		String firstStudent = scanner.nextLine();
		String secondStudent = scanner.nextLine();
		
		// equals dùng cho kiểu dữ liệu reference: string
		// kiểm tra cái value của biến
		// kiểm tra vị trí của biến trong vùng nhớ
		if(firstStudent.equals(secondStudent)) {
			System.out.println("Hai sinh viên trùng tên nhau.");
		} else {
			System.out.println("Hai sinh viên khác tên nhau.");
		}
		
		// dùng cho kiểu dữ liệu primitive type
		if(firstStudent == secondStudent) {
			System.out.println("Hai sinh viên trùng tên nhau.");
		} else {
			System.out.println("Hai sinh viên khác tên nhau.");
		}
	}
	
	@Test
	public void TC_04() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		if(a > b && a > c) {
			System.out.println(a + " lớn nhất");
		} else if(b > c){
			System.out.println(b + " lớn nhất");
		} else {
			System.out.println(c + " lớn nhất");
		}
	}
	
	@Test
	public void TC_06() {
		float diem = scanner.nextFloat();
		
		if(10 >= diem && diem >= 8.5) {
			System.out.println("Điểm A");
		} else if(8.5 > diem && diem >= 7.5) {
			System.out.println("Điểm B");
		} else if(7.5 > diem && diem >= 5) {
			System.out.println("Điểm C");
		} else if(5 > diem && diem >= 0){
			System.out.println("Điểm D");
		} else {
			System.out.println("Nhập điểm lại");
		}
	}
	
	@Test
	public void TC_07() {
		int month = scanner.nextInt();
		
		// tháng 31 ngày 1 3 5 7 8 10 12
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("Tháng có 31 ngày");
		} else if(month == 2) {
			System.out.println("Tháng có 28 ngày");
		} else if(month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("Tháng có 30  ngày");
		} else {
			System.out.println("Vui lòng nhập tháng từ 1 đến 12!");
		}
	}
}
