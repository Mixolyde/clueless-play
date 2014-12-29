clueless-play
=============

Clueless Server Implementation using Play Framework in Scala.

This application is thee server which allows one or more players to play a 
game of Clueless, which is like Clue,
but with simplified movement. This code establishes the RESTful server for
maintaing the state of games and handling move instructions.

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
* Started game logic and case classes

### Todo

* Game Logic (cards, game data, players, move logic)
* Store game in server
* Send game data as JSON object
* Receive move submissions
* Update state on move submission
* Send out game over messages?
* Index web page with instructions and link to client
* Web GUI client
* AI players
* Watch AI-only game


Development Tools
-----------------

* [Scala](http://www.scala-lang.org/)
* [Scala IDE](http://scala-ide.org/) (Eclipse Luna)
* [Typesafe Activator](http://typesafe.com/)
* [Play Framework](https://www.playframework.com)
* [Akka Framework](http://akka.io/)
* [Github](https://github.com/Mixolyde/clueless-play)
* [EGit](https://eclipse.github.io/) Git plugin for Eclipse
* [Jenkins](http://jenkins-ci.org) CI build server

Continuous Integration
----------------------

Current build server can be found at [Jenkins](http://ec2-54-172-180-224.compute-1.amazonaws.com:8080/jenkins). 
There is currently one job running:

* Clueless Server Build Test - runs unit tests and creates distribution .zip file.
