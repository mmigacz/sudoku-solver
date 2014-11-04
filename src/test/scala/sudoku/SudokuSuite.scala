package sudoku

/**
 * Sudoku tests
 */

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SudokuSuite extends FunSuite {

  trait SolutionChecker extends Solver with InputStringParser with SolutionStringSaver


  test("Solving sudoku 1") {
    val expected =
      """1,3,5,2,9,7,8,6,4
        |9,8,2,4,1,6,7,5,3
        |7,6,4,3,8,5,1,9,2
        |2,1,8,7,3,9,6,4,5
        |5,9,7,8,6,4,2,3,1
        |6,4,3,1,5,2,9,7,8
        |4,2,6,5,7,1,3,8,9
        |3,5,9,6,2,8,4,1,7
        |8,7,1,9,4,3,5,2,6""".stripMargin

    new SolutionChecker {
      val input =
        """0,3,5,2,9,0,8,6,4
          |0,8,2,4,1,0,7,0,3
          |7,6,4,3,8,0,0,9,0
          |2,1,8,7,3,9,0,4,0
          |0,0,0,8,0,4,2,3,0
          |0,4,3,0,5,2,9,7,0
          |4,0,6,5,7,1,0,0,9
          |3,5,9,0,2,8,4,1,7
          |8,0,0,9,0,0,5,2,6""".stripMargin

      assert(csv == expected)
    }
  }


  test("Solving sudoku 2") {
    val expected =
      """5,6,4,8,7,3,2,1,9
        |3,2,1,9,6,5,8,7,4
        |8,9,7,4,2,1,6,5,3
        |9,8,3,5,1,7,4,6,2
        |4,7,6,3,9,2,1,8,5
        |2,1,5,6,8,4,3,9,7
        |1,3,8,2,5,9,7,4,6
        |7,5,2,1,4,6,9,3,8
        |6,4,9,7,3,8,5,2,1""".stripMargin

    new SolutionChecker {
      val input =
        """0,6,0,8,0,0,2,0,9
          |3,2,1,0,6,0,0,7,0
          |0,9,0,0,0,0,6,5,3
          |0,0,0,0,1,7,0,6,0
          |4,0,0,3,0,2,0,0,5
          |0,1,0,6,8,0,0,0,7
          |1,3,0,0,0,9,0,4,0
          |0,5,0,0,4,0,9,3,8
          |6,0,9,0,0,8,0,0,0""".stripMargin

      assert(csv == expected)
    }
  }

  test("Unresolvable sudoku") {
    val expected = ""

    new SolutionChecker {
      val input =
        """7,6,0,8,0,0,2,0,9
          |3,2,1,0,6,0,0,7,0
          |0,9,0,0,0,0,6,5,3
          |0,0,0,0,1,7,0,6,0
          |4,0,0,3,0,2,0,0,5
          |0,1,0,6,8,0,0,0,7
          |1,3,0,0,0,9,0,4,0
          |0,5,0,0,4,0,9,3,8
          |6,0,9,0,0,8,0,0,0""".stripMargin

      assert(csv == expected)
    }
  }

}
