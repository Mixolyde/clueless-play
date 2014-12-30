package actors

import akka.actor.{ Actor, ActorRef, Props }
import akka.event.Logging
import scala.collection.mutable.Map

class GameDataSupervisor extends Actor {
  import GameDataSupervisor._

  val log = Logging(context.system, this)

  var gameActors: scala.collection.mutable.Map[Int, ActorRef] = Map()
  var gameIndex: Int = 0

  override def preStart(): Unit = {
    log.info("GameDataSupervisor starting up")
  }

  def receive = {
    case NewGame          => {
      log.info("Received new game message")
      //update the game index
      gameIndex += 1
      
      val child = context.actorOf(GameDataActor.props(gameIndex))
      gameActors += (gameIndex -> child)
      
      sender ! gameIndex
      
    }
    
    case NewPlayer(id: Int, name: String) => {
      //forward the message to the right actor
      gameActors(id) forward NewPlayer(id, name)
    }
    
    case GetGameData(id: Int) => {
      log.info("Received get game data message")
      
      //forward the message to the right actor
      gameActors(id) forward GetGameData(id)
    }
    
    case ListGames => {
      val ids: Set[Int] = gameActors.keySet.toSet[Int]
      
      sender() ! GameList(ids)
    }
    
    case StartGame(id: Int)        => {
      log.info("Received game start message for game: " + id)
      
      //forward the message to the right actor
      gameActors(id) forward StartGame(id)
      
    }
    
    case EndGame(id: Int) => {
      log.info("Received message to end game: " + id)
      val child = gameActors get id
      child match {
        case Some(ref) => {
          log.info("Sending end game message to game actor.")
          ref ! EndGame(id)
          gameActors -= id
        }
        case None => log.info("No game actor with that id found.")
      }
    }
    
    case _                => log.info("Received unknown message in GameDataSupervisor")
  }

  //val child = context.actorOf(Props[MyActor], name = "myChild")

}

object GameDataSupervisor {
  def props(): Props = Props(new GameDataSupervisor())
  
  //receive messages
  case object NewGame
  case object ListGames
  
  case class StartGame(id: Int)
  case class GetGameData(id: Int)
  case class EndGame(id: Int)
  case class NewPlayer(id: Int, name: String)
  
  //response messages
  case class GameList(ids: Set[Int])
}
