package genericUtilities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Random;

public class Java_utility {
public int getRandomNum() {

	/**
	 * this method is used to fetch the random class 
	 * @return 
	 */
	
		Random ran = new Random();
		int ranDomNum = ran.nextInt(10000);
		return ranDomNum;
}

/**
 * it is used to get the current system date based on YYYY-MM-DD format
 * @return
 */
	public String getSystemDate() {
		String timeStam=LocalDateTime.now().toString().replace(":", "-");
		return timeStam;
	}

	/**it is used to get the current system date based on DD-MM-YYYY format
 * @return
	 */
	
	public String getSystemDateIST() {
		Date date=new Date(0, 0, 0);
		String currentDate=date.toString();
		System.out.println(currentDate);
		String[] arr=currentDate.split("");
		
		String yyyy=arr[5];
		String dd=arr[2];
		int mm=date.getMonth()+1;
		
		String format= dd+"-"+mm+"-"+yyyy;
		return format;
	}
	
	
}