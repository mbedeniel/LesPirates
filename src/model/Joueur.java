package model;

import affichage.IAffichage;

public class Joueur {
	private Nom nom;
	private int vie = 5;
	private int popularite = 0;
	private Main main;
	private static final IAffichage affichage = Jeu.getAffichage();
	
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

	public void setPopularite(int popularite) {
		this.popularite = popularite;
	}

	public void afficher() {
		affichage.afficherJoueur(donnerNom(), String.valueOf(vie), String.valueOf(popularite));
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
	
	public void jouerCarteAttaque(Joueur adversaire, int numCarte) {
		CarteAttaque carteAttaque = (CarteAttaque)main.retirerCarte(numCarte);
		carteAttaque.afficher(numCarte);
		int vie = adversaire.vie - carteAttaque.getVie();
		if(vie < 0) {
			vie = 0;
		}
		adversaire.setVie(vie);
	}

	public void jouerCartePopularite(int numCarte) {
		CartePopularite cartePopularite = (CartePopularite)main.retirerCarte(numCarte);
		cartePopularite.afficher(numCarte);
		setPopularite(popularite + cartePopularite.getPopularite());
	}
		
}
