package gamelogic

trait BoardLocation
case class Hallway(room1: Room, room2: Room) extends BoardLocation

case class Passage(room1: Room, room2: Room)

object Board {

  private val PASSAGES_ONE: Set[Passage] = Set(Passage(STUDY, KITCHEN), Passage(CONSERVATORY, LOUNGE))
  val PASSAGES = PASSAGES_ONE ++ PASSAGES_ONE.map ((passage) => Passage(passage.room2, passage.room1))

  private val HALLWAYS_ONE: Set[Hallway] = Set(
    Hallway(STUDY, HALL),
    Hallway(HALL, LOUNGE),
    Hallway(LIBRARY, BILLIARD_ROOM),
    Hallway(BILLIARD_ROOM, DINING_ROOM),
    Hallway(CONSERVATORY, BALL_ROOM),
    Hallway(BALL_ROOM, KITCHEN),
    Hallway(STUDY, LIBRARY),
    Hallway(LIBRARY, CONSERVATORY),
    Hallway(HALL, BILLIARD_ROOM),
    Hallway(BILLIARD_ROOM, BALL_ROOM),
    Hallway(LOUNGE, DINING_ROOM),
    Hallway(DINING_ROOM, KITCHEN))

  val HALLWAYS = HALLWAYS_ONE ++
    HALLWAYS_ONE.map((hallway) => Hallway(hallway.room2, hallway.room1))

  //Starting order
  val START_ORDER = List(SCARLET, MUSTARD, WHITE, GREEN, PEACOCK, PLUM)  
  
  //starting locations
  val STARTS: Map[Character, Hallway] = Map(
    (SCARLET, Hallway(HALL, LOUNGE)),
    (MUSTARD, Hallway(LOUNGE, DINING_ROOM)),
    (WHITE, Hallway(BALL_ROOM, KITCHEN)),
    (GREEN, Hallway(CONSERVATORY, BALL_ROOM)),
    (PEACOCK, Hallway(LIBRARY, CONSERVATORY)),
    (PLUM, Hallway(STUDY, LIBRARY)))

  def getStart(character: Character):BoardLocation = {
    STARTS(character)
  }
}
