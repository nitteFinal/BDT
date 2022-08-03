import scala.io.Source

object ScalaWordCount {
    def main(args: Array[String]) {
        var fileName = "hello.txt"
        var wordCount = scala.collection.mutable.Map[String, Int]()

        for(line <- Source.fromFile(fileName).getLines)
            for(word <- line.split(" "))
                wordCount(word) = if(wordCount.contains(word)) wordCount(word) + 1 else 1
        
        for((k,v) <- wordCount) {
            printf("Word %s occurs %d times\n", k, v)
        }
    }

}