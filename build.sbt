name := """play-products-demo"""
organization := "com.example"

version := "1.0-SNAPSHOT"

// Enable the Play Scala plugin for this project.
lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.15"

libraryDependencies += guice
