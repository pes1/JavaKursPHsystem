package PHUtskrift;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import model.Anställd;
import model.JavaProgrammer;
import model.PersonalRegister;
import model.Receptionist;
import model.Tekniker;

abstract class CLI {

	static void visaCLI(PersonalRegister personalRegister, Scanner scanner){
		
		//Variables
		String kommandoString;
		String tempAnställdString;
		String nyttNamn;
		double nyUppTid = 0.0;
		boolean uppdateraUppTid = false;
		int nyttBetyg = 0;
		boolean sättBetyg = false;
		char kommando = '#';
		int antalYrkeskategorier = 3;
		int[] stapelData = new int[antalYrkeskategorier + 1];


		while(true){
			kommandoString = "";

			System.out.println("\nVälj ett kommando:");
			System.out.println("==================");

			System.out.println("1. Skapa ny anställd");
			System.out.println("2. Visa alla anställda");
			System.out.println("3. Visa lönestatistik");
			System.out.println("4. Visa personalfördelning");
			System.out.println("5. Visa anställd"); 
			System.out.println("6. Uppdatera anställd");
			System.out.println("7. Ta bort anställd");
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
				//personalfördenling, stapeldiagram
				//TODO: ny metod för detta; gör styrvariablerna till anropsvariabler för att ta bort dom från klassens lokala variabler 
				//TODO: skriv ut en stapel för okända personalkategorier, för det fall någon lägger till en personalkategori utan att uppdatera denna klass
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

			case '5':
				//Visa anställd
				Anställd enAnställd1 = hittaNamn(personalRegister, scanner);
				//TODO: visa detaljinfo för den anställd som hittades
				
				System.out.println("\n namnsök slut " );
				break;

			case '6':
				//uppdatera anställd
				System.out.print("\nNamn på anställd: ");
				Anställd tempAnställd = personalRegister.slåUppAnställd(scanner.nextLine().trim());

				if (tempAnställd == null) {
					System.out.println("Det finns ingen anställd med det namnet.");
					//TODO: lägg in break och ta bort else-satsen nedan.
				} else {
					System.out.print("Nytt namn för " + tempAnställd.getNamn() + " (Enter för att hoppa över): ");
					nyttNamn = scanner.nextLine();
					try {
						tempAnställd.setNamn(nyttNamn);
					} catch (IllegalArgumentException e) {
						System.out.println("--hoppar över--");
					}

					if (tempAnställd instanceof Tekniker) {
						//Uppdatera attribut specifika för Tekniker
						System.out.print("Upptid (" + ((Tekniker) tempAnställd).getUppTid() + "): ");

						uppdateraUppTid = false;
						try {
							nyUppTid = Double.parseDouble(scanner.nextLine().trim());
							uppdateraUppTid = true;
						} catch (NumberFormatException e) {
							System.out.println("--ogilting input, hoppar över--");
						}

						if (uppdateraUppTid) {
							try {
								((Tekniker) tempAnställd).setUppTid(nyUppTid);
							} catch (IllegalArgumentException e) {
								System.out.println("--ogiltig input, hoppar över--");
							}
						}

					}//Uppdatera Tekniker

					if (tempAnställd instanceof JavaProgrammer) {
						//Uppdatera attribut specifika för Javaprogrammerare
						System.out.print("Upptid (" + ((JavaProgrammer) tempAnställd).getUppTid() + "): ");

						uppdateraUppTid = false;
						try {
							nyUppTid = Double.parseDouble(scanner.nextLine().trim());
							uppdateraUppTid = true;
						} catch (NumberFormatException e) {
							System.out.println("--ogilting input, hoppar över--");
						}

						if (uppdateraUppTid) {
							try {
								((JavaProgrammer) tempAnställd).setUppTid(nyUppTid);
							} catch (IllegalArgumentException e) {
							}
						}
					}//Uppdatera Javaprogrammerare

					if (tempAnställd instanceof Receptionist) {
						//Uppdatera attribut specifika för Receptionister
						System.out.print("Sätt betyg för receptionisten " + ((Receptionist) tempAnställd).getNamn() + " (1-5), tomt för att hoppa över: ");

						sättBetyg = false;
						try {
							nyttBetyg = Integer.parseInt(scanner.nextLine().trim());
							sättBetyg = true;
						} catch (NumberFormatException e) {
							System.out.println("--ogiltig input, hoppar över--");
						}

						if (sättBetyg) {
							try {
								((Receptionist) tempAnställd).setBetyg(nyttBetyg);
							} catch (IllegalArgumentException e) {
								System.out.println("--ogiltig input, hoppar över--");
							}
						}
					}//Uppdatera Receptionist
				}

				break;

			case '7':
				System.out.print("Namn på anställd att ta bort (Enter för att avbryta: ");
				tempAnställdString = scanner.nextLine().trim();
				
				if(tempAnställdString.length() == 0) {
					System.out.println("--Hoppar över--");
					break;
				}
				
				if(	personalRegister.taBortAnställd(tempAnställdString)){
					System.out.println("Anställd borttagen.");
				} else {
					System.out.println("Det gick inte att ta bort.");
				}
				
				break;
				
			case '0':
				return;

			default:
				System.out.println("Okänt kommando");
				break;
			}//switch

		}//while


	}//visaCLI

	private static Anställd hittaNamn (PersonalRegister personalRegister, Scanner scanner) {
		//TODO: Flytta till klassen PersonalRegister, så att sökningen sker där snarare än i CLI-klassen
		String namn;
		System.out.print("\nNamn (Minst ett tecken långt): ");

		do {
			namn = scanner.nextLine().trim();
		} while (namn.length() == 0);
		//- namn är här längre en noll stycken tecken.

		Set<Anställd> personalCollection1 = personalRegister.getKopia();

		Iterator<Anställd> iter = personalCollection1.iterator();	//  
		while (iter.hasNext()) {
			Anställd enAnställd = iter.next();
			if ( enAnställd.getNamn().equals(namn)){
				System.out.println("Anställd funnen: " + enAnställd);
				return enAnställd;}  //-- 
		} //- of while
		
		//-- Inget namn funnet i personallistan
		System.out.println("Inget personal med namn: " + namn);
		return null;

	} //hittaAnställd

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
