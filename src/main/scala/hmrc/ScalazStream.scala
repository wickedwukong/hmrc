package hmrc

import scalaz.stream._
import scalaz.stream.Process._
import scalaz._
import Scalaz._
import scalaz.concurrent.Task
import scalaz.concurrent.Task._

object ScalazStream extends App {
  val dataSourceProcess: stream.Process[Task, Int] = scalaz.stream.Process(1, 2, 3).toSource
  val task: Task[(Int) => String] = Task.delay((i: Int) => i.toString + "L")
  val channel: Process[Task, (Int) => String] = Process repeatEval task
  val f: (Int) => Task[String] = (i: Int) => Task.delay(i.toString + "L")
  val channel1 = Process repeatEval f

  val end: Sink[Task, String] = io.print(System.out)
  val ppp = dataSourceProcess.filter(_ > 2).flatMap(i => (Process repeatEval  f(i))).take(3) to end

  ppp.run.run
//  val pp = (x through channel) to end
//  pp.run.run


//  val pp = x.filter(_ == "a") to end
//  println(pp)

//  pp.run.run


//  (x.flatMap((v: Int) =>  ).run.run

}
