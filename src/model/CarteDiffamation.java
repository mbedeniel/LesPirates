package model;

import affichage.IAffichage;

public class CarteDiffamation extends CarteSpecial {

	private int popularite;
	private static IAffichage affichage = Jeu.getAffichage();

	public CarteDiffamation(String titre, int popularite) {
		super(titre, "retire des points de popularite a l’adversaire");
		this.popularite = popularite;
	}

	public int getPopularite() {
		return popularite;
	}

	@Override
	public void afficher(int numCarte) {
		affichage.afficherCarte(titre, description, popularite, numCarte);
	}

}
