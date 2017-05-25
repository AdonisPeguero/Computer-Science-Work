// CPS 2231-03, Adonis Peguero, peguenoa@kean.edu 
import java.util.Scanner;

public class Program1 {
	
	public static void main(String[] args) {
		
        Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number for Celsius: ");
		
		float Celsius = input.nextFloat();
		
		double i = 9.0; 
		
		i=i/5;
		
		double Fahrenheit = i * Celsius + 32;
		
		System.out.print(Celsius + " Celsius is " + Fahrenheit + " Fahrenheit"); 
		
		
	}

}
