package javaBasic;

import java.util.Scanner;

/// ctrl+shift+C để comment nhiều hoặc 1 dòng

public class Topic_01_Data_Type {
	/// các biến dưới đây là toàn cục
	static int studentNumber;
	static boolean statusValue;
	static final String BROWSER_NAME = "Chrome"; 	///static + final sẽ là hằng số, mà hằng số thì nên viết hoa
	String studentName = "Nam";
	
	/// trong hàm static muốn dùng 1 biến toàn cục thì biến đó cũng phải là static
	public static void main(String[] args) {
		
//		System.out.println(studentNumber);		/// giá trị mặc định khi chưa gán giá trị bằng 0
//		System.out.println(statusValue);				/// gái trị mặc định là false
//		System.out.println(Topic_01_Data_Type.BROWSER_NAME);       /// biến static có thể truy cập bằng tên class
//		
//		
//		/// muốn sử dụng 1 biến ko là static thì như vầy
//		/// new 1 đối tượng mới là topic và truy cập thông qua nó
//		Topic_01_Data_Type topic = new Topic_01_Data_Type();
//		System.out.println(topic.studentName);
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println(name);			/// có ln là xuống hàng
		System.out.println(name);
		System.out.print(name);
		System.out.print(name);
	}
	
	/// hàm getter: getText, getCurrentURL, getTitle, getAttribute, getCssValue...
	/// void ko dùng return được
	public void setStudentName(String stdName) {
		/// biến n là cục bộ, trong phạm vi 1 hàm, và biến local ko có giá trị mặc định như biến toàn cục
		int n;
		System.out.println();
		this.studentName = stdName;
	}
	
	/// hàm setter là các action: sendkey, click, clear, select, back, forward, refresh...
	public String getStudentName() {
		return this.studentName;
	}
} 
