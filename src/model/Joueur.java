package model;

import affichage.IAffichage;

public class Joueur {
	private Nom nom;
	private int vie = 5;
	private int popularite = 0;
	private Main main;
	private static IAffichage affichage = Jeu.getAffichage();

	public Joueur(Nom nom) {
		this.nom = nom;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Nom getNom() {
		return nom;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public int getPopularite() {
		return popularite;
	}

	public void afficher() {
		affichage.afficherJoueur(donnerNom(), vie, popularite);
	}

	public void afficherMain() {
		affichage.afficherCartes(donnerNom());
		main.afficher();
	}

	public String donnerNom() {
		return nom.toString();
	}

	public boolean ajouterCarte(Carte carte) {
		return main.ajouterCarte(carte);
	}

	public Carte recupererCarte(int numCarte) {
		return main.retirerCarte(numCarte);
	}

	public void modifierVie(int nouvelVie) {
		nouvelVie += vie;
		if (nouvelVie < 0) {
			nouvelVie = 0;
		}
		vie = nouvelVie;
	}

	public void modifierPopularite(int nouvelPopularite) {
		nouvelPopularite += popularite;
		if (nouvelPopularite > 5) {
			nouvelPopularite = 5;
		} else if (nouvelPopularite < 0) {
			nouvelPopularite = 0;
		}
		popularite = nouvelPopularite;
	}

}
