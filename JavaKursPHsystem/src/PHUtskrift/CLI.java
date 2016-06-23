package PHUtskrift;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import model.Anst�lld;
import model.JavaProgrammer;
import model.PersonalRegister;
import model.Receptionist;
import model.Tekniker;

abstract class CLI {

	static void visaCLI(PersonalRegister personalRegister, Scanner scanner){
		String kommandoString;
		String anst�lldUppdateraString;
		String nyttNamn;
		double nyUppTid = 0.0;
		boolean uppdateraUppTid = false;
		int nyttBetyg = 0;
		boolean s�ttBetyg = false;
		char kommando = '#';
		int antalRoller = 3; //antal Yrkeskategorier
		int[] stapelData = new int[antalRoller + 1];


		while(true){
			kommandoString = "";

			System.out.println("\nV�lj ett kommando:");
			System.out.println("==================");

			System.out.println("1. Skapa ny anst�lld");
			System.out.println("2. Visa alla anst�llda");
			System.out.println("3. Visa l�nestatistik");
			System.out.println("4. Visa personalf�rdelning");
			System.out.println("5. Visa anst�lld"); 
			System.out.println("6. Uppdatera anst�lld");
			System.out.println("\n0. Avsluta");

			do {
				kommandoString = scanner.nextLine().trim();
			} while (kommandoString.length() == 0);
			//input �r nu garanterat icke-tom

			kommando = kommandoString.charAt(0);

			switch(kommando) {
			case '1':
				System.out.println(l�ggTillAnst�lld(personalRegister, scanner));
				break;

			case '2':
				Set<Anst�lld> personalCollection = personalRegister.getKopia();
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
				Anst�lld h�gstBetald = personalRegister.h�gstBetald();
				System.out.println("\nH�gst betald: " + (h�gstBetald == null ? "--ingen--" : h�gstBetald + ", " + h�gstBetald.getM�nadsL�n()) );

				Set<Anst�lld> personalSet = new HashSet<Anst�lld>(personalRegister.getKopia());
				double medelL�n;

				if(personalSet.size() == 0){
					medelL�n = 0;
				} else {
					long totalL�n = 0L;
					for (Anst�lld anst�lld : personalSet) {
						totalL�n += anst�lld.getM�nadsL�n();
					}

					medelL�n = ((double)totalL�n / personalSet.size());
				}
				System.out.println("\nMedell�n: " + medelL�n);

				break;

			case '4':
				//personalf�rdenling, stapeldiagram
				//TODO: hantera ok�nda personalkategorier, f�r den h�ndelse n�gon l�gger till en ny kategori utan att uppdatera denna klass
				stapelData = personalRegister.getAntalAnst�llda();
				System.out.print("Totalt antal anst�llda: " + stapelData[0] + " ");
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
				//Visa anst�lld
				Anst�lld enAnst�lld1 = hittaNamn(personalRegister, scanner);
				//TODO: visa detaljinfo f�r den anst�lld som hittades
				
				System.out.println("\n namns�k slut " );
				break;

			case '6':
				//uppdatera anst�lld
				System.out.print("\nNamn p� anst�lld: ");
				anst�lldUppdateraString = scanner.nextLine();
				Anst�lld anst�lldUppdatera = personalRegister.sl�UppAnst�lld(anst�lldUppdateraString.trim());

				if (anst�lldUppdatera == null) {
					System.out.println("Det finns ingen anst�lld med det namnet.");
				} else {
					System.out.print("Nytt namn f�r " + anst�lldUppdatera.getNamn() + " (Enter f�r att hoppa �ver): ");
					nyttNamn = scanner.nextLine();
					try {
						anst�lldUppdatera.setNamn(nyttNamn);
					} catch (IllegalArgumentException e) {
						System.out.println("--hoppar �ver--");
					}

					if (anst�lldUppdatera instanceof Tekniker) {
						//Uppdatera attribut specifika f�r Tekniker
						System.out.print("Upptid (" + ((Tekniker) anst�lldUppdatera).getUppTid() + "): ");

						uppdateraUppTid = false;
						try {
							nyUppTid = Double.parseDouble(scanner.nextLine().trim());
							uppdateraUppTid = true;
						} catch (NumberFormatException e) {
							System.out.println("--ogilting input, hoppar �ver--");
						}

						if (uppdateraUppTid) {
							try {
								((Tekniker) anst�lldUppdatera).setUppTid(nyUppTid);
							} catch (IllegalArgumentException e) {
								System.out.println("--ogiltig input, hoppar �ver--");
							}
						}

					}//Uppdatera Tekniker

					if (anst�lldUppdatera instanceof JavaProgrammer) {
						//Uppdatera attribut specifika f�r Javaprogrammerare
						System.out.print("Upptid (" + ((JavaProgrammer) anst�lldUppdatera).getUppTid() + "): ");

						uppdateraUppTid = false;
						try {
							nyUppTid = Double.parseDouble(scanner.nextLine().trim());
							uppdateraUppTid = true;
						} catch (NumberFormatException e) {
							System.out.println("--ogilting input, hoppar �ver--");
						}

						if (uppdateraUppTid) {
							try {
								((JavaProgrammer) anst�lldUppdatera).setUppTid(nyUppTid);
							} catch (IllegalArgumentException e) {
							}
						}
					}//Uppdatera Javaprogrammerare

					if (anst�lldUppdatera instanceof Receptionist) {
						//Uppdatera attribut specifika f�r Receptionister
						System.out.print("S�tt betyg f�r receptionisten " + ((Receptionist) anst�lldUppdatera).getNamn() + " (1-5), tomt f�r att hoppa �ver: ");

						s�ttBetyg = false;
						try {
							nyttBetyg = Integer.parseInt(scanner.nextLine().trim());
							s�ttBetyg = true;
						} catch (NumberFormatException e) {
							System.out.println("--ogiltig input, hoppar �ver--");
						}

						if (s�ttBetyg) {
							try {
								((Receptionist) anst�lldUppdatera).setBetyg(nyttBetyg);
							} catch (IllegalArgumentException e) {
								System.out.println("--ogiltig input, hoppar �ver--");
							}
						}
					}//Uppdatera Receptionist
				}

				break;

			case '0':
				return;

			default:
				System.out.println("Ok�nt kommando");
				break;
			}//switch

		}//while


	}

	private static Anst�lld hittaNamn (PersonalRegister personalRegister, Scanner scanner) {

		String namn;
		System.out.print("\nNamn (Minst ett tecken l�ngt): ");

		do {
			namn = scanner.nextLine().trim();
		} while (namn.length() == 0);
		//- namn �r h�r l�ngre en noll stycken tecken.

		Set<Anst�lld> personalCollection1 = personalRegister.getKopia();

		Iterator<Anst�lld> iter = personalCollection1.iterator();	//  
		while (iter.hasNext()) {
			Anst�lld enAnst�lld = iter.next();
			if ( enAnst�lld.getNamn().equals(namn)){
				System.out.println("Anst�lld funnen: " + enAnst�lld);
				return enAnst�lld;}  //-- 
		} //- of while
		
		//-- Inget namn funnet i personallistan
		System.out.println("Inget personal med namn: " + namn);
		return null;

	} //hittaAnst�lld

	private static boolean l�ggTillAnst�lld (PersonalRegister personalRegister, Scanner scanner) {

		String namn;
		String personalString;
		char personalKategori = '#';

		System.out.print("\nNamn (F�r att avbryta, tryck enter): ");
		namn = scanner.nextLine().trim();
		if(namn.length() == 0 ) {
			return false;
		}

		System.out.println("\nV�lj personalkategori:");
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
				return (personalRegister.l�ggTillAnst�lld(new JavaProgrammer(namn)));
			} catch (IllegalArgumentException e) {
				System.out.println("Otill�tet namn.");
				return false;
			}

		case '2':
			try {
				return (personalRegister.l�ggTillAnst�lld(new Receptionist(namn)));
			} catch (IllegalArgumentException e) {
				System.out.println("Otill�tet namn.");
				return false;
			}

		case '3':
			try {
				return (personalRegister.l�ggTillAnst�lld(new Tekniker(namn)));
			} catch (IllegalArgumentException e) {
				System.out.println("Otill�tet namn.");
				return false;
			}

		case '0':
			return false;

		default:
			System.out.println("Ok�nd personalkategori");
			return false;
		} //switch

	} //l�ggTillAnst�lld

}//Class
