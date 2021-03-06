sudoku-solver
=============

Simple scala sudoku solver

Implementation of backtracking algorithms described on Wikipedia http://en.wikipedia.org/wiki/Sudoku_solving_algorithms

Main takes two parameters:
* srcFile.csv -  a CSV input file consisting of an unsolved Sudoku with 0's representing blanks
* dstFile.csv - output a CSV file with the solved Sudoku

*Example srcFile.csv* 
```
0,3,5,2,9,0,8,6,4
0,8,2,4,1,0,7,0,3
7,6,4,3,8,0,0,9,0
2,1,8,7,3,9,0,4,0
0,0,0,8,0,4,2,3,0
0,4,3,0,5,2,9,7,0
4,0,6,5,7,1,0,0,9
3,5,9,0,2,8,4,1,7
8,0,0,9,0,0,5,2,6
```
### Running
* you need scala and sbt
* clone repo 
* change directory to sudoku-solver
* run **sbt**

#### Running solver
```sbt run srcFile.csv dstFile.csv```

#### Tests
```sbt test```
