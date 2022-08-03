import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD

object TweetMining{
	def main(args:Array[String]){
		val conf = new SparkConf().setAppName("UserMining").setMaster("local[*]")
		val sc = new SparkContext(conf)
		val tweets = sc.textFile("rt.json").mapPartitions(TweetUtils.parseFromJson(_))
		val userTweets = tweets.map(x=>(x.user,x)).groupByKey()
		val tweetsByUser = userTweets.map(x=>(x._1,x._2.size)).sortBy(_._2,ascending = false)
		tweetsByUser.take(10).foreach(println)
	}
}

import com.google.gson._

object TweetUtils{
	case class Tweet(
		id:String,
		user:String,
		userName:String,
		text:String,
		place:String,
		country:String,
		lang:String
	)
	def parseFromJson(lines:Iterator[String]):Iterator[Tweet] = {
		val gson = new Gson
		lines.map(line => gson.fromJson(line,classOf[Tweet]))
	}
}
