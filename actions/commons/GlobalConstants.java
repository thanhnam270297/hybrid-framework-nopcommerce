package commons;

/// các hằng số dùng chung cho tất cả các class
public class GlobalConstants {
	public static final String DEV_APP_URL_STRING = "https://demo.nopcommerce.com/";
	public static final String STG_APP_URL_STRING = "https://demo.nopcommerce.com/";
	public static final String UAT_APP_URL_STRING = "https://demo.nopcommerce.com/";
	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	
	public static final String PROJECT_PATH = System.getProperty("user,dir");
	public static final String UPLOAD_FILES_PATH = PROJECT_PATH + "/uploadFiles";
	public static final String DOWNLOAD_FILES_PATH = PROJECT_PATH + "/downloadFiles";
}
