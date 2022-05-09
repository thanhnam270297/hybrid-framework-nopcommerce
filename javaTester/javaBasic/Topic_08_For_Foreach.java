package javaBasic;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Topic_08_For_Foreach {

	@Test
	public void TC_01_For() {

		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}

		/*
		 * vế 1: biến tạm dùng để tăng giá trị lên sau mỗi lần duyệt, dùng để so sánh
		 * với tổng giá trị vế 2: so sánh vs tổng vế 3: tăng i lên 1 đơn vị sau khi chạy
		 * phần thân for
		 */

		/*
		 * lần 1: i = 0 0 < 5 : đúng in số 0 ra i++ tăng lên 1 đơn vị (i = 1)
		 */

		/*
		 * lần 2 i = 1 1 < 5 : đúng in số 1 ra i++ tăng lên 1 đơn vị (i = 2)
		 */

		/*
		 * lần 6 i = 5 5 < 5 : sai
		 */

		System.out.println("--------------------------");

		for (int i = 0; i <= 5; i++) {
			System.out.println(i);
		}

		/*
		 * lần 6 i = 5 5 <= 5 : đúng in số 5 ra i++ tăng lên 1 đơn vị (i = 6)
		 */

		/*
		 * lần 7 i = 6 6 <= 5 : sai
		 */
	}

	@Test
	public void TC_02_For() {
		/// array cos 5 phần tử
		String[] cityName = { "Sai Gon", "Ha Noi", "Da Nang", "Can Tho", "Long An" };
		/// array / list / queue (index) bắt đầu từ 0

		/// for: dùng để chạy hết tất cả các giá trị
		for (int i = 0; i < cityName.length; i++) {
			System.out.println(cityName[i]);
		}

		/// for kết hợp với if: thõa mãn điều kiện mới action
		/// có biến đếm cityName[i], dùng để điều kiện để filter
		for (int i = 0; i < cityName.length; i++) {
			if (cityName[i].equals("Long An")) {
				System.out.println("Do action!");
				break;
				/// nếu ko có break thì tất cả các giá trị trong mảng đều đc chạy qua dù đã thõa
				/// điều kiện
			}
		}
	}

	@Test
	public void TC_03_Foreach() {
		String[] cityName = { "Sai Gon", "Ha Noi", "Da Nang", "Can Tho", "Long An" };

		/// java collection
		/// class: arraylist / linkedlist / vector / ...
		/// interface: list / set / queue / ...
		List<String> cityAddress = new ArrayList<String>();
		
		/// lúc chưa add cho cityAddress thì số phần tử là 0
		System.out.println(cityAddress.size());

		/// compile coding: add lúc viết code
		cityAddress.add("Vung Tau");
		cityAddress.add("Lam Dong");
		
		/// sau khi add 2 phần tử VT và LĐ thì số lượng là 0
		System.out.println(cityAddress.size());
		
		/// city là 1 biến tạm đại diện cho các phần tử trong mảng
		for (String city : cityName) {
			/// runtime (running) lúc chạy code mới add
			/// sau khi add các phần tử của cityName vào cityAddress thì tổng số lượng phần tử là 7
			cityAddress.add(city);
		}

		System.out.println(cityAddress.size());
		
		for (String cityAdd : cityAddress) {
			System.out.println(cityAdd);
		}
	}
}
