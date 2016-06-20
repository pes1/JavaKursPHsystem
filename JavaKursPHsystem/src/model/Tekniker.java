package model;

public class Tekniker {
	
	//Variables
	private static int basM�nadsL�n = 27000;
	private static int basM�nadsBonus = 2000;
	
	private String namn;
	
	//Constructor
	public Tekniker(String namn) {
		this.namn = namn;
	}
	
	//Methods
	
	@Override
	public String toString() {
		return "Tekniker " + getNamn();
	}
	
	public static int getBasM�nadsL�n() {
		return basM�nadsL�n;
	}
	
	public static int getBasM�nadsBonus() {
		return basM�nadsBonus;
	}
	
	public int getL�n() {
		return basM�nadsL�n;
	}
	
	public int getBonus() {
		return getBasM�nadsBonus();
	}
	
	public String getNamn() {
		return namn;
	}
	
	
}//Class
