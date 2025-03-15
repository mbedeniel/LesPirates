package model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CartePermutation extends CarteSpecial {

	private static SecureRandom random;

	public CartePermutation(String titre) {
		super(titre, "permute 01 carte de chaque joueurs avec une carte de son adversaire");
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void jouerCarte(Joueur joueur, int numCarte) {
		afficher(numCarte);
		Joueur adversaire = Jeu.recupererAdversaire(joueur);
		int numCarteAdversaire = random.nextInt(1, adversaire.recupererNbCarte());
		Carte carteAdversaire = adversaire.recupererCarte(numCarteAdversaire);
		int numCarteJoueur = random.nextInt(1, joueur.recupererNbCarte());
		Carte carteJoueur = joueur.recupererCarte(numCarteJoueur);
		adversaire.ajouterCarte(carteJoueur);
		joueur.ajouterCarte(carteAdversaire);
		affichage.afficherPermutation(adversaire.donnerNom(), joueur.donnerNom(), numCarteJoueur);
		affichage.afficherPermutation(joueur.donnerNom(), adversaire.donnerNom(), numCarteAdversaire);

	}

}
