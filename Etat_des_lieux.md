## Etat des lieux (ce fichier a pour but de décrire l'état d'avancement du projet)

# Etat des lieux 1

1. Besoin redéfini sous forme de fonctionnalités à implémenter
2. Répertoire créé pour la partie backend, initialisée à l'aide de Spring Initializer (génération d'un projet Spring Web avec qques dépendances utiles), sans aucune fonctionnalité pour le moment
3. TODO : créer l'arborescence souhaitée pour une API REST, créer les modèles nécessaires (carte), et exposer un endpoint permettant de récupérer une liste de 10 cartes. Des tests devront être rédigés au préalable, couvrant les cas d'utilisation prévus; l'approche TDD permet justment de bien se poser à l'avance la question des use case à prévoir !.

___


# Etat des lieux 2

Le projet contient un répertoire pour la partie backend (un répertoire distinct contiendra plus tard la partie frontend).
Une application backend fonctionnelle a été générée grâce à Spring Initializr. On a le squelette d'une application web MVC (outil de build : Gradle), avec qques dépendances utiles (Apache Commons, Lombok, JUnit,...). Spring Boot Admin a également été ajouté. Il ne sera peut-être pas utilisé, mais si on a besoin de monitorer l'application, cette dépendance sera déjà présente.
Ont également été créés (sans l'implémentation finale qui permettra réellement au frontend d'appeler ce backend) :
* Les modèles nécessaires pour représenter une carte (carte, couleur, valeur)
* Un controller @RestController, avec un endpoint GET permettant de renvoyer une liste JSON de cartes à jouer (on peut passer un nombre de cartes souhaité en paramètre)
* Un service proposant pour le moment une unique méthode getRandomHand pour renvoyer une liste de cartes
L'application se lance et un serveur embarqué Tomcat démarre et est prêt à recevoir les requêtes (application marquée comme "UP" par le monitoring Spring Boot Admin).

La méthode getRandomHand() ne fait rien pour l'instant, sauf lever une Exception. L'implémentation va être faite dans le prochain jalon. Des tests unitaires ont été écrits afin de tester le comportement attendu pour cette fonction, à savoir :
* On doit obtenir le nombre de cartes demandé
* Les cartes obtenues dans une main doivent toutes être différentes
* Si on ne spécifie pas de paramètre pour la fonction, on doit obtenir une main de 10 cartes par défaut (ce nombre est défini dans une constante facilmeent changeable)
* Si on spécifie un paramètre invalide (< 0 ou > au nombre de cartes dans un paquet, par ex. 52 dans notre cas), la méthode doit lever une IllegalArgumentException

Aucun test du controller n'a été réalisé. Cela pourrait être fait, mais pour respecter les contraintes de temps, on se concentre sur le "coeur du métier", à savoir la méthode permettant de récupérer une main aléatoire de 10 cartes.
Comme aucun test frontend n'est prévu (pour des raisons de temps et de connaissances en frameworks de tests frontend), on placera peut-être la fonction de tri côté backend afin de la tester avec JUnit, même si dans l'idée originale, il était plutôt envisager de faire le tri côté frontend, une fois la main récupérée depuis le serveur.

___

# Etat des lieux 3

La méthode getRandomHand() est maintenant implémentée. Les TU passent tous (la couleur verte est bien agréable à l'oeil !).
Le controller a été testé via Postman afin de vérifier qu'il renvoyait bien une liste JSON de cartes, correspondant à la taille de main passée en paramètre (@RequestParam).
Une gestion des erreurs a été rajoutée au niveau du endpoint via la classe ResponseStatusException de Spring, afin d'afficher le code HTTP et le message d'erreur adéquats.

___

# Nice to have

Partie à compléter (éventuellement) à la fin du projet avec des idées d'améliorations, si elles surgissent ! On pourra y lister des fonctionnalités supplémentaires, des tests à rajouter pour améliorer la couverture du code si jugée trop faible, des idées de refactorisation si nécessaire mais non fait par manque de temps...
* PITest (https://pitest.org/) : utile pour faire des tests de mutation et améliorer la pertinence des TU, non ajouté pour le moment, mais utile pour s'assurer que les TU testent réellement le fonctionnement du code, et non simplement sa "couverture", i.e. "passent dans toutes les branches du code", mais ne vérifient pas que le comportement est correct.