

public class TestJulianDate {
	private JulianDate Julian;
	private String error;
	private int year;
	private int month;
	private int day;
	private double expectedJD;
	
	public static void main(String[] args) 
	{
		TestJulianDate test = new TestJulianDate();
		test.startTesting();		
	}
	
	private void startTesting() {
		if(testGet())
			System.out.println("testGet(): Successful");
		else
			System.out.println("Test harness returned false: " + error);
		
		if(testCorrectness())
			System.out.println("testCorrectness(): Successful");
		else
			System.out.println("Test harness returned false: " + error);
	}
	
	private boolean testGet() {
		Julian = new JulianDate();
		try {
		Julian.julianDateAlgorithm(Julian.setTodaysDate());
		return true;
		}
		catch(Exception e){
			error = "Unable to get JulianDate from class";
			return false;
		}	
	}
	
	private boolean testCorrectness() {
		Julian = new JulianDate();
		double julian = 0;
		year = 1997;
		month = 3;
		day = 19;
		expectedJD = 2450527.0;
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
}

