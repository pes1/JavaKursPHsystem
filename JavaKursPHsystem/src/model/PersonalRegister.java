package model;

import java.util.HashSet;
import java.util.Set;

public class PersonalRegister {

	//Variables
	private Set<Anställd> personalCollection = new HashSet<Anställd>();
	
	//Methods
	public boolean läggTillAnställd(Anställd anställd){
		System.out.println("Debug: ny anställd");
		if(anställd == null) {
			return false;
		} else if (anställd.getNamn().length() == 0) {
			return false;
		}
		
		return personalCollection.add(anställd);
	}
	
	public Set<Anställd> getKopia (){
		return new HashSet<Anställd>(personalCollection);
	}
	
	public Anställd högstBetald() {
		if (personalCollection.isEmpty()) return null;
		
		Anställd högstBetald = null;
		
		for (Anställd anställd: personalCollection) {
			if (högstBetald == null) {
				högstBetald = anställd;
			} else if (anställd.getMånadsLön() > högstBetald.getMånadsLön()) {
				högstBetald = anställd;
			}			
		}
		return högstBetald;
	}
	
}
