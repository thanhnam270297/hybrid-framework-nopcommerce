package javaBasic;

public class Topic_04_Operator {

	public static void main(String[] args) {
		/*
		int numberA = 10;
		numberA += 5;
		
		System.out.println(numberA);
		
		/// 15/5 = 3 => đáp án là 3
		System.out.println(numberA / 5);
		
		/// 15%6 = 2 dư 1 => đáp án là 1
		System.out.println(numberA % 7);
		
		///--------------------------///
		int numberB = 15;
		
		System.out.println(numberB++);
		/// in thằng numberB ra trước
		/// sau đó cộng thêm 1 => numberB là 16 nhưng in ra 15 vì lệnh in là lệnh trước lệnh ++
		
		
		/// bây giờ numberB đang là 16 và cộng thêm 1, vì lệnh ++ trước lệnh in => numberB là 17
		System.out.println(++numberB);
		*/
		
		///-------------------///
		int firstVariable = 5, secondVariable = 7;
		int result = firstVariable++ + ++secondVariable - 8;
		
		/// bước 4: firstvariable là postfix nên sẽ dược xử lí sau cùng
		System.out.println("First Variable = " + firstVariable);
		
		/// bước 1: secondvariable là prefix nên sẽ được xử lý trước
		System.out.println("Second Variable = " + secondVariable);
		
		/// bước 2: sau đó tới các toán hạn + - * /
		/// bước 3: gán kết quả cho result
		System.out.println("Third Variable = " + result);
		
		///-----------------------///
		String address = "Ho Chi Minh";
		
		/// biểu thức tam nguyên (có 3 dấu là = ? : )
		boolean status = (address == "Long An") ? true : false;
		System.out.println(status);
	}

}
