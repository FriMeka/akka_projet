
# Akka Project

## Instructions pour lancer le serveur

1. **Assurez-vous que SBT est installé** sur votre système.

2. **Pour le lancer**, dans le dossier du projet exécutez les commandes suivantes :

    ```bash
    sbt clean
    sbt update
    sbt compile
    sbt run
    ```

## Bug remarqué

- **Erreur 404 Tomcat** : Si vous rencontrez une erreur 404 mentionnant Tomcat lorsque vous accédez à `http://localhost:8080/`, cela signifie que Tomcat utilise le même port que votre serveur Akka HTTP.

  **Solution** : butez le service Tomcat pour libérer le port :

    ```bash
    sudo service tomcat stop
    ```
