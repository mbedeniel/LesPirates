package model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CartePermutation extends CarteSpecial {

	private static SecureRandom random;

	public CartePermutation(String titre) {
		super(titre, "permute les mains des 02 joueurs");
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
		int numCarteAdversaire = random.nextInt(1, adversaire.nbCarte());
		Carte carteAdversaire = adversaire.recupererCarte(numCarteAdversaire);
		int numCarteJoueur = random.nextInt(1, joueur.nbCarte());
		Carte carteJoueur = joueur.recupererCarte(numCarteJoueur);
		adversaire.ajouterCarte(carteJoueur);
		joueur.ajouterCarte(carteAdversaire);
		affichage.afficherPermutation(adversaire.donnerNom(), joueur.donnerNom(), numCarteJoueur);
		affichage.afficherPermutation(joueur.donnerNom(), adversaire.donnerNom(), numCarteAdversaire);

	}

}
