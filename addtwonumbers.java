import java.util.Scanner;


public class addtwonumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		System.out.println("This program adds two numbers togethers, please enter the first number");
		int m  = scanner.nextInt();
		System.out.println("Please enter the second number");
		int n  = scanner.nextInt();
		int sum = m + n;
		System.out.println("The answer is "+sum);
	}

}