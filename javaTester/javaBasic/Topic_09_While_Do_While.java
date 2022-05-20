package javaBasic;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Topic_09_While_Do_While {
	
	Scanner scanner = new Scanner(System.in);

	// while: kiểm tra điều kiện trước rồi mới vào phần thân
	// do while: cho chạy phần thân trước ít nhất 1 lần rồi mới kiểm tra điều kiện

	public static void main(String[] args) {

		int i = 0;

		// block code, biến i chỉ sử dụng trong block code này
		for (i = 0; i < 5; i++) {
			System.out.println("For: " + i);
//			if (i == 3) {
//				break;
//			}
		}
		
		System.out.println("Biến i sau khi done vòng for: " + i);

		/* sau khi chạy for xong thì i = 5
		 * For: 0 For: 1 For: 2 For: 3 While: 3 While: 4 Do while: 5
		 * => ko thõa điều kiện để chạy while
		 */

		// i = 5 ko thõa mãn
		while (i < 5) {
			System.out.println("While: " + i);
			i++;
			if (i == 3) {
				break;
			}
		}

		// chạy ít nhất 1 lần rồi mới kiểm tra điều kiện
		do {
			System.out.println("Do while: " + i);
			i++;
		} while (i < 5);
	}
	
	@Test
	public void TC_01() {
		int number = scanner.nextInt();
		
		for (int i = number; i < 100; i++) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
	
	@Test
	public void TC_02() {
		int number = scanner.nextInt();
		
		while (number  < 100) {
			if(number % 2 == 0) {
				System.out.println(number);
			}
			number++;
		}
	}
	
	@Test
	public void TC_03() {
		int number = scanner.nextInt();
		
		do {
			if(number % 2 == 0) {
				System.out.println(number);
			}
			number++;
		} while (number  < 100);
	}
	
	@Test
	public void TC_04() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		
		// các số từ A đến B
		while (numberA < numberB) {
			// chia hết cho cả 3 và 5
			if(numberA % 3 == 0 && numberA % 5 == 0) {
				System.out.println(numberA);
			}
			numberA++;
		}
	}
	
	@Test
	public void TC_05() {
		int n = scanner.nextInt();
		int i = 0;
		
		// từ 0 đến n
		while (n > 0) {
			// số lẻ từ 0 đến n
			if(n % 2 != 0) {
				System.out.println(n);
				i += n;
			}
			n--;
		}
		System.out.println("Tổng: " + i);
	}
	
	@Test
	public void TC_06() {
		int n = scanner.nextInt();
		int i = 1;
		
		// từ 0 đến n
		while (n > 0) {
			// số lẻ từ 0 đến n
			i *= n;
			n--;
		}
		System.out.println("Giai thừa: " + i);
	}
}
