package model;

import affichage.IAffichage;

public class CarteFinal extends CarteSpecial {

	private static IAffichage affichage = Jeu.getAffichage();

	protected CarteFinal(String titre) {
		super(titre, "fait gagner automatiquement, l'adversaire perd tout ses points");
	}

	@Override
	public void afficher(int numCarte) {
		affichage.afficherCarteSpecial(titre, description, numCarte);

	}

}
