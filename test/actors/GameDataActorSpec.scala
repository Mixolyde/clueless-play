package actors

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import akka.testkit._
import akka.actor._
import org.specs2.matcher.BeEqualTo
import actors.GameDataSupervisor._

@RunWith(classOf[JUnitRunner])
class GameDataActorSpec extends TestKit(ActorSystem("UnitTestSystem")) with SpecificationLike {
  
  "New Game Data Actor" should {
    // create test actor reference with dummy id
    val actorRef:TestActorRef[GameDataActor] = TestActorRef(new GameDataActor(1))
    val actor = actorRef.underlyingActor

    "initialize with new game data" in {

      actor.gameId must beEqualTo(1)
      val testData = actor.gameData
      testData.players must beEmpty
      testData.moveState must beNone
      testData.winner must beNone
      
    }
    "stop when receives end game message" in {
      actorRef ! EndGame(1)
      todo
    }
  }

}