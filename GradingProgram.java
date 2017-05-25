// This is program creates grades and tells percentages for a class
// author: Adonis Peguero
import java.util.*;
public class GradingProgram
{ 
        public static void main(String[] args) 
        {
        
         Scanner input = new Scanner(System.in);

	 // Tell user what this program does
	 
         System.out.println("This is program creates grades for a class");
        
	 // Declare all variables
	 // Number of Studnts, Number of total points
         int NStudents, TPoints;

	 int count;

	 int width;
         
	 int SPoints; // Students points

	 double percent;

	 double TotalPercent;

	 char grade; 

	 TotalPercent=0;

	 // ask user how many students are in the class
	 System.out.print("How many students are in the class? ");
	 NStudents= input.nextInt();

         while ( NStudents == 0 )
	 {
	   //When user inputs 0 as number of students	 
           System.out.println("Number of students needs to be bigger then zero ");
	   System.out.print("How many students are in the class? ");
	   NStudents= input.nextInt();
	 }
         
	 // ask user to enter the total possible points  
	 System.out.print("Enter The Total Possible Points ");
         TPoints= input.nextInt();
	
	 // set table 
	  String formathd = "       CLASS OF "+NStudents+" STUDENTS    INITIALS     POINTS     PERCENT    GRADE ";
	  width=formathd.length();
	  System.out.println(formathd);
          System.out.println("                              --------    --------    -------    ------    ");


	  // get data from all students 
          for( count = 0; count < NStudents; count++)
	  { 

	     //Ask for student initials	  
             System.out.print("Enter Student Initials ");
	     String Initials = input.next();

	     //Ask for student points
	     System.out.print("Enter Student Points ");
             SPoints= input.nextInt();

	     while ( SPoints > TPoints)
	     { 
		// if user input is bigger then possible points      
                System.out.println("** Invalid Student Points **");
		System.out.print("Enter Student Points ");
                SPoints= input.nextInt();
	     }

             // Calculate percent
             percent = (double)SPoints/(double)TPoints;
	     percent = percent * 100;
 
	     // Calculate grade
             if(percent>=90.00)
	     {
               grade = 'A'; 
	     }	     
             else if(percent>=80.00)
	     {
               grade = 'B'; 
	     }	    
	     else if(percent>=70.00)
	     {
               grade = 'C'; 
	     }	    
	     else if(percent>=65.00)
	     {
               grade = 'D';	     
	     }
	     else
	     {
               grade = 'F'; 
	     }	    

	    //Add all the percents 
	    TotalPercent+=percent;

	     // Organize table
	     String formatf = "%36s %11d %11.2f %8c \n";
	     System.out.printf(formatf, Initials, SPoints, percent, grade);
	     
   
	  }

	  //Get class average percent
	  TotalPercent= TotalPercent/NStudents;

	  // Get class average grade
	   if(TotalPercent >= 90.00)
	     {
               grade = 'A'; 
	     }	     
             else if(TotalPercent>=80.00)
	     {
               grade = 'B'; 
	     }	    
	     else if(TotalPercent>=70.00)
	     {
               grade = 'C'; 
	     }	    
	     else if(TotalPercent>=65.00)
	     {
               grade = 'D';	     
	     }
	     else
	     {
               grade = 'F'; 
	     }	   
	   
	  System.out.println(" ");  

          // Show class average percent and average grade 
	  String CAverage = "CLASS AVERAGE";
	  String formatd = " %40s %18.2f %8c \n";
          System.out.printf(formatd, CAverage, TotalPercent, grade); 

          System.out.println("Thank you for using this grading program");

        }// end of main method
} // end of class        
