name := "HelloWorldAkkaHttp"

version := "0.1"

scalaVersion := "2.13.16"

val http4sVersion = "0.23.30"

import org.scalajs.linker.interface.ModuleSplitStyle
import sbt.Keys.libraryDependencies
enablePlugins(JSDependenciesPlugin)
lazy val akka_project = project.in(file("."))
  .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
  .settings(
    scalaVersion := "3.3.3",

    // Tell Scala.js that this is an application with a main method
    scalaJSUseMainModuleInitializer := true,

    /* Configure Scala.js to emit modules in the optimal way to
     * connect to Vite's incremental reload.
     * - emit ECMAScript modules
     * - emit as many small modules as possible for classes in the "livechart" package
     * - emit as few (large) modules as possible for all other classes
     *   (in particular, for the standard library)
     */
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("livechart")))
    },

    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.8.0", //import scala.js

    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.2.9", //import akka
      "com.typesafe.akka" %% "akka-actor-typed" % "2.6.19",
      "com.typesafe.akka" %% "akka-stream" % "2.6.19",
      "org.http4s" %% "http4s-ember-client" % http4sVersion, //import http4s
      "org.http4s" %% "http4s-ember-server" % http4sVersion,
      "org.http4s" %% "http4s-dsl"          % http4sVersion,
      "com.github.cornerman" %% "sloth" % "0.8.0", //import sloth
      "org.jsoup" % "jsoup" % "1.18.1", //import jsoup
      "com.google.cloud.functions" % "functions-framework-api" % "1.1.0",
    ),
    libraryDependencies += "com.google.code.gson" % "gson" % "2.10.1", //import json

    //dependencies for alpha vantage scala by benmosheron
    // https://mvnrepository.com/artifact/org.apache.httpcomponents/fluent-hc
    libraryDependencies += "org.apache.httpcomponents" % "fluent-hc" % "4.5.14",
    // https://mvnrepository.com/artifact/io.spray/spray-json
    libraryDependencies += "io.spray" %% "spray-json" % "1.3.6",
    // https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.5.11",
    // https://mvnrepository.com/artifact/com.typesafe.scala-logging/scala-logging
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",


      /*import React*/
      jsDependencies ++= Seq(

      "org.webjars.npm" % "react" % "17.0.2"
        /        "umd/react.development.js"
        minified "umd/react.production.min.js"
        commonJSName "React",

      "org.webjars.npm" % "react-dom" % "17.0.2"
        /         "umd/react-dom.development.js"
        minified  "umd/react-dom.production.min.js"
        dependsOn "umd/react.development.js"
        commonJSName "ReactDOM",

      "org.webjars.npm" % "react-dom" % "17.0.2"
        /         "umd/react-dom-server.browser.development.js"
        minified  "umd/react-dom-server.browser.production.min.js"
        dependsOn "umd/react-dom.development.js"
        commonJSName "ReactDOMServer"),

    jsDependencies += "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js"
  )





