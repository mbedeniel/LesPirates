package model;

public class CartePermutation extends CarteSpecial {

	public CartePermutation(String titre, String description) {
		super(titre, description);
	}

	@Override
	protected void afficher(int numCarte) {
		// TODO Auto-generated method stub

	}

	@Override
	public void jouerCarte(Joueur joueur, int numCarte) {
		Joueur adversaire = Jeu.recupererAdversaire(joueur);
		Main main = joueur.getMain();
		joueur.setMain(adversaire.getMain());
		adversaire.setMain(main);
		joueur.afficherMain();
		adversaire.afficherMain();
	}

}
