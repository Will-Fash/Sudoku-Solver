# Sudoku Solver

A sudoku solver using the backtracking method
The program is a sudoku solver, essentially it takes in the size of the grid, the possible solution values and then the sudoku puzzle itself. 
The program uses a recursive backtracking approach to solve sudoku problems that are passed to it. 

## Program Flow Step by Step:
•	MultiDimensional ArrayLists were used to store the sudoku puzzle and an ArrayList was used to store the possible solution values.
•	There are methods to validate the sudoku puzzle input and the possible solution values.
•	There are methods to check for sudoku constraints i.e duplicate values in rows, columns and boxes.
•	There is the solve method and the print method.

There are only 2 classes in the program a Sudoku class and a main class.
**Sudoku Class**: This is the main class that handles the solving of sudoku puzzles. 
**Main Class**: This takes an object of the sudoku class and also interacts with the user.

## DataStructure:

The major Datastructure were arraylists and arrays. These were used to arrange data for easier manipulation.

## Assumptions.

The size of the grid is a perfect square 
The size of the puzzle is a square of the gridsize
A boxsize is the square root of the gridsize
The puzzle has a solution
There are no repetitions in the possible solutions values
Must be able to solve a valid sudoku puzzle

## Key Algorithms and Design Elements:
The program makes use of recursive backtracking.
The programs uses a multidimensional array list to store and manipulate the puzzle.
The program takes user input for sudoku puzzle line by line so as to make it easier for the user to correct input mistakes.
The program validates user inputs for both the possible solution values and the sudoku puzzle
The program prints out entered values so the user can cross-check what they entered
The program formats the solution into their boxes for easier readability.
The program makes use of a lot of helper variables to perform some of its functional and non-functional requirements.
