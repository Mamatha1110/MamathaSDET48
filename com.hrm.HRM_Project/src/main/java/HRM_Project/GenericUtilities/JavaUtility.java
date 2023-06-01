package HRM_Project.GenericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random rand = new Random();
		return rand.nextInt(1000);
	}
	
	public String systemDate()
	{
		Date currentDate = new Date();
		return currentDate.toString();
	}
	
	public String dateInRequiredFormat()
	{
		Date currentDate = new Date();
		String cDate = currentDate.toString();
		String[] curDate = cDate.split(" ");
		String dateFormat = curDate[2]+"/"+curDate[1]+"/"+curDate[5];
		return dateFormat;
	}
}
