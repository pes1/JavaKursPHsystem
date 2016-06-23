package model;

public class Receptionist extends Anställd {

	//Variables
	private static long basMånadsLön   = 22000;
	private static long basMånadsBonus = 1000;
	
	private int[] betyg = new int[10];
	private int nästaBetyg = 0;

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
	public long getBasMånadsLön() {
		return basMånadsLön;
	}

	@Override
	public long getBasMånadsBonus() {
		return basMånadsBonus;
	}

	@Override
	public long getBonus() {
		return (long) (calcKundnöjdhet() * getBasMånadsBonus());
	}

	@Override
	public long getMånadsLön() {
		return (basMånadsLön + getBonus());
	}
	
	// Sätt ett nytt betyg som skriver över det älsta betyget, 
	// samt inkrementera variabeln för älsta betyg
	// TODO: kasta IllegalArgumentException vid ogiltig indata
	public void setBetyg(int nyttBetyg) {
		betyg [nästaBetyg++] = nyttBetyg;
		nästaBetyg = nästaBetyg % betyg.length;
	}
	
	public double calcKundnöjdhet(){
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
