lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """play-scala-hello-world-tutorial""",
    organization := "com.example",
    version := "0.1", // 1.0-SNAPSHOT
    scalaVersion := "2.13.6",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test, // 5.1.0
      "org.reactivemongo" %% "play2-reactivemongo" % "0.19.1-play27" // 0.20.13-play27
//      "org.reactivemongo" %% "reactivemongo-play-json-compat" % "0.20.13-play27"
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    ),
    play.sbt.routes.RoutesKeys.routesImport += "play.modules.reactivemongo.PathBindables._"
  )
