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
	
	public boolean taBortAnst�lld(String namn) {
		for (Anst�lld anst�lld : personalCollection) {
			if (anst�lld.getNamn().trim().equalsIgnoreCase(namn)) {
				personalCollection.remove(anst�lld);
				return true;
			}
		}
		return false;
	}
	
	public boolean finnsAnst�lld(String namn) {
		for (Anst�lld anst�lld : personalCollection) {
			if (anst�lld.getNamn().trim().equalsIgnoreCase(namn)) {
				return true;
			}
		}
		return false;
	}
	
	public Anst�lld sl�UppAnst�lld (String namn) {
		for (Anst�lld anst�lld : personalCollection) {
			if (anst�lld.getNamn().trim().equalsIgnoreCase(namn)) {
				return anst�lld;
			}
		}
		return null;
	}
	
	public void uppdateraAnst�lld (String namn) {
		for (Anst�lld anst�lld : personalCollection) {
			if (anst�lld.getNamn().trim().equalsIgnoreCase(namn)) {
				anst�lld.setNamn(namn);
			}
		}
	}
	
	//TODO: Returnerar detta en kopia �ven av de anst�llda? G�r det att �ndra i anst�llda genom att �ndra i kopian av registret?
	public Set<Anst�lld> getKopia (){
		return new HashSet<Anst�lld>(personalCollection);
	}

	public int[] getAntalAnst�llda(){
		int antalTotalt = 0;
		int antalJavaProgrammer = 0;
		int antalReceptionist = 0;
		int antalTekniker = 0;
		
		for (Anst�lld anst�lld: personalCollection) {
			if (anst�lld instanceof JavaProgrammer) {
				antalJavaProgrammer ++;
			}
			if (anst�lld instanceof Receptionist) {
				antalReceptionist ++;
			}
			if (anst�lld instanceof Tekniker) {
				antalTekniker ++;
			}
			antalTotalt++;		
		}

		int[] stapelData = {antalTotalt,antalJavaProgrammer,antalReceptionist,antalTekniker};
		return stapelData;
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
