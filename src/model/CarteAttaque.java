package model;

public class CarteAttaque extends Carte {
	private int vie;
	
	public CarteAttaque(String titre, String description, int vie) {
		super(titre, description);
		this.vie = vie;
	}

	@Override
	public void afficher() {
		Jeu.getAffichage().afficherCarte(titre, description,String.valueOf(vie) );
	}
}
