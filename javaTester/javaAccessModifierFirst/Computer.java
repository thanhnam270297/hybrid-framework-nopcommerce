package javaAccessModifierFirst;

public class Computer {
	
	// private chỉ sử dụng trong class, class ngoài ko truy cập đc
	// lỗi not visible
	
	// property
	private int ssdSize;
	
	// method
	private void setSsdSize(int ssdSize) {
		
		// tên biến khác nhau thì ko cần dùng this
		this.ssdSize = ssdSize;
	}
	
	public static void main(String[] args) {
		Computer comp = new Computer();
		
		comp.ssdSize = 128;
		System.out.println(comp.ssdSize);
		
		comp.setSsdSize(256);
		System.out.println(comp.ssdSize);
	}
}
