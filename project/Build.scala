import sbt._
import Keys._

object HmrcBuild extends Build {
  val opts = Project.defaultSettings ++ Seq(
    scalaVersion := "2.11.4",
    resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
    libraryDependencies ++= Seq(
        "org.specs2" %% "specs2-core" % "2.4.15" % "test"
      )
    )

  lazy val root =
    Project(id = "hmrc",
      base = file("."),
      settings = opts) 
}
