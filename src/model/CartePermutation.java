package model;

public class CartePermutation extends CarteSpecial {

	public CartePermutation(String titre) {
		super(titre, "permute les mains des 02 joueurs");
	}

	@Override
	public void jouerCarte(Joueur joueur, int numCarte) {
		afficher(numCarte);
		Joueur adversaire = Jeu.recupererAdversaire(joueur);
		Main main = joueur.getMain();
		joueur.setMain(adversaire.getMain());
		adversaire.setMain(main);
		joueur.afficherMain();
		adversaire.afficherMain();
	}

}
