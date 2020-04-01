name := "JsonToScala"
libraryDependencies += "io.spray" %% "spray-json" % "1.3.5"
libraryDependencies += "io.jsonwebtoken" % "jjwt" % "0.9.1"
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.6"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.10.3"

//for logging
libraryDependencies ++= Seq("com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
  "ch.qos.logback" % "logback-classic" % "1.1.2")