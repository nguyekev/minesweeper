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
            int arr[][]= new int[row][col];
            for(int i = 0 ; i < row; i++) {
                char [] field = theInput.nextLine().toCharArray();
                for(int j = 0; j < field.length; j++) {
                    if(field[j] == '*') {
                        adjacentAlert(arr, i, j);
                    }
                }
            }
            fPrint(fCase, arr);

            row = theInput.nextInt();
            col = theInput.nextInt();
            if(!(row == 0 || col == 0))
                System.out.println();
            fCase++;
        }
    }

    private static void adjacentAlert(int arr[][], int a, int b) {
        try {
            arr[a][b] = -1;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(arr[a-1][b-1] == -1))
                arr[a-1][b-1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(arr[a-1][b] == -1))
                arr[a-1][b]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(arr[a-1][b+1] == -1))
                arr[a-1][b+1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(arr[a][b-1] == -1))
                arr[a][b-1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(arr[a][b+1] == -1))
                arr[a][b+1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(arr[a+1][b-1] == -1))
                arr[a+1][b-1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(arr[a+1][b] == -1))
                arr[a+1][b]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            if(!(arr[a+1][b+1] == -1))
                arr[a+1][b+1]++;
        } catch (ArrayIndexOutOfBoundsException e) {}
    }
    private static void fPrint(int fCase, int arr[][]) {
        System.out.println("Field #"+ fCase +":");
        for(int a = 0; a < arr.length;a++) {
            for(int b = 0; b < arr[a].length; b++) {
                if(arr[a][b] == -1)
                    System.out.print("*");
                else
                    System.out.print(arr[a][b]);
            }
            System.out.println();
        }
    }
}
