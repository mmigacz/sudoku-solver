package sudoku

import java.io.File

import com.github.tototoshi.csv.CSVWriter


/**
 * This trait converts solution grid into csv string
 */
trait SolutionStringSaver extends Solver {

  lazy val csv = solution.map(_.mkString(CsvDelimiter)).mkString("\n")

}


/**
 * This trait save solution grid into given file
 */
trait SolutionFileSaver extends Solver {

  def saveCsv(outputFile: String): Unit = {
    val writer = CSVWriter.open(new File(outputFile))
    writer.writeAll(solution)
  }

}


