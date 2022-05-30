package modele;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Board extends JFrame implements ActionListener {
	static char[][] plan = new char[10][10];
	static Navire[] tabNavires = new Navire[4];
	static char[][] planJoueur = new char[10][10];
	static Navire[] tabNaviresJoueur = new Navire[4];
	static boolean gagnat = false;
	static boolean perdu=false;
	public JLabel label;
	public JLabel label2;
	public JPanel labelPanel;
	JTextField text = new JTextField("");
	public JTextField[][] texts = new JTextField[10][10];
	int xEnnemi;
	int yEnnemi;
	static int score=0;

	
	public static char directionAlea() {
		char c = 'h';
		double rand = Math.random();
		if (rand > 0.5) {
			c = 'v';
		}
		return c;
	}

	public static int nombreAlea() {
		Random random = new Random();
		return random.nextInt(10);
	}

	public static boolean verifCollision(Navire n1, Navire n2) {
		boolean test = true;
		if (n1.direction == 'h' && n2.direction == 'h') {
			if ((n2.p.x == n1.p.x) && ((n2.p.x + n2.taille >= n1.p.x) && (n2.p.x <= n1.p.x + n1.taille))
					|| (n2.p.x + n2.taille > 9)) {
				test = false;
			}
		} else if (n1.direction == 'v' && n2.direction == 'v') {
			if ((n2.p.y == n1.p.y) && ((n2.p.y + n2.taille >= n1.p.y) && (n2.p.y <= n1.p.y + n1.taille))
					|| (n2.p.y + n2.taille > 9)) {
				test = false;
			}
		} else if (n1.direction == 'v' && n2.direction == 'h') {
			if ((n2.p.y >= n1.p.y) && (n2.p.y <= n1.p.y + n1.taille)
					&& ((n2.p.x <= n1.p.x) && (n2.p.x + n2.taille >= n1.p.x)) || (n2.p.x + n2.taille > 9)) {
				test = false;
			}
		} else if (n1.direction == 'h' && n2.direction == 'v') {
			if ((n2.p.x >= n1.p.x) && (n2.p.x <= n1.p.x + n1.taille)
					&& ((n2.p.y <= n1.p.y) && (n2.p.y + n2.taille >= n1.p.y)) || (n2.p.y + n2.taille > 9)) {
				test = false;
			}
		}

		return test;

	}

	public static boolean verifFrameCollision(Navire n) {
		boolean test = true;
		if ((n.direction == 'h') && (n.p.x > 6)) {
			test = false;
		} else if ((n.direction == 'v') && (n.p.y > 6)) {
			test = false;
		}

		return test;
	}

	public static void creationNavires(Navire[] tabNavires) {
		Navire n1 = new Navire("porte avions", 4, directionAlea(), nombreAlea(), nombreAlea());
		while (verifFrameCollision(n1) == false) {
			Navire n = new Navire("porte avions", 4, directionAlea(), nombreAlea(), nombreAlea());
			n1 = n;
		}
		tabNavires[0] = n1;

		Navire n2 = new Navire("destroyer", 3, directionAlea(), nombreAlea(), nombreAlea());
		while (verifCollision(n1, n2) == false) {
			Navire n = new Navire("destroyer", 3, directionAlea(), nombreAlea(), nombreAlea());
			n2 = n;
		}
		tabNavires[1] = n2;

		Navire n3 = new Navire("sous-marin", 3, directionAlea(), nombreAlea(), nombreAlea());
		while ((verifCollision(n1, n3) == false) || (verifCollision(n2, n3) == false)) {
			Navire n = new Navire("sous-marin", 3, directionAlea(), nombreAlea(), nombreAlea());
			n3 = n;
		}
		tabNavires[2] = n3;

		Navire n4 = new Navire("bateau patrouille", 2, directionAlea(), nombreAlea(), nombreAlea());
		while ((verifCollision(n1, n4) == false) || (verifCollision(n2, n4) == false)
				|| (verifCollision(n3, n4) == false)) {
			Navire n = new Navire("bateau patrouille", 2, directionAlea(), nombreAlea(), nombreAlea());
			n4 = n;
		}
		tabNavires[3] = n4;

	}

	public static void creationPlan(char[][] plan) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				plan[i][j] = '~';
			}
		}
	}

	public static void affichageNavires(Navire[] tabNavires, char[][] plan) {
		String str;
		char x1 = ' ';
		char y1 = ' ';

		for (int a = 0; a < 4; a++) {

			if (tabNavires[a].direction == 'v') {
				for (int i = tabNavires[a].p.y; i < tabNavires[a].p.y + tabNavires[a].taille; i++) {
					plan[i][tabNavires[a].p.x] = 'X';
					x1 = Integer.toString(tabNavires[a].p.x).charAt(0);
					y1 = Integer.toString(i).charAt(0);
					str = "(" + x1 + "," + y1 + ")";
					tabNavires[a].coords.add(str);

				}
			} else if (tabNavires[a].direction == 'h') {
				for (int i = tabNavires[a].p.x; i < tabNavires[a].p.x + tabNavires[a].taille; i++) {
					plan[tabNavires[a].p.y][i] = 'X';
					x1 = Integer.toString(i).charAt(0);
					y1 = Integer.toString(tabNavires[a].p.y).charAt(0);
					str = "(" + x1 + "," + y1 + ")";
					tabNavires[a].coords.add(str);
				}
			}
		}
	}

	public static void affichagePlan(char[][] plan) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(plan[i][j] + "  ");

			}
			System.out.println();
		}
	}

	public void MenuPrincipale(String titre) {

		JFrame menu = new JFrame("Menu Principal");
		menu.setSize(250, 250);
		menu.setLocation(400, 200);
		menu.setVisible(true);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menu.setLayout(new GridLayout(4, 1));
		JButton demarrer = new JButton("Démarrer le Jeu");
		demarrer.add(demarrer);

		JButton choisirOption = new JButton("Choisir niveau de difficulte");
		choisirOption.add(choisirOption);

		JButton quitter = new JButton("Quitter le Jeu");
		this.add(quitter);
		menu.setVisible(true);
	}

	public Board(String titre) {

		creationNavires(tabNavires);
		creationPlan(plan);
		affichageNavires(tabNavires, plan);
		affichagePlan(plan);

		System.out.println();

		creationNavires(tabNaviresJoueur);
		creationPlan(planJoueur);
		affichageNavires(tabNaviresJoueur, planJoueur);
		affichagePlan(planJoueur);

		int x = 0;
		int y = 0;
		JFrame f = new JFrame("Battleship");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(3, 1));
		f.setSize(900, 700);
		

		f.setLocation(500, 100);
		JPanel f1 = new JPanel();
		JButton[] boutons = new JButton[100];

		f1.setLayout(new GridLayout(10, 10));
		for (int i = 0; i < 100; i++) {
			x = i / 10;
			y = i % 10;
			JButton btn = new JButton("(" + y + "," + x + ")");
			boutons[i] = btn;
			btn.addActionListener(this);
			f1.add(boutons[i]);

		}
		f.add(f1);
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BorderLayout());
		this.label = new JLabel("votre score est : "+score, SwingConstants.LEFT);
		labelPanel.add(label);
		f.add(labelPanel);

		JPanel f2 = new JPanel();
		f2.setLayout(new GridLayout(10, 10));
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Font font1 = new Font("font", Font.BOLD, 20);
				JTextField text = new JTextField("~");
				text.setText("      " + planJoueur[i][j]);
				text.setFont(font1);
				texts[i][j] = text;
				f2.add(text);

			}

		}
		f.add(f2);
		f.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("ok");
		Object button = e.getSource();
		JButton bouton = (JButton) button;
		System.out.println(bouton.getText());
		String coord = bouton.getText();
		String ch1 = coord.substring(1, 2);
		String ch2 = coord.substring(3, 4);
		int x = Integer.parseInt(ch1);
		int y = Integer.parseInt(ch2);
		String ch = Character.toString(plan[y][x]);
		String ch3 = bouton.getText();
		for (int i = 0; i < 4; i++) {
			if (tabNavires[i].coords.contains(ch3)) {
				tabNavires[i].taille--;
				score=score+100;
				label.setText("votre score est : "+score);
				System.out.println(tabNavires[i].nom +" ennemi touché");
			}
			if (tabNavires[i].taille == 0) {
				tabNavires[i].taille--;
				score=score+100;
				label.setText("votre score est : "+score+"  "+tabNavires[i].nom + " ennemi detruit ");

				System.out.println(tabNavires[i].nom + " ennemi detruit ");
			}
		}
		


		bouton.setText(ch);
		perdu=true;
		gagnat = true;
		for (int i = 0; i < 4; i++) {
			if (tabNavires[i].taille != -1) {
				gagnat = false;
			}
		}
		if (gagnat == true) {
			label.setText(label.getText() + " vous avez gagné.");

		}
		xEnnemi = nombreAlea();
		yEnnemi = nombreAlea();
		text.setText("#");
		Color color = new Color(255, 0, 0);
		texts[yEnnemi][xEnnemi].setBackground(color);
		String ch4="(" + xEnnemi + "," + yEnnemi + ")";
		System.out.println(ch4);
		for (int i = 0; i < 4; i++) {
			if (tabNaviresJoueur[i].coords.contains(ch4)) {
				tabNaviresJoueur[i].taille--;
				score=score-50;
				label.setText("votre score est : "+score);
				System.out.println("votre "+tabNaviresJoueur[i].nom+" a été touché");
			}
			
			if (tabNaviresJoueur[i].taille == 0) {
				tabNaviresJoueur[i].taille--;
				score=score-50;
				label.setText("votre score est : "+score+"  "+tabNaviresJoueur[i].nom + " a été detruit ");
				System.out.println("votre "+tabNaviresJoueur[i].nom + " a été detruit ");
			}
		}
		
		
		for (int i = 0; i < 4; i++) {
			if (tabNaviresJoueur[i].taille != -1) {
				perdu = false;
			}
		}
		if (perdu == true) {
			label.setText(label.getText() + " l'ennemi a gagné. ");

		}

	}

	public static void main(String[] arg) {
		
		
		new Board("Batlleship");

	}

}/*
	 * class EcouteurBouton implements ActionListener {
	 * 
	 * 
	 * 
	 * }
	 */
