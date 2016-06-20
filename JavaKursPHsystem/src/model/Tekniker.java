package model;

public class Tekniker {
	
	//Variables
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
	
	public String getNamn() {
		return namn;
	}
	
	
}//Class
