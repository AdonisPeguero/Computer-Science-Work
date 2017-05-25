
// CPS 2231-03, Adonis Peguero, peguenoa@kean.edu 
import java.util.Scanner;
public class Program3 {
	public static void main(String[] args) {
	
	System.out.println("Please enter a 4-by-3 matrix row by row:");
    double[][] m=createArray();
	double[] colSum=new double[4];
	System.out.println("The input matrix is:");
	for (int i=0;i<4;i++){	
	colSum[i]=sumColumn(m,i);
	
	}
	printResult(m,colSum);
	System.out.println("");
    String G = maximumNumber(m);
	System.out.println(G);
	String U = minimumNumber(m);
	System.out.println(U);
	
	System.out.println("Program 3 is developed by Adonis Peguero email: peguenoa@kean.edu");
	}
	
	public static String minimumNumber(double[][] h ) {
		double minimum = h[0][0];
		String S ="";
		for (int c = 0; c < 4; c++){
		
		for (int row = 0; row < h.length; row++){
			if(h[row][c]<minimum){
				minimum=h[row][c];
				S="The minimum number is "+h[row][c]+" at row "+row+", column "+c;
			}
			
			else {
				minimum = h[0][0];
				S="The minimum number is "+h[0][0]+" at row 0, column 0";
			}
		}
		}
		return S;
		
	}
	
	public static String maximumNumber(double[][] h ) {
		double max = h[0][0];
		String S ="";
		for (int c = 0; c < 4; c++){
		
		for (int row = 0; row < h.length; row++){
			if(h[row][c]>max){
				max=h[row][c];
				S="The maximum number is "+h[row][c]+" at row "+row+", column "+c;
			}
		}
			  
		}
		return S;
	}
	
	public static double[][] createArray() {
		Scanner input = new Scanner(System.in);
		double[][] matrix= new double[3][4];
		for (int row = 0; row < matrix.length; row++) {
			  for (int column = 0; column < matrix[row].length; column++) {
			    matrix[row][column] = input.nextDouble(); 
			  }
			}

		return matrix;
	}
	
	public static double sumColumn(double[][] m, int columnIndex) {
		double total = 0;
		for (int row = 0; row < m.length; row++)
			   total += m[row][columnIndex];
		return total;
	}
	
	
	public static void printResult(double[][] m, double[] sum) {
	  int column,row;
	   for ( row = 0; row < m.length; row++) {
		   System.out.print("      ");
		   for ( column = 0; column < sum.length; column++) {
			
		      System.out.printf(" %6.1f ", m[row][column] );
		     
		  }
		   System.out.println();
		  
		} 
	   System.out.print("Sum:  ");
	   for ( column = 0; column < sum.length; column++)
		   System.out.printf( "%7.1f ",sum[column]);
	}
}