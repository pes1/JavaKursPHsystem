package PHUtskrift;

import java.util.Collection;
import java.util.Scanner;

import model.Anst�lld;
import model.JavaProgrammer;
import model.PersonalRegister;
import model.Tekniker;

abstract class CLI {

	static void visaCLI(PersonalRegister personalRegister, Scanner scanner){
		String kommandoString;
		char kommando = '#';

		while(true){
			kommandoString = "";

			System.out.println("\nV�lj ett kommando:");
			System.out.println("==================");

			System.out.println("1. Skapa ny anst�lld");
			System.out.println("2. Visa alla anst�llda");
			System.out.println("3. Visa l�nestatistik");
			System.out.println("4. Visa personalf�rdelning");
			System.out.println("\n0. Avsluta");

			do {
				kommandoString = scanner.nextLine().trim();
			} while (kommandoString.length() == 0);
			//input �r nu garanterat icke-tom

			kommando = kommandoString.charAt(0);

			switch(kommando) {
			case '1':
				l�ggTillAnst�lld(personalRegister, scanner);
				break;

			case '2':
				Collection<Anst�lld> personalCollection = personalRegister.getPersonalRegister();
				System.out.println("\nSamtliga anst�llda:");
				System.out.println("===================");
				if (personalCollection.isEmpty()){
					System.out.println("--Inga anst�llda--");
				} else {
					for(Anst�lld anst�lld : personalCollection) {
						System.out.println(anst�lld);
					}
				}
				break;
				
			case '3':
				//l�nestatistik
				break;
				
			case '4':
				//personalf�rdenling (stapeldiagram?)
				break;


			case '0':
				return;

			default:
				System.out.println("Ok�nt kommando");
				break;
			}//switch

		}//while


	}

	private static void l�ggTillAnst�lld (PersonalRegister personalRegister, Scanner scanner) {

		String namn;
		String personalString;
		char personalKategori = '#';

		System.out.print("\nNamn (F�r att avbryta, tryck enter): ");
		namn = scanner.nextLine().trim();
		if(namn.length() == 0 ) {
			return;
		}

		System.out.println("\nV�lj personalkategori:");
		System.out.println("======================");
		System.out.println("1. Javaprogrammerare");
		System.out.println("2. Tekniker");
		System.out.println("0. (Avbryt)");

		do {
			personalString = scanner.nextLine().trim();
		} while (personalString.length() == 0);

		personalKategori = personalString.charAt(0);

		switch (personalKategori) {
		case '1':
			System.out.println(personalRegister.l�ggTillAnst�lld(new JavaProgrammer(namn)));

			break;

		case '2':
			System.out.println(personalRegister.l�ggTillAnst�lld(new Tekniker(namn)));
			break;
			
		case '+':
			return;

		default:
			System.out.println("Ok�nd personalkategori");
			break;
		} //switch

	} //l�ggTillAnst�lld

}//Class
