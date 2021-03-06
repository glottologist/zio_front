val ZioVersion            = "1.0.0-RC11-1"
val ZioCatsVersion        = "2.0.0.0-RC2"
val DoobieVersion         = "0.8.0-RC1"
val Http4sVersion         = "0.21.0-M3"
val CirceVersion          = "0.12.0-RC1"
val LogbackVersion        = "1.2.3"
val ScalaLogVersion       = "3.9.2"
val PureConfigVersion     = "0.11.1"
val H2Version             = "1.4.199"
val FlywayVersion         = "5.2.4"
val Specs2Version         = "4.7.0"
val TestContainersVersion = "0.29.0"
val PSQLContainerVersion  = "1.12.0"
val PSQLDriverVersion     = "42.2.6"
val ZIOKafkaVersion       = "0.0.1"
//val ZIOKafkaVersion       = "8ff9e0a3"

resolvers += Resolver.sonatypeRepo("snapshots")

organization := "CloverGroup"
name := "front"
version := "0.1.0"
scalaVersion := "2.12.8"
maxErrors := 3
updateOptions := updateOptions.value.withLatestSnapshots(false)
libraryDependencies ++= Seq(
  "org.specs2"                 %% "specs2-core"            % Specs2Version % Test,
  "dev.zio"                    %% "zio"                    % ZioVersion,
  "dev.zio"                    %% "zio-interop-cats"       % ZioCatsVersion,
  "dev.zio"                    %% "zio-kafka"              % ZIOKafkaVersion,
  "com.dimafeng"               %% "testcontainers-scala"   % TestContainersVersion,
  "org.testcontainers"         % "postgresql"              % PSQLContainerVersion % Test,
  "org.postgresql"             % "postgresql"              % PSQLDriverVersion,
  "org.http4s"                 %% "http4s-blaze-server"    % Http4sVersion,
  "org.http4s"                 %% "http4s-blaze-client"    % Http4sVersion,
  "org.http4s"                 %% "http4s-circe"           % Http4sVersion,
  "org.http4s"                 %% "http4s-dsl"             % Http4sVersion,
  "io.circe"                   %% "circe-generic"          % CirceVersion,
  "io.circe"                   %% "circe-literal"          % CirceVersion,
  "io.circe"                   %% "circe-parser"           % CirceVersion,
  "org.tpolecat"               %% "doobie-core"            % DoobieVersion,
  "org.tpolecat"               %% "doobie-h2"              % DoobieVersion,
  "org.tpolecat"               %% "doobie-hikari"          % DoobieVersion,
  "org.tpolecat"               %% "doobie-postgres"        % DoobieVersion,
  "com.h2database"             % "h2"                      % H2Version,
  "org.flywaydb"               % "flyway-core"             % FlywayVersion,
  "ch.qos.logback"             % "logback-classic"         % LogbackVersion,
  "com.typesafe.scala-logging" %% "scala-logging"          % ScalaLogVersion,
  "com.github.pureconfig"      %% "pureconfig"             % PureConfigVersion,
  "com.github.pureconfig"      %% "pureconfig-cats-effect" % PureConfigVersion
)

scalacOptions --= Seq(
  "-Xfatal-warnings"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
addCommandAlias("chk", "all scalafmtSbtCheck scalafmtCheck test:scalafmtCheck")
