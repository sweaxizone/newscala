// for publishing, use
// https://github.com/sbt/sbt-ci-release
// -----

ThisBuild / homepage := Some(url("https://github.com/sweaxizone/newscala"))
// Alternatively License.Apache2 see https://github.com/sbt/librarymanagement/blob/develop/core/src/main/scala/sbt/librarymanagement/License.scala
ThisBuild / licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
ThisBuild / developers := List(
    Developer(
        id = "matheusds4",
        name = "Matheus Dias de Souza",
        email = "hydroperfox@gmail.com",
        url = url("https://github.com/matheusds4")
    )
)
ThisBuild / packageDoc / publishArtifact := true

val toolkitV = "0.5.0"
val toolkit = "org.scala-lang" %% "toolkit" % toolkitV
val toolkitTest = "org.scala-lang" %% "toolkit-test" % toolkitV

ThisBuild / scalaVersion := "3.3.4"

// main project
lazy val root = (project in file("."))
    .settings(
        organization := "io.github.sweaxizone",
        name := "newscala",

        libraryDependencies += toolkit,
        libraryDependencies += (toolkitTest % Test)
    )
