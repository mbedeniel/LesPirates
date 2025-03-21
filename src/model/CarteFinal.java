package model;

public class CarteFinal extends CarteSpecial {

	public CarteFinal(String titre) {
		super(titre, "fait gagner automatiquement, l'adversaire perd tout ses points");
	}

	@Override
	public void jouerCarte(Joueur joueur, int numCarte) {
		afficher(numCarte);
		joueur.setVie(joueur.recupererMinVie());
	}

}
