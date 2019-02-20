public class Reading {
	
	private Time time;
	private double temp;
	private double rainfall;
	
	public Reading(Time time, double temp, double rainfall) {
		this.time = time;
		this.rainfall = rainfall;
		this.temp = temp;
	}
	
	public double getTemp() {
		return temp;
	}
	
	public double getRain(){
		return rainfall;
	}
}
