name := """clueless-play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

//local app dependencies
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-testkit" % "2.3.4"
)

//enable compiler feature warnings
scalacOptions ++= Seq("-feature")
