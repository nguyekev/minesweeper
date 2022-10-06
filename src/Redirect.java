import java.util.Scanner;
import java.io.File;
import java.io.*;
/*
Simple example to allow demonstration of file redirection.
The example can also read a command line argument and open
a file and read from its contents instead of the keyboard
(System.in)
File redirection works in any OS as follows:
$java ProgramName < input_file.txt > output_file.txt
The above command will have the program read input from the specified
input file instead of the keyboard. The output from the program will
be redirected from the monitor/console/System.out to the specified
output file.
The < is used to redirect input, the > is used to redirect output.
They are SUPER handy for testing your code without having to set up code
to work with files. Input redirection also allows you to avoid tediously
typing in data over and over again to test your program code when it gets
input from the user.
-----------
Command line arguments can be checked for and used as necessary via
the args parameter to main (public static void main(String [] args)).
They are a way to provide initial or startup information to your program.
Most programs that can be run from the command line (e.g. the java compiler
(javac.exe)
and the java interpreter (java.exe)) are designed to accept a wide variety
of command line arguments.
*/
public class Redirect{
    public static void main(String [] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);

        if (args.length == 1){
            //assuming if there is 1 argument on the command line
            // it is the name of a file to use for testing
            //input = new Scanner(new File(args[0]));
            input = new Scanner(new File(args[0]));
        }

        int val;
        System.out.print("Enter an int: ");
        val = input.nextInt();
        System.out.println("You entered: " + val);

    }
}