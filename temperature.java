// This is program calculates and prints average monthly temperatures
// author: Adonis Peguero
import java.util.*;
public class temperature
{ 
        public static void main(String[] args) 
        {// begin main method
	int k;
	int width;	
	// month names
	String [] months = {"January  ", "February ", "March    ", "April    ", "May      ", "June     ", "July     ", "August   ", "September", "October  ", "November ", "December "};
	//zipcode
	int zipcode;
	int [] Range = new int [12];
        Scanner input = new Scanner(System.in);
	double HighsAverage, LowsAverage, RangeAverage;
	int HighestHigh, HighestLow, HighestRange;
	int LowestHigh, Lowestlow, LowestRange; 

	
	// all high temperature for each month
	int [] Highs = new int [12];
	// all low temperature for each month 
	int [] Lows = new int [12];
	
	//ask for zipcode
	System.out.println("Enter the zipcode ");
	zipcode=input.nextInt();

	for (k=0;k<12;k++)
	{
          System.out.println("Enter the average high for "+months[k]);
	  Highs[k]= input.nextInt();
          System.out.println("Enter the average low for "+months[k]);
	  Lows[k]=input.nextInt();
          	  
	}
	
	//calculate Range
	for (k=0;k<12;k++)
	{
	  Range[k]=Highs[k]-Lows[k];
	}

	System.out.println ("");
	System.out.println ("Temperatures for zipcode "+zipcode);
	System.out.println ("");

        // set table 
	String formathd = ("Months        Highs      Lows      Range");
	width=formathd.length();
	System.out.println(formathd);
	System.out.println ("------        -----      ----      -----");

	//  display date 
	for (k=0;k<12;k++)
	{
	String formatf = "%8s  %9d %9d %9d \n";
	System.out.printf(formatf,  months[k], Highs[k], Lows[k], Range[k]);
	}
	//pass highs,lows,and range arrays to average method 
	HighsAverage=Average(Highs);
	LowsAverage=Average(Lows);
	RangeAverage=Average(Range);
        //display all averages 
	System.out.println ("");
        String formatq = ("Annual Average");
	String formatr = "%6s  %7.2f %9.2f %9.2f \n";
	System.out.printf(formatr, formatq, HighsAverage, LowsAverage, RangeAverage);

	//Gets all the Highest
	HighestHigh=Highest(Highs);
	HighestLow=Highest(Lows);
	HighestRange=Highest(Range);
	// display Highest
	String formatj = ("Highest month");
	String formato = "%6s  %7s %9s %9s \n";
	System.out.printf(formato, formatj, months[HighestHigh], months[HighestLow], months[HighestRange]);

	// Get all Lowest 
	LowestHigh=Lowest(Highs);
	Lowestlow=Lowest(Lows);
	LowestRange=Lowest(Range);
	// display Lowest
	String formatb = ("Lowest month");
	String formatn = "%6s  %7s %9s %9s \n";
	System.out.printf(formatn, formatb, months[LowestHigh], months[Lowestlow], months[LowestRange]);


        }// end of main method

	// calculate average
	public static double Average(int[]array)
	{
	int length;
	double Total;
	Total=0.0;	
	for (int k=0;k<12;k++)
	{
          Total=Total+array[k];
	}

        double avg = Total/array.length;  
        return avg;  
	}

	//calculate highest
        public static int Highest(int[]array)
	{
	int k;
        int k2;
	int Total;
       	Total=0;
	k2=0;

       	for (k=0;k<12;k++)
	{
          if(array[k]>Total)
	  {
            Total=array[k];
	  }
	}  
 	for (k=0;k<12;k++)
	{
          if(array[k]==Total)
	  {
            k2=k;
	  }
	}  
	return k2;

	}

	// calculate Lowest
	public static int Lowest(int[]array)
	{
	int k;
        int k2;
	int Total;
       	Total=10000000;
	k2=0;

       	for (k=0;k<12;k++)
	{
          if(array[k]<Total)
	  {
            Total=array[k];
	  }
	}  
 	for (k=0;k<12;k++)
	{
          if(array[k]==Total)
	  {
            k2=k;
	  }
	}  
	return k2;

	}
	

} // end of class        
