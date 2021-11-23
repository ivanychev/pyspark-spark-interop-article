ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.15"

val sparkVersion = "3.2.0"

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.12" % sparkVersion % "provided",
  "org.apache.spark" % "spark-sql_2.12" % sparkVersion % "provided"
)
assembly / assemblyJarName := "spark-sample-dep-1.0.jar"
assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
lazy val root = (project in file("."))
  .settings(
    name := "spark-sample-dep",
    idePackagePrefix := Some("org.sergey")
  )
