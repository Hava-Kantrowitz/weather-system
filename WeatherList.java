import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherList implements IWeatherStructure{
	
	private LinkedList<DailyWeatherReport> reports = new LinkedList<DailyWeatherReport>();
	
	public WeatherList(LinkedList<DailyWeatherReport> reports) {
		this.reports = reports;
	}
	
	public double averageTempForMonth(int month, int year) {
		LinkedList<Double> averages = new LinkedList<Double>();
		for (DailyWeatherReport report : reports) {
			if (report.getMonth() == month && report.getYear() == year) {
				averages.add(report.dayAverageTemp());
			}
		}
		
		if (averages.size() == 0) {
			return -1;
		}
		
		double average = 0;
		for (Double av : averages) {
			average = average + av;
		}
		
		average = average/averages.size();
		return average;
	}
	
	public double totalRainfallForMonth(int month, int year) {
		LinkedList<Double> totals = new LinkedList<Double>();
		for (DailyWeatherReport report : reports) {
			if (report.getMonth() == month && report.getYear() == year) {
				totals.add(report.dayTotalRain());
			}
		}
		
		if (totals.size() == 0) {
			return -1;
		}
		
		double totalRain = 0;
		for (Double rain : totals) {
			totalRain = totalRain + rain;
		}
		
		return totalRain;
		
	}
	
	public WeatherList addDailyReport(GregorianCalendar date, LinkedList<Reading> readings){
		DailyWeatherReport newReport = new DailyWeatherReport(date, readings);
		reports.add(newReport);
		WeatherList newList = new WeatherList(reports);
		return newList;
	}

}
