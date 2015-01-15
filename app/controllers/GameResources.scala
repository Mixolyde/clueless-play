package controllers

import akka.util.Timeout
import akka.pattern.ask
import play.api.http.ContentTypes
import play.api.mvc.Controller
import play.api.mvc.Action
import play.api.libs.json._
import play.api.Logger
import play.api.libs.concurrent.Akka
import play.api.Play.current
import scala.concurrent.duration._
import scala.concurrent.Await
import actors.GameDataSupervisor
import actors.GameDataSupervisor._

object GameResources extends Controller {
  val log = Logger(this.getClass())
  implicit val timeout = Timeout(5.seconds)

  def index = Action {
    val future = ask(Akka.system.actorSelection("/user/GameDataSupervisor"), ListGames).mapTo[GameList]
    val ids = Await.result(future, 1.second)
    
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

    Ok(Json.prettyPrint(json)).as(ContentTypes.JSON)
  }
  
  def newGame = Action {
    log.info("Creating new game.")
    // look up game data supervisor actor
    val future = ask(Akka.system.actorSelection("/user/GameDataSupervisor"), NewGame).mapTo[Int]
    val id = Await.result(future, 1.second)
    
    //return index action after handling the POST
    Redirect("/games/" + id + "/view")
  }
  
  def submitPlayer(id: Int) = TODO
  
  def submitStart(id: Int) = TODO
  
  def deleteGame(id: Int) = Action {
    log.info("Ending game with id: " + id)
    // look up game data supervisor actor
    Akka.system.actorSelection("/user/GameDataSupervisor") ! EndGame(id)
    Redirect("/games")

  }

}