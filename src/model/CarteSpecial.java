package model;

import affichage.ZoneJeu;

public abstract class CarteSpecial extends Carte {

	protected CarteSpecial(String titre, String description) {
		super(titre, description);
	}

	@Override
	public void afficher(int numCarte) {
		affichage.afficherCarteSpecial(titre, description, numCarte);

	}

	@Override
	public ZoneJeu donnerZone() {
		return ZoneJeu.SPECIAL;
	}

}
