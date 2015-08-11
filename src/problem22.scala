import java.util

/**
 * Created by a21032267 on 2015/08/10.
 */
object problem22 {
  def main(args: Array[String]){
    import scala.io._


    val source = Source.fromFile("/Users/a21032267/Downloads/names.txt", "UTF-8")

    try {
      // Iteratorを取得して一行ずつ表示
      source.getLines().foreach { line: String => getScore(line) }
    } finally {
      source.close ()
    }
  }

  def getScore (sentence: String): Unit = {
    val scalaList = sentence.split(",", -1).toList.sorted.zipWithIndex

    // 文字列からダブルクオーテーションを外す
    // index の 張替えを行ったcollectionを返す
    val list =
      for {
        (name, index)  <- scalaList
      } yield (name.filterNot(c => c.toInt == 34), index+1)


    println(list)

    val score = for {
      name <- list
      c <- name._1.toCharArray
    } yield (c.toInt - 64) * name._2

    println (score.sum)

  }

}
