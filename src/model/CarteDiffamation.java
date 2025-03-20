package model;

public class CarteDiffamation extends CarteSpecial {

	private int popularite;

	public CarteDiffamation(String titre, int popularite, Jeu jeu) {
		super(titre, "retire des points de popularite a l’adversaire",jeu);
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
	public void jouerCarte(Joueur joueur, int numCarte) {
		joueur = jeu.recupererAdversaire(joueur);
		afficher(numCarte);
		joueur.modifierPopularite(popularite);
	}

}
