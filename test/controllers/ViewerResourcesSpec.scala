package controllers

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class ViewerResourcesSpec extends Specification {
    "Viewer" should {

    "render game the viewer page" in new WithApplication{
      
      //TODO submit a game POST request to generate a game
      val viewer = route(FakeRequest(GET, "/games/1/view")).get

      //status(viewer) must equalTo(OK)
      contentType(viewer) must beSome.which(_ == "text/html")
      contentAsString(viewer) must contain ("TODO")
    }
  }

}