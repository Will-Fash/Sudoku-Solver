package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int size; //Size of sudoku grid
        String grid = ""; // Problem characters to fill Sudoku Grid with
        String fillCharacters; //Possible solution characters to solve sudoku with


        Scanner input = new Scanner(System.in); //Object to read in user input to variables


        System.out.println("Enter the size of the puzzle:"); //Requesting size from user
        size = input.nextInt(); //Storing user input in size
        System.out.println();


        System.out.println("Enter the characters to be used to fill the puzzle:"); //Requesting possible solutioin characters from the user
        fillCharacters = input.nextLine(); //Storing user input in a variable
        fillCharacters = input.nextLine();
        System.out.println();

        System.out.println("Enter the unsolved sudoku puzzle " + size + " characters at a time" +
                "\nand hit enter after each entry:"); //Requesting a number of problem characters at a time from user
        String temp = input.nextLine();
        grid += temp;


        int count = 1;
        while (count < size){
            temp = input.nextLine(); // Storing problem characters in a temp variable
            grid += temp; // concatenating grid variable with temp variable to store all problem characters
            count++;
        }




        System.out.println();


        Sudoku yo = new Sudoku(9, "53..7...." + "6..195..." + ".98....6." + "8...6...3" + "4..8.3..1" + "7...2...6" + ".6....28." + "...419..5" + "....8..79", "123456789");
        Sudoku answer = new Sudoku(size, grid, fillCharacters); //Object of Sudoku with the initialized variables passed into the constructor of the sudoku class
        answer.solution(); //Calling method to solve sudoku
    }
}
