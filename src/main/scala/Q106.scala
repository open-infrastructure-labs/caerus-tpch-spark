package main.scala

import org.apache.spark.sql.DataFrame
import org.apache.spark.SparkContext
import org.apache.spark.sql.functions.sum
import org.apache.spark.sql.functions.udf

/**
 * TPC-H Query 6 modifed for spark pushdown.
 *
 *
 */
class Q106 extends TpchQuery {

  override def execute(sc: SparkContext, schemaProvider: TpchSchemaProvider): DataFrame = {

    // this is used to implicitly convert an RDD to a DataFrame.
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    import sqlContext.implicits._
    import schemaProvider._
    // orig lineitem.filter($"l_discount" >= 0.05 && $"l_discount" <= 0.07 && $"l_quantity" < 24 && $"l_shipdate" >= "1994-01-01" && $"l_shipdate" < "1995-01-01")
    lineitem.filter($"l_discount" >= 0.05 && $"l_discount" <= 0.07 && $"l_quantity" < 24 && $"l_shipdate" >= "1994-01-01" && $"l_shipdate" < "1995-01-01")
      .agg(sum($"l_extendedprice"))
  }

}
