package gamelogic

sealed abstract class Card 
sealed class Room() extends Card with BoardLocation
sealed class Weapon() extends Card
sealed class Character() extends Card

case object GREEN   extends Character()
case object PLUM    extends Character()
case object WHITE   extends Character()
case object MUSTARD extends Character()
case object SCARLET extends Character()
case object PEACOCK extends Character()

case object KNIFE       extends Weapon()
case object CANDLESTICK extends Weapon()
case object PIPE        extends Weapon()
case object PISTOL      extends Weapon()
case object ROPE        extends Weapon()
case object POISON      extends Weapon()

case object HALL          extends Room()
case object STUDY         extends Room()
case object LIBRARY       extends Room()
case object CONSERVATORY  extends Room()
case object BALL_ROOM     extends Room()
case object BILLIARD_ROOM extends Room()
case object LOUNGE        extends Room()
case object DINING_ROOM   extends Room()
case object KITCHEN       extends Room()
