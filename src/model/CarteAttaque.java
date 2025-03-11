package model;

import affichage.IAffichage;
import affichage.ZoneJeu;

public class CarteAttaque extends Carte {
	private int vie;
	private static IAffichage affichage = Jeu.getAffichage();

	public CarteAttaque(String titre, String description, int vie) {
		super(titre, description);
		this.vie = vie;
	}

	public int getVie() {
		return vie;
	}

	@Override
	public void afficher(int numCarte) {
		affichage.afficherCarte(titre, description, vie, numCarte);
	}

	@Override
	public ZoneJeu donnerZone() {
		return ZoneJeu.ATTAQUE;
	}
}
