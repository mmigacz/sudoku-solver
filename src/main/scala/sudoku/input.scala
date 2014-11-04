package sudoku

import scala.io.Source

/**
 * This trait parses sudoku unsolved grid from csv string
 */
trait InputStringParser extends SudokuDef {
  val input: String

  lazy val inputLines = {
    input.split("\n").toVector
  }
}

/**
 * This trait parses sudoku unsolved grid from csv file
 */
trait InputFileParser extends SudokuDef {
  val filePath: String

  lazy val inputLines = {
    Source.fromFile(filePath).getLines().toVector
  }
}

