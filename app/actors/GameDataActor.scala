package actors

import akka.actor.{ Actor, Props }
import akka.event.Logging
import gamelogic.{ Card, GameData }
import GameDataSupervisor._

class GameDataActor extends Actor {
  val log = Logging(context.system, this)
  val gameData: GameData = new GameData()

  def receive = {
    case EndGame(id: Int) => {
      log.info("Received end game message.")
    }
    case _ => log.info("Unrecognized message received.")
  }

}

object GameDataActor {
  def props(): Props = Props(new GameDataActor())

}