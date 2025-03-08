package model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Pioche {
	private Carte[] cartes = new Carte[Jeu.getTaillePioche()];
	private int nbCarte =  Jeu.getTaillePioche();
	private static SecureRandom random;
	
	public Pioche() {
		//TODO il faut generer les cartes de la pioche
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	public Carte piocher() {
		return retirerCarte(random.nextInt(0, nbCarte-1));
	}
	public Main piocherMain() {
		int nbCarteMain = Jeu.getTailleMain()-1;
		Carte[] cartes = new Carte[nbCarteMain];
		for(int i=0;i<nbCarteMain;i++) {
			cartes[i] = piocher();
		}
		return new Main(cartes);
	}
	public Carte retirerCarte(int indice) {
		Carte carte = cartes[indice];
		for(int i=indice;i<cartes.length-1;i++) {
			cartes[indice] = cartes[indice+1];
		}
		cartes[nbCarte-1] = null;
		nbCarte --;
		return carte;
	}
}
