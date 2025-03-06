package model;

public class CartePopularite extends Carte {
	private int popularite;
	
	public CartePopularite(String titre, String description, int popularite) {
		super(titre, description);
		this.popularite = popularite;
	}

	@Override
	public void afficher() {
		Jeu.getAffichage().afficherCarte(titre,description, String.valueOf(popularite));
	}
}
