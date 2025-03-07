package model;

import affichage.IAffichage;

public class Joueur {
	private Nom nom;
	private int vie;
	private int popularite;
	private Main main;
	private static final IAffichage affichage = Jeu.getAffichage();
	
	
	
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
		affichage.afficherJoueur(nom.toString(), String.valueOf(vie), String.valueOf(popularite));
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
	public void jouerCarte(int numCarte) {
		main.retirerCarte(numCarte);
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
	
}
