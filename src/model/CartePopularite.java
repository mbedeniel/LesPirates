package model;

import affichage.IAffichage;
import affichage.ZoneJeu;

public class CartePopularite extends Carte {
	private int popularite;
	private static final IAffichage affichage = Jeu.getAffichage();
	
	
	
	public int getPopularite() {
		return popularite;
	}

	public CartePopularite(String titre, String description, int popularite) {
		super(titre, description);
		this.popularite = popularite;
	}

	@Override
	public void afficher(int numCarte) {
		affichage.afficherCarte(titre,description, String.valueOf(popularite), numCarte);
	}
	
	@Override
	protected ZoneJeu donnerZone() {
		return ZoneJeu.POPULARITE;
	}
}
