package model;

public class Tekniker {
	
	//Variables
	private static int basl�n = 27000;
	
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
	
	public static int getBasl�n() {
		return basl�n;
	}
	
	public String getNamn() {
		return namn;
	}
	
	
}//Class
