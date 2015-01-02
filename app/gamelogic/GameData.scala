package gamelogic

import scala.util.Random

import play.api.Logger

class GameData {
  var players: Map[Character, PlayerData] = Map()
  var winner: Option[String] = None
  var moveState: Option[MoveState] = None

  //TODO randomize winning combo
  val winningCards = WinningCards(HALL, KNIFE, PLUM)

  def addPlayer(newPlayer: String) = {
    val charsInUse: Set[Character] = players.keySet
    val charsAvailable = Board.START_ORDER filterNot { case char => charsInUse contains char }
    if (charsAvailable.length > 0) {
      val randomChar = charsAvailable(Random.nextInt(charsAvailable.length))
      // create a new player record with an empty hand
      players += (randomChar -> PlayerData(newPlayer,
        Board.STARTS(randomChar), None))
      GameData.log.info("Added player: " + newPlayer)
      GameData.log.info("New player data: " + players)
    }

  }

  def startGame(): Unit = {
    players.size match {
      case x if x < 2 => throw (new IllegalArgumentException("Cannont start game with fewer than 2 players"))
      case x => {
        //TODO set initial hands
        //TODO set initial move state

      }
    }
  }

  def applyMove(): Unit = {
    //TODO apply move and update game data
    throw (new NotImplementedError())
  }
  
  def isLegalMove(): Boolean = {
    //TODO finish legal move checks
    
    
    throw (new NotImplementedError())
  }
}

case class WinningCards(room: Room, weapon: Weapon, character: Character)

case class PlayerData(
  val name: String,
  val boardLocation: BoardLocation,
  val hand: Option[Set[Card]])

sealed abstract class MoveType
case object Move extends MoveType
case object Suggestion extends MoveType
case object Accusation extends MoveType
case object ChooseCard extends MoveType

case class MoveState(val character: Character,
                     val moveType: MoveType)

object GameData {
  val log = Logger(this.getClass())
}
 
