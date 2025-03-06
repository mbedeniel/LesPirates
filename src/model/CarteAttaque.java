package model;

public class CarteAttaque extends Carte {
	private int vie;
	
	@Override
	public void afficher() {
		// TODO Auto-generated method stub
		Jeu.getAffichage().afficherCarte(titre, String.valueOf(vie), description);
	}
}
