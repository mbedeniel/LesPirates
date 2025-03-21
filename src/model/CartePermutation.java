package model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CartePermutation extends CarteSpecial {

	private static SecureRandom random;

	public CartePermutation(String titre, Jeu jeu) {
		super(titre, "permute 01 carte de chaque joueurs avec une carte de son adversaire", jeu);
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void jouerCarte(Joueur joueur, int numCarte) {
		afficher(numCarte);
		int nbJoueur = jeu.getNB_JOUEUR();
		Joueur[] joueurs = { jeu.recupererAdversaire(joueur), joueur };
		int[] numCartes = new int[nbJoueur];
		Carte[] cartes = new Carte[nbJoueur];
		for (int i = 0; i < nbJoueur; i++) {
			numCartes[i] = random.nextInt(1, joueurs[i].recupererNbCarte());
			cartes[i] = joueurs[i].recupererCarte(numCartes[i]);
		}
		for (int i = 0; i < nbJoueur; i++) {
			joueurs[i].ajouterCarte(cartes[nbJoueur - i]);
			affichage.afficherPermutation(joueurs[i].donnerNom(), joueurs[nbJoueur - i].donnerNom(),
					numCartes[nbJoueur - i]);
		}

	}

}
