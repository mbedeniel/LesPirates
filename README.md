# LesPirates

## Introduction

LesPirates est un jeu de société sur le thème des pirates développé en Java. Dans ce jeu, deux pirates s'affrontent pour prendre le commandement du navire "Le Sanguinaire". Chaque joueur devra, par le biais de cartes, accumuler des points de popularité ou infliger des dégâts (points de vie) à son adversaire. Le premier pirate à atteindre 5 points de popularité ou celui qui survit le plus longtemps remporte la partie.

*Note : Ce projet est une version console.*

## Fonctionnalités

- **Phase 1 : Cartes de Popularité**  
  Implémentation initiale avec uniquement des cartes de popularité.
- **Phase 2 : Cartes d’Attaque**  
  Extension du jeu avec des cartes d’attaque pour affecter les points de vie de l’adversaire.
- **Phase 3 : Cartes Spéciales**  
  Ajout de cartes de défense, de sabotage, etc., pour enrichir le gameplay.

*Les règles détaillées et l’ensemble des fonctionnalités sont décrites dans le document de préparation du projet.*

## Architecture et Conception

Le projet est développé en suivant les principes de la programmation orientée objet, avec une séparation nette entre la logique métier et l’affichage :

- **Modélisation** :  
  - Utilisation de l’héritage, d’interfaces, de classes abstraites et d’énumérations pour modéliser les entités du jeu.
- **Diagrammes UML** :  
  - **Diagramme de classes** : Décrit la structure du système (modèles et relations).  
  - **Diagrammes de séquence** : Diagramme système et diagrammes détaillés pour certaines interactions.  
  *[Espace réservé pour les diagrammes UML à venir]*

## Technologies et Outils

- **Langage** : Java
- **Environnement de développement** : Eclipse
- **Linter/Qualité de code** : SonarQube

## Installation et Exécution

1. **Importation du projet**  
   - Importez le projet dans Eclipse en utilisant l’option "Import Existing Projects into Workspace".
2. **Compilation**  
   - Assurez-vous que Java est correctement installé sur votre machine.
   - Le projet se compile via Eclipse.
3. **Exécution**  
   - La méthode `main` se trouve dans la classe `Jeu`.
   - Exécutez la classe `Jeu` pour lancer l’application en mode console.

## Organisation du Code

Le code est organisé de manière à séparer clairement la logique métier (modèles) de la gestion de l’affichage :
- **Modèle** : Contient la logique du jeu (gestion des cartes, points de vie, popularité, etc.).
- **Affichage** : Gère l’interaction avec l’utilisateur en mode console.

## Contact

- **GitHub** : [mbedeniel](https://github.com/mbedeniel/)
- **LinkedIn** : [Niel Mbede](https://www.linkedin.com/in/niel-mbede/)

---

*Ce projet est réalisé dans le cadre du cours de Programmation Orientée Objet.*
