# akka_project

Pour lancer le serveur :
  etre sur que sbt est bien installé

  dans le dossier du projet :
        sbt clean
        sbt update
        sbt compile
        sbt run


Bug remarqué :
  error 404 tomcat dans le browser à localhost:8080/ => il faut fermer sa gueule à tomcat : sudo service tomcat stop
