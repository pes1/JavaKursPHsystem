package model;

public abstract class Anst�lld {

	//Variables
	
	private String namn;
	
	//Constructor
	public Anst�lld(String namn) throws IllegalArgumentException{
		if(namn.trim().length() == 0) {
			throw new IllegalArgumentException("Namnet m�ste inneh�lla minst ett tecken.");
		}
		
		this.namn = namn.trim();
	}
	
	//Methods
	
	public abstract long getBasM�nadsL�n();
	
	public abstract long getBonus();
	
	public abstract long getBasM�nadsBonus();

	public abstract long getM�nadsL�n();
			
	public String getNamn() {
		return namn;
	}
	
	public void setNamn(String namn) throws IllegalArgumentException {
		if (namn.trim().length() == 0) {
			throw new IllegalArgumentException("Namnet f�r inte vara tomt");
		}
		
		this.namn = namn.trim();
	}
		
} //-- of class Anst�lld
