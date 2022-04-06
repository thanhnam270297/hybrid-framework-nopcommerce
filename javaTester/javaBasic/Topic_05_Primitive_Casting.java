package javaBasic;

public class Topic_05_Primitive_Casting {

	public static void main(String[] args) {
		/* ngầm định (ko mất dữ liệu)
		byte bNumber = 126;
		System.out.println(bNumber);
		
		short sNumber = bNumber;
		System.out.println(sNumber);
		
		int iNumber = sNumber;
		System.out.println(iNumber);
		
		float fNumber = iNumber;
		System.out.println(fNumber);
		
		double dNumber = fNumber;
		System.out.println(dNumber);
		*/
		
		/// tường minh
		double dNumber = 92345678923432432d;
		System.out.println(dNumber);
		
		/// từ kiểu dữ liệu lớn qua nhỏ thì phải cast
		float fNumber = (float) dNumber;
		System.out.println(fNumber);
		
		long lNumber = (long) fNumber;
		System.out.println(lNumber);
		
		int iNumber = (int) lNumber;
		System.out.println(iNumber);
	}

}
