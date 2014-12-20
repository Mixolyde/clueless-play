package gamelogic

sealed abstract class Card 
sealed case class Room() extends Card
sealed case class Weapon() extends Card
sealed case class Character() extends Card

object GREEN extends Character()
object PLUM extends Character()
object WHITE extends Character()
object MUSTARD extends Character()
object SCARLET extends Character()
object PEACOCK extends Character()

object KNIFE extends Weapon()
object CANDLESTICK extends Weapon()
object PIPE extends Weapon()
object PISTOL extends Weapon()
object ROPE extends Weapon()
object POISON extends Weapon()

object HALL extends Room()