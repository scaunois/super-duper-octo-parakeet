# Prérequis pour exécuter l'application
- JDK Java 11
- Angular 12

# Lancer l'application en local
* Se placer dans le répertoire sdop-backend et exécuter :
	* './gradlwew build' pour générer le jar exécutable du backend
	* 'java -jar build/libs/sdop-backend-0.0.1-SNAPSHOT.jar' pour démarrer le serveur d'application (si les logs affichent un message "Started SdopBackendApplication in XXX seconds", ça veut dire que l'application a correctement démarré)
	* Vérifier sur un navigateur l'URL "http://localhost:8080/actuator/health", qui doit afficher {"status":"UP"}
* Se placer dans le répertoire sdop-frontend et exécuter :
	* 'npm install' pour télécharger toutes les dépendances nécessaires, notamment les dépendances Angular
	* 'ng serve' pour démarrer l'application frontend, exposée sur le port 4200 par défaut ('ng serve --port=XXXX' pour utiliser un autre port)
	* Vérifier sur un navigateur que l'application est bien accessible à l'URL "http://localhost:4200" : on devrait y voir une page n'affichant pour le moment aucune main, et proposant un bouton pour distribuer une nouvelle main


# Utilisation de l'application
* Cliquer sur le bouton "Distribuer" afin de demander au backend une nouvelle main aléatoire de N cartes. Par défaut N = 10, mais on peut renseigner un nombre différent (compris entre 0 et 52) pour avoir une main de la taille désirée.
* Une fois une main affichée à l'écran, on peut la trier en cliquant sur le bouton "Trier" : le tri se fait par couleur (Carreau, Coeur, Pique, Trèfle) puis, au sein de chaque couleur, par ordre croissant de valeur (As, 2,..., 10, Valet, Dame, Roi).
* Si le backend échoue (si on demande une taille invalide, ou si une erreur inattendue se produit), un message d'erreur est affiché à l'utilisateur.
