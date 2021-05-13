Ci-dessous une reformulation simplifiée du besoin et une traduction des consignes de l'exercice sous formes de fonctionnalités à implémenter :

Reformulation du besoin tel que compris :

On veut être capable d'afficher une main de 10 cartes soit dans un ordre aléatoire, soit triées par couleur et valeur (dans cet ordre !).
Par exemple, on veut pouvoir générer et afficher la main suivante (♦️=carreau, ♥️=coeur, ♠️=pique, ♣️=trèfle) :
* ordre aléatoire :
	As♦️, 5♦️, 10♠️, 8♣️, 6♥️, 5♣️, 3♠️, 9♥️, Roi♣️, Dame♠️
* triée par couleur et valeur :
	As♦️, 5♦️, 6♥️, 9♥️, 3♠️, 10♠️, Dame♠️, 5♣️, 8♣️, Roi♣️
Les ordres retenus sont donc ♦️, ♥️, ♠️, ♣️ pour les couleurs, et As, 2, 3, 4, 5, 6, 7, 8, 9, 10, Valet, Dame, Roi (i.e. l'ordre classique pour un jeu de cartes)

Fonctionnalités à implémenter pour répondre à ce besoin :

1. Backend

- méthode pour choisir aléatoirement 10 cartes parmi un jeu de cartes standard (on suppose qu'il n'y a qu'un seul jeu et qu'on a donc forcément 10 cartes différentes)
- exposer un endpoint GET pour renvoyer une main de 10 cartes (sous forme de (liste JSON) en utilisant la méthode précédente

2. Frontend :

- afficher sur une page une liste de 10 cartes (format textuel au début)
- afficher un bouton permettant de trier la liste (et la ré-afficher) par couleur + valeur
