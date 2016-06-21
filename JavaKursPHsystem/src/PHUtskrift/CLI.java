package PHUtskrift;

import java.util.Scanner;

abstract class CLI {

	static void visaCLI(){
		Scanner scanner = new Scanner(System.in);
		String input = "";
		char kommando = '#';

		while(true){
			System.out.println("\nV�lj ett kommando:");
			System.out.println("==================");

			System.out.println("1. Skapa ny anst�lld");
			System.out.println("2. Visa alla anst�llda");
			System.out.println("\n0. Avsluta");

			do{
				input = scanner.nextLine().trim();
			}while(input.length() == 0);
			//input �r nu garanterat icke-tom

			kommando = input.charAt(0);
			switch(kommando) {
			case '1':
				System.out.println("debug: skapa ny anst�lld");
				break;
				
			case '2':
				System.out.println("debug: vsia alla anst�llda");
				break;

			
			case '0':
				scanner.close();
				return;
				
			default:
				System.out.println("Ok�nt kommando");
			break;
			}//switch

		}//while


	}
}
