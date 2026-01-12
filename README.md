# API de Gestion de Personnel

Une API REST développée avec Spring Boot pour gérer les collaborateurs et les départements d'une organisation.

## 📋 Caractéristiques

- **Gestion des collaborateurs** : création, lecture, modification et suppression de collaborateurs
- **Gestion des départements** : consultations des départements et affiliation des collaborateurs
- **Statistiques** : génération de données pour visualisations graphiques (graphiques en camembert)
- **Génération de données** : création de données fictives pour test
- **Base de données H2** : base de données intégrée pour développement et test

## 🛠️ Technologies utilisées

- **Framework** : Spring Boot 4.0.1
- **Langage** : Java 21
- **Build** : Maven
- **Base de données** : H2 (base de données en mémoire)
- **ORM** : Spring Data JPA / Hibernate
- **API REST** : Spring Web MVC
- **DevTools** : Spring Boot DevTools (rechargement automatique)

## 📦 Structure du projet

```
collaborateurs/
├── src/
│   ├── main/
│   │   ├── java/com/iut/collaborateurs/
│   │   │   ├── CollaborateursApplication.java      # Point d'entrée
│   │   │   ├── controllers/                         # Contrôleurs REST
│   │   │   │   ├── CollaborateurController.java
│   │   │   │   └── DepartementsController.java
│   │   │   ├── entity/                              # Entités JPA
│   │   │   │   ├── Collaborateur.java
│   │   │   │   └── Departement.java
│   │   │   ├── repository/                          # Repositories
│   │   │   │   ├── CollaborateurRepository.java
│   │   │   │   └── DepartementRepository.java
│   │   │   ├── service/                             # Logique métier
│   │   │   │   ├── CollaborateurService.java
│   │   │   │   ├── DepartementService.java
│   │   │   │   ├── CollaborateurGeneratorService.java
│   │   │   │   ├── DataInitializerService.java
│   │   │   │   └── PiechartData.java
│   │   │   └── listener/                            # Listeners
│   │   │       └── DataInitializerListener.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/iut/collaborateurs/
│           └── CollaborateursApplicationTests.java
├── pom.xml
└── mvnw, mvnw.cmd
```

## 🚀 Démarrage rapide

### Prérequis

- Java 21 ou supérieur
- Maven 3.6+ ou utiliser le wrapper Maven (`mvnw`)

### Installation et exécution

1. **Cloner le repository** (ou accéder au dossier du projet)

   ```bash
   cd collaborateurs
   ```

2. **Compiler le projet**

   ```bash
   ./mvnw clean install
   ```

   ou sur Windows :

   ```bash
   mvnw.cmd clean install
   ```

3. **Lancer l'application**

   ```bash
   ./mvnw spring-boot:run
   ```

   ou sur Windows :

   ```bash
   mvnw.cmd spring-boot:run
   ```

4. **Accéder à l'application**
   - API REST : `http://localhost:8080`
   - Console H2 : `http://localhost:8080/h2`

## 📡 API Endpoints

### Collaborateurs

#### Récupérer tous les collaborateurs

```http
GET /api/collaborateurs
```

**Réponse** : Liste de tous les collaborateurs

#### Récupérer les statistiques par département (pour graphique)

```http
GET /api/collaborateurs/departement/piechart
```

**Réponse** : Données de statistiques formatées pour visualisation

#### Générer des données fictives

```http
POST /api/collaborateurs/generate/{nb}
```

**Paramètres** :

- `{nb}` : nombre de collaborateurs fictifs à générer

#### Modifier un collaborateur

```http
PUT /api/collaborateurs/{id}
```

**Body** : Collaborateur (JSON)

#### Supprimer un collaborateur

```http
DELETE /api/collaborateurs/delete/{id}
```

**Paramètres** :

- `{id}` : ID du collaborateur à supprimer

### Départements

#### Récupérer tous les départements

```http
GET /api/departements
```

**Réponse** : Liste de tous les départements

#### Récupérer un département par ID

```http
GET /api/departements/{id}
```

**Paramètres** :

- `{id}` : ID du département

## 📊 Modèles de données

### Collaborateur

```json
{
  "id": 1,
  "matricule": "MAT001",
  "nom": "Dupont",
  "prenom": "Jean",
  "adresse": "123 Rue de Paris",
  "emailPro": "jean.dupont@company.com",
  "numSecu": "123456789012345",
  "photo": "https://exemple.com/photo.jpg",
  "actif": true,
  "intitulePoste": "Développeur",
  "idDepartement": 1,
  "civilite": "M",
  "nomBanque": "BNP Paribas",
  "bic": "BNPAFRPP",
  "ban": "FR7612345678901234567890123"
}
```

### Département

```json
{
  "id": 1,
  "nom": "Informatique"
}
```

## ⚙️ Configuration

La configuration de l'application se trouve dans `src/main/resources/application.properties` :

```properties
spring.application.name=collaborateurs
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.generate-ddl=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2
```

## 🗄️ Base de données

L'application utilise **H2**, une base de données en mémoire pour le développement et les tests. Les tables sont créées automatiquement au démarrage de l'application.

### Accéder à la console H2

1. Lancer l'application
2. Accéder à : `http://localhost:8080/h2`
3. Configuration :
   - URL JDBC : `jdbc:h2:mem:testdb`
   - Utilisateur : `sa`
   - Mot de passe : (laisser vide)

## 🔄 Initialisation des données

Un `DataInitializerListener` initialise automatiquement la base de données au démarrage de l'application avec des données de test.

## 📝 Notes de développement

- **CORS activé** : Les endpoints acceptent les requêtes cross-origin pour faciliter l'intégration avec des frontends externes
- **Auto-génération des IDs** : Les IDs des collaborateurs et départements sont générés automatiquement
- **Validation des données** : À implémenter selon vos besoins

## 🧪 Tests

Pour exécuter les tests :

```bash
./mvnw test
```

Les tests unitaires se trouvent dans `src/test/java`.

## 📚 Références et ressources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [H2 Database](http://www.h2database.com/)

