import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface IWeatherStructure {
	
	public double averageTempForMonth(int month, int year);
	public double totalRainfallForMonth(int month, int year);
	public IWeatherStructure addDailyReport(GregorianCalendar date, LinkedList<Reading> readings);

}
