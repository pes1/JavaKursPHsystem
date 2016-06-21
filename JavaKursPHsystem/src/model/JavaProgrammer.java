package model;
/*-----------------------------------------------
 * 
 * JavaProgrammer 
 * �r n�stan identisk med Tekniker
 * 
 *-----------------------------------------------
 */
public class JavaProgrammer extends Anst�lld {

	//Variables
	private static long basM�nadsL�n   = 29000;
	private static long basM�nadsBonus = 1001;
	
//	private String namn;
	private double uppTid = 1.0;
	
	//Constructor
	public JavaProgrammer(String namn) {
//		this.namn = namn;
		super(namn);  				//-- Anropar �verklassens konstruktor.
 
	}
	
	//Methods ---------------------------------------------------
	
	@Override
	public String toString() {
		return "JavaProgrammer " + getNamn();
	}
	
	@Override
	public long getBonus() {
		return (long) (((double) getBasM�nadsBonus()) *  getUppTid());
	}
	
	@Override
	public long getBasM�nadsBonus(){
		return basM�nadsBonus;
	}
	
	@Override
	public long getBasM�nadsL�n(){
		return basM�nadsL�n;
	}

	
	
	@Override
	public long getM�nadsL�n() {
		return getBasM�nadsL�n() +  getBonus();
	}
	
	
	public double getUppTid() {
		return uppTid;
	}
	
	public void setUppTid(double nyUppTid) {
		if(       nyUppTid > 1.0) { this.uppTid = 1.0;}
		else if ( nyUppTid < 0.0) { this.uppTid = 0.0;}
		else { this.uppTid = nyUppTid;
		}
	}
	
}//Class
