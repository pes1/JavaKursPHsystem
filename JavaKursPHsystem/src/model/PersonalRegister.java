package model;

import java.util.HashSet;
import java.util.Set;

public class PersonalRegister {

	//Variables
	private Set<Anst�lld> personalCollection = new HashSet<Anst�lld>();
	
	//Methods
	public boolean l�ggTillAnst�lld(Anst�lld anst�lld){
		System.out.println("Debug: ny anst�lld");
		if(anst�lld == null) {
			return false;
		} else if (anst�lld.getNamn().length() == 0) {
			return false;
		}
		
		return personalCollection.add(anst�lld);
	}
	
	public Set<Anst�lld> getKopia (){
		return new HashSet<Anst�lld>(personalCollection);
	}
	
	public Anst�lld h�gstBetald() {
		if (personalCollection.isEmpty()) return null;
		
		Anst�lld h�gstBetald = null;
		
		for (Anst�lld anst�lld: personalCollection) {
			if (h�gstBetald == null) {
				h�gstBetald = anst�lld;
			} else if (anst�lld.getM�nadsL�n() > h�gstBetald.getM�nadsL�n()) {
				h�gstBetald = anst�lld;
			}			
		}
		return h�gstBetald;
	}
	
}
