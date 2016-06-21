package model;

public abstract class Anställd {

	//Variables
	private static long basMånadsLön ;
	private static long basMånadsBonus ;
	
	private String namn;
	
	//Constructor
	public Anställd(String namn) {
		this.namn = namn;
	}
	
	public abstract long getBasMånadsLön();
	
	public abstract long getBonus();
	
	public abstract long getBasMånadsBonus();

	public abstract long getMånadsLön();
		
	public String getNamn() {
		return namn;
	}
	
	
	
	
	
	
} //-- of class Anställd
