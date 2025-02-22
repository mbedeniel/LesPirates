package model;

import affichage.Affichage;
import affichage.IAffichage;

public class Jeu {
	private IAffichage affichage = new Affichage();
	
	public void lancerJeux() {
		affichage.presenterJeux();
	}
}
