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
	
	public void jouerAttaque(Joueur adversaire, int numCarte) {
		CarteAttaque carteAttaque = (CarteAttaque)main.retirerCarte(numCarte);
		carteAttaque.afficher(numCarte);
		int nouvelVie = adversaire.vie + carteAttaque.getVie();
		if(nouvelVie < 0) {
			nouvelVie = 0;
		}
		adversaire.vie = nouvelVie;
	}

	public void jouerPopularite(int numCarte) {
		CartePopularite cartePopularite = (CartePopularite)main.retirerCarte(numCarte);
		cartePopularite.afficher(numCarte);
		int nouvelPopularite =  popularite + cartePopularite.getPopularite();
		if(nouvelPopularite > 5) {
			nouvelPopularite = 5;
		}
		popularite = nouvelPopularite;
	}
	
	public void jouerSoin(int numCarte) {
		CarteSoin carteSoin = (CarteSoin)main.retirerCarte(numCarte);
		carteSoin.afficher(numCarte);
		int nouvelVie = vie + carteSoin.getVie();
		if(nouvelVie > 5) {
			nouvelVie = 5;
		}
		vie = nouvelVie;
	}
	
	public void jouerDiffamation(Joueur adversaire,int numCarte) {
		CarteDiffamation carteDiffamation = (CarteDiffamation)main.retirerCarte(numCarte);
		carteDiffamation.afficher(numCarte);
		int nouvelPopularite = adversaire.popularite + carteDiffamation.getPopularite();
		if(nouvelPopularite < 0) {
			nouvelPopularite = 0;
		}
		adversaire.popularite = nouvelPopularite;
		
	}
	
	public void jouerFinal(Joueur adversaire,int numCarte) {
		CarteFinal carteFinal = (CarteFinal)main.retirerCarte(numCarte);
		carteFinal.afficher(numCarte);
		adversaire.vie = 0;
	}
		
}
