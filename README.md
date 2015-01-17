clueless-play
=============

A Clue-less server implementation using the Play Framework in Scala.

This application is the server which allows one or more players to play a 
game of Clue-less, which is like Clue,
but with simplified board movement. This code establishes the RESTful server for
maintaining the state of games and handling move instructions. Eventually it will
provide a web interface for viewing and playing the game.

Instructions
------------

### Test the app

1. Checkout the source from github
2. Run `activator test` from a command prompt in the checkout directory


### Run the App

1. Checkout the source from github
2. Run `activator run` from a command prompt in the checkout directory
3. Navigate to [http://localhost:9000]

Project Status
--------------

### Completed

* Grabbed play template and setup in github
* Started game logic and case classes for game objects
* Started game logic handling actors. The `GameDataActor` holds the 
  mutable state of a single game instance. The `GameDataSupervisor` 
  maintains list of active game actors and manages communication with them.
* Basic resource pages for listing games

### Todo

* Lots of unit tests
* Game Logic (game data, players, move logic)
* Move/game history log which stores/logs all moves played
* Server game state CRUD via messages
* Send game data as JSON object
* Receive player info and start game
* Receive move submissions
* Update state on move submission
* Possibly send out a "game over" message directly to clients
* Index web page with instructions and link to client
* Web GUI client
* AI players
* Watch AI-only game
* Auto-refreshing game viewer
* More jenkins jobs for deploying the server and running application tests

Development Tools
-----------------

* [Scala](http://www.scala-lang.org/) Amazing functional/OO general purpose programming language
* [Scala IDE](http://scala-ide.org/) (Eclipse Luna) Eclipse-based IDE for Scala
* [Play Framework](https://www.playframework.com) Web application and REST service framework
* [Akka Framework](http://akka.io/) Actor-based concurrency framework
* [SBT](http://www.scala-sbt.org/) Interactive, simple build tool for running, testing, and deploying Scala projects
* [Typesafe Activator](http://typesafe.com/) Scala, AKKA, Play, and SBT all rolled into one awesome package
* [Specs2](https://etorreborre.github.io/specs2) Unit/Integration test framework for Scala
* [Github](https://github.com/Mixolyde/clueless-play) GIT version control repository
* [EGit](https://eclipse.github.io/) Git plugin for Eclipse
* [Jenkins](http://jenkins-ci.org) CI build server
* [Postman](http://www.getpostman.com/) Easy and powerful REST API testing toolkit

Continuous Integration
----------------------

The project's [Jenkins](http://jenkins-ci.org) build server can be found 
[here](http://ec2-54-172-180-224.compute-1.amazonaws.com:8080/jenkins). 
There is currently one job running:

* Clueless Server Build Test - runs unit tests and creates distribution .zip file.

[![Build Status](http://ec2-54-172-180-224.compute-1.amazonaws.com:8080/jenkins/job/Clueless_Server_Play_Test/badge/icon)](http://ec2-54-172-180-224.compute-1.amazonaws.com:8080/jenkins/job/Clueless_Server_Play_Test/)
