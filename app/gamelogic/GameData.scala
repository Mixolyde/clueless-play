package gamelogic

import gamelogic._

class GameData {
  var players: Set[PlayerCharacter] = Set()
  var winner: Option[String] = None
  var moveState: Option[MoveState] = None
  
  //TODO set initial locations for players
  val playerLocations: Set[(Character, BoardLocation)] = Set()
  
  //TODO randomize winning combo
  val winningCards = WinningCards(HALL, KNIFE, PLUM)
  
  def addPlayer(newPlayer: PlayerCharacter) = {
    //TODO add player info to players set
  }
  
  def startGame() = {
    //TODO set initial hands
    //TODO set initial move start
  }
  
  def applyMove(): Unit = {
    //TODO apply move and update game data
  }
}

case class WinningCards(room: Room, weapon: Weapon, character: Character)

case class PlayerCharacter(
    val name:String, 
    val character:Character,
    val hand:Set[Card])
    
sealed abstract class MoveType
case object Move extends MoveType
case object Suggestion extends MoveType
case object Accusation extends MoveType
case object ChooseCard extends MoveType

case class MoveState(val character:Character,
    val moveType:MoveType)
 
