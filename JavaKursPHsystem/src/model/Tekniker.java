package model;

public class Tekniker extends Anställd {

	//Variables
	private static long basMånadsLön   = 27000;
	private static long basMånadsBonus = 2000;
	
	private static String befattning = "Tekniker";

	private double uppTid = 1.0;

	//Constructor
	public Tekniker(String namn) {
		super(namn);  	//-- Anropar överklassens konstruktor.
	}

	//Methods ---------------------------------------------------

	@Override
	public String toString() {
		return getBefattning() + " " + getNamn();
	}

	@Override
	public long getBonus() {
		return (long) (((double) getBasMånadsBonus()) *  getUppTid());
	}

	@Override
	public long getBasMånadsBonus() {
		return basMånadsBonus;
	}

	@Override
	public long getBasMånadsLön() {
		return basMånadsLön;
	}

	@Override
	public long getMånadsLön() {
		return getBasMånadsLön() + getBonus();
	}

	public String getBefattning() {
		return befattning;
	}
	
	public double getUppTid() {
		return uppTid;
	}

	public void setUppTid(double nyUppTid) throws IllegalArgumentException {
		if (nyUppTid > 1.0) throw new IllegalArgumentException("Upptid kan inte vara större än 1.");
		if (nyUppTid < 0.0) throw new IllegalArgumentException("Upptid kan inte vara mindre än 0.");
		this.uppTid = nyUppTid;
	}
	
}//Class
