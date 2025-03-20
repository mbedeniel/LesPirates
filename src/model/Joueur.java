package model;

import affichage.IAffichage;

public class Joueur {
	private Nom nom;
	private int vie = 5;
	private int popularite = 0;
	private Main main;
	private Jeu jeu;
	private static IAffichage affichage = Jeu.getAffichage();

	public Joueur(Nom nom, Jeu jeu) {
		this.nom = nom;
		this.jeu = jeu;
	}

	public void setMain(Main main) {
		this.main = main;
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

	public int recupererNbCarte() {
		return main.getNbCarte();
	}

	public boolean ajouterCarte(Carte carte) {
		return main.ajouterCarte(carte);
	}

	public Carte recupererCarte(int numCarte) {
		return main.retirerCarte(numCarte);
	}

	public void modifierVie(int nouvelVie) {
		nouvelVie += vie;
		if (nouvelVie < jeu.getMIN_VIE()) {
			nouvelVie = jeu.getMIN_VIE();
		}else if(nouvelVie > jeu.getMAX_VIE()){
			nouvelVie = jeu.getMAX_VIE();
		}
		vie = nouvelVie;
	}

	public void modifierPopularite(int nouvelPopularite) {
		nouvelPopularite += popularite;
		if (nouvelPopularite > jeu.getMAX_POPULARITE()) {
			nouvelPopularite = jeu.getMAX_POPULARITE();
		} else if (nouvelPopularite < jeu.getMIN_POPULARITE()) {
			nouvelPopularite = 0;
		}
		popularite = nouvelPopularite;
	}

}
