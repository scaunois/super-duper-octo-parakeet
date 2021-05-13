### super-duper-octo-parakeet
### Test technique Atexo - Afficher et trier une main de cartes à jouer

___

**RAPPEL DES CONSIGNES :**

On souhaite développer un jeu de cartes.
Dans ce jeu, un joueur tire une main de 10 cartes de manière aléatoire.
Chaque carte possède une couleur ("Carreaux", par exemple) et une valeur ("10", par exemple).
On vous demande de:

Construire un ordre aléatoire des couleurs. L'ordre des couleurs est, par exemple, l'un des suivants :
--> Carreaux, Coeur, Pique, Trèfle

Construire un ordre aléatoire des valeurs. L'ordre des valeurs est, par exemple, l'un des suivants :
--> AS, 5, 10, 8, 6, 5, 7, 4, 2, 3, 9, Dame, Roi, Valet

Construire une main de 10 cartes de manière aléatoire.
Présenter la main "non triée" à l'écran puis la main triée selon n'importe quel ordre défini dans la 1ère et 2ème étape. C'est-à-dire que vous devez classer les cartes par couleur et valeur.
Vous présenterez une solution qui tourne sur le langage Java/Spring.
Vous pouvez utiliser un serveur d'application pour présenter la main de l'utilisateur (une interface graphique est la bienvenue), ou simplement la sortie console.

___

**Remarque préalable sur la langue utilisée :**

L'anglais sera utilisé dans le code (et les commentaires) mais le français sera utilisé pour le reste de la communication (messages de commits, explications des choix,...)

___

**STRATEGIE (INITIALE) :**
1. Exprimer le besoin sous forme de fonctionnalités à fournir par un backend (création d'une main de cartes) / frontend (affichage de la main et déclenchement d'un tri)
2. Coder un **web-service Java (avec Spring Boot)** exposant un endpoint pour renvoyer une main de cartes
3. Coder un **frontend (Angular)** affichant une simple page permettant de demander une nouvelle main au backend, et un bouton pour la trier (le tri se fera a priori côté frontend car on ne souhaite pas implémenter de mécanisme de stockage de la main donc on ne peut pas demander une main au backend puis appeler un autre endpoint qui renverrait la même main mais triée)
4. Fournir une **mini documentation technique** de l'application (comment la lancer et comment l'utiliser)

Dans l'optique d'un backend minimaliste, avec un unique endpoint qui renverrait à chaque requête une main aléatoirement triée de 10 cartes, essayer de suivre **l'approche TDD** et rédiger avant d'implémenter ledit endpoint les tests unitaires qui permettront de valider le comportement **avant de commencer à coder le frontend**
Il ne sera pas prévu de tests frontend a priori, des tests visuels de l'application suffiront à vérifier/montrer que l'application répond bien aux consignes.

_Cette stratégie est bien sûr susceptible d'évoluer au fur et à mesure, notamment en fonction des contraintes de temps..._
Le fichier "Etat_des_lieux.md" devrait permettre, en suivant ses modifications grâce à l'historique des commits, de suivre l'évolution de la compréhension du pb, l'avancement du développement, les différentes techniques/stratégies essayées, etc.

___

**ETAPES DE DEVELOPPEMENT :**

Chaque avancée majeure du projet sera isolée dans un commit clairement annoté afin de pouvoir voir la construction progressive d'une application fonctionnelle.
