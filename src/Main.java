import java.util.Scanner;
public class Main {
    public static void main(String[] theArgs){
        Scanner input = new Scanner(System.in);
        mineSweeper(input);
    }

    private static void mineSweeper(Scanner theInput) {
        int row = theInput.nextInt();
        int col = theInput.nextInt();
        int fCase = 1;
        while(!(row == 0 || col == 0)) {
            theInput.nextLine();
            int [][] field = new int[row][col];
            for(int i = 0 ; i < row; i++) {
                char [] fieldRow = theInput.nextLine().toCharArray();
                for(int j = 0; j < field.length; j++) {
                    if(fieldRow[j] == '*') {
                        adjacentAlert(field, i, j);
                    }
                }
            }
            fPrint(fCase, field);

            row = theInput.nextInt();
            col = theInput.nextInt();
            if(!(row == 0 || col == 0))
                System.out.println();
            fCase++;
        }
    }

    private static void adjacentAlert(int [][] theField, int theRow, int theCol) {
        try {
            theField[theRow][theCol] = -1;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(theField[theRow-1][theCol-1] == -1))
                theField[theRow-1][theCol-1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(theField[theRow-1][theCol] == -1))
                theField[theRow-1][theCol]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(theField[theRow-1][theCol+1] == -1))
                theField[theRow-1][theCol+1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(theField[theRow][theCol-1] == -1))
                theField[theRow][theCol-1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(theField[theRow][theCol+1] == -1))
                theField[theRow][theCol+1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(theField[theRow+1][theCol-1] == -1))
                theField[theRow+1][theCol-1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(theField[theRow+1][theCol] == -1))
                theField[theRow+1][theCol]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(theField[theRow+1][theCol+1] == -1))
                theField[theRow+1][theCol+1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
    }
    private static void fPrint(int theFieldCase, int [][] theField) {
        System.out.println("Field #"+ theFieldCase +":");
        for(int i = 0; i < theField.length;i++) {
            for(int j = 0; j < theField[i].length; j++) {
                if(theField[i][j] == -1)
                    System.out.print("*");
                else
                    System.out.print(theField[i][j]);
            }
            System.out.println();
        }
    }
}
