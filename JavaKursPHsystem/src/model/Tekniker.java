package model;

public class Tekniker extends Anst�lld {

	//Variables
	private static long basM�nadsL�n   = 27000;
	private static long basM�nadsBonus = 2000;
	
	private static String befattning = "Tekniker";

	private double uppTid = 1.0;

	//Constructor
	public Tekniker(String namn) {
		super(namn);  	//-- Anropar �verklassens konstruktor.
	}

	//Methods ---------------------------------------------------

	@Override
	public String toString() {
		return getBefattning() + " " + getNamn();
	}

	@Override
	public long getBonus() {
		return (long) (((double) getBasM�nadsBonus()) *  getUppTid());
	}

	@Override
	public long getBasM�nadsBonus() {
		return basM�nadsBonus;
	}

	@Override
	public long getBasM�nadsL�n() {
		return basM�nadsL�n;
	}

	@Override
	public long getM�nadsL�n() {
		return getBasM�nadsL�n() + getBonus();
	}

	public String getBefattning() {
		return befattning;
	}
	
	public double getUppTid() {
		return uppTid;
	}

	public void setUppTid(double nyUppTid) throws IllegalArgumentException {
		if (nyUppTid > 1.0) throw new IllegalArgumentException("Upptid kan inte vara st�rre �n 1.");
		if (nyUppTid < 0.0) throw new IllegalArgumentException("Upptid kan inte vara mindre �n 0.");
		this.uppTid = nyUppTid;
	}
	
}//Class
