package model;

import affichage.Affichage;
import affichage.IAffichage;
import affichage.ZoneJeu;

public class Jeu {
	private IAffichage affichage = new Affichage();
	private Joueur joueur = new Joueur();
	
	public void lancerJeux() {
		affichage.souhaiterBienvenue();
		affichage.raconterHistoire();
		affichage.presenterJeux();
		String[][] joueurs = joueur.parserJoueurs(null);
		affichage.afficherJoueurs(joueurs);
	}
	
	public boolean avoirGagnant() {
		//TODO
		return false;
	}
	
	public String donnerGagnant() {
		//TODO
		return null;
	}
}
