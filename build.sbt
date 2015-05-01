import com.typesafe.sbt.SbtAspectj._

name := """activator-akka-kamon"""

version := "2.3.9"

scalaVersion := "2.11.6"

val kamonVersion = "0.3.6-d0a337c13755763934d116847e8c9aa5bc10a0b4"
val kamonRepo = "io.kamon_tom"

//need to a resolver... or maybe not

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.9",
  kamonRepo %% "kamon-core" % kamonVersion,
  kamonRepo %% "kamon-akka" % kamonVersion,
  kamonRepo %% "kamon-statsd" % kamonVersion,
  kamonRepo %% "kamon-log-reporter" % kamonVersion,
  kamonRepo %% "kamon-system-metrics" % kamonVersion,

  "org.aspectj" % "aspectjweaver" % "1.8.5"
)

scalacOptions += "-feature"

aspectjSettings

javaOptions <++= AspectjKeys.weaverOptions in Aspectj

fork in run := true
