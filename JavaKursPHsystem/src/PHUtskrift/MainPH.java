package PHUtskrift;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainPH {


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int input = -1;

		while(input != 0) {
			System.out.println("\nVälj ett kommando:");
			System.out.println("==================");

			System.out.println("1. Skapa ny anställd");

			System.out.println("\n0. Avsluta");

			try{
				input = scanner.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("input: " + input);
				System.out.println("Endast siffror.");
				
			}

			scanner.nextLine();
			System.out.println(input);

		}//while

		System.out.println("\nProgrammet avslutas.");
		scanner.close();
		System.exit(0);


	}//main

}//Class

