lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.bowl",
      scalaVersion := "2.12.4"
    )),
    name := "scalatest-bowl"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test
