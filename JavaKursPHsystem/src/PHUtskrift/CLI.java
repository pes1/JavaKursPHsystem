package PHUtskrift;

import java.util.Collection;
import java.util.Scanner;

import model.Anställd;
import model.JavaProgrammer;
import model.PersonalRegister;
import model.Tekniker;

abstract class CLI {

	static void visaCLI(PersonalRegister personalRegister, Scanner scanner){
		String kommandoString;
		char kommando = '#';

		while(true){
			kommandoString = "";

			System.out.println("\nVälj ett kommando:");
			System.out.println("==================");

			System.out.println("1. Skapa ny anställd");
			System.out.println("2. Visa alla anställda");
			System.out.println("3. Visa lönestatistik");
			System.out.println("4. Visa personalfördelning");
			System.out.println("\n0. Avsluta");

			do {
				kommandoString = scanner.nextLine().trim();
			} while (kommandoString.length() == 0);
			//input är nu garanterat icke-tom

			kommando = kommandoString.charAt(0);

			switch(kommando) {
			case '1':
				läggTillAnställd(personalRegister, scanner);
				break;

			case '2':
				Collection<Anställd> personalCollection = personalRegister.getPersonalRegister();
				System.out.println("\nSamtliga anställda:");
				System.out.println("===================");
				if (personalCollection.isEmpty()){
					System.out.println("--Inga anställda--");
				} else {
					for(Anställd anställd : personalCollection) {
						System.out.println(anställd);
					}
				}
				break;
				
			case '3':
				//lönestatistik
				break;
				
			case '4':
				//personalfördenling (stapeldiagram?)
				break;


			case '0':
				return;

			default:
				System.out.println("Okänt kommando");
				break;
			}//switch

		}//while


	}

	private static void läggTillAnställd (PersonalRegister personalRegister, Scanner scanner) {

		String namn;
		String personalString;
		char personalKategori = '#';

		System.out.print("\nNamn (För att avbryta, tryck enter): ");
		namn = scanner.nextLine().trim();
		if(namn.length() == 0 ) {
			return;
		}

		System.out.println("\nVälj personalkategori:");
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
			System.out.println(personalRegister.läggTillAnställd(new JavaProgrammer(namn)));

			break;

		case '2':
			System.out.println(personalRegister.läggTillAnställd(new Tekniker(namn)));
			break;
			
		case '+':
			return;

		default:
			System.out.println("Okänd personalkategori");
			break;
		} //switch

	} //läggTillAnställd

}//Class
