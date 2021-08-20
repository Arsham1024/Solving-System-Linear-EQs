import java.util.ArrayList;
import java.util.Arrays;

public class Jacobi {
   static final int MAX = 50; //The maximum amount of iterations we allow
   private double [][] augment;
   private double [] starting_Values;
   private double stopping_Error;
   private int n_LinearEQs;

   public double[][] getAugment() {
      return augment;
   }

   public double[] getStarting_Values() {
      return starting_Values;
   }

   public double getStopping_Error() {
      return stopping_Error;
   }

   public int getN_LinearEQs() {
      return n_LinearEQs;
   }

   public Jacobi(double [][] augment, double [] starting_values, double stopping_Error, int n_LinearEQs){
      this.augment = augment.clone();
      this.starting_Values = starting_values.clone();
      this.stopping_Error = stopping_Error;
      this.n_LinearEQs = n_LinearEQs;
   }

   public void solve_Jacobi(){
      double current_Error = 0.0;
      int n = getN_LinearEQs();
      double [][] copyAugment = getAugment();
      double [] X_values = getStarting_Values();
      double desired_Error = getStopping_Error();

      double [] X_PlaceHolder = new double[n];

      //Need to run this method 50 times maximum
      for (int i = 0; i < MAX; i++) {
         current_Error = 0.0;

         for (int j = 0; j < n ; j++) {
            double sum = 0.0;

            for (int k = 0; k < n ; k++) {
               //use the starting values to calculate sum of everything except for the x1 for the first eq
               //And sum of everything except x2 for second and etc.
               //Then we bring the sum to the other side and subtract from b.
               // we need to skip the iteration where j and k are the same because X(j) is what we want to solve for.
               if (j != k) {
                  sum += copyAugment[j][k] * X_values[k];
               }
               else continue;
            }
            // Solving for the current X
            // copyAugment[j][n] = b value
            // sum = all the other terms values
            // copyAugment[j][j] = the current X's multiple
            double current_X_Value = (copyAugment[j][n] - sum) / copyAugment[j][j];

            // Calculating the relative error
            /** need to impliment L2 norm here */
            double relative_Error = Math.abs((X_values[j] - current_X_Value) / current_Error);

            //replacing the current error with relative error that we calculated.
            if (relative_Error > current_Error) current_Error = relative_Error;

            //Putting these current xes into a place holder
            X_PlaceHolder[j] = current_X_Value;
         }

         // now per Jacobi method we replace the starting X values with calculated X values.
         // replacing one x at a time. This will be useful in Gauss-Sidle later.
         X_values = X_PlaceHolder.clone();

         //printing each iteration solution
         System.out.printf("\niteration %d: {", i+1);
         for(int v=0; v<n; v++)
         {
            System.out.printf ("%.4f ", X_values[v]);
         }
         System.out.print("\b}");

         if(current_Error < desired_Error){
            System.out.println("\nconverged at the above iteration.\n\n");
            return;
         }
      }
      //if we reach here it means did not converge within 5 iterations
      System.out.println("\nThese equations do not converge within 50 iterations and above is the 50th iteration.");
      //insert the quations
   }
}
