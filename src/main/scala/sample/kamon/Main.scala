package sample.kamon

import akka.actor._
import MessageGenerator._
import RandomNumberActor._
//you need this library I believe
import kamon.Kamon

object Main extends App {

  //This is now necessary to add
  Kamon.start()

  val system = ActorSystem("application")

  val numberGenerator = system.actorOf(Props[RandomNumberActor], "numbers")

  val generator = system.actorOf(Props[MessageGeneratorActor], "artifical")

  generator ! ConstantLoad(Schedule(numberGenerator, GenerateNumber, 5000))
  generator ! ConstantLoad(Schedule(numberGenerator, GenerateSecureNumber, 1000))
  generator ! Peak(Schedule(numberGenerator, GenerateNumber, 100000))
  generator ! Peak(Schedule(numberGenerator, GenerateSecureNumber, 25000))
}
