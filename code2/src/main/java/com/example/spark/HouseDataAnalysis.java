package com.example.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class HouseDataAnalysis {
    public static void main(String[] args) {
        // 创建 SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("HouseDataAnalysis")
                .master("local[*]")  // 使用本地模式，[*] 表示使用所有可用的核心
                .getOrCreate();

        // 读取 CSV 文件
//        Dataset<Row> df = spark.read()
//                .option("header", "true")  // 表示第一行是列名
//                .csv("hdfs://81.70.186.67:9000/sh_data.csv"); // 读取数据
       Dataset<Row> df = spark.read().option("header", "true").csv("src/main/resources/datas/sh_data.csv"); // 读取相对路径下的本地数据


        // 分析房屋总价的统计信息
        System.out.println("房屋总价的统计信息：");
        df.select("total_price").describe().show();

        // 定义装修情况变量，并去除null值
        System.out.println("装修情况的分布情况：");
        df.select("decoration")
                .na().drop("any")
                .groupBy("decoration")
                .count()
                .show();

        // 分析是否有电梯的房屋数量,并去除null值
        System.out.println("是否有电梯的房屋数量统计：");
        df.select("elevator")
                .na().drop("any")
                .groupBy("elevator")
                .count()
                .show();

        // 显示不同地区有多少个房屋的数据
        System.out.println("不同地区房屋数量统计：");
        df.select("district")
                .na().drop("any")
                .groupBy("district")
                .count()
                .show();

        // 停止 SparkSession
        spark.stop();
    }
}