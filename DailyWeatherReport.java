import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyWeatherReport {
	
	private GregorianCalendar date = new GregorianCalendar();
	private LinkedList<Reading> readings = new LinkedList<Reading>();
	
	public DailyWeatherReport(GregorianCalendar date, LinkedList<Reading> readings) {
		this.date = date;
		this.readings = readings;
	}
	
	public double dayAverageTemp() {
		double averageTemp = 0;
		for (Reading reading : readings) {
			averageTemp = averageTemp + reading.getTemp();
		}
		
		averageTemp = averageTemp/readings.size();
		return averageTemp;
	}
	
	public double dayTotalRain() {
		double totalRain = 0;
		for (Reading reading : readings) {
			totalRain = totalRain + reading.getRain();
		}
		
		return totalRain;
	}
	
	public int getMonth() {
		return date.get(GregorianCalendar.MONTH);
	}
	
	public int getYear() {
		return date.get(GregorianCalendar.YEAR);
	}
	

}
