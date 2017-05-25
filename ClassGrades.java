// This program creates grades for a class
// author:  Adonis Peguero
import java.util.*;
public class ClassGrades
{ 
        public static void main(String[] args) 
        { 
	//tell user what the program does
	System.out.println ("This program creates grades for a class of students ");
	Scanner input = new Scanner(System.in);
        // declare variables 
	int NStudents; // number of students 
	int TPPoints;  // total possible points
        int count, width, spoints, n;
	char grade, avggrade;
	double percent , avgpercent , avgpoints, lpercent, hpercent;

	avgpercent = 0;
	lpercent = 100.0;
	hpercent = 0;
	
	// ask and get from the user the number of the students in the class
	System.out.print ("Please Enter the Number of students: " );	
      	NStudents =input.nextInt();

	while( NStudents <= 0 ){

        System.out.print ("Please Enter another number greater then zero for students? " );	
      	NStudents =input.nextInt();
	}	

	// declare array 
	int [] Points = new int [NStudents];
	

        // ask and get the total possible points
	System.out.print ("Please Enter the Total Possible Points: " );
	TPPoints =input.nextInt();

	while( TPPoints <= 0 ){

        System.out.print ("Please Enter another number greater then zero for Total Possible Points? " );	
      	TPPoints =input.nextInt();
	}

        // store each student grade into the array
	System.out.println ("Please Enter Each Students Points ");
	for ( count = 0; count < NStudents; count++ )
	{ 
	   System.out.print ("Points for Student "+ (count + 1)+ " " );
	   spoints =input.nextInt();

	// if student points bigger then possible point, ask for smaller number  
	while ( spoints > TPPoints){
	System.out.println ("Sorry that is over the total possible, try again" );
	System.out.print ("Points for Student "+ (count + 1)+ " " );
	spoints =input.nextInt();
       	}
	Points[count] = spoints;

	}
	System.out.println (" ");
 
	// set up table of outputs
	String formathd = ("Class of " +NStudents+ " students    Student Points   Percent      Grade");
       	width=formathd.length();
	System.out.println(formathd);
	System.out.println ("-------------------    --------------   -------      -----"); 

       	for ( count = 0; count < NStudents; count++ )
	{
	    //calculate each student percent
	    n = Points[count];	
	    percent = (double)n/(double)TPPoints;
	    percent = percent * 100;

	    // determinate grade 
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
	     else if(percent>=60.00)
	     {
               grade = 'D';	     
	     }
	     else
	     {
               grade = 'F'; 
	     }	    
            
	     if(hpercent < percent){
             hpercent=percent;
	     }
	     if( lpercent > percent){
	     lpercent = percent;
	     }
       
            // show values  
	    String formatg = ("Student "+ (count + 1)+ "    " );
	    String formatf = " %11s  %16d %13.2f %9c \n";
	    System.out.printf(formatf, formatg, n, percent, grade); 
	  
	    avgpercent = avgpercent + percent;

	}	    
        System.out.println ("-------------------    --------------   -------      -----"); 
         
         avgpercent = avgpercent /(double) NStudents;

         // get class avg percent 
       	  if(avgpercent>=90.00)
	     {
               grade = 'A'; 
	     }	     
             else if(avgpercent>=80.00)
	     {
               grade = 'B'; 
	     }	    
	     else if(avgpercent>=70.00)
	     {
               grade = 'C'; 
	     }	    
	     else if(avgpercent>=60.00)
	     {
               grade = 'D';	     
	     }
	     else
	     {
               grade = 'F'; 
	     }	    

         String formatq = ("Class Average");
	 String formato = " %11s %31.2f %9c \n";
	 System.out.printf(formato, formatq, avgpercent, grade);

       	  
	   // calculate the highest percent

	  // determinate grade 
             if(hpercent>=90.00)
	     {
               grade = 'A'; 
	     }	     
             else if(hpercent>=80.00)
	     {
               grade = 'B'; 
	     }	    
	     else if(hpercent>=70.00)
	     {
               grade = 'C'; 
	     }	    
	     else if(hpercent>=60.00)
	     {
               grade = 'D';	     
	     }
	     else
	     {
               grade = 'F'; 
	     }

         // print highest percent data
	 String formatt = ("Highest Percent");
	 String formatv = " %11s %29.2f %9c \n";
	 System.out.printf(formatv, formatt, hpercent, grade);

	
          // calculate lowest percent 


	 // determinate grade 
             if(lpercent>=90.00)
	     {
               grade = 'A'; 
	     }	     
             else if(lpercent>=80.00)
	     {
               grade = 'B'; 
	     }	    
	     else if(lpercent>=70.00)
	     {
               grade = 'C'; 
	     }	    
	     else if(lpercent>=60.00)
	     {
               grade = 'D';	     
	     }
	     else
	     {
               grade = 'F'; 
	     }	    
         // print lowest percent data
	 String format1 = ("Lowest Percent");
	 String format2 = " %11s %30.2f %9c \n";
	 System.out.printf(format2, format1, lpercent, grade);
	 


	}
}
