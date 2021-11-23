from pyspark import SQLContext
from pyspark.sql import DataFrame
from pyspark.sql import SparkSession

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    spark = (SparkSession
             .builder
             .appName("app")
             .master("local[2]")
             .config(
        "spark.driver.extraClassPath",
        "<<Add JAR path here>>")
             .getOrCreate())

    lib = spark._jvm.org.sergey.MySparkLibrary()

    java_dataframe = lib.rangeDataframe(
        spark._jsparkSession,
        "range_column",
        10
    )
    sql_context = SQLContext(spark.sparkContext, sparkSession=spark)
    python_dataframe: DataFrame = DataFrame(java_dataframe, sql_context)
    print(python_dataframe.toPandas())

