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
	
	
}
