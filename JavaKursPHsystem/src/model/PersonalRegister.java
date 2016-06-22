package model;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class PersonalRegister {

	private Set<Anst�lld> personalCollection = new HashSet<Anst�lld>();
	
	
	public boolean l�ggTillAnst�lld(Anst�lld anst�lld){
		System.out.println("Debug: ny anst�lld");
		if(anst�lld == null) {
			return false;
		} else if (anst�lld.getNamn().length() == 0) {
			return false;
		}
		
		return personalCollection.add(anst�lld);
	}
	
	public Collection<Anst�lld> getPersonalRegister (){
		return personalCollection;
	}
	
	
}
