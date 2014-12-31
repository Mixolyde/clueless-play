package gamelogic

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class BoardSpec extends Specification {
  "Board static helpers" should {
    "contain both directions in passages" in {
      Board.PASSAGES must contain (Passage(STUDY, KITCHEN), Passage(KITCHEN, STUDY))
      
    }
    
    "contain both directions in hallways" in {
      Board.HALLWAYS must contain (Hallway(STUDY, HALL), Hallway(HALL, STUDY))
      
    }
    "have Scarlet start in the hall/lounge hallway" in {
      Board.getStart(SCARLET) mustEqual Hallway(HALL, LOUNGE)
    }
  }

}
