

import play.api._
import play.api.Play.current
import play.api.libs.concurrent.Akka
import akka.actor._
import actors.GameDataSupervisor

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    //create initial actors
    Logger.info("Initializing Supervisors")
    Akka.system.actorOf(Props[GameDataSupervisor], name = "GameDataSupervisor")

    Logger.info("Application has started")
  }

  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
  }

}