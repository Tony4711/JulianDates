
public class MetricDate extends JulianDate{
	
	private int metYear;
    private int metMonth;
    private int metDay;
    
    public MetricDate() {
    	super();
    }
    
    public static void main(String[] args) 
	{
    	MetricDate md = new MetricDate();
    	JulianDate Julian = new JulianDate();
    	double ju = Julian.julianDateAlgorithm(Julian.setDate(1997, 3, 19));
    	md.metricDateAlgorithm(ju);
    	md.metricToJulian(ju);
	}
    
    public void metricDateAlgorithm(double julian){
        metYear = (int) (julian/1000);
        metMonth = (int) ((julian%1000)/100);
        metDay = (int) ((julian%1000)%100);
        System.out.println("Metric Date: "+metDay+"."+metMonth+"."+metYear);
        }
    
    public void metricToJulian(double julian) {
    	julian = (metYear * 1000) + (metMonth * 100) + metDay;
    	System.out.println("Metric date " + metDay + "." + metMonth + "." + metYear + " is equal to the Julian date " + julian);
    	}
    }