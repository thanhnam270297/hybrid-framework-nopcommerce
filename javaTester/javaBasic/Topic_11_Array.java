package javaBasic;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class Topic_11_Array {

	public static void main(String[] args) {
//		// khai báo mảng
//		int numberA[] = {1, 2, 69, 8, 99};
//		int[] numberB = {11, 24, 6, 82, 90};
//		
//		// lấy ra phần tử của mảng, truyền index vào
//		System.out.println(numberA[2]);
//		System.out.println(numberB[6]); // khi truyền index vượt quá số index hiện có của mảng => báo lỗi
		
		// Array phải cố định phần tử ngay từ đầu, trong quá trình chạy ko add thêm vào đc
		// ArrayList thì đc
		
		// cố định khi viết code
		String[] studentName = {"Hoa", "Nhi", "Tài"};
		studentName[0] = "Nam"; // Nam sẽ thế chỗ Hoa
		
		for (int i = 0; i < studentName.length; i++) {
			if (studentName[i].equals("Tài")) {
				System.out.println("Tài buscu");
			}
		}
		
		// động => khi chạy code mới add
		ArrayList<String> stdName = new ArrayList<String>();
		for (String std : stdName) {
			stdName.add(std);
		}
		
		// chuyển list thành mảng
		

	}

	@Test
	public void TC_01_Find_Max_Number_In_List() {
		int number[] = {1, 99, 35, 8, 98};
		int x = 0;
		
		for (int i = 0; i < number.length; i++) {
			if(x < number[i]) {
				x = number[i];
			}
		}
		System.out.println(x);
	}
	
	@Test
	public void TC_02_Sum_First_And_Last() {
		int number[] = {1, 99, 35, 8, 98};
		System.out.println("Tổng là: " + (number[0] + number[number.length - 1]));
	}
	
	@Test
	public void TC_03_Find_Even_Number() {
		int number[] = {1, 99, 35, 8, 98};
		for (int i = 0; i < number.length; i++) {
			if(number[i] % 2 == 0) {
				System.out.println("Even number: " + number[i]);
			}
		}
	}
	
	@Test
	public void TC_04_Average() {
		int number[] = {1, 99, 35, 8, 98};
		float sum = 0;
		for (int i = 0; i < number.length; i++) {
			sum += number[i];
		}
		
		System.out.println("Trung bình cộng: " + (sum / number.length));
	}
	
}
