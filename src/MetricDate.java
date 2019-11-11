
public class MetricDate extends JulianDate{
	
	private int metYear;
    private int metMonth;
    private int metDay;
    //private double julian;
    
    public MetricDate() {
    	super();
    }
    
    public static void main(String[] args) 
	{
    	MetricDate md = new MetricDate();
    	JulianDate Julian = new JulianDate();
		//Print the returned Julian Date from the method, needs a parameter of  an Array that represents the todays date, takes the date from the Calendar instance of java
		System.out.println(Julian.julianDateAlgorithm(Julian.setDate(1997, 3, 19)));
    	md.metricDateAlgorithm();
    	md.metricToJulian();
	}
    
    public void metricDateAlgorithm(){
        metYear = (int) (julian/1000);
        metMonth = (int) ((julian%1000)/100);
        metDay = (int) ((julian%1000)%100);
        System.out.println("Metric Date: "+metDay+"."+metMonth+"."+metYear);
        }
    
    public void metricToJulian() {
    	julian = (metYear * 1000) + (metMonth * 100) + metDay;
    	System.out.println("Metric date " + metDay + "." + metMonth + "." + metYear + " is equal to the Julian date " + julian);
    	}
    }