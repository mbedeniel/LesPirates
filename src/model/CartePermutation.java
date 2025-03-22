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
		Joueur adversaire = joueur.recupererAdversaire();
		for (int i = 0; i < 2; i++) {
			numCarte = random.nextInt(1, joueur.recupererNbCarte() - i);
			Carte carte = joueur.recupererCarte(numCarte);
			adversaire.ajouterCarte(carte);
			affichage.afficherPermutation(adversaire.donnerNom(), joueur.donnerNom(), numCarte);
			Joueur joueurActuel = joueur;
			joueur = adversaire;
			adversaire = joueurActuel;
		}
	}

}
