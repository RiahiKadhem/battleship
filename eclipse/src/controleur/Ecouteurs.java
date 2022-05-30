package controleur;

import java.util.Scanner;

public class Ecouteurs {
	
	private Scanner scanner = new Scanner(System.in);
	int choix;
	
	public Ecouteurs() {
		
	}

	public int getIntegerOptionDeMenu() {
		choix = scanner.nextInt();
		scanner.nextLine();
		return choix;
		
	}

	

}
