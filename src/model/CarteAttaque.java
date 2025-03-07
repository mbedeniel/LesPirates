package model;

import affichage.ZoneJeu;

public class CarteAttaque extends Carte {
	private int vie;
	
	public CarteAttaque(String titre, String description, int vie) {
		super(titre, description);
		this.vie = vie;
	}

	@Override
	public void afficher(int numCarte) {
		Jeu.getAffichage().afficherCarte(titre, description,String.valueOf(vie),numCarte);
	}
	
	@Override
	protected ZoneJeu donnerZone() {
		return ZoneJeu.ATTAQUE;
	}
}
