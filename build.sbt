import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.mackler",
      scalaVersion := "2.12.4",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Slovak Natural Language Generation",
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-language:postfixOps", "-language:existentials", "-language:reflectiveCalls", "-language:implicitConversions"),
    libraryDependencies += scalactic,
    libraryDependencies += scalaTest % Test
  )
