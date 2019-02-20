import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherMonitor {
	
	private IWeatherStructure weatherStruct;
	
	public WeatherMonitor(IWeatherStructure weatherStruct) {
		this.weatherStruct = weatherStruct;
	}
	
	public double averageTempForMonth(int month, int year) {
		return weatherStruct.averageTempForMonth(month, year);
	}
	
	public double totalRainfallForMonth(int month, int year) {
		return weatherStruct.totalRainfallForMonth(month, year);
	}
	
	public IWeatherStructure addDailyReport(GregorianCalendar date, LinkedList<Reading> readings){
		return weatherStruct.addDailyReport(date, readings);
	}

}
