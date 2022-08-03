import scala.io.StdIn
import scala.collection.mutable.ArrayBuffer

object minmax {
    def main(args: Array[String]):Unit ={
        var numArr = scala.collection.mutable.ArrayBuffer[Int]()
        print("Enter total numbers")
        val n = scala.io.StdIn.readInt()
        print("enter Element\n")
        for(i <- 1 to n) {
            numArr += scala.io.StdIn.readInt()
        }
        val t = Minmax(numArr)
        printf("Max num is %d, Min num is %d",t._1, t._2)
    }
    def Minmax(numArr: ArrayBuffer[Int]): (Int,Int) ={
        var max = -999
        var min = 999
        for(i <- numArr) {
            if(i > max) max = i
            if(i < min) min = i
        }
        (max, min)
    }
}
