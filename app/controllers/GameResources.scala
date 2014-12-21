package controllers

import play.api.mvc.Controller
import play.api.mvc.Action
import play.api.libs.json._

object GameResources extends Controller {

  def index = Action {
    val ids = List(1, 2, 3, 4)
    
    Ok(views.html.gamelist("Games List Page", ids))
  }

  def gameData(id: Int) = Action {
    //TODO lookup game data for id and return it as JSON
    
    val json: JsValue = Json.parse("""
      {"board":{"knife":"3,3","candlestick":"4,5","pipe":"4,5"},
      "move_state":{"player":"scarlett","phase":"move|suggestion|accusation|choose_card_to_show"},
      "players":[
      {"name":"Brian","character":"mustard","active":true,"cards":["knife","dining","plum"],"position":"1,1"},
      {"name":"John","character":"white","active":false,"cards":["candlestick","pool"],"position":"1,3"}],
      "winner":"mustard"}
      """)

    Ok(json)
  }
  
  def newGame = TODO
  
  def getMoves(id: Int) = TODO
    
  def submitMove(id: Int) = TODO
  
  def submitPlayer(id: Int) = TODO
  
  def submitStart(id: Int) = TODO
  
  def deleteGame(id: Int) = TODO

}