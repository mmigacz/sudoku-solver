package sudoku

import scala.util.{Failure, Success}


/**
 * Backtracking sudoku solver
 */
trait Solver extends SudokuDef {

  /**
   * Represents a current stage of sudoku.
   *
   * @param grid current sudoku grid
   * @param x row of field for which solitions are checked
   * @param y column of field for which solitions are checked
   */
  case class Board(grid: Grid, x: Int = 0, y: Int = 0) {

    /**
     * Update board's active field
     * @param v a number from 1 to 9
     * @return a copy of this board with updated field at (x, y)
     */
    def insert(v: Int): Board = Board(grid.updated(x, grid(x).updated(y, v)), x, y)

    /**
     * Check if current field can be updated with given value
     * @param value a number from 1 to 9
     * @return true if no numbers exists in same rows & same columns same as (i) & 3x3 zone (i) is currently in
     */
    def canInsert(value: Int): Boolean = {
      !(possibleIndexes.toStream exists (i =>
        grid(x)(i) == value || grid(i)(y) == value ||
          grid(x / ZoneSize * ZoneSize + i % ZoneSize)(y / ZoneSize * ZoneSize + i / ZoneSize) == value))
    }

    /**
     * Solve sudoku board
     * @return solved board with non empty grid, or unsolved board with EmptyGrid if the solution can't be found
     */
    def solve(): Board = {
      if (grid(x)(y) != EmptyField) {
        next()
      } else {
        (for {
          v <- possibleValues
          if canInsert(v)
        } yield {
          insert(v).next()
        }).toStream.dropWhile(_.grid == EmptyGrid).headOption.getOrElse(Board(EmptyGrid, x, y))
      }
    }

    /**
     * Move the current filed to the next state.
     * @return a copy of this board with updated field position
     */
    def next(): Board = {
      (x, y) match {
        case (MaxIndex, MaxIndex) => this
        case (MaxIndex, _) => Board(grid, 0, y + 1).solve()
        case _ => Board(grid, x + 1, y).solve()
      }
    }

  }

  /**
   * Counted sudoku solution
   */
  lazy val solution: Grid = {
    startGrid match {
      case Failure(e) =>
        printf("Error parse initial grid")
        EmptyGrid

      case Success(g) =>
        Board(g).solve().grid
    }
  }


}
