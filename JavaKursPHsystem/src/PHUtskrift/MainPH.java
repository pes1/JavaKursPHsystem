package PHUtskrift;

import model.Tekniker;

public class MainPH {

	public static void main(String[] args) {
		
		Tekniker tekniker = new Tekniker("Kalle");
		
		tekniker.setUppTid(.999);

		System.out.println("Namn: "           + tekniker.getNamn());
		System.out.println("upptid: "         + tekniker.getUppTid());
		System.out.println("basm�nadsbonus: " + tekniker.getBasM�nadsBonus());
		System.out.println("bonus: "          + tekniker.getBonus());
		System.out.println("basm�nads�n: "    + tekniker.getBasM�nadsL�n());
		System.out.println("slutl�n: "        + tekniker.getM�nadsL�n());
	} 

}//Class

