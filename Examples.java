import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

public class Examples {
	
	Time time = new Time(6, 45);
	Reading reading1 = new Reading(time, 70, 2);
	Reading reading2 = new Reading(time, 72, 3);
	Reading reading3 = new Reading(time, 72, 0);
	Reading reading4 = new Reading(time, 71, 1);
	LinkedList<Reading> readings = new LinkedList<Reading>();
	
	GregorianCalendar date1 = new GregorianCalendar(2018, 7, 10);
	DailyWeatherReport weather1 = new DailyWeatherReport(date1, readings);
	GregorianCalendar date2 = new GregorianCalendar(2018, 7, 11);
	DailyWeatherReport weather2 = new DailyWeatherReport(date2, readings);
	GregorianCalendar date3 = new GregorianCalendar(2018, 7, 15);
	DailyWeatherReport weather3 = new DailyWeatherReport(date3, readings);
	GregorianCalendar wrongDate1 = new GregorianCalendar(2016, 7, 12);
	DailyWeatherReport wrongWeather1 = new DailyWeatherReport(wrongDate1, readings);
	GregorianCalendar wrongDate2 = new GregorianCalendar(2018, 12, 9);
	DailyWeatherReport wrongWeather2 = new DailyWeatherReport(wrongDate2, readings);
	
	GregorianCalendar addDate = new GregorianCalendar(2015, 4, 24);
	DailyWeatherReport addWeather = new DailyWeatherReport(addDate, readings);
	
	LinkedList<DailyWeatherReport> reports = new LinkedList<DailyWeatherReport>();
	IWeatherStructure monitor = new WeatherList(reports);
	
	LinkedList<DailyWeatherReport> reportsAdd = new LinkedList<DailyWeatherReport>();
	IWeatherStructure monitorAdd = new WeatherList(reportsAdd);
	
	public Examples() {
		readings.add(reading1);
		readings.add(reading2);
		readings.add(reading3);
		readings.add(reading4);
		
		reports.add(weather1);
		reports.add(weather2);
		reports.add(weather3);
		reports.add(wrongWeather1);
		reports.add(wrongWeather2);
		
		reportsAdd.add(weather1);
		reportsAdd.add(weather2);
		reportsAdd.add(weather3);
		reportsAdd.add(wrongWeather1);
		reportsAdd.add(wrongWeather2);
		reportsAdd.add(addWeather);
	}
	
	// test average temp with correct month and year
	@Test 
	public void testAverageTemp() {
		assertEquals(monitor.averageTempForMonth(7, 2018), 71.25, 0.1);
	}
	
	// test average temp with correct month, wrong year, yields -1 if the date isn't in the set
	@Test
	public void testAverageWrongYear() {
		assertEquals(monitor.averageTempForMonth(7, 2010), -1, .1);
	}
	
	// test average temp with correct year, wrong month, yields -1 if the date isn't in the set
	@Test
	public void testAverageWrongMonth() {
		assertEquals(monitor.averageTempForMonth(1, 2018), -1, .1);
	}
	
	// test total rain with correct month and year
	@Test
	public void testTotalRainfall() {
		assertEquals(monitor.totalRainfallForMonth(7, 2018), 18.0, .1);
	}
	
	// test total rain with correct month, wrong year, yields -1 if the date isn't in the set
	@Test
	public void testTotalWrongYear() {
		assertEquals(monitor.totalRainfallForMonth(7, 2010), -1, .1);
	}
	
	// test total rain with wrong month, correct year, yields -1 if the date isn't in the set
	@Test
	public void testTotalWrongMonth() {
		assertEquals(monitor.totalRainfallForMonth(1, 2018), -1, .1);
	}
	
	// test add of the report via average temp 
	@Test
	public void testAddReportTemp() {
		assertEquals(monitor.addDailyReport(addDate, readings).averageTempForMonth(4, 2015), monitorAdd.averageTempForMonth(4, 2015), .1);
	}
	
	// test add of the report via total rain
	@Test
	public void testAddReportRain() {
		assertEquals(monitor.addDailyReport(addDate, readings).totalRainfallForMonth(4, 2015), monitorAdd.totalRainfallForMonth(4, 2015), .1);
	}

}
