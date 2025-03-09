package model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Pioche {
	private static final int TAILLE_PIOCHE = Jeu.getTaillePioche();
	private Carte[] cartes = new Carte[TAILLE_PIOCHE];
	private int nbCarte = TAILLE_PIOCHE;
	private static SecureRandom random;
	private static Carte[] touteCartes = {new CarteAttaque("A", "description", 0),new CarteAttaque("A", "description", 0),new CartePopularite("P", "descrition", 2)};

	public Pioche() {
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		for(int i=0;i<TAILLE_PIOCHE;i++) {
			cartes[i] = touteCartes[random.nextInt(0, touteCartes.length - 1)];
		}
	}

	public Carte piocher() {
		if(cartes[0]==null) {
			renouvelerPioche();
		}
		return retirerCarte(random.nextInt(0, nbCarte - 1));
	}

	public Main piocherMain() {
		int nbCarteMain = Jeu.getTailleMain() - 1;
		Carte[] cartes = new Carte[nbCarteMain];
		for (int i = 0; i < nbCarteMain; i++) {
			cartes[i] = piocher();
		}
		return new Main(cartes);
	}

	public Carte retirerCarte(int indice) {
		Carte carte = cartes[indice];
		for (int i = indice; i < cartes.length - 1; i++) {
			cartes[indice] = cartes[indice + 1];
		}
		cartes[nbCarte - 1] = null;
		nbCarte--;
		return carte;
	}
	
	public void renouvelerPioche() {
		Pioche pioche = new Pioche();
		cartes = pioche.cartes;
	}
}
