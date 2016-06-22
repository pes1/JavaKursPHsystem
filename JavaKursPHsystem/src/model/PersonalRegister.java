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
	
	public boolean taBortAnställd(String namn) {
		for (Anställd anställd : personalCollection) {
			if (anställd.getNamn().trim().equalsIgnoreCase(namn)) {
				return personalCollection.remove(anställd);
			}
		}
		return false;
	}
	
	public boolean finnsAnställd(String namn) {
		for (Anställd anställd : personalCollection) {
			if (anställd.getNamn().trim().equalsIgnoreCase(namn)) {
				return true;
			}
		}
		return false;
	}
	
	public Anställd slåUppAnställd (String namn) {
		for (Anställd anställd : personalCollection) {
			if (anställd.getNamn().trim().equalsIgnoreCase(namn)) {
				return anställd;
			}
		}
		return null;
	}
	
	public void uppdateraAnställd (String namn) {
		for (Anställd anställd : personalCollection) {
			if (anställd.getNamn().trim().equalsIgnoreCase(namn)) {
				anställd.setNamn(namn);
			}
		}
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
