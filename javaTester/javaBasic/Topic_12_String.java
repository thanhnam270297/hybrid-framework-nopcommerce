package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_12_String {

	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String s1 = "Cat";
		String s2 = s1;
		String s3 = new String("Cat");

		// s1 và s2 có cùng vùng nhớ, s3 các vùng nhớ
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s2 == s3);
		// euqal tham chiếu cho string nên true
		System.out.println(s1.equals(s3));
	}

	@Test
	public void TC_01_lenght() {
		String schoolName = "Automation Testing";
		System.out.println("Lenght string is: " + schoolName.length());
	}

	@Test
	public void TC_02_charAt() {
		String schoolName = "Automation Testing";
		// truyền vào index nên bắt đầu từ 0
		System.out.println("Char at 5: " + schoolName.charAt(5));
	}

	@Test
	public void TC_03_concat() {
		String schoolName = "Automation Testing";
		// thực tế thì dùng phép + sẽ nhanh hơn dùng hàm concat
		System.out.println("New Name: " + schoolName.concat(" Class"));
	}

	@Test
	public void TC_04_equals() {
		String schoolName1 = "Automation Testing Web";
		String schoolName2 = "Automation Testing API";

		// kiểm tra tuyệt đối
		System.out.println("Compare 1: " + schoolName1.equals(schoolName2));
		System.out.println("Compare 2: " + schoolName1.equals("Automation Testing Web"));

		// kiểm tra tương đối, ko phân việt uppercase hoặc lowercase
		System.out.println("Compare 3: " + schoolName2.equalsIgnoreCase("automation testing apI"));
	}

	@Test
	public void TC_05_startsWith_endsWith_Contains() {
		String schoolName = "Automation Testing";

		System.out.println("Có bắt đầu bằng 1 kí tự / 1 chuỗi ko? => " + schoolName.startsWith("A"));
		System.out.println("Có kết thúc bằng 1 kí tự / 1 chuỗi ko? => " + schoolName.endsWith("g"));
		System.out.println("Có chứa 1 kí tự / 1 chuỗi ko? => " + schoolName.contains("mati"));
	}

	@Test
	public void TC_06_index() {
		String schoolName = "Automation Testing";
		// thực tế thì dùng phép + sẽ nhanh hơn dùng hàm concat
		System.out.println("Vị trí " + schoolName.indexOf("Testing"));
		System.out.println("Vị trí " + schoolName.indexOf("T"));
	}

	@Test
	public void TC_07_subString() {
		String schoolName = "Automation Testing";
		// thực tế thì dùng phép + sẽ nhanh hơn dùng hàm concat
		System.out.println("Sub String 1: " + schoolName.substring(4, 13));
		System.out.println("Sub String 2: " + schoolName.substring(11));

		// hàm split tách chuỗi dựa vào kí tự khoảng trắng, => cho ra mảng kí tự
		String result[] = schoolName.split(" ");
		System.out.println("Sub String 3: " + result[1]);
	}

	@Test
	public void TC_08_replace() {
		String price = "$100.00";
		price = price.replace("$", "");
		System.out.println(price);

		float priceF = Float.parseFloat(price);
		System.out.println("After Replace: " + priceF);
	}

	@Test
	public void TC_09_trim() {
		String schoolName = "    \n    \t Automation Testing	\n ";
		System.out.println(schoolName);
		// trim dùng để loại bỏ khoảng trắng, tab, xuống dòng ở đầu và sau chuỗi
		System.out.println("New Name: " + schoolName.trim());
	}

	@Test
	public void TC_10_convert() {
		int number1 = 70;
		String value1 = String.valueOf(number1);
		System.out.println("Value1 String = " + value1);
		value1 = number1 + "zzz";
		System.out.println("Value1 String lần 2 = " + value1);

		String value2 = "1000";
		int number2 = Integer.parseInt(value2);
		System.out.println("Number2 = " + number2);
	}

	@Test
	public void TC_11_Ex1() {
		String schoolName = "    \n    \t Automation Testing	\n ";
		int upper = 0;
		int lower = 0;

		// cho chạy vòng lặp
		for (int i = 0; i < schoolName.length(); i++) {
			
			// cho về kiểu char
			char character = schoolName.charAt(i);
			
			if (character >= 'A' && character <= 'Z') {
				upper++;
			} else if (character >= 'a' && character <= 'z') {
				lower++;
			}
		}
		
		System.out.println("UPPERCASE letters: " + upper);
		System.out.println("lowercase letters: " + lower);
		
	}

	@Test
	public void TC_12_Ex2() {
		String schoolName = "Automation Testing 345 Tutorials Online 789";
		int a = 0;
		int so = 0;
		
		for (int i = 0; i < schoolName.length(); i++) {
			// cho về kiểu char
			char character = schoolName.charAt(i);
			
			// kí tự a
			if (character == 'a' || character == 'A') {
				a++;
			} 
			
			// number
			if(character <= '9' && character >= '0') {
				so++;
			}
		}
		
		System.out.println("Kí tự a trong chuỗi: " + a);	
		System.out.println("Chuỗi có chứa từ Testing: " + schoolName.contains("Testing"));
		System.out.println("Chuỗi bắt đầu bằng từ Automation: " + schoolName.startsWith("Automation"));
		System.out.println("Chuỗi kết thúc bằng từ Online: " + schoolName.endsWith("Online"));
		System.out.println("Vị trí từ Tutorials: " + schoolName.indexOf("Tutorials"));
		System.out.println("Chuỗi mới: " + schoolName.replace("Online", "Offline"));
		System.out.println("Số lượng kí tự số trong chuỗi: " + so);
	}
	
	@Test
	public void TC_13_Ex3() {
		String userName = scanner.nextLine();
		
		// dùng hàm reverse
		String Reverse = new StringBuilder(userName).reverse().toString();
		
		System.out.print("Original word: " + userName);
		System.out.println("/n");
		System.out.print("Reverse word: " + Reverse);
		System.out.println("/n");
	}
}
