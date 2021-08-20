import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("please select one of the following:\n" +
               "\t1. import equations from a file.\n" +
               "\t2. input values of each equation.\n" +
               "\t3. Exit.");
            System.out.print("select by typing 1 or 2: ");
            int option = keyboard.nextInt();

            switch (option) {
                case 1:
                    fileImportMethod();
                    break;
                case 2:
                    userInputMethod();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    userInputMethod();
                    break;
            }
        }
    }

    private static void userInputMethod() {
        //        number of equations
        int n_LinearEQs = 0;
        Scanner userInput = new Scanner(System.in);
        do {
            System.out.print("Enter the number of linear equations you want to solve (must be between 2-10): ");
            n_LinearEQs = userInput.nextInt();
            // For now do less than 10, do extra credit after!
        }while (n_LinearEQs <=1 || n_LinearEQs >= 11);

        //---

        //Augmented matrix, nXn+1 for b value
        double [][] augment = new double[n_LinearEQs][n_LinearEQs+1];

        //The initial value used for the first itteration usually 0,0,0 in case of three equations.
        double [] starting_Values = new double [n_LinearEQs];

        //The error the user can tolerate.
        double stopping_ErrorValue;

        //Ask for user to input equations
        System.out.println("input values for each row including b value: ");
        for (int i = 0; i < n_LinearEQs ; i++) {
            for (int j = 0; j <n_LinearEQs+1 ; j++) {
                augment[i][j] = userInput.nextInt();
            }
        }
        userInput.nextLine();

//        Ask for the starting values
        System.out.print("Enter the starting values below:\n");
        for (int i = 1; i <= n_LinearEQs ; i++) {
            System.out.printf("X%d: ", i);
            starting_Values[i-1] = userInput.nextDouble();
        }

        //Ask for stopping error value
        System.out.print("enter the stopping error: ");
        stopping_ErrorValue = userInput.nextDouble();


        drawLine();
        System.out.println("Calculating the valuses using Jacobi method: ");
        Jacobi jb = new Jacobi(augment, starting_Values, stopping_ErrorValue, n_LinearEQs);
        jb.solve_Jacobi();

        drawLine();
        System.out.println("Calculating values using Gauss-Sidle method: ");
        Gauss_Sidle gs = new Gauss_Sidle(augment, starting_Values, stopping_ErrorValue, n_LinearEQs);
        gs.solve_Gauss_Sidle();
    }

    public static void fileImportMethod() throws IOException {
        File f = new File("C:\\Users\\arsha\\Desktop\\ArshamMehrani_CS3010_P1\\src\\inputs.txt");

        Scanner sc = new Scanner(f);
        int num_EQs = 0;


        //figure out the number of equations
        while(sc.hasNextLine()) {
            sc.nextLine();
            num_EQs++;
        }

        //if the number of equations is too high or too low
        if (num_EQs > 10 || num_EQs < 2){
            System.out.println("The number of euqations are too low or too high.");
            System.exit(0);
        }

        //creating the augmented matrix
        double [][] augment = new double[num_EQs][num_EQs+1];
        //reset scanner
        Scanner populate = new Scanner(f);
        for (int i = 0; i < num_EQs ; i++) {
            for (int j = 0; j < num_EQs+1 ; j++) {
                augment[i][j] = populate.nextInt();
            }
        }

        Scanner keyboard = new Scanner(System.in);
        //Ask for the error
        System.out.println("what is the desired error to reach?");
        double stopping_error = keyboard.nextDouble();

        //ask for the initial values of X vector
        double [] starting_values = new double[num_EQs];
        System.out.print("Enter the starting values below:\n");
        for (int i = 1; i <= num_EQs ; i++) {
            System.out.printf("X%d: ", i);
            starting_values[i-1] = keyboard.nextDouble();
        }

        //make the instances of each class
        drawLine();
        System.out.println("Now calculating the equations using the Jacobi method: ");
        Jacobi js = new Jacobi(augment, starting_values, stopping_error, num_EQs);
        js.solve_Jacobi();

        drawLine();
        System.out.println("Now calculating the equations using the Gauss-sidle method: ");
        Gauss_Sidle gs = new Gauss_Sidle(augment, starting_values, stopping_error, num_EQs);
        gs.solve_Gauss_Sidle();

    }
    public static void drawLine(){
        System.out.println();
        for (int i = 0; i <40 ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
