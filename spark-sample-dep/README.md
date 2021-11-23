# Supplimental code for the Spark-PySpark interop article

## To build the JAR

```bash
cd spark-sample-dep
sbt assembly
```

## To run the pyspark script

1. Edit the script with the path to the JAR built in the previous step
2. Install the requirements from `requirements.txt` with

```bash
cd pysparkScala && pip3 install -r requirements.txt
````