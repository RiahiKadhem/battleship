package vue;

import controleur.Ecouteurs;
import modele.Board;

public class Jeu {
	
	private Apparence apparence;
	private Board board;
	private Ecouteurs ecouteurs;
	
	public Jeu() {
		
		apparence = new Apparence();
		
	}
	
	
public static void main(String[] arg) {
		
		Jeu battleship = new Jeu();
		battleship.demarrer();
		
		//new Board("Batlleship");

	}
	
public void demarrer() {
	
	apparence.afficherMenu();
	apparence.afficherLesOptionsDeMenu();
	menuPrincipal();
}

public void menuPrincipal() {
	
	int choixMenu;
	boolean quitter = false;
	ecouteurs = new Ecouteurs();
	
	
while(!quitter) {
		
		System.out.println("Veuillez saisir votre choix: ");
		System.out.println();
		choixMenu = ecouteurs.getIntegerOptionDeMenu();
		
		switch(choixMenu) {
		
		case 0:
			apparence.afficherMessages("Vous allez demarrer le jeu.......");
			new Board("Batlleship");
			//Board board = new Board("Battleship");
			//jeu.JeuEnCours();
			break;
			
		case 1:
//The flush() method of PrintWriter Class in Java is used to flush the stream. 
//By flushing the stream, it means to clear the stream of any element that may be or maybe not inside the stream.				
			System.out.flush();
			apparence.reglesDuJeu();
			break;
			
		case 2:
			apparence.afficherMessages("Vous allez quitter le jeu............");
			quitterLeJeu();
			break;
			
		}
	}
	
}

public void quitterLeJeu() {
	
	apparence.afficherMessageDeFin();
//La methode System.exit quitte le programme en cours en mettant fin a l'instance en cours de JVM
	System.exit(0);
}

	
	
}
