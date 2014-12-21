package gamelogic

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
    
class GameData {
  val players: Set[PlayerCharacter] = Set()
  var winner: Option[String] = None
  var moveState: MoveState = MoveState(SCARLET, Move)
  

}