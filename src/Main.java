/**
 * Kevin Nguyen
 * TCSS 360A
 * Assignment 1: Minesweeper
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("minesweeper_input.txt"));
        int row  = input.nextInt();
        int col = input.nextInt();
        int fieldCase = 1;
        while (row != 0 || col != 0){
            char[][] field = new char[row][col];
            for (int i = 0; i < row; i++){
                String line = input.next();
                for (int j = 0; j < col; j++){
                    field[i][j] = line.charAt(j);
                }
            }
            System.out.println("Field #" + fieldCase + ":");
            for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    if (field[i][j] == '*'){
                        System.out.print("*");
                    } else {
                        int count = 0;
                        if (i > 0 && j > 0 && field[i-1][j-1] == '*'){
                            count++;
                        }
                        if (i > 0 && field[i-1][j] == '*'){
                            count++;
                        }
                        if (i > 0 && j < col-1 && field[i-1][j+1] == '*'){
                            count++;
                        }
                        if (j > 0 && field[i][j-1] == '*'){
                            count++;
                        }
                        if (j < col-1 && field[i][j+1] == '*'){
                            count++;
                        }
                        if (i < row-1 && j > 0 && field[i+1][j-1] == '*'){
                            count++;
                        }
                        if (i < row-1 && field[i+1][j] == '*'){
                            count++;
                        }
                        if (i < row-1 && j < col-1 && field[i+1][j+1] == '*'){
                            count++;
                        }
                        System.out.print(count);
                    }
                }
                System.out.println();
            }
            row = input.nextInt();
            col = input.nextInt();
            if (row != 0 || col != 0){
                System.out.println();
            }
            fieldCase++;
        }
    }
}