package affichage;

import java.util.Scanner;

public class Affichage implements IAffichage {

	private Scanner scanner = new Scanner(System.in);

	@Override
	public void souhaiterBienvenue() {
		System.out.println("PRESENTATION ET REGLES DU JEU  \n");
		System.out.println("\t Bienvenue \n");
	}

	@Override
	public void raconterHistoire() {
		System.out.println("\t Jack le Borgne et Bill Jambe-de-Bois sont deux pirates souhaitant prendre le \n"
				+ "\t commandement du navire à l’etendard noir, « Le Sanguinaire ». L’equipage doit donc les \n"
				+ "\t departager par un vote. Chacun des deux rivaux doit ainsi gagner en popularite (ou \n"
				+ "\t affaiblir son adversaire) afin de devenir le nouveau capitaine. \n");
	}

	@Override
	public void presenterJeux() {
		System.out.println(
				"\t Le Jeu des Pirates est un jeu de societe de cartes dans lequel deux joueurs s’affrontent. \n"
						+ "\t -Chaque joueur pioche quatre cartes. A tour de role, un pirate pioche une nouvelle \n"
						+ "\t carte et l’ajoute à sa main. Il doit ensuite decider s’il attaque son adversaire ou s’il \n"
						+ "\t s’attribue des points de popularite. \n"
						+ "\t -Chaque pirate possede cinq cœurs rouges correspondant a ses points de vie. S’il n’a \n"
						+ "\t plus de coeur, alors il a perdu et son adversaire gagne. \n"
						+ "\t -Le but du jeu est que son pirate atteigne cinq points de popularite ou simplement \n"
						+ "\t survive plus longtemps que son adversaire ! \n"
						+ "\t -Au debut de son tour, le pirate pioche une carte et l’ajoute à sa main. \n"
						+ "\t Il choisit ensuite parmi sa main, composee de cinq cartes, une carte qu’il depose : \n"
						+ "\t \t -Dans sa zone de popularite s’il s’agit d’une carte de popularite, \n"
						+ "\t \t -Dans la zone de son adversaire s’il s’agit d’une carte d’attaque. \n");
	}

	@Override
	public void afficherCarte(String titre, String description, int effet, int numCarte) {
		System.out.println("\t numero carte : " + numCarte + " \n \t titre : " + titre + "\n \t effet : " + effet
				+ "\n \t description : " + description + " \n");
	}

	@Override
	public void afficherCartes(String nom) {
		System.out.println("AFFICHAGE DES CARTES DE " + nom + "\n");
	}

	@Override
	public void afficherJoueur(String nom, int vie, int popularite) {
		System.out.println(" \t nom : " + nom + "\n \t vie : " + vie + "\n \t popularite : " + popularite + " \n");
	}

	@Override
	public void afficherJoueurs() {
		System.out.println("AFFICHAGE DES JOUEURS  \n");
	}

	@Override
	public void piocherMain(String nom, int nbCarte) {
		System.out.println(nom + " pioche une main de " + nbCarte + " cartes \n");

	}

	@Override
	public void piocherCarte(String nom) {
		System.out.println(nom + " pioche une carte \n");
	}

	@Override
	public void jouerCarte(String nom, ZoneJeu zoneJeu) {
		System.out.println(nom + " joue une carte dans la zone " + zoneJeu + " \n");
	}

	@Override
	public void afficherTour(String nom) {
		System.out.println("C'est au tour de " + nom + " de jouer \n");
	}

	@Override
	public void afficherGagnant(String nom) {
		System.out.println(
				"Felicitation a " + nom + " il a gagne la partie ne soit pas jaloue tu gagnera la prochaine foi \n");
	}

	@Override
	public int choisirCarte(String nom, int nbMaxCarte) {
		int numCarte;
		do {
			System.out.println(nom + " tu veux jouer qu'elle carte ? \n");
			System.out.println("Entre un numero de carte pour jouer : ");
			numCarte = scanner.nextInt();
		} while (numCarte < 1 && numCarte > nbMaxCarte);
		return numCarte;
	}

	@Override
	public void afficherProblem() {
		System.out.println("Un probleme est survenue lors de la partie \n");
	}

	@Override
	public void afficherCarteSpecial(String titre, String description, int numCarte) {
		System.out.println("\t numero carte : " + numCarte + " \n \t titre : " + titre + "\n \t description : "
				+ description + " \n");
	}
}
