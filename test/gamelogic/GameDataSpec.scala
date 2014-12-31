package gamelogic

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

@RunWith(classOf[JUnitRunner])
class GameDataSpec extends Specification {
  "Game Data when initialized" should {
    val testData = new GameData()
    "be empty" in {      
      testData.players must beEmpty
    }
    "have no move state" in {
      testData.moveState must beNone
    }
    "have no winner" in {
      testData.winner must beNone
    }
  } 

}