import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD

object WordCount{
	def main(args:Array[String]){
		val conf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
		val sc = new SparkContext(conf)
		val wordRDD = sc.textFile("log.txt").flatMap(_.split(" "))
		val wordCountRDD = wordRDD.map(word=>(word,1))
		val combinedWordCount = wordCountRDD.reduceByKey((v1,v2)=>v1+v2)
		val result = combinedWordCount.filter(x=>x._2 > 4)
		//result.saveAsTextFile("wordCountsDir")
		result.foreach(println)
	}
}