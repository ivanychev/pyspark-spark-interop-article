package org.sergey

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.{functions => f}

class MySparkLibrary {
  case class Record(value: Int)

  def rangeDataframe(spark: SparkSession, columnName: String, rangeUntil: Int): DataFrame = {
    val range: Seq[Record] = (0 to rangeUntil).map(Record)

    spark.createDataFrame(range).select(
      f.col("value").alias(columnName)
    )
  }
}
