package model;

public class Tekniker {
	
	//Variables
	private static long basM�nadsL�n = 27000;
	private static long basM�nadsBonus = 2000;
	
	private String namn;
	private double uppTid = 1.0;
	
	//Constructor
	public Tekniker(String namn) {
		this.namn = namn;
	}
	
	//Methods
	
	@Override
	public String toString() {
		return "Tekniker " + getNamn();
	}
	
	public static long getBasM�nadsL�n() {
		return basM�nadsL�n;
	}
	
	public static long getBasM�nadsBonus() {
		return basM�nadsBonus;
	}
	
	public long getM�nadsL�n() {
		return getBasM�nadsL�n() +  getBonus();
	}
	
	public long getBonus() {
		return (long) (((double) getBasM�nadsBonus()) *  getUppTid());
	}
	
	public String getNamn() {
		return namn;
	}

	public double getUppTid() {
		return uppTid;
	}
	
	public void setUppTid(double nyUppTid) {
		if(nyUppTid > 1.0) {
			this.uppTid = 1.0;
		}
		else if (nyUppTid < 0.0) {
			this.uppTid = 0.0;
		}
		else {
			this.uppTid = nyUppTid;
		}
	}
	
}//Class
