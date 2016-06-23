package model;

public class Receptionist extends Anst�lld {

	//Variables
	private static long basM�nadsL�n   = 22000;
	private static long basM�nadsBonus = 1000;
	
	private int[] betyg = new int[10];
	private int n�staBetyg = 0;

	//Constructor
	public Receptionist(String namn) {
		super(namn);
	}
	
	//Methods
	@Override
	public String toString() {
		return "Receptionist " + getNamn();
	}

	@Override
	public long getBasM�nadsL�n() {
		return basM�nadsL�n;
	}

	@Override
	public long getBasM�nadsBonus() {
		return basM�nadsBonus;
	}

	@Override
	public long getBonus() {
		return (long) (calcKundn�jdhet() * getBasM�nadsBonus());
	}

	@Override
	public long getM�nadsL�n() {
		return (basM�nadsL�n + getBonus());
	}
	
	// S�tt ett nytt betyg som skriver �ver det �lsta betyget, 
	// samt inkrementera variabeln f�r �lsta betyg
	// TODO: kasta IllegalArgumentException vid ogiltig indata
	public void setBetyg(int nyttBetyg) {
		betyg [n�staBetyg++] = nyttBetyg;
		n�staBetyg = n�staBetyg % betyg.length;
	}
	
	public double calcKundn�jdhet(){
		return calcMedel(betyg);
	}
		
	public double calcMedel(int[] heltal) {
		int summa = 0;
		if (heltal.length == 0) return 0;
		for (int i = 0; i < heltal.length; i++) {
			summa += heltal[i];	
		}
		return (double) summa / (double) heltal.length;
	}
}
