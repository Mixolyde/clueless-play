package controllers

import akka.util.Timeout
import akka.pattern.ask
import play.api.mvc.Controller
import play.api.mvc.Action
import play.api.libs.json._
import play.api.Logger
import play.api.libs.concurrent.Akka
import play.api.Play.current
import scala.concurrent.duration._
import actors.GameDataSupervisor
import actors.GameDataSupervisor._

object GameResources extends Controller {
  val log = Logger(this.getClass())
  implicit val timeout = Timeout(5.seconds)

  def index = Action {
    val ids = List()
    
    ask(Akka.system.actorSelection("/user/GameDataSupervisor"), ListGames)
    
    Ok(views.html.gamelist("Games List Page", ids))
  }

  def gameData(id: Int) = Action {
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

    Ok(json)
  }
  
  def newGame = Action {
    log.info("Creating new game.")
    // look up game data supervisor actor
    Akka.system.actorSelection("/user/GameDataSupervisor") ! NewGame
    
    //TODO redirect to games list index page?
    Ok("New Game message sent")
  }
  
  def submitPlayer(id: Int) = TODO
  
  def submitStart(id: Int) = TODO
  
  def deleteGame(id: Int) = Action {
    log.info("Ending game with id: " + id)
    // look up game data supervisor actor
    Akka.system.actorSelection("/user/GameDataSupervisor") ! EndGame(id)
    //TODO redirect to games list index page?
    Ok("End Game message sent")

  }

}