public class TestJulianDate {
	
	private JulianDate Julian;
	private String error;
	private int year = 1997;
	private int month = 3;
	private int day = 19;
	private double expectedJD = 2450527.0;
	private double daysBetween = 0;
	private double expectedDaysBetween = 28;
	
	public static void main(String[] args) 
	{
		TestJulianDate test = new TestJulianDate();
		test.startTesting();	
	}
	
	private void startTesting() {
		Julian = new JulianDate();
		if(testSettingTodaysDate())
			System.out.println("testSettingTodaysDate(): Successful");
		else
			System.out.println("Test harness returned false: " + error);
		
		if(testSettingDate())
			System.out.println("testSettingDate(): Successful");
		else
			System.out.println("Test harness returned false: " + error);
		
		if(testCorrectness())
			System.out.println("testCorrectness(): Successful");
		else
			System.out.println("Test harness returned false: " + error);
		
		if(testDaysBetweenDates())
			System.out.println("testDaysBetweenDates(): Successful");
		else
			System.out.println("Test harness returned false: " + error);
	}
	
	private boolean testSettingTodaysDate() {
		try {
		Julian.julianDateAlgorithm(Julian.setTodaysDate());
		return true;
		}
		catch(Exception e){
			error = "Unable to set todays date";
			return false;
		}	
	}
	
	private boolean testSettingDate() {
		try {
		Julian.julianDateAlgorithm(Julian.setDate(year, month, day));
		return true;
		}
		catch(Exception e){
			error = "Unable to set date";
			return false;
		}	
	}
	
	private boolean testCorrectness() {
		double julian = 0;
		try {
			julian = Julian.julianDateAlgorithm(Julian.setDate(year, month, day));
			if(julian == expectedJD) {
				return true;
			}
			else {
				error = "Julian Date was different to expected one";
				return false;
			}
		}catch (Exception e) {
			error = "Unable to set Date";
			return false;
		}
	}
	
	private boolean testDaysBetweenDates() {
		double julian1 = 0;
		double julian2 = 0;
		try {			
			julian1 = Julian.julianDateAlgorithm(Julian.setDate(year, month, day));
			julian2 = Julian.julianDateAlgorithm(Julian.setDate(year, month - 1, day));
			daysBetween = julian1 - julian2;
			if(daysBetween == expectedDaysBetween)
			return true;
			else {
				error = "Calculated days between the dates is a different one then expected";
				return false;
			}
		}
		catch(Exception e) {
			error = "Unable to set Date";
			return false;
		}
	}
}

