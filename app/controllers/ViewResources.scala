package controllers

import play.api.mvc.Controller
import play.api.mvc.Action
import play.api.libs.json._

object ViewResources extends Controller {
  
  def viewGame(id: Int, autorefresh:Boolean) = Action { request =>
    //TODO lookup game data for id and return it as JSON
    
    //dummy json return value parsed as literal
    val json: JsValue = Json.parse("""
      {"board":{"knife":"3,3","candlestick":"4,5","pipe":"4,5"},
      "move_state":{"player":"scarlett","phase":"move|suggestion|accusation|choose_card_to_show"},
      "players":[
      {"name":"Brian","character":"mustard","active":true,"cards":["knife","dining","plum"],"position":"1,1"},
      {"name":"John","character":"white","active":false,"cards":["candlestick","pool"],"position":"1,3"}],
      "winner":"mustard"}
      """)
    if(autorefresh){  
      Ok(views.html.gameviewer("Game Viewer for: " + id, Json.prettyPrint(json), true))
      .withHeaders("Refresh" -> ("10;url=/games/" + id + "/view?autorefresh=true") )
    } else {
      Ok(views.html.gameviewer("Game Viewer for: " + id, Json.prettyPrint(json), false))
    }
  }

}