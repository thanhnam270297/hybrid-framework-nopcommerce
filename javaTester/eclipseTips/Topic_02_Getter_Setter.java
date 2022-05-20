package eclipseTips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_02_Getter_Setter {

	/*
	 * carName này có thuộc tính là private 
	 * => bên ngoài class sẽ ko truy cập được đến carName 
	 * trong lthđt thì sẽ thông qua các hàm chứ ko cho phép truy cập trực tiếp đến carName 
	 * các hàm đó là getter và setter
	 */
	private String carName;
	private String carColor;
	private String carType;

	

	/**
	 * @return the carColor
	 */
	public String getCarColor() {
		return carColor;
	}

	/**
	 * @param carColor the carColor to set
	 */
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	/**
	 * @return the carType
	 */
	public String getCarType() {
		return carType;
	}

	/**
	 * @param carType the carType to set
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	
	/* nếu có quá nhiều biến cần gán getter setter
	 * right click > source > generate getter setter > select biến cần tạo getter setter
	 * package thì chỉ truy cập từ các class chung package
	 * method comment là tạo java doc
	 */

}
