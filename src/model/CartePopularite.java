package model;

import affichage.ZoneJeu;

public class CartePopularite extends Carte {
	private int popularite;
	
	public CartePopularite(String titre, String description, int popularite) {
		super(titre, description);
		this.popularite = popularite;
	}

	@Override
	public void afficher(int numCarte) {
		Jeu.getAffichage().afficherCarte(titre,description, String.valueOf(popularite), numCarte);
	}
	
	@Override
	protected ZoneJeu donnerZone() {
		return ZoneJeu.POPULARITE;
	}
}
