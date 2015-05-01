import com.typesafe.sbt.SbtAspectj._

name := """activator-akka-kamon"""

version := "2.3.9"

scalaVersion := "2.11.6"

val kamonVersion = "0.3.6-SNAPSHOT"
val kamonRepo = "io.kamon_tom"

//need to a resolver... or maybe not

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.9",
  "com.typesafe.akka" %% "akka-slf4j" % "2.3.9",
  "ch.qos.logback" % "logback-classic" % "1.0.13",
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
