import akka.actor.{Actor, ActorSystem, Props}

/**
 *  Pretty simple actor just logging when initializing itself and receiving a message
 */
class LoggingActor extends Actor {

  //Print out the current thread name!
  println(Thread.currentThread().toString + " : LoggingActor is initialized")

  def receive = {
    //Print out the current thread name!
    case message: String => println(Thread.currentThread().toString + s" : Message = $message" )
  }
}

/**
 *  Pretty simple object, which has the main method to run
 */
object ActorDebuggerMain {

  /**
   *  1. Create an ActorSystem
   *  2. Create an Actor (LoggingActor)
   *  3. Send a message to the actor, created in 2.
   *  4. Shuts down the system for proper exit
   */
  def main(args: Array[String]): Unit ={

    //Print out the current thread name!
    println(Thread.currentThread().toString + " : ActorDebuggerMain.main() running" )

    val system = ActorSystem("ActorDebuggerSystem")

    val actor  = system.actorOf(Props[LoggingActor])

    actor ! "Message from man()"

    Thread.sleep(500);
    system.shutdown()
  }
}