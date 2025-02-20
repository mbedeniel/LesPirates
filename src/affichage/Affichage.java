package affichage;

import java.util.Scanner;

public class Affichage {
	
	private Scanner scanner = new Scanner(System.in);
	private static int NB_CARTE_MAIN = 4;
	private static int NB_JOUEUR_MAX = 2;
	
	public void afficherMessageAccueil() {
		System.out.println("Bienvenue \n");
	}
	
	public void raconterHistoire() {
		System.out.println("Jack le Borgne et Bill Jambe-de-Bois sont deux pirates souhaitant prendre le \n"
				+ "commandement du navire à l’etendard noir, « Le Sanguinaire ». L’equipage doit donc les \n"
				+ "departager par un vote. Chacun des deux rivaux doit ainsi gagner en popularite (ou \n"
				+ "affaiblir son adversaire) afin de devenir le nouveau capitaine. \n");
	}
	
	public void presenterJeux() {
		System.out.println( "Le Jeu des Pirates est un jeu de societe de cartes dans lequel deux joueurs \n"
				+ "s’affrontent. \n"
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
	
	public void afficherCarte(String carte[]) {
		System.out.println(" \t titre : "+carte[0]+"\n \t vie : "+carte[1]+"\n \t popularite : "+carte[2]+"\n \t description : "+carte[3]+" \n");
	}

	public void afficherCartes(String cartes[][]) {
		System.out.println("---------------------\n");
		System.out.println("AFFICHAGE DES CARTES : \n");
		for(int i=0;i<cartes.length;i++) {
			System.out.println(" \t numero carte : "+(i+1));
			afficherCarte(cartes[i]);
		}
		System.out.println("---------------------\n");
	}
	
	public void afficherJoueur(String joueur[]) {
		System.out.println(" \t nom : "+joueur[0]+"\n \t vie : "+joueur[1]+"\n \t popularite : "+joueur[2]+" \n");
	}
	
	public void afficherJoueurs(String joueurs[][]) {
		System.out.println("---------------------\n");
		System.out.println("AFFICHAGE DES JOUEURS : \n");
		for(int i=0;i<NB_JOUEUR_MAX;i++) {
			afficherJoueur(joueurs[i]);
		}
		System.out.println("---------------------\n");
	}
	
	public void piocherMain(String cartes[][],String nom) {
		System.out.println(nom + " pioche une main de "+NB_CARTE_MAIN+" cartes \n");
		String[] carte = new String[4];
		for(int i=0;i<NB_CARTE_MAIN;i++) {
			carte[0]=cartes[i][0];
			carte[1]=cartes[i][1];
			carte[2]=cartes[i][2];
			carte[3]=cartes[i][3];
			piocherCarte(carte,nom);
		}
		
	}
	
	public void piocherCarte(String carte[],String nom) {
		System.out.println(nom + " pioche une carte \n");
		afficherCarte(carte);
	}
	
	public void jouerCarte(String[] carte,String nom,Boolean zone) {
		String nomZone;
		switch(zone) {
		case true:
			nomZone = "ATTAQUE";
			break;
		case false:
			nomZone = "POPULARITE";
			break;
			
		}
		System.out.println(nom+" joue une carte dans la zone "+nomZone+" \n");
		afficherCarte(carte);
	}
	
	public void afficherTour(String nom) {
		System.out.println("C'est au tour de "+nom+" de jouer \n");
	}
	
	public void afficherGagnant(String nom) {
		System.out.println("Felicitation a "+nom+" il a gagne la partie \n");
	}
	
	/*Es ce que c'est a cette classe de recuperer le numéro de la carte a jouer ?*/
	/*Car j'ai pensé que ma methode pouvais recuperer le numero de la carte et la retourner*/
	public int choisirCarte(String nom) {
		int numCarte;
		do {
			System.out.println(nom +" tu veux jouer qu'elle carte ? \n");
			System.out.println("Entre un numero de carte parmi celle que tu as \n");
			numCarte = scanner.nextInt();
		}while(1 < numCarte && numCarte > 5);
		return numCarte;
	}
	
	public static void main(String[] args) {
		
		String[] carte0 = new String[4];
		carte0[0] = "ATTAQUE SURPRISE";
		carte0[1] = "1";
		carte0[2] = "0";
		carte0[3] = "retire 1 point de vie à l'adversaire";
		String[] carte1 = new String[4];
		carte1[0] = "ÉPÉE ARDENTE";
		carte1[1] = "2";
		carte1[2] = "0";
		carte1[3] = "retire 2 points de vie à l'adversaire";
		String[] carte2 = new String[4];
		carte2[0] = "COUP DE CROCHET";
		carte2[1] = "3";
		carte2[2] = "0";
		carte2[3] = "retire 3 points de vie à l'adversaire";
		String[] carte3 = new String[4];
		carte3[0] = "COUP DE BOUTEILLE";
		carte3[1] = "2";
		carte3[2] = "0";
		carte3[3] = "retire 2 points de vie à l'adversaire";
		String[] carte4 = new String[4];
		carte4[0] = "LANCER DE DAGUE";
		carte4[1] = "1";
		carte4[2] = "0";
		carte4[3] = "retire 1 point de vie à l'adversaire";
		String[] carte5 = new String[4];
		carte5[0] = "PROVOCATION BRUTALE";
		carte5[1] = "2";
		carte5[2] = "0";
		carte5[3] = "retire 2 points de vie à l'adversaire";
		String[] carte6 = new String[4];
		carte6[0] = "DÉFI SANGLANT";
		carte6[1] = "3";
		carte6[2] = "0";
		carte6[3] = "retire 3 points de vie à l'adversaire";

		String[] carte7 = new String[4];
		carte7[0] = "DISCOURS SINCÈRE";
		carte7[1] = "0";
		carte7[2] = "2";
		carte7[3] = "ajoute 2 points de popularité à l'utilisateur";
		String[] carte8 = new String[4];
		carte8[0] = "DISCOURS BRUTAL";
		carte8[1] = "-1";
		carte8[2] = "3";
		carte8[3] = "ajoute 3 points de popularité à l'utilisateur mais lui retire 1 point de vie";
		String[] carte9 = new String[4];
		carte9[0] = "CHANT DE PIRATE";
		carte9[1] = "0";
		carte9[2] = "2";
		carte9[3] = "ajoute 2 points de popularité à l'utilisateur";
		String[] carte10 = new String[4];
		carte10[0] = "TRAHISON MALICIEUSE";
		carte10[1] = "-2";
		carte10[2] = "4";
		carte10[3] = "ajoute 4 points de popularité à l'utilisateur mais lui retire 2 points de vie";
		String[] carte11 = new String[4];
		carte11[0] = "SERMENT DE FRATERNITE";
		carte11[1] = "0";
		carte11[2] = "3";
		carte11[3] = "ajoute 3 points de popularité à l'utilisateur";
		String[] carte12 = new String[4];
		carte12[0] = "DISCOURS ENFLAMMÉ";
		carte12[1] = "0";
		carte12[2] = "2";
		carte12[3] = "ajoute 2 points de popularité à l'utilisateur";
	
		String[][] data = {
		    {"ATTAQUE SURPRISE", "1", "0", "retire 1 point de vie à l'adversaire"},
		    {"ÉPÉE ARDENTE", "2", "0", "retire 2 points de vie à l'adversaire"},
		    {"COUP DE CROCHET", "3", "0", "retire 3 points de vie à l'adversaire"},
		    {"COUP DE BOUTEILLE", "2", "0", "retire 2 points de vie à l'adversaire"},
		    {"LANCER DE DAGUE", "1", "0", "retire 1 point de vie à l'adversaire"},
		    {"PROVOCATION BRUTALE", "2", "0", "retire 2 points de vie à l'adversaire"},
		    {"DÉFI SANGLANT", "3", "0", "retire 3 points de vie à l'adversaire"},
		    {"DISCOURS SINCERE", "0", "2", "ajoute 2 points de popularité à l'utilisateur"},
		    {"DISCOURS BRUTAL", "-1", "3", "ajoute 3 points de popularité à l'utilisateur mais lui retire 1 point de vie"},
		    {"CHANT DE PIRATE", "0", "2", "ajoute 2 points de popularité à l'utilisateur"},
		    {"TRAHISON MALICIEUSE", "-2", "4", "ajoute 4 points de popularité à l'utilisateur mais lui retire 2 points de vie"},
		    {"SERMENT DE FRATERNITE", "0", "3", "ajoute 3 points de popularité à l'utilisateur"},
		    {"DISCOURS ENFLAMME", "0", "2", "ajoute 2 points de popularité à l'utilisateur"}
		};
		int lengthCartes =  data.length;
		String[][] cartes = new String[lengthCartes][4];
		for (int i = 0; i < lengthCartes; i++) {
		    for (int j = 0; j < NB_CARTE_MAIN; j++) {
		        cartes[i][j] = data[i][j];
		    }
		}
		
		String[][] cartes1 = new String[NB_CARTE_MAIN][4];
		String[][] cartes2 = new String[NB_CARTE_MAIN][4];
		for(int i=0;i<NB_CARTE_MAIN;i++) {
			for(int j=0;j<4;j++) {
				cartes1[i][j]=cartes[i][j];
				cartes2[i][j]=cartes[lengthCartes-1-i][j];
			}
		}
		
		String nomJoueur1="Jack le Borgne";
		String nomJoueur2="Bill Jambe-de-Bois";
		
		String[] joueur1 = new String[3];
		joueur1[0]=nomJoueur1;
		joueur1[1]="5";
		joueur1[2]="0";
		String[] joueur2 = new String[3];
		joueur2[0]=nomJoueur2;
		joueur2[1]="5";
		joueur2[2]="0";
		String[][] joueurs = {joueur1,joueur2};
		String[][][] mainCartes = {cartes1,cartes2};
		int choixCarte;
		
		Affichage affichage =  new Affichage();
		affichage.afficherMessageAccueil();
		affichage.raconterHistoire();
		affichage.presenterJeux();
		affichage.afficherJoueurs(joueurs);
		for(int i=0;i<2;i++) {
			affichage.piocherMain(mainCartes[i],joueurs[i][0]);
		}
		for(int i=0;i<2;i++) {
			affichage.afficherTour(joueurs[i][0]);
			affichage.piocherCarte(carte12,joueurs[i][0]);
			affichage.afficherCartes(cartes1);
			choixCarte = affichage.choisirCarte(joueurs[i][0]);
			affichage.jouerCarte(carte12,joueurs[i][0],true);
			affichage.afficherJoueurs(joueurs);
		}
		affichage.afficherGagnant(nomJoueur2);
	}
	/*Les parametres d'ntres sont de types primitifs, tableaux, enum, String*/
}
