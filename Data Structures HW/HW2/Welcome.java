import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * This class is the answer to HW02. It reverses an inputed name, and it creates 
 * a triangle of numbers.
 * 
 * @author Max
 */
public class Welcome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to CS 201: Data Structures!");
        Scanner scan = new Scanner(System.in);

        // Ask Name
        System.out.print("What is your name: ");
        String name = scan.nextLine();

        // Ask Number- If an exception is thrown, the program will quit.
        System.out.print("Enter an integer: ");
        int num = 0;
        try {
            num = scan.nextInt();
        }
        catch (InputMismatchException e){
            System.err.println("You must enter an integer");
            System.exit(1);
        }
        
        // Welcome & Reverse name
        System.out.println("\nWelcome " + name);
        StringBuilder s = new StringBuilder(name);
        System.out.print("Your name backwards is " + s.reverse());

        // Positive Number Triangle
        StringJoiner sj;
        if (num > 0) {
            for (Integer col = 0; col <= num; col++) {
                sj = new StringJoiner(",");
                for (Integer row = 0; row < col; row++) {
                    sj.add(col.toString());
                }
                System.out.println(sj.toString());
            }
        }

        // Negative Number Triangle
        if (num < 0) {
            for (Integer col = 0; col >= num; col--) {
                sj = new StringJoiner(",");
                for (Integer row = 0; row > col; row--) {
                    sj.add(col.toString());
                }
                System.out.println(sj.toString());
            }
        }

        // Zero Triangle
        if (num == 0) {
            System.out.println("Cannot print a triangle of height 0");
        }
    }
}
