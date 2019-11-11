
import java.util.Calendar;

public class JulianDate implements JulianDates {
	
	private int day;
	private int month;
	private int year;
	private int jY;
	private int jM;
	private int jD;
	private int jB;
	protected double julian;
	private int JGREG= 15 + 31*(10+12*1582);
	private int[] date;
	private int[] todaysDate;

	public static void main(String[] args) 
	{
		JulianDate Julian = new JulianDate();
		//Print the returned Julian Date from the method, needs a parameter of  an Array that represents the todays date, takes the date from the Calendar instance of java
		System.out.println(Julian.julianDateAlgorithm(Julian.setDate(1997, 3, 19)));
	}
	
	public int[] setTodaysDate() {
		Calendar today = Calendar.getInstance();
		todaysDate = new int[]{today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DATE)};
		return todaysDate;
	}
	
	public int[] setDate(int y, int m, int d) {
		date = new int[]{y, m, d}; 
		return date;
	}
	
	/*
	 * @param Array that has the day at position 0, the month at position 1 and the year at position 2
	 */
	public double julianDateAlgorithm(int[] date) {
		year = date[0];
		month = date[1];
		day = date[2];
		jY = year;
		jD = day;
		if (year < 0)
			jY++;
		jM = month;
		if (month > 2)
		{
			jM++;
		}else
		{
			jY--;
			jM += 13;
		}
		julian = (Math.floor(365.25 * jY) + Math.floor(30.6001*jM) + jD + 1720995.0);
		   if (day + 31 * (month + 12 * year) >= JGREG)
		   {
			   //gregorianischer Kalender
			   jB = (int)(0.01 * jY);
			   julian += 2 - jB + (0.25 * jB);
		   }
		   return Math.floor(julian);
		 }
}