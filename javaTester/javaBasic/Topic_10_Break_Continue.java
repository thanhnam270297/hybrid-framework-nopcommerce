package javaBasic;

import java.util.Iterator;

public class Topic_10_Break_Continue {

	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
//
//			// continue là loại trừ, ko in ra chứ ko phải tiếp tục
//			if (i == 5) {
//				continue;
//			}
//			System.out.println(i);
//		}

//		for (int i = 0; i < 10; i++) {
//
//			// break là dừng chạy khi i = 7, ko chạy 8 9
//			if (i == 7) {
//				break;
//			}
//			System.out.println(i);
//		}
		
		// nested for, trong for có thể lòng vào 1 vòng lặp for, while, do-while, if else
		for (int i = 0; i <= 5; i++) {
			
			System.out.println("Lần chạy của i (for thứ nhất): " + i);
			
			for (int j = 0; j <= 5; j++) {
				if(j == 4) {
					continue;
				}
				System.out.println("Lần chạy của j (for thứ hai): " + j);
				
				for (int x = 0; x <= 5; x++) {
					if(x == 4) {
						break;
					}
					System.out.println("x của for thứ ba: " + x);
				}
			}
		}

	}

}
