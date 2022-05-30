package vue;

public class Apparence {
	

public Apparence() {
		
	}
	
	public void afficherMenu() {
		System.out.println("Bienvenue dans le Jeu Battleship....................................");
		System.out.println("\n" + " _           _   _   _           _     _       \r\n"
				+ "| |         | | | | | |         | |   (_)      \r\n"
				+ "| |__   __ _| |_| |_| | ___  ___| |__  _ _ __  \r\n"
				+ "| '_ \\ / _` | __| __| |/ _ \\/ __| '_ \\| | '_ \\ \r\n"
				+ "| |_) | (_| | |_| |_| |  __/\\__ \\ | | | | |_) |\r\n"
				+ "|_.__/ \\__,_|\\__|\\__|_|\\___||___/_| |_|_| .__/ \r\n"
				+ "                                        | |    \r\n"
				+ "                                        |_|   " 
				
				
				
				+"|__\r\n"
				+ "                                     |\\/\r\n"
				+ "                                     ---\r\n"
				+ "                                     / | [\r\n"
				+ "                              !      | |||\r\n"
				+ "                            _/|     _/|-++'\r\n"
				+ "                        +  +--|    |--|--|_ |-\r\n"
				+ "                     { /|__|  |/\\__|  |--- |||__/\r\n"
				+ "                    +---------------___[}-_===_.'____                 /\\\r\n"
				+ "                ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _\r\n"
				+ " __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7\r\n"
				+ "|                                                                     BB-61/\r\n"
				+ " \\_________________________________________________________________________|"
				
		);
	}
	
	public void afficherMessages(String message) {
		System.out.println(message);
		
	}
	
	public void afficherLesOptionsDeMenu() {
		System.out.println("press: \n" + 
				"\t 0 - Demarrer le Jeu \n" + 
				"\t 1 - Afficher les regles du jeu \n" +
				"\t 2 - Quitter le jeu \n");
	}
	
	public void afficherMessageDeFin() {
		System.out.println(
							" _                \r\n"
							+ "| |               \r\n"
							+ "| |__  _   _  ___ \r\n"
							+ "| '_ \\| | | |/ _ \\\r\n"
							+ "| |_) | |_| |  __/\r\n"
							+ "|_.__/ \\__, |\\___|\r\n"
							+ "        __/ |     \r\n"
							+ "       |___/    ");
	}
	
	public void reglesDuJeu() {
		
		System.out.println("Votre mission est d'exterminer la flotte de l'ennemi \n" + "Veuillez tirer dans les cases du cadran de l'ennemi pour atteindre ses navires \n" +
		"L'ennemi tirera sur votre flotte simultanement \n" + "Vous recevrez un message lorsque vous aurez remporte la partie \n");
	}
	
}
