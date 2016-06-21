package PHUtskrift;

import java.util.Scanner;

abstract class CLI {

	static void visaCLI(){
		Scanner scanner = new Scanner(System.in);
		String input = "";
		char kommando = '#';

		while(true){
			System.out.println("\nVälj ett kommando:");
			System.out.println("==================");

			System.out.println("1. Skapa ny anställd");
			System.out.println("2. Visa alla anställda");
			System.out.println("\n0. Avsluta");

			do{
				input = scanner.nextLine().trim();
			}while(input.length() == 0);
			//input är nu garanterat icke-tom

			kommando = input.charAt(0);
			switch(kommando) {
			case '1':
				System.out.println("debug: skapa ny anställd");
				break;
				
			case '2':
				System.out.println("debug: vsia alla anställda");
				break;

			
			case '0':
				scanner.close();
				return;
				
			default:
				System.out.println("Okänt kommando");
			break;
			}//switch

		}//while


	}
}
