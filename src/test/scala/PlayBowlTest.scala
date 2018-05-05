

class PlayBowlTest  extends org.scalatest.FunSuite {

  def testSameRolls(ball: Int, expected: Int, max: Int=20) = {
    val game = new Bowl
    for (i <- 1 to max) game.roll(ball)
    val scr = game.score
    assert(scr == expected, "Score="+scr)
  } 
  
  def spareBalls(game: Bowl) = {
    game.roll(6)
    game.roll(4)
  }

  def repeatBalls(count: Int, ball: Int, game: Bowl) =
    for (i <- 1 to count) game.roll(ball)

  test("scoreAll_0"){
    def scoreAll_0 =
      testSameRolls(0, 0)
    scoreAll_0
  }


  test("scoreGame"){
    def scoreGame = {
      val game = new Bowl
      for (i <- Seq(2, 3,   3, 5,   2, 8,   4, 6,   10,   1, 1,   1, 9,   5, 5,   10,   4, 3,   7)) game.roll(i)
      val scr = game.score
      assert(scr == 120, "Score="+scr)
    }
    scoreGame
  } 
    
  test("scoreAll_1"){
    def scoreAll_1 =
      testSameRolls(1, 20)
    scoreAll_1
  }

  test("testIncomplete"){
    def testIncomplete =
      testSameRolls(1,   18, 18)
    testIncomplete
  }  
    
  test("scoreOneSpare"){
    def scoreOneSpare = {
      val game = new Bowl
      spareBalls(game)
      repeatBalls(18, 1, game)
      val scr = game.score
      assert(scr == 29, "Score="+scr)    
    }
    scoreOneSpare
  }

  test("scoreSpareInFrame3"){
    def scoreSpareInFrame3 = {
      val game = new Bowl
      repeatBalls(4, 0, game)
      spareBalls(game)
      repeatBalls(10, 1, game)
      val scr = game.score
      assert(scr == 10 + 1 + 10, "Score="+scr)
    }
    scoreSpareInFrame3
  }


  test("scoreStrikeInFrame3"){
    def scoreStrikeInFrame3 = {
      val game = new Bowl
      repeatBalls(4, 0, game)
      game.roll(10)
      repeatBalls(10, 7, game)
      val scr = game.score
      assert(scr == 10 + 14 + 10 * 7 , "Score="+scr) 
    }
    scoreStrikeInFrame3
  }

  test("scoreAllStrike"){
    def scoreAllStrike = {
      val game = new Bowl
      repeatBalls(12, 10, game)
      val scr = game.score
      assert(scr == 300, "Score="+scr)
    }
    scoreAllStrike
  }

}  
  
  
