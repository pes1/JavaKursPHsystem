package PHUtskrift;

import java.util.Scanner;

import model.PersonalRegister;

public class MainPH {

	static final Scanner scanner = new Scanner(System.in);


	public static void main(String[] args) {

		PersonalRegister personalRegister = new PersonalRegister();
		
		CLI.visaCLI(personalRegister, scanner);
		
		scanner.close();

		System.out.println("\nProgrammet avslutas.");

	}//main

}//Class

