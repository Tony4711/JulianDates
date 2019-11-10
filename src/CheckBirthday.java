import java.util.Scanner;

public class CheckBirthday {
	
	private JulianDate Julian;
	private double todaysDate = 0;
	private double julianBirthday = 0;
	private double daysOnEarth = 0;
	private double weekDay = 0;
	private int day = 0;
	private int month = 0;
	private int year = 0;
	private double person1 = 0;
	private double person2 = 0;
	private String name;

	public static void main(String[] args) {
		CheckBirthday Birthday = new CheckBirthday();
		Birthday.compareTwoBirthdays();
		
	}
	
	private double calculateDaysOnEarth(double today, double birthday){
		daysOnEarth = today - birthday;
		birthday = Math.floor(birthday + 0.5)%7;
		System.out.println(daysOnEarth);
		System.out.println(setWeekDay(birthday));
		return weekDay;
	}
	
	private void compareTwoBirthdays() {
		person1 = calculateDaysOnEarth(getTodaysDate(), getBirthday());
		person2 = calculateDaysOnEarth(getTodaysDate(), getBirthday());
		System.out.println(person1);
		System.out.println(person2);
		if (Double.compare(person1, person2) == 0) { 
			  
            System.out.println("You both are of the same age."); 
        } 
        else if (Double.compare(person1, person2) < 0) { 
  
            System.out.println("Person 1 is older then person 2."); 
        } 
        else { 
  
            System.out.println("Person 2 is older then person 1."); 
        } 
	}
	
	private String setWeekDay(double d) {
		String day = "";
		int i = (int) d;
		switch (i) {
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
		name = "";
		Julian = new JulianDate();
		System.out.println("Please insert your name and your birthday.");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Name: ");
		name = input.nextLine();
		System.out.println("Day: ");
		day = input.nextInt();
		System.out.println("Month: ");
		month = input.nextInt();
		System.out.println("Year: ");
		year = input.nextInt();
		julianBirthday = Julian.julianDateAlgorithm(Julian.setDate(year, month, day));
		return julianBirthday;
	}

}
