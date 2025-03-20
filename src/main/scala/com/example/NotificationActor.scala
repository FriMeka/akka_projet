import akka.actor.{Actor, ActorRef, Props}

class NotificationActor extends Actor {
  
  // Stockage des utilisateurs abonnés aux notifications
  var subscribers: Map[String, ActorRef] = Map()

  def receive: Receive = {
    
    // Lorsqu'un utilisateur s'abonne
    case SubscribeToNotifications(userId, ref) =>
      subscribers += (userId -> ref)
      println(s"Utilisateur $userId abonné aux notifications.")

    // Lorsqu'un utilisateur se désabonne
    case UnsubscribeFromNotifications(userId) =>
      subscribers -= userId
      println(s"Utilisateur $userId désabonné.")

    // Gestion d'une alerte de prix
    case PriceAlert(asset, price, threshold, userId) =>
      subscribers.get(userId).foreach { userRef =>
        userRef ! s"Alerte : $asset a atteint $price (Seuil: $threshold)"
      }

    // Gestion d'une alerte sur un indicateur technique
    case IndicatorAlert(asset, indicator, value, userId) =>
      subscribers.get(userId).foreach { userRef =>
        userRef ! s"Alerte : Indicateur $indicator pour $asset est à $value"
      }
  }
}

object NotificationActor {
  def props: Props = Props[NotificationActor]
}
