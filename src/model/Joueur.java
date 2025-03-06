package model;

import affichage.ZoneJeu;

public class Joueur {
	private Nom nom;
	private int vie;
	private int popularite;
	private Main main;
	
	
	
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public Nom getNom() {
		return nom;
	}
	public void afficher() {
		Jeu.getAffichage().afficherJoueur(nom.toString(), String.valueOf(vie), String.valueOf(popularite));
	}
	
	public void afficherMain() {
		main.afficher();
	}
	public String donnerNom() {
		return nom.toString();
	}
	public boolean ajouterCarte(Carte carte) {
		return main.ajouterCarte(carte);
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
