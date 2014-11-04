package sudoku

/**
 * Sudoku application. It takes two parameters:
 * input csv file with unsolved sudoku
 * output csv file, where solution is saved
 */
object Sudoku {

  def main(args: Array[String]) {
    args match {

      case Array(src, dst) =>
        val solver = new Solver with InputFileParser with SolutionFileSaver with SolutionStringSaver {
          override val filePath: String = src
        }
        solver.saveCsv(dst)

      case _ =>
        println("Usage: app srcFilePath dstFilePath")

    }
  }

}
