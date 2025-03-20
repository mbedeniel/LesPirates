package model;

public class CarteFinal extends CarteSpecial {

	protected CarteFinal(String titre, Jeu jeu) {
		super(titre, "fait gagner automatiquement, l'adversaire perd tout ses points", jeu);
	}

	@Override
	public void jouerCarte(Joueur joueur, int numCarte) {
		afficher(numCarte);
		joueur.setVie(jeu.getMIN_VIE());
	}

}
