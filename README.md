// author: Adonis Peguero
import java.util.*;
public class bestBuy
{ 
        public static void main(String[] args) 
        {
		System.out.println("This program Compares the price of two items to tell Best Value");
         	System.out.println("------------------------------------------------");
                Scanner input= new Scanner(System.in); //new scanner input
		System.out.println("Compare the price of two items:");
		System.out.println("Type 1 Dry packages in Pounds and Ounces");
		System.out.println("Type 2 Liquid containers in Quarts and Ounces");
		System.out.println("------------------------------------------------");
                System.out.print("What package do you want? ");
		int ChoicesOfTypes;
		ChoicesOfTypes=input.nextInt();
	       	int WeightOfPackage1InPounds;
	        int WeightOfPackage1InOunces;
		float PriceOfPackage1;	
		int WeightOfPackage2InPounds;
	        int WeightOfPackage2InOunces;
		float PriceOfPackage2;
		int PoundsIntoOuncesForPackage1;
		int AddOuncesOfPackage1;
		float ValuePerOuncesOfPackage1;
		int PoundsIntoOuncesForPackage2;
		int AddOuncesOfPackage2;
		float ValuePerOuncesOfPackage2;
		int WeightOfPackage1InQuarts;
		int WeightOfPackage2InQuarts;
		int QuartsIntoOuncesForPackage1;
		int QuartsIntoOuncesForPackage2;

 		if(ChoicesOfTypes==1){  // Type 1 
                System.out.println("What weigth is the first package in pounds and ounces ?"); // ask for pounds and ounces of first package 
                WeightOfPackage1InPounds=input.nextInt(); 
		WeightOfPackage1InOunces=input.nextInt();
                System.out.print("Enter your price for the first package $ "); // ask for price of first package 
 		PriceOfPackage1=input.nextFloat();

                System.out.println("What weigth is the second package in pounds and ounces ?"); // ask for pounds and ounces of second package 
                WeightOfPackage2InPounds=input.nextInt(); 
		WeightOfPackage2InOunces=input.nextInt();
                System.out.print("Enter your price for the second package $ "); // ask for price of second package
 		PriceOfPackage2=input.nextFloat();

                // calculate the value per ounces of package 1 

		PoundsIntoOuncesForPackage1 =  WeightOfPackage1InPounds * 16; 
		AddOuncesOfPackage1 = PoundsIntoOuncesForPackage1 + WeightOfPackage1InOunces;
		ValuePerOuncesOfPackage1 = PriceOfPackage1 / AddOuncesOfPackage1;  

		// calculate the value per ounces of package 2
		
		PoundsIntoOuncesForPackage2 =  WeightOfPackage2InPounds * 16;
		AddOuncesOfPackage2 =  PoundsIntoOuncesForPackage2 + WeightOfPackage2InOunces;
		ValuePerOuncesOfPackage2 = PriceOfPackage2 / AddOuncesOfPackage2;

		// Decided which answer to give the user

		if (ValuePerOuncesOfPackage1 < ValuePerOuncesOfPackage2){
		System.out.println("Item 1 at $"+ValuePerOuncesOfPackage1+" per ounce is a better buy than Item 2 at $"+ValuePerOuncesOfPackage2+" per ounce");

		}

		if (ValuePerOuncesOfPackage2 < ValuePerOuncesOfPackage1){
		System.out.println("Item 2 at $"+ValuePerOuncesOfPackage2+" per ounce is a better buy than Item 1 at $"+ValuePerOuncesOfPackage1+" per ounce");

		}

		}
		if(ChoicesOfTypes==2){ // Type 2
		System.out.println("What weigth is the first package in quarts and ounces ?"); // ask for quarts and ounces of first package 
                WeightOfPackage1InQuarts=input.nextInt(); 
		WeightOfPackage1InOunces=input.nextInt();
                System.out.print("Enter your price for the first package $ "); // ask for price of first package 
 		PriceOfPackage1=input.nextFloat();

                System.out.println("What weigth is the second package in quarts and ounces ?"); // ask for pounds and ounces of second package 
                WeightOfPackage2InQuarts=input.nextInt(); 
		WeightOfPackage2InOunces=input.nextInt();
                System.out.print("Enter your price for the second package $ "); // ask for price of second package
 		PriceOfPackage2=input.nextFloat();

                // calculate the value per ounces of package 1 

		QuartsIntoOuncesForPackage1 =  WeightOfPackage1InQuarts * 32; 
		AddOuncesOfPackage1 = QuartsIntoOuncesForPackage1 + WeightOfPackage1InOunces;
		ValuePerOuncesOfPackage1 = PriceOfPackage1 / AddOuncesOfPackage1;  

		// calculate the value per ounces of package 2
		
		QuartsIntoOuncesForPackage2 =  WeightOfPackage2InQuarts * 32;
		AddOuncesOfPackage2 =  QuartsIntoOuncesForPackage2 + WeightOfPackage2InOunces;
		ValuePerOuncesOfPackage2 = PriceOfPackage2 / AddOuncesOfPackage2;

		// Decided which answer to give the user

		if (ValuePerOuncesOfPackage1 < ValuePerOuncesOfPackage2){
		System.out.println("Item 1 at $"+ValuePerOuncesOfPackage1+" per ounce is a better buy than Item 2 at $"+ValuePerOuncesOfPackage2+" per ounce");

		}

		if (ValuePerOuncesOfPackage2 < ValuePerOuncesOfPackage1){
		System.out.println("Item 2 at $"+ValuePerOuncesOfPackage2+" per ounce is a better buy than Item 1 at $"+ValuePerOuncesOfPackage1+" per ounce");

		}    


		}
		
		// happens if the user inputs an wrong answer

		if (ChoicesOfTypes > 2){
			System.out.println("Invalid Option, What package type do you want?");
			System.out.print("Choose either 1 or 2 ");
                        ChoicesOfTypes=input.nextInt();
			
		if ( ChoicesOfTypes > 2){

	           System.out.println("Error invalid option. Program Terminated");
		}			
			

        	if(ChoicesOfTypes==1){  // Type 1 
                System.out.println("What weigth is the first package in pounds and ounces ?"); // ask for pounds and ounces of first package 
                WeightOfPackage1InPounds=input.nextInt(); 
		WeightOfPackage1InOunces=input.nextInt();
                System.out.print("Enter your price for the first package $ "); // ask for price of first package 
 		PriceOfPackage1=input.nextFloat();

                System.out.println("What weigth is the second package in pounds and ounces ?"); // ask for pounds and ounces of second package 
                WeightOfPackage2InPounds=input.nextInt(); 
		WeightOfPackage2InOunces=input.nextInt();
                System.out.print("Enter your price for the second package $ "); // ask for price of second package
 		PriceOfPackage2=input.nextFloat();

                // calculate the value per ounces of package 1 

		PoundsIntoOuncesForPackage1 =  WeightOfPackage1InPounds * 16; 
		AddOuncesOfPackage1 = PoundsIntoOuncesForPackage1 + WeightOfPackage1InOunces;
		ValuePerOuncesOfPackage1 = PriceOfPackage1 / AddOuncesOfPackage1;  

		// calculate the value per ounces of package 2
		
		PoundsIntoOuncesForPackage2 =  WeightOfPackage2InPounds * 16;
		AddOuncesOfPackage2 =  PoundsIntoOuncesForPackage2 + WeightOfPackage2InOunces;
		ValuePerOuncesOfPackage2 = PriceOfPackage2 / AddOuncesOfPackage2;

		// Decided which answer to give the user

		if (ValuePerOuncesOfPackage1 < ValuePerOuncesOfPackage2){
		System.out.println("Item 1 at $"+ValuePerOuncesOfPackage1+" per ounce is a better buy than Item 2 at $"+ValuePerOuncesOfPackage2+" per ounce");

		}

		if (ValuePerOuncesOfPackage2 < ValuePerOuncesOfPackage1){
		System.out.println("Item 2 at $"+ValuePerOuncesOfPackage2+" per ounce is a better buy than Item 1 at $"+ValuePerOuncesOfPackage1+" per ounce");

		}

		}
		if(ChoicesOfTypes==2){ // Type 2
		System.out.println("What weigth is the first package in quarts and ounces ?"); // ask for quarts and ounces of first package 
                WeightOfPackage1InQuarts=input.nextInt(); 
		WeightOfPackage1InOunces=input.nextInt();
                System.out.print("Enter your price for the first package $ "); // ask for price of first package 
 		PriceOfPackage1=input.nextFloat();

                System.out.println("What weigth is the second package in quarts and ounces ?"); // ask for pounds and ounces of second package 
                WeightOfPackage2InQuarts=input.nextInt(); 
		WeightOfPackage2InOunces=input.nextInt();
                System.out.print("Enter your price for the second package $ "); // ask for price of second package
 		PriceOfPackage2=input.nextFloat();

                // calculate the value per ounces of package 1 

		QuartsIntoOuncesForPackage1 =  WeightOfPackage1InQuarts * 32; 
		AddOuncesOfPackage1 = QuartsIntoOuncesForPackage1 + WeightOfPackage1InOunces;
  		ValuePerOuncesOfPackage1 = PriceOfPackage1 / AddOuncesOfPackage1;  

		// calculate the value per ounces of package 2
		
		QuartsIntoOuncesForPackage2 =  WeightOfPackage2InQuarts * 32;
		AddOuncesOfPackage2 =  QuartsIntoOuncesForPackage2 + WeightOfPackage2InOunces;
		ValuePerOuncesOfPackage2 = PriceOfPackage2 / AddOuncesOfPackage2;

		// Decided which answer to give the user

		if (ValuePerOuncesOfPackage1 < ValuePerOuncesOfPackage2){
		System.out.println("Item 1 at $"+ValuePerOuncesOfPackage1+" per ounce is a better buy than Item 2 at $"+ValuePerOuncesOfPackage2+" per ounce");

		}

		if (ValuePerOuncesOfPackage2 < ValuePerOuncesOfPackage1){
		System.out.println("Item 2 at $"+ValuePerOuncesOfPackage2+" per ounce is a better buy than Item 1 at $"+ValuePerOuncesOfPackage1+" per ounce");

		}    


		}




		}	

	
	
        }// end of main method
} // end of class        
