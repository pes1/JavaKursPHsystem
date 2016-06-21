package PHUtskrift;

import model.Tekniker;

public class MainPH {

	public static void main(String[] args) {
		
		Tekniker tekniker = new Tekniker("Kalle");
		
		tekniker.setUppTid(.999);

		System.out.println("Namn: "           + tekniker.getNamn());
		System.out.println("upptid: "         + tekniker.getUppTid());
		System.out.println("basmånadsbonus: " + tekniker.getBasMånadsBonus());
		System.out.println("bonus: "          + tekniker.getBonus());
		System.out.println("basmånadsön: "    + tekniker.getBasMånadsLön());
		System.out.println("slutlön: "        + tekniker.getMånadsLön());
	} 

}//Class

