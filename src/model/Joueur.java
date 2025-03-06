package model;

import affichage.ZoneJeu;

public class Joueur {
	private String nom;
	private int vie;
	private int popularite;
	private Main main;
	public void afficher() {
		Jeu.getAffichage().afficherJoueur(nom, String.valueOf(vie), String.valueOf(popularite));
	}
	public void setMain(Main main) {
		this.main = main;
	}






	public Carte[] recupererCartes() {
		//TODO
		return null;
	}
	public String[] parserJoueur() {
		//TODO
		return null;
	}
	public String[][] parserJoueurs(Joueur[] joueurs) {
		//TODO
		return null;
	}
	public ZoneJeu jouerCarte(int nbCarte) {
		//TODO
		return null;
	}
}
