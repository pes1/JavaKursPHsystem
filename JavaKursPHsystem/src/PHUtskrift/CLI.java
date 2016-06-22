package PHUtskrift;

import java.util.HashSet;
import java.util.InputMismatchException;
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
		String anställdUppdateraString;
		String nyttNamn;
		Anställd anställdUppdatera;
		String nyUppTidString;
		double nyUppTid = 0.0;
		boolean uppdateraUppTid = false;
		String nyttBetygString;
		int nyttBetyg = 0;
		boolean sättBetyg = false;
		char kommando = '#';

		while(true){
			kommandoString = "";

			System.out.println("\nVälj ett kommando:");
			System.out.println("==================");

			System.out.println("1. Skapa ny anställd");
			System.out.println("2. Visa alla anställda");
			System.out.println("3. Visa lönestatistik");
			System.out.println("4. Visa personalfördelning");
			System.out.println("5. Uppdatera anställd");
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
				break;

			case '5':
				//uppdatera anställd
				System.out.print("\nNamn på anställd: ");
				anställdUppdateraString = scanner.nextLine();
				anställdUppdatera = personalRegister.slåUppAnställd(anställdUppdateraString.trim());

				if (anställdUppdatera == null) {
					System.out.println("Det finns ingen anställd med det namnet.");
				} else {
					System.out.print("Nytt namn för " + anställdUppdatera.getNamn() + " (Enter för att hoppa över): ");
					nyttNamn = scanner.nextLine();
					try {
						anställdUppdatera.setNamn(nyttNamn);
					} catch (IllegalArgumentException e) {
						System.out.println("--hoppar över--");
					}

					if (anställdUppdatera instanceof Tekniker) {
						//Uppdatera attribut specifika för Tekniker
						System.out.print("Upptid (" + ((Tekniker) anställdUppdatera).getUppTid() + "): ");

						uppdateraUppTid = false;
						try {
							nyUppTid = Double.parseDouble(scanner.nextLine().trim());
							uppdateraUppTid = true;
						} catch (NumberFormatException e) {
							System.out.println("--ogilting input, hoppar över--");
						}

						if (uppdateraUppTid) {
							try {
								((Tekniker) anställdUppdatera).setUppTid(nyUppTid);
							} catch (IllegalArgumentException e) {
								System.out.println("--ogiltig input, hoppar över--");
							}
						}

					}//Uppdatera Tekniker
					
					if (anställdUppdatera instanceof JavaProgrammer) {
						//Uppdatera attribut specifika för Javaprogrammerare
						System.out.print("Upptid " + ((JavaProgrammer) anställdUppdatera).getUppTid() + "): ");
						
						uppdateraUppTid = false;
						try {
							nyUppTid = Double.parseDouble(scanner.nextLine().trim());
							uppdateraUppTid = true;
						} catch (NumberFormatException e) {
							System.out.println("--ogilting input, hoppar över--");
						}
						
						if (uppdateraUppTid) {
							try {
								((JavaProgrammer) anställdUppdatera).setUppTid(nyUppTid);
							} catch (IllegalArgumentException e) {
							}
						}

					}//Uppdatera Javaprogrammerare
					
					if (anställdUppdatera instanceof Receptionist) {
						//Uppdatera attribut specifika för Receptionister
						System.out.print("Sätt betyg för receptionisten " + ((Receptionist) anställdUppdatera).getNamn() + " (1-5), tomt för att hoppa över: ");
						
						sättBetyg = false;
						try {
							nyttBetyg = Integer.parseInt(scanner.nextLine().trim());
							sättBetyg = true;
						} catch (NumberFormatException e) {
							System.out.println("--ogiltig input, hoppar över--");
						}
						
						if (sättBetyg) {
							try {
								((Receptionist) anställdUppdatera).setBetyg(nyttBetyg);
							} catch (IllegalArgumentException e) {
								System.out.println("--ogiltig input, hoppar över--");
							}
						}
					}//Uppdatera Receptionist
				}

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
		System.out.println("2. Tekniker");
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
