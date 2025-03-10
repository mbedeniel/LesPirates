package model;

import affichage.ZoneJeu;

public abstract class CarteSpecial extends Carte {

	protected CarteSpecial(String titre, String description) {
		super(titre, description);
	}

	protected abstract void afficher(int numCarte);

	@Override
	protected ZoneJeu donnerZone() {
		return ZoneJeu.SPECIAL;
	}

}
