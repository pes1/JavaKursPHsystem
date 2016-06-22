package model;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class PersonalRegister {

	private Set<Anställd> personalCollection = new HashSet<Anställd>();
	
	
	public boolean läggTillAnställd(Anställd anställd){
		System.out.println("Debug: ny anställd");
		if(anställd == null) {
			return false;
		} else if (anställd.getNamn().length() == 0) {
			return false;
		}
		
		return personalCollection.add(anställd);
	}
	
	public Collection<Anställd> getPersonalRegister (){
		return personalCollection;
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
