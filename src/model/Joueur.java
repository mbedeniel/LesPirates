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
	
	public Carte recupererCarte(int numCarte) {
		return main.retirerCarte(numCarte);
	}
	
	public void setVie(int vie) {
		this.vie = vie;
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
		if(nouvelPopularite > 5) {
			nouvelPopularite = 5;
		}
		vie = nouvelPopularite;
	}
	
	public void jouerAttaque(Joueur adversaire, Carte carteJoue, int numCarte) {
		CarteAttaque carteAttaque = (CarteAttaque) carteJoue;
		carteAttaque.afficher(numCarte);
		int nouvelVie = adversaire.vie + carteAttaque.getVie();
		if (nouvelVie < 0) {
			nouvelVie = 0;
		}
		adversaire.vie = nouvelVie;
	}

	public void jouerPopularite(Carte carteJoue, int numCarte) {
		CartePopularite cartePopularite = (CartePopularite) carteJoue;
		cartePopularite.afficher(numCarte);
		int nouvelPopularite = popularite + cartePopularite.getPopularite();
		if (nouvelPopularite > 5) {
			nouvelPopularite = 5;
		}
		popularite = nouvelPopularite;
	}

	public void jouerSoin(Carte carteJoue, int numCarte) {
		CarteSoin carteSoin = (CarteSoin) carteJoue;
		carteSoin.afficher(numCarte);
		int nouvelVie = vie + carteSoin.getVie();
		if (nouvelVie > 5) {
			nouvelVie = 5;
		}
		vie = nouvelVie;
	}

	public void jouerDiffamation(Joueur adversaire, Carte carteJoue, int numCarte) {
		CarteDiffamation carteDiffamation = (CarteDiffamation) carteJoue;
		carteDiffamation.afficher(numCarte);
		int nouvelPopularite = adversaire.popularite + carteDiffamation.getPopularite();
		if (nouvelPopularite < 0) {
			nouvelPopularite = 0;
		}
		adversaire.popularite = nouvelPopularite;

	}

	public void jouerFinal(Joueur adversaire, Carte carteJoue, int numCarte) {
		CarteFinal carteFinal = (CarteFinal) carteJoue;
		carteFinal.afficher(numCarte);
		adversaire.vie = 0;
	}

}
