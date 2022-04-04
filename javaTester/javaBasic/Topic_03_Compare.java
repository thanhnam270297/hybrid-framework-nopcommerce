package javaBasic;

public class Topic_03_Compare {
	int number = 8;
	
	public static void main(String[] args) {
		/// 1 vùng nhớ chứa biến x
		int x = 5;
		/// 1 vùng nhớ chứa biến y
		int y = x;
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		y = 10;
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		/// cả 2 first và second đều tham chiếu đến cùng 1 ô nhớ
		Topic_03_Compare firstVariable = new Topic_03_Compare();
		Topic_03_Compare secondVariable = firstVariable;
		/// Topic_03_Compare secondVariable = new Topic_03_Compare(); trường hợp này mới là 2 ô nhớ khác nhau
		
		System.out.println("Before = " + firstVariable.number);
		System.out.println("Before = " + secondVariable.number);
		
		secondVariable.number = 15;
		
		System.out.println("After = " + firstVariable.number);
		System.out.println("After = " + secondVariable.number);
	}

}
