Inventory Manager API

Inventory Manager API est une application backend construite avec Java Spring Boot, permettant de gérer les produits, fournisseurs et mouvements de stock dans un environnement de gestion d'inventaire.

Technologies

Java 17

Spring Boot

Spring Web

Spring Validation

Lombok

JPA + Hibernate

H2 Database (modifiable)

Postman (pour les tests API)

Fonctionnalités

Produits

Créer un produit

Récupérer tous les produits

Récupérer un produit par ID

Supprimer un produit

Fournisseurs

Ajouter un fournisseur

Lister tous les fournisseurs

Récupérer un fournisseur par ID

Supprimer un fournisseur

Mouvements de stock

Ajouter un mouvement IN ou OUT

Valider la logique de stock

Historique des mouvements

Suppression d'un mouvement

Lancer le projet

# cloner le repo
git clone https://github.com/raphMei/inventory-manager-api.git

# ouvrir dans votre IDE
# lancer la classe InventorymanagerApplication.java

Endpoints principaux

    Produits

POST /api/product
GET /api/product
GET /api/product/{id}
DELETE /api/product/{id}

    Fournisseurs

POST /api/supplier
GET /api/supplier
GET /api/supplier/{id}
DELETE /api/supplier/{id}

    Mouvements de stock

POST /api/stock_movement
GET /api/stock_movement
GET /api/stock_movement/{id}
DELETE /api/stock_movement/{id}

    Tests API

Une collection Postman est disponible :

inventorymanager-tests.postman_collection.json

Importez-la dans Postman pour tester tous les endpoints.

    Améliorations possibles

Ajouter une authentification JWT

Ajouter un front (Thymeleaf ou React)

Export PDF/CSV des mouvements

Notifications de seuils bas de stock

    Auteur

raphMei

Projet réalisé dans un objectif d'entraînement Back-End Java Spring Boot

N'hésitez pas à fork ou étoiler le repo si vous avez trouvé ce projet utile ! 

