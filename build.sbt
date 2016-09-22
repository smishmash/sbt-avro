name := "sbt-avro-1.4"
organization := "com.cavorite"
description := "Sbt plugin for compiling Avro sources"

version := "1.1.0-SNAPSHOT"

sbtPlugin := true

scalaVersion := appConfiguration.value.provider.scalaProvider.version
scalacOptions in Compile ++= Seq("-deprecation")

libraryDependencies ++= Seq(
  "org.apache.avro" % "avro" % "1.4.1",
  "org.specs2" %% "specs2-core" % "3.6.4" % "test"
)

publishMavenStyle := false
bintrayOrganization := Some("sbt")
bintrayRepository := "sbt-plugin-releases"
bintrayPackage := "sbt-avro"
bintrayReleaseOnPublish := false

ScriptedPlugin.scriptedSettings
scriptedLaunchOpts := { scriptedLaunchOpts.value ++
  Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
}
scriptedBufferLog := false