package model;

public abstract class Anst�lld {

	//Variables
	private static long basM�nadsL�n ;
	private static long basM�nadsBonus ;
	
	private String namn;
	
	//Constructor
	public Anst�lld(String namn) {
		this.namn = namn;
	}
	
	public abstract long getBasM�nadsL�n();
	
	public abstract long getBonus();
	
	public abstract long getBasM�nadsBonus();

	public abstract long getM�nadsL�n();
		
	public String getNamn() {
		return namn;
	}
	
	
	
	
	
	
} //-- of class Anst�lld
