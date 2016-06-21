package model;

public abstract class Anställd {

	//Variables
	
	private String namn;
	
	//Constructor
	public Anställd(String namn) {
		this.namn = namn;
	}
	
	//Methods
	
	public abstract long getBasMånadsLön();
	
	public abstract long getBonus();
	
	public abstract long getBasMånadsBonus();

	public abstract long getMånadsLön();
		
	public String getNamn() {
		return namn;
	}
	
} //-- of class Anställd
