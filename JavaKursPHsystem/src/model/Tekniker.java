package model;

public class Tekniker {
	
	//Variables
	private static int basMånadsLön = 27000;
	private static int basMånadsBonus = 2000;
	
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
	
	public static int getBasMånadsLön() {
		return basMånadsLön;
	}
	
	public static int getBasMånadsBonus() {
		return basMånadsBonus;
	}
	
	public int getLön() {
		return basMånadsLön;
	}
	
	public int getBonus() {
		return getBasMånadsBonus();
	}
	
	public String getNamn() {
		return namn;
	}
	
	
}//Class
