# 🏴‍☠️ LesPirates

## 🌟 Introduction

LesPirates est un jeu de société sur le thème des pirates développé en Java. Dans ce jeu, deux pirates s'affrontent pour prendre le commandement du navire **"Le Sanguinaire"**. Chaque joueur devra, par le biais de cartes, accumuler des points de popularité ou infliger des dégâts (points de vie) à son adversaire. Le premier pirate à atteindre 5 points de popularité ou celui qui survit le plus longtemps remporte la partie.

## ⚙️ Fonctionnalités

- **Phase 1 : Cartes de Popularité**  
  Implémentation initiale avec uniquement des cartes de popularité.
- **Phase 2 : Cartes d’Attaque**  
  Extension du jeu avec des cartes d’attaque pour affecter les points de vie de l’adversaire.
- **Phase 3 : Cartes Spéciales**  
  Ajout de cartes de défense, de sabotage, etc., pour enrichir le gameplay.

### 🏆 Cartes Spéciales

- **Carte Soin** : Augmente la vie du joueur qui la joue.
- **Carte Diffamation** : Diminue les points de popularité de l’adversaire.
- **Carte Finale** : Fait gagner automatiquement celui qui la joue.
- **Carte Permutation** : Permet à un joueur d'échanger une de ses cartes avec une carte de son adversaire.

## 🏰 Architecture et Conception

Le projet est développé en suivant les principes de la programmation orientée objet, avec une séparation nette entre la logique métier et l’affichage :

- **Modélisation** :  
  - Utilisation de l’héritage, d’interfaces, de classes abstraites et d’énumérations pour modéliser les entités du jeu.
- **Diagrammes UML** :  
  - [**Diagramme de classes**](https://www.edrawmax.com/online/share.html?code=f9d171c806fc11f0bd090a54be41f961) : Décrit la structure du système (modèles et relations).
  - [**Diagramme de séquence système**](https://www.edrawmax.com/online/share.html?code=66a4f2bc086911f0a9690a54be41f961) : Montre les interactions à haut niveau.
  - [**Diagramme de séquence détaillé - Carte Soin**](https://www.edrawmax.com/online/share.html?code=70a4f5b205fa11f08cf40a951ba8b83d)
  - [**Diagramme de séquence détaillé - Carte Permutation**](https://www.edrawmax.com/online/share.html?code=ce081a5606fc11f082130a951ba8b83d)
  - [**Référence afficherJoueurs**](https://www.edrawmax.com/online/share.html?code=60cad906086911f0aced0a54be41f961)
  
  Des informations détaillées sur ces diagrammes UML sont disponibles dans le dossier **UML**.

## 💻 Technologies et Outils

- **Langage** : Java
- **Environnement de développement** : Eclipse
- **Linter/Qualité de code** : SonarQube

## 🚀 Installation et Exécution

1. **Importation du projet**  
   - Importez le projet dans Eclipse en utilisant l’option "Import Existing Projects into Workspace".
2. **Compilation**  
   - Assurez-vous que Java est correctement installé sur votre machine.
   - Le projet se compile via Eclipse.
3. **Exécution**  
   - La méthode `main` se trouve dans la classe `Jeu`.
   - Exécutez la classe `Jeu` pour lancer l’application en mode console.

## 🗂️ Organisation du Code

Le code est organisé de manière à séparer clairement la logique métier (modèles) de la gestion de l’affichage :
- **Modèle** : Contient la logique du jeu (gestion des cartes, points de vie, popularité, etc.).
- **Affichage** : Gère l’interaction avec l’utilisateur en mode console et affiche des effets graphiques en ASCII.

## 🎮 Exemple de Partie

─── [ Tour 1 ] ───
🏴‍☠️ **Jack le Borgne** joue sa carte **Discours Inspirant**  
➡️ Effet : **+1 Popularité**  
🌟 Animation : *Jack galvanise l’équipage avec un discours passionné !*

...

─── [ Tour 5 ] ───
🏴‍☠️ **Bill Jambe-de-Bois** joue sa carte **Carte Permutation**  
➡️ Effet : **Échange une carte avec Jack**  
🌟 Animation : *Les cartes sont discrètement échangées sous le regard des matelots !*

...

─── [ Tour 8 ] ───
🏴‍☠️ **Jack le Borgne** joue sa carte **Carte Finale**  
➡️ Effet : **Victoire Immédiate**  
🌟 Animation : *Jack s’empare du gouvernail sous un tonnerre d’acclamations !*

🏆 **Jack le Borgne remporte la partie !**

## 👨‍💼 Contact

- **Développeur** : [Niel Mbede](https://github.com/mbedeniel/)
- **LinkedIn** : [Niel Mbede](https://www.linkedin.com/in/niel-mbede/)

