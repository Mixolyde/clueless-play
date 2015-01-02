package actors

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import akka.testkit._
import akka.actor._

@RunWith(classOf[JUnitRunner])
class GameDataSupervisorSpec  extends TestKit(ActorSystem("UnitTestSystem")) with SpecificationLike {
  
  "New Game Data Supervisor" should {
    // create test actor reference with dummy id
    val actorRef:TestActorRef[GameDataActor] = TestActorRef(new GameDataActor(1))
    val actor = actorRef.underlyingActor

    "initialize with new game data" in {

      todo

    }
  }
}