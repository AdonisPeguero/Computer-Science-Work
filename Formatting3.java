// This is a program that adds two decimals
// author: Adonis Peguero
import java.util.*;
public class Formatting3 
{ 
    
    public static void main(String[] args) 
    { 
    // declare variables here
    double real1, real2, result;
    int int1, int2, intresult;
    int width;
    int choice;
    String dashes = "-";
    Scanner input = new Scanner(System.in);
    // Set up the names of the table
    String formathd = "    Operation      Value1     Value2     Result \n";
    width=formathd.length();
    // width is making the table by as long as formathd
    // Tell user what choices he/she has
    System.out.println("Do you want 1 for Add & Subtract or 2 for Multiplication and Division, or 3 for exit");
    choice=input.nextInt();
    // this will only happen is choice is equal 1 or 2
    while(choice==1 || choice==2 ){
    
    // ask user for two decimals 
    System.out.print("Enter two values with decimals ");
    real1= input.nextDouble();
    real2= input.nextDouble();
    int1 = (int)real1;
    int2 = (int)real2;

    if(choice==1)	    
    { 
    // add the decimals
    result=real1+real2;
    // Now add code for integers 
   
    intresult = (int)real1+(int)real2;
   
    System.out.println(formathd);
    System.out.println("--------------------------------------------------");
    // Makes an String and makes the values of real1, real2, result by to the 2 decimal place
    String op = "   SUM       ";
    String intop = "   SUM       ";
    String formatf = op + "%10.2f %10.2f %10.2f \n";
    String formatd = intop + "%10d %10d %10d \n";
    // prints SUM and real1, real2, result to the 2 decimal place in the same line
    System.out.printf(formatf, real1, real2, result);
    System.out.printf(formatd, int1, int2, intresult);
    System.out.println("--------------------------------------------------");
    // now add the code for subtracion 
    result=real1-real2;	
    intresult = (int)real1-(int)real2;
    String intsubop = "Difference   ";
    String subop = "Difference   "; 
    formatf = subop + "%10.2f %10.2f %10.2f \n";
    formatd = intsubop + "%10d %10d %10d \n";  
    System.out.printf(formatf, real1, real2, result);
    System.out.printf(formatd, int1, int2, intresult);
   
    System.out.println("Do you want 1 for Add & Subtract or 2 for Multiplication and Division, or 3 for exit");
    choice=input.nextInt();

    }

     if(choice==2)	    
    {
      if(int2==0 || real2==0)
    {
         System.out.print("Enter a non-zero value with decimals, with a non-zero interger portion ");
         real2=input.nextDouble();
	 int2=(int)real2;
	 choice=2;
    } 
	    
    // Mult the decimals
    result=real1*real2;
    // Now Mult code for integers 
   
    intresult = (int)real1*(int)real2;
   
    System.out.println(formathd); 
    System.out.println("--------------------------------------------------");
    // Makes an String and makes the values of real1, real2, result by to the 2 decimal place
    String op = "   Product   ";
    String intop = "   Product   ";
    String formatf = op + "%10.2f %10.2f %10.2f \n";
    String formatd = intop + "%10d %10d %10d \n";
    // prints Product and real1, real2, result to the 2 decimal place in the same line
    System.out.printf(formatf, real1, real2, result);
    System.out.printf(formatd, int1, int2, intresult);
    System.out.println("--------------------------------------------------");
   

    // now add the code for Divicion 
    result=real1/real2;	
    intresult = (int)real1/(int)real2;
    String intsubop = "   Quotient  ";
    String subop = "   Quotient  "; 
    formatf = subop + "%10.2f %10.2f %10.2f \n";
    formatd = intsubop + "%10d %10d %10d \n";  
    System.out.printf(formatf, real1, real2, result);
    System.out.printf(formatd, int1, int2, intresult);

    System.out.println("Do you want 1 for Add & Subtract or 2 for Multiplication and Division, or 3 for exit");
    choice=input.nextInt();   
    
    }

    }
     // thank the user for using the program
     if(choice>=3)
     {         
     System.out.println("Thank you for using Formatting");  
    
    }

    // now ask the user if they want multiplication and division
    // Loop if the answer is yes
    //
    }// end of main method
} // end of class        
