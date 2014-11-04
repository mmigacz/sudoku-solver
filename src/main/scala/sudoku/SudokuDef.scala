package sudoku

import scala.util.Try

/**
 * Sudoku setup
 */
trait SudokuDef {

  val GridSize = 9
  val MaxIndex = 8
  val ZoneSize = 3
  val EmptyField = 0

  val possibleIndexes = 0 to MaxIndex
  val possibleValues = 1 to GridSize


  val CsvDelimiter = ","

  type Grid = Vector[Vector[Int]]

  val EmptyGrid: Grid = Vector[Vector[Int]]()

  val inputLines: Vector[String]


  def parseGrid(): Try[Grid] = Try {
    inputLines.map(_.split(CsvDelimiter).toVector.map(_.toInt))
  }

  /**
   * Given unsolved Sudoku with 0's representing blanks. Looks like this:
   *
   * 0,3,5,2,9,0,8,6,4
   * 0,8,2,4,1,0,7,0,3
   * 7,6,4,3,8,0,0,9,0
   * 2,1,8,7,3,9,0,4,0
   * 0,0,0,8,0,4,2,3,0
   * 0,4,3,0,5,2,9,7,0
   * 4,0,6,5,7,1,0,0,9
   * 3,5,9,0,2,8,4,1,7
   * 8,0,0,9,0,0,5,2,6
   */
  lazy val startGrid: Try[Grid] = parseGrid()

}
