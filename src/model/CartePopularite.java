package model;

import affichage.IAffichage;
import affichage.ZoneJeu;

public class CartePopularite extends Carte {
	private int popularite;
	private static IAffichage affichage = Jeu.getAffichage();

	public CartePopularite(String titre, String description, int popularite) {
		super(titre, description);
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
}
