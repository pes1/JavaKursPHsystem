package model;

public class Tekniker extends Anställd {

	//Variables
	private static long basMånadsLön   = 27000;
	private static long basMånadsBonus = 2000;

	private double uppTid = 1.0;

	//Constructor
	public Tekniker(String namn) {
		super(namn);  				//-- Anropar överklassens konstruktor.
	}

	//Methods ---------------------------------------------------

	@Override
	public String toString() {
		return "Tekniker " + getNamn();
	}

	@Override
	public long getBonus() {
		return (long) (((double) getBasMånadsBonus()) *  getUppTid());
	}

	@Override
	public long getBasMånadsBonus(){
		return basMånadsBonus;
	}

	@Override
	public long getBasMånadsLön(){
		return basMånadsLön;
	}

	@Override
	public long getMånadsLön() {
		return getBasMånadsLön() +  getBonus();
	}

	public double getUppTid() {
		return uppTid;
	}

	public void setUppTid(double nyUppTid) {
		if(nyUppTid > 1.0) {
			this.uppTid = 1.0;
		}
		else if (nyUppTid < 0.0) {
			this.uppTid = 0.0;
		}
		else {
			this.uppTid = nyUppTid;
		}
	}

}//Class
