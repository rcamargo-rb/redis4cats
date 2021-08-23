name := "redis4cats"
version := "0.1"
scalaVersion := "2.13.6"

val redis4catsVersion = "1.0.0"
val redis4cats = Seq ("redis4cats-core", "redis4cats-effects", "redis4cats-streams", "redis4cats-log4cats")

libraryDependencies ++= redis4cats.map("dev.profunktor" %% _ % redis4catsVersion)


