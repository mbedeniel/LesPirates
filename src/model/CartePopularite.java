package model;

import affichage.ZoneJeu;

public class CartePopularite extends Carte {
	private int popularite;

	public CartePopularite(String titre, String description, Jeu jeu, int popularite) {
		super(titre, description, jeu);
		this.popularite = popularite;
	}

	public int getPopularite() {
		return popularite;
	}

	@Override
	public void afficher(int numCarte) {
		affichage.afficherCarte(titre, description, popularite, numCarte);
	}

	@Override
	public ZoneJeu donnerZone() {
		return ZoneJeu.POPULARITE;
	}

	@Override
	public void jouerCarte(Joueur joueur, int numCarte) {
		afficher(numCarte);
		joueur.modifierPopularite(popularite);
	}

}
