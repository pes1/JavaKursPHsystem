package model;

public abstract class Anställd {

	//Variables
	
	private String namn;
	
	//Constructor
	public Anställd(String namn) throws IllegalArgumentException{
		if(namn.trim().length() == 0) {
			throw new IllegalArgumentException("Namnet måste innehålla minst ett tecken.");
		}
		
		this.namn = namn.trim();
	}
	
	//Methods
	
	public abstract long getBasMånadsLön();
	
	public abstract long getBonus();
	
	public abstract long getBasMånadsBonus();

	public abstract long getMånadsLön();
			
	public String getNamn() {
		return namn;
	}
	
	public void setNamn(String namn) throws IllegalArgumentException {
		if (namn.trim().length() == 0) {
			throw new IllegalArgumentException("Namnet får inte vara tomt");
		}
		
		this.namn = namn.trim();
	}
		
} //-- of class Anställd
