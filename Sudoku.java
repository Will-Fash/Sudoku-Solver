package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {

    private int gridSize; // Gridsize
    private int boxSize; // Boxsize
    private ArrayList<String> fillValues = new ArrayList<>(); // ArrayList values to hold possible solution values
    private ArrayList<ArrayList> sGrid = new ArrayList<>(gridSize); // ArrayList to hold sudoku puzzle
    private String [] interim; // Temporary array to hold String values
    private boolean valuesChecked; // Variable to hold the result of the valueChecked method
    private boolean inputChecked; // Variable to hold the result of the inputChecked method

    public Sudoku(int n, String input, String fillValues) {

        this.interim = inputArray(input); // Convert the input string to an array and store it
        this.gridSize = n; // Gridsize is passed into the constructor
        this.valuesChecked = valuesChecker(fillValues); // ValuesChecked holds the return of the valueChecker method
        this.inputChecked = inputChecker(input); // inputChecked holds the return of the inputChecker method
        this.boxSize = (int)sqrt(this.gridSize); // Boxsize is squareroot of gridsize
        for (int i = 0; i < fillValues.length(); i++) {
            this.fillValues.add(String.valueOf(fillValues.charAt(i)));
        } // Passing the characters in the fillvalues variable to the fillvalues arraylist
        for(int i = 0; i < this.gridSize; i++){
            this.sGrid.add(new ArrayList<String>(this.gridSize));
        } //Making a multidimensional arraylist to hold the sudoku puzzle

        int count = 0;
        for(int i = 0; i < this.gridSize; i++){
            for(int j = 0; j < this.gridSize; j++){
                this.sGrid.get(i).add(this.interim[count]);
                count = count + 1;
            }
        } // Filling the multidimensional arraylist with values from the string input

    }


    public void solution(){

        System.out.println("The values you entered to fill the sudoku puzzle are:"); // To show user values they entered for solution
        printFIllValues(); // Method to print values to solve the puzzle
        System.out.println();
        System.out.println("\nThe sudoku puzzle you've given is:"); // To show users the sudoku puzzle they entered
        sGridPrint(); // Method to print out the puzzle they passed in
        System.out.println();

        if(valuesChecked == true && inputChecked == true){ //Check if the values passed in are correct
            if( !solve(0, 0)){
            System.out.println("Solution not found!"); //  No solution if it can't solve sudoku puzzle
            } else {
                System.out.println("The solution is:");
                sGridPrint(); // Print the solved sudoku puzzle
            }
        } else{ // if values fail the check constraint print this out
            System.out.println("Something is wrong with the sudoku puzzle or the possible values to be filled into the puzzle.");
        }
    }

    // Method to solve Sudoku
    private boolean solve(int r, int c){

        if(r == gridSize){
          if( (c += 1) == gridSize){
                return true;
            }
        }// Base condition to stop recursion

        if( r == gridSize){
            r = 0;
        } // it should go to the next column and turn the index of the row to zero

        if(!sGrid.get(r).get(c).equals(".")){
            return solve(r + 1, c);
        } // It should skip cells that aren't dots


        for(int i  =  0; i < fillValues.size(); i++ ){
            if(constraintChecker(r, c, fillValues.get(i))){
                sGrid.get(r).set(c,fillValues.get(i)); // if it passes constraint check it should set the index to the proper value from fill values

                if(solve(r + 1, c)){
                    return true;
                } // it should try to solve the next cell
            }

        }

        sGrid.get(r).set(c,"."); // if there's no answer it should set it back to dot (in essence backtracking)
        return false;
    }

    // Checks to satisfy the constraints of Sudoku
    private boolean constraintChecker(int c, int r, String variable){

        for(int i = 0; i < gridSize; i++ ){
            if(sGrid.get(i).get(r).equals(variable)){
                return false;
            }
        } // Loops to find a duplicate value in the column


        for(int j = 0; j < gridSize; j++){
            if(sGrid.get(c).get(j).equals(variable)){
                return false;
            } // Loops to find a duplicate value in the row
        }


        int brLimit = (c / boxSize) * boxSize;
        int bcLimit = (r / boxSize) * boxSize;

        for(int i = 0; i < boxSize; i++){
            for(int j = 0; j < boxSize; j++){
                if(variable.equals(sGrid.get(brLimit + i).get(bcLimit + j ))){
                    return false;
                }
            }
        } // Loops to find a duplicate value in a box

        return true;
    }

    // Method applied on gridsize to get boxsize
    private double sqrt(int num) {
        double tempNum;

        double sRoot = num / 2;

        do {
            tempNum = sRoot;
            sRoot = (tempNum + (num / tempNum)) / 2;
        } while ((tempNum - sRoot) != 0);

        return sRoot;
    }

    // Method to validate input for sudoku puzzle
    public boolean inputChecker(String input){

        double N = Math.pow(gridSize,2);
        if(N == input.length()){
            return true;
        } else {
            return false;
        }

    }

    // Method to validate the values provided as solution
    private boolean valuesChecker(String input){

        if(input.length() != gridSize){
            return false;

        } else if(input.length() == gridSize){

            char[] arr = input.toCharArray();
            Arrays.sort(arr);

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] != arr[i + 1]) {
                    continue;
                }else {
                    return false;
                }
            }
        }

        return true;
    }

    // Mehod to convert input String to array
    private String[] inputArray(String input){

        String [] temp = new String[input.length()];
        for(int i = 0; i < input.length(); i++){
            temp[i] = input.substring(i,i+1);
        }

        return temp;
    }

    // Method to print out Solved Sudoku
    public void sGridPrint(){
        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                System.out.print(sGrid.get(i).get(j));
                if(j == gridSize - 1){
                    System.out.println();
                }
                if(j == (boxSize - 1)){
                    System.out.print("  ");
                }
                if(j == (boxSize * 2 - 1) && ((boxSize * 2 - 1) < (gridSize - 1))){
                    System.out.print("  ");
                }
                if(j == (boxSize * 3 - 1) && ((boxSize * 3 - 1) < (gridSize - 1))){
                    System.out.print("  ");
                }
                if(j == (boxSize * 4 - 1) && ((boxSize * 4 - 1) < (gridSize - 1))){
                    System.out.print("  ");
                }
                if(j == (boxSize * 5 - 1) && ((boxSize * 5 - 1) < (gridSize - 1))){
                    System.out.print("  ");
                }
                if(i == (boxSize - 1) && j == (gridSize - 1)){
                    System.out.println();
                }
                if(i == (boxSize * 2 - 1) && j == (gridSize - 1)){
                    System.out.println();
                }
                if((i == (boxSize * 3 - 1) && (boxSize * 3 - 1 < (gridSize - 1))) && j == (gridSize - 1)){
                    System.out.println();
                }
                if((i == (boxSize * 4 - 1) && (boxSize * 4 - 1 < (gridSize - 1))) && j == (gridSize - 1)){
                    System.out.println();
                }
                if((i == (boxSize * 5 - 1) && (boxSize * 5 - 1 < (gridSize - 1))) && j == (gridSize - 1)){
                    System.out.println();
                }// Some formating for readability
            }
        }
        System.out.println();
    }

    // Method to print out the values provided as solution.
    public void printFIllValues(){
        for(String i: fillValues)
            System.out.print(i);
    }


}
