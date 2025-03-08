package affichage;

import java.util.Scanner;

import model.Jeu;

public class Affichage implements IAffichage {

	private Scanner scanner = new Scanner(System.in);

	@Override
	public void souhaiterBienvenue() {
		System.out.println("Bienvenue \n");
	}

	@Override
	public void raconterHistoire() {
		System.out.println("Jack le Borgne et Bill Jambe-de-Bois sont deux pirates souhaitant prendre le \n"
				+ "commandement du navire à l’etendard noir, « Le Sanguinaire ». L’equipage doit donc les \n"
				+ "departager par un vote. Chacun des deux rivaux doit ainsi gagner en popularite (ou \n"
				+ "affaiblir son adversaire) afin de devenir le nouveau capitaine. \n");
	}

	@Override
	public void presenterJeux() {
		System.out.println(
				"Le Jeu des Pirates est un jeu de societe de cartes dans lequel deux joueurs \n" + "s’affrontent. \n"
						+ "-Chaque joueur pioche quatre cartes. A tour de role, un pirate pioche une nouvelle \n"
						+ "carte et l’ajoute à sa main. Il doit ensuite decider s’il attaque son adversaire ou s’il \n"
						+ "s’attribue des points de popularite. \n"
						+ "-Chaque pirate possede cinq cœurs rouges correspondant a ses points de vie. S’il n’a \n"
						+ "plus de coeur, alors il a perdu et son adversaire gagne. \n"
						+ "-Le but du jeu est que son pirate atteigne cinq points de popularite ou simplement \n"
						+ "survive plus longtemps que son adversaire ! \n"
						+ "-Au debut de son tour, le pirate pioche une carte et l’ajoute à sa main. \n"
						+ "Il choisit ensuite parmi sa main, composee de cinq cartes, une carte qu’il depose : \n"
						+ "\t -Dans sa zone de popularite s’il s’agit d’une carte de popularite, \n"
						+ "\t -Dans la zone de son adversaire s’il s’agit d’une carte d’attaque. \n");
	}

	@Override
	public void afficherCarte(String titre, String description, String effet, int numCarte) {
		System.out.println("\t numero carte : " + numCarte + " \n \t titre : " + titre + "\n \t effet : " + effet
				+ "\n \t description : " + description + " \n");
	}

	@Override
	public void afficherJoueur(String nom, String vie, String popularite) {
		System.out.println(" \t nom : " + nom + "\n \t vie : " + vie + "\n \t popularite : " + popularite + " \n");
	}

	@Override
	public void piocherMain(String nom) {
		System.out.println(nom + " pioche une main de " + Jeu.getTailleMain() + " cartes \n");

	}

	@Override
	public void piocherCarte(String nom) {
		System.out.println(nom + " pioche une carte \n");
	}

	@Override
	public void jouerCarte(String nom, ZoneJeu zoneJeu) {
		System.out.println(nom + " joue une carte dans la zone " + zoneJeu.toString() + " \n");
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
	public int choisirCarte(String nom) {
		int numCarte;
		do {
			System.out.println(nom + " tu veux jouer qu'elle carte ? \n");
			System.out.println("Entre un numero de carte pour jouer : ");
			numCarte = scanner.nextInt();
		} while (numCarte < 1 && numCarte > Jeu.getTailleMain() + 1);
		return numCarte;
	}

	@Override
	public void afficherProblem() {
		System.out.println("Un probleme est survenue lors de la partie \n");
	}

//	public static void main(String[] args) {
//
//		String[] carte0 = new String[4];
//		carte0[0] = "ATTAQUE SURPRISE";
//		carte0[1] = "1";
//		carte0[2] = "0";
//		carte0[3] = "retire 1 point de vie a l'adversaire";
//		String[] carte1 = new String[4];
//		carte1[0] = "EPEE ARDENTE";
//		carte1[1] = "2";
//		carte1[2] = "0";
//		carte1[3] = "retire 2 points de vie a l'adversaire";
//		String[] carte2 = new String[4];
//		carte2[0] = "COUP DE CROCHET";
//		carte2[1] = "3";
//		carte2[2] = "0";
//		carte2[3] = "retire 3 points de vie a l'adversaire";
//		String[] carte3 = new String[4];
//		carte3[0] = "COUP DE BOUTEILLE";
//		carte3[1] = "2";
//		carte3[2] = "0";
//		carte3[3] = "retire 2 points de vie a l'adversaire";
//		String[] carte4 = new String[4];
//		carte4[0] = "LANCER DE DAGUE";
//		carte4[1] = "1";
//		carte4[2] = "0";
//		carte4[3] = "retire 1 point de vie a l'adversaire";
//		String[] carte5 = new String[4];
//		carte5[0] = "PROVOCATION BRUTALE";
//		carte5[1] = "2";
//		carte5[2] = "0";
//		carte5[3] = "retire 2 points de vie a l'adversaire";
//		String[] carte6 = new String[4];
//		carte6[0] = "DEFI SANGLANT";
//		carte6[1] = "3";
//		carte6[2] = "0";
//		carte6[3] = "retire 3 points de vie a l'adversaire";
//
//		String[] carte7 = new String[4];
//		carte7[0] = "DISCOURS SINCERE";
//		carte7[1] = "0";
//		carte7[2] = "2";
//		carte7[3] = "ajoute 2 points de popularite a l'utilisateur";
//		String[] carte8 = new String[4];
//		carte8[0] = "DISCOURS BRUTAL";
//		carte8[1] = "-1";
//		carte8[2] = "3";
//		carte8[3] = "ajoute 3 points de popularite a l'utilisateur mais lui retire 1 point de vie";
//		String[] carte9 = new String[4];
//		carte9[0] = "CHANT DE PIRATE";
//		carte9[1] = "0";
//		carte9[2] = "2";
//		carte9[3] = "ajoute 2 points de popularite a l'utilisateur";
//		String[] carte10 = new String[4];
//		carte10[0] = "TRAHISON MALICIEUSE";
//		carte10[1] = "-2";
//		carte10[2] = "4";
//		carte10[3] = "ajoute 4 points de popularite a l'utilisateur mais lui retire 2 points de vie";
//		String[] carte11 = new String[4];
//		carte11[0] = "SERMENT DE FRATERNITE";
//		carte11[1] = "0";
//		carte11[2] = "3";
//		carte11[3] = "ajoute 3 points de popularite a l'utilisateur";
//		String[] carte12 = new String[4];
//		carte12[0] = "DISCOURS ENFLAMME";
//		carte12[1] = "0";
//		carte12[2] = "2";
//		carte12[3] = "ajoute 2 points de popularite a l'utilisateur";
//
//		String[][] data = { { "ATTAQUE SURPRISE", "1", "0", "retire 1 point de vie a l'adversaire" },
//				{ "ÉPEE ARDENTE", "2", "0", "retire 2 points de vie a l'adversaire" },
//				{ "COUP DE CROCHET", "3", "0", "retire 3 points de vie a l'adversaire" },
//				{ "COUP DE BOUTEILLE", "2", "0", "retire 2 points de vie a l'adversaire" },
//				{ "LANCER DE DAGUE", "1", "0", "retire 1 point de vie a l'adversaire" },
//				{ "PROVOCATION BRUTALE", "2", "0", "retire 2 points de vie a l'adversaire" },
//				{ "DEFI SANGLANT", "3", "0", "retire 3 points de vie a l'adversaire" },
//				{ "DISCOURS SINCERE", "0", "2", "ajoute 2 points de popularite a l'utilisateur" },
//				{ "DISCOURS BRUTAL", "-1", "3",
//						"ajoute 3 points de popularite a l'utilisateur mais lui retire 1 point de vie" },
//				{ "CHANT DE PIRATE", "0", "2", "ajoute 2 points de popularite a l'utilisateur" },
//				{ "TRAHISON MALICIEUSE", "-2", "4",
//						"ajoute 4 points de popularite a l'utilisateur mais lui retire 2 points de vie" },
//				{ "SERMENT DE FRATERNITE", "0", "3", "ajoute 3 points de popularite a l'utilisateur" },
//				{ "DISCOURS ENFLAMME", "0", "2", "ajoute 2 points de popularite a l'utilisateur" } };
//		int lengthCartes = data.length;
//		String[][] cartes = new String[lengthCartes][4];
//		for (int i = 0; i < lengthCartes; i++) {
//			for (int j = 0; j < Jeu.getTailleMain(); j++) {
//				cartes[i][j] = data[i][j];
//			}
//		}
//
//		String[][] cartes1 = new String[Jeu.getTailleMain()][4];
//		String[][] cartes2 = new String[Jeu.getTailleMain()][4];
//		for (int i = 0; i < Jeu.getTailleMain(); i++) {
//			for (int j = 0; j < 4; j++) {
//				cartes1[i][j] = cartes[i][j];
//				cartes2[i][j] = cartes[lengthCartes - 1 - i][j];
//			}
//		}
//
//		String nomJoueur1 = "Jack le Borgne";
//		String nomJoueur2 = "Bill Jambe-de-Bois";
//
//		String[] joueur1 = new String[3];
//		joueur1[0] = nomJoueur1;
//		joueur1[1] = "5";
//		joueur1[2] = "0";
//		String[] joueur2 = new String[3];
//		joueur2[0] = nomJoueur2;
//		joueur2[1] = "5";
//		joueur2[2] = "0";
//		String[][] joueurs = { joueur1, joueur2 };
//		String[][][] mainCartes = { cartes1, cartes2 };
//		int choixCarte;
//
//		IAffichage affichage = new Affichage();
//		affichage.souhaiterBienvenue();
//		affichage.raconterHistoire();
//		affichage.presenterJeux();
//		affichage.afficherJoueurs(joueurs);
//		for (int i = 0; i < 2; i++) {
//			affichage.piocherMain(mainCartes[i], joueurs[i][0]);
//		}
//		boolean avoirGagne = false;
//		do {
//			for (int i = 0; i < 2; i++) {
//				affichage.afficherTour(joueurs[i][0]);
//				affichage.piocherCarte(carte12, joueurs[i][0]);
//				affichage.afficherCartes(mainCartes[i]);
//				choixCarte = affichage.choisirCarte(joueurs[i][0]);
//				affichage.jouerCarte(mainCartes[i][choixCarte - 1], joueurs[i][0], ZoneJeu.ATTAQUE);
//				affichage.afficherJoueurs(joueurs);
//			}
//			avoirGagne = true;
//		} while (!avoirGagne);
//		affichage.afficherGagnant(nomJoueur2);
//	}
	/* Les parametres d'ntres sont de types primitifs, tableaux, enum, String */
}
