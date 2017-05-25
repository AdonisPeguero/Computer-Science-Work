// CPS 2231-03, Adonis Peguero, peguenoa@kean.edu 
import java.util.Scanner;

public class Program2 {
	
	public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);

	int inAscii;
	
	int[] count= new int[256]; // every ascii character 

	char inChar;

	System.out.println("Please enter a string  and press ENTER to end.");

	String inString =input.nextLine();

	for (int i = 0; i < inString.length();i++) { // the ascii value for every letter and Make every ascii value into a array directory

	inChar=inString.charAt(i);                   // then add 1 to the directory value if the letters repeat. 

	inAscii=(int) inChar;

	count[inAscii]++;

	}
	
	for (int i = 1; i<256; i++){ // Go THROUGH the array and print the directory as a char to get the letter 
		
		if(count[i]!=0){ // only print characters that have values bigger then one
		
		if (count[i] > 1){ // letter appears more then ones print times 
			
			System.out.printf("character:%c, ASCII#: %3d, occurs %2d times\n",(char)i,i,count[i]);
			
		}
		
		else{ // letter appears ones print times 
			
			System.out.printf("character:%c, ASCII#: %3d, occurs %2d time\n",(char)i,i,count[i]);
		}
		
	}
	
	}
	
	System.out.println("Program 2 is developed by Adonis Peguero email: peguenoa@kean.edu");
		
	}
}

