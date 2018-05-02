import scala.collection.mutable.ListBuffer

object PlayBowl{
  
  def main(args: Array[String]): Unit = {
    val game = new Bowl
    for (i <- Seq(2, 3,   3, 5,   2, 8,   4, 6,   1,0,   2, 1,   1, 9,   5, 5,   10,   4, 3,   7)) game.roll(i)
    val scr = game.score
    println("Bowling game score: "+scr)
  }
  
}

class Bowl {
  
  var rolls = new ListBuffer[Int](); 

  def roll(i: Int) = {
    rolls = rolls += i
  }

  def count(i: Int = 0, sum: Int = 0, frames: Int = 0): Int =
    if (i >= rolls.size || frames == 10) sum
    else {
      val roll_1 = rolls(i)
      if (roll_1 == 10) count(i + 1, sum + 10 + rolls(i + 1) + rolls(i + 2), frames + 1)
      else {
        val roll_2 = rolls(i + 1)
        if ( (roll_1 + roll_2)  == 10) count(i + 2, sum + 10 + rolls(i + 2), frames + 1)
        else count(i + 2, sum + roll_1 + roll_2, frames + 1)
      }
    }
  
    def score: Int = count()
}