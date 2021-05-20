name := "Spark TPC-H Queries"

version := "1.0"

scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.0.1"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1"
libraryDependencies += "com.github.scopt" %% "scopt" % "4.0.0-RC2"
libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "3.2.2"
libraryDependencies += "ch.cern.sparkmeasure" %% "spark-measure" % "0.17"
