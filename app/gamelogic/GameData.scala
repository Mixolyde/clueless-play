package gamelogic

case class PlayerCharacter(val name:String, 
    val character:Character,
    val hand:Set[Card])

class GameData {
  var isOver: Boolean = false
  val players: Set[PlayerCharacter] = Set()

}