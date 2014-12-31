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
  "Game data when adding players" should {
    val testData = new GameData()
    "allow only six players" in {
      (1 to 6).foreach(x => testData.addPlayer("newPlayer" + x))
      testData.players must haveLength(6)
      
      testData.addPlayer("too many players")
      testData.players must haveLength(6)
    }
  } 
  

}