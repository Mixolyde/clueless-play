package gamelogic

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class BoardSpec extends Specification {
  "Board" should {
    "Passage list contains both directions" in {
      Board.PASSAGES must contain (Passage(STUDY, KITCHEN), Passage(KITCHEN, STUDY))
      
    }
    
    "Hallway list contains both directions" in {
      Board.HALLWAYS must contain (Hallway(STUDY, HALL), Hallway(HALL, STUDY))
      
    }
    "Scarlet starts in the hall/lounge hallway" in {
      Board.getStart(SCARLET) mustEqual Right(Hallway(HALL, LOUNGE))
    }
  }

}