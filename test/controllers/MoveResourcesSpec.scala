package controllers

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class MoveResourcesSpec extends Specification {
  "Move" should {

    "render game the available moves resource" in new WithApplication {

      //TODO submit a game POST request to generate a game
      val moves = route(FakeRequest(GET, "/games/1/move")).get

      //status(viewer) must equalTo(OK)
      contentType(moves) must beSome.which(_ == "text/html")
      contentAsString(moves) must contain("TODO")
    }
  
  "receive move POST and update game data" in new WithApplication {

      //TODO submit a game POST request to generate a game
      //TODO submit move put data JSON
      val moves = route(FakeRequest(PUT, "/games/1/move")).get

      //status(viewer) must equalTo(OK)
      contentType(moves) must beSome.which(_ == "text/html")
      contentAsString(moves) must contain("TODO")
    }
  }


}