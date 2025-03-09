package model;

import affichage.IAffichage;
import affichage.ZoneJeu;

public class CarteAttaque extends Carte {
	private int vie;
	private static final IAffichage affichage = Jeu.getAffichage();
	
	
	public int getVie() {
		return vie;
	}

	public CarteAttaque(String titre, String description, int vie) {
		super(titre, description);
		this.vie = vie;
	}

	@Override
	public void afficher(int numCarte) {
		affichage.afficherCarte(titre, description,String.valueOf(vie),numCarte);
	}
	
	@Override
	protected ZoneJeu donnerZone() {
		return ZoneJeu.ATTAQUE;
	}
}
