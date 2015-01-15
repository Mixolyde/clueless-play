package controllers

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class GameResourcesSpec extends Specification {
    "GameResources" should {

    "render an empty game list page" in new WithApplication{
      val home = route(FakeRequest(GET, "/games")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain ("Games List Page")
    }
    
    "create a new game on empty POST" in new WithApplication{
      val home = route(FakeRequest(POST, "/games")).get

      //must return a redirect
      status(home) must equalTo(SEE_OTHER)
      contentType(home) must beNone
    }

  }

}