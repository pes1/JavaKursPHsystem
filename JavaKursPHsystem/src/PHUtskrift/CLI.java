package PHUtskrift;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import model.Anställd;
import model.JavaProgrammer;
import model.PersonalRegister;
import model.Receptionist;
import model.Tekniker;

abstract class CLI {

	static void visaCLI(PersonalRegister personalRegister, Scanner scanner){
		String kommandoString;
		char kommando = '#';
		int antalRoller = 3; //antal Yrkeskategorier
		int[] stapelData = new int[antalRoller + 1];


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
				System.out.println(läggTillAnställd(personalRegister, scanner));
				break;

			case '2':
				Set<Anställd> personalCollection = personalRegister.getKopia();
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
				Anställd högstBetald = personalRegister.högstBetald();
				System.out.println("\nHögst betald: " + (högstBetald == null ? "--ingen--" : högstBetald + ", " + högstBetald.getMånadsLön()) );

				Set<Anställd> personalSet = new HashSet<Anställd>(personalRegister.getKopia());
				double medelLön;

				if(personalSet.size() == 0){
					medelLön = 0;
				} else {
					long totalLön = 0L;
					for (Anställd anställd : personalSet) {
						totalLön += anställd.getMånadsLön();
					}

					medelLön = ((double)totalLön / personalSet.size());
				}
				System.out.println("\nMedellön: " + medelLön);

				break;

			case '4':
				//personalfördenling (stapeldiagram?) 
				stapelData = personalRegister.getAntalAnställda();
				System.out.print("Totalt antal anställda: " + stapelData[0] + " ");
				for(int i=0; i<stapelData[0]; i++){
					System.out.print("*");
				}
				System.out.println();
				System.out.println("varav");
				System.out.print("Programmerare:          " + stapelData[1] + " ");
				for(int i=0; i<stapelData[1]; i++){
					System.out.print("*");
				}
				System.out.println();
				System.out.print("Receptionister:         " + stapelData[2] + " ");
				for(int i=0; i<stapelData[2]; i++){
					System.out.print("*");
				}
				System.out.println();				
				System.out.print("Tekniker:               " + stapelData[3] + " ");
				for(int i=0; i<stapelData[3]; i++){
					System.out.print("*");
				}
				System.out.println();
				break;

			case '0':
				return;

			default:
				System.out.println("Okänt kommando");
				break;
			}//switch

		}//while


	}

	private static boolean läggTillAnställd (PersonalRegister personalRegister, Scanner scanner) {

		String namn;
		String personalString;
		char personalKategori = '#';

		System.out.print("\nNamn (För att avbryta, tryck enter): ");
		namn = scanner.nextLine().trim();
		if(namn.length() == 0 ) {
			return false;
		}

		System.out.println("\nVälj personalkategori:");
		System.out.println("======================");
		System.out.println("1. Javaprogrammerare");
		System.out.println("2. Receptionist");
		System.out.println("3. Tekniker");
		System.out.println("0. (Avbryt)");

		do {
			personalString = scanner.nextLine().trim();
		} while (personalString.length() == 0);

		personalKategori = personalString.charAt(0);

		switch (personalKategori) {
		case '1':
			try {
				return (personalRegister.läggTillAnställd(new JavaProgrammer(namn)));
			} catch (IllegalArgumentException e) {
				System.out.println("Otillåtet namn.");
				return false;
			}

		case '2':
			try {
				return (personalRegister.läggTillAnställd(new Receptionist(namn)));
			} catch (IllegalArgumentException e) {
				System.out.println("Otillåtet namn.");
				return false;
			}

		case '3':
			try {
				return (personalRegister.läggTillAnställd(new Tekniker(namn)));
			} catch (IllegalArgumentException e) {
				System.out.println("Otillåtet namn.");
				return false;
			}

		case '0':
			return false;

		default:
			System.out.println("Okänd personalkategori");
			return false;
		} //switch

	} //läggTillAnställd

}//Class
