import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "seal-the-deal-server"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      "com.google.code.gson" % "gson" % "2.1",
      "com.google.guava" % "guava" % "14.0.1"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here
    )

}
