package com.example.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import java.util.Properties;

public class Decoration {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("HouseDataAnalysis")
                .master("local[*]")  // 使用本地模式，[*] 表示使用所有可用的核心
                .getOrCreate();

        // 读取 CSV 文件
//        Dataset<Row> df = spark.read().option("header", "true").csv("hdfs://81.70.186.67:9000/sh_data.csv"); // 读取数据
        Dataset<Row> df = spark.read().option("header", "true").csv("src/main/resources/datas/sh_data.csv"); // 读取相对路径下的本地数据


        // 定义装修情况变量，并去除null值
        Dataset<Row> decorationDF = df.select("decoration").na().drop().groupBy("decoration").count();
        decorationDF.show();

        // 将结果存入数据库
        String url = "jdbc:mysql://81.70.186.67:11234/house";
        String user = "root";
        String password = "root@ldyLDY";

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        decorationDF.write()
                .mode(SaveMode.Overwrite) // 如果表已经存在，覆盖写入
                .jdbc(url, "decoration", props);

// 停止 SparkSession
        spark.stop();

        // 停止 SparkSession
        spark.stop();
    }
}
