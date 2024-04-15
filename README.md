# Installation
```shell
mvnw jetty:run-war -DskipTests
```
A chaque démarrage de l'application, la base de données est réinitialisée. Pour désactiver cette fonctionnalité, il suffit de commenter la ligne 9 du fichier `src/main/resources/application.properties`:
```properties
hibernate.hbm2ddl.auto=create
```

#   s p r i n g - w e a t h e r - a p i  
 #   s p r i n g - m v c - w e a t h e r - b a c k e n d  
 