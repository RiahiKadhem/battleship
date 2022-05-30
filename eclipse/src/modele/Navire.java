package modele;
import java.util.ArrayList;
import java.util.Random;

public class Navire {
	String nom;
	int taille;
	char direction;
	boolean visible;
	Point p = new Point(-1, -1);
	ArrayList<String> coords = new ArrayList<String>();
	static char[][] plan = new char[10][10];
	static Navire[] tabNavires = new Navire[4];

	public Navire(String nom, int taille, char direction, int x, int y) {
		this.nom = nom;
		this.taille = taille;
		this.direction = direction;
		this.visible = true;
		this.p.x = x;
		this.p.y = y;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	
	
	

}
