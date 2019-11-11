import java.util.Calendar;
import java.util.Scanner;

public class CheckBirthday {
	
	private JulianDate Julian;
	private double todaysDate = 0;
	private double julianBirthday = 0;
	private double daysOnEarth = 0;
	private int bDay = 0;
	private int bMonth = 0;
	private int bYear = 0;
	private double person1 = 0;
	private double person2 = 0;
	private String name1 = "";
	private String name2 = "";
	private double today;
	private double birth;
	private double weekDay;
	private double daysAlive;
	

	public static void main(String[] args) {
		CheckBirthday Birthday = new CheckBirthday();
		Birthday.today = Birthday.getTodaysDate(); //get the date of the day	
	/*
	 * Uncomment the method you want to run
	 */
		//Birthday.calculateForOnePerson();
		Birthday.calculateForTwoPerson();
	}
	
	private void checkForEvent(double daysAlive) {
		checkForSunday(weekDay);
		happyBirthday();
		divisible100(daysAlive);
	}
	
	private double calculateForOnePerson() {
		birth = getBirthday(); //Input of the birthday from one user
		weekDay = checkForWeekDayOfBirth(birth);
		daysAlive = calculateDaysOnEarth(today, birth);
		checkForEvent(daysAlive);
		calculateDaysOnEarthMetric(daysAlive);
		return daysAlive;
	}
	
	private void calculateForTwoPerson() {
		compareTwoBirthdays();
		//checkForEvent(daysAlive);
		
	}
	
	private void divisible100(double days) {
		if(days%100 == 0)
		{
			System.out.println("Your days on earth a divisible by 100 without rest, nice!");
		}
	}
	
	private void checkForSunday(double day) {
		if(day == 6) {
			System.out.println("Congratulations! I think you are kind of a special person?");
		}
	}
	
	private double calculateDaysOnEarth(double today, double birthday){
		daysOnEarth = today - birthday;
		//checkForWeekDayOfBirth(birthday);
		System.out.println("and you are living on earth since: " + daysOnEarth + " days.");
		checkForEvent(daysOnEarth);
		return daysOnEarth;
	}
	
	private void calculateDaysOnEarthMetric(double days) {
		double metYears = days/1000;
        System.out.println("In the metric calendar, you are " + metYears + " years old.");
	}
	
	private double checkForWeekDayOfBirth(double weekDay) {
		weekDay = Math.floor(weekDay + 0.5)%7;
		System.out.println("You were born on " + setWeekDay(weekDay));
		return weekDay;
	}
	
	private void happyBirthday() {
		Calendar today = Calendar.getInstance();
		if(bMonth == today.get(Calendar.MONTH)+1) {
			{
				if(bDay == today.get(Calendar.DATE))
				System.out.println("Happy birthday!");
			}
		}
	}
	
	private void compareTwoBirthdays() {
		person1 = calculateForOnePerson();
		person2 = calculateForOnePerson();
		if (Double.compare(person1, person2) == 0) { 
			  
            System.out.println("You both are of the same age."); 
        } 
        else if (Double.compare(person1, person2) < 0) { 
  
            System.out.println(name2 + " is older then " + name1 +"."); 
        } 
        else { 
  
            System.out.println(name1 + " is older then " + name2 +"."); 
        } 
	}
	
	private String setWeekDay(double weekDay) {
		String day = "";
		int d = (int) weekDay;
		switch (d) {
		case 0: day = "Monday";
				break;
		case 1: day = "Tuesday";
				break;
		case 2: day = "Wednesday";
				break;
		case 3: day = "Thursday";
				break;
		case 4: day = "Friday";
				break;
		case 5: day = "Saturday";
				break;
		case 6: day = "Sunday";
			break;
		}
		return day;
	}
	
	private double getTodaysDate() {
		Julian = new JulianDate();
		todaysDate = Julian.julianDateAlgorithm(Julian.setTodaysDate());
		return todaysDate;
	}
	
	private double getBirthday() {
        Julian = new JulianDate();
        if (name1 != "")
        {
        	System.out.println();
            System.out.println("To compare your birthday to another one, a second person is required.");
        }
        System.out.println("Please insert your name and your birthday.");
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.println("Name: ");
        if (name1 == "")
            name1 = input.nextLine();
        else
            name2 = input.nextLine();    
        System.out.println("Day: ");
        bDay = input.nextInt();
        System.out.println("Month: ");
        bMonth = input.nextInt();
        System.out.println("Year: ");
        bYear = input.nextInt();
        System.out.println();
        julianBirthday = Julian.julianDateAlgorithm(Julian.setDate(bYear, bMonth, bDay));
        return julianBirthday;
    }


}
