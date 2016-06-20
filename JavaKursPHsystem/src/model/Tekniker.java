package model;

public class Tekniker {
	
	//Variables
	private static int basMånadslön = 27000;
	private static int basbonus = 2000;
	
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
	
	public static int getBasmånadslön() {
		return basMånadslön;
	}
	
	public static int getBasbonus() {
		return basbonus;
	}
	
	public int getBonus() {
		return getBasbonus();
	}
	
	public String getNamn() {
		return namn;
	}
	
	
}//Class
