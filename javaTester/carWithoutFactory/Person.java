package carWithoutFactory;

public class Person {

	public static void main(String[] args) {
		// buổi sáng
		Honda honda = new Honda();
		honda.viewCar();
		honda.driveCar();
		
		// buổi chiều
		Toyota toyota = new Toyota();
		toyota.viewCar();
		toyota.driveCar();
		
		// buổi tối
		Kia kia = new Kia();
		kia.viewCar();
		kia.driveCar();
	}

}
