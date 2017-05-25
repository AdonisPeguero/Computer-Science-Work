//Calculate Electricity bill a real world Example.


// Step1 

             //We are going to create a Plan abstract class. 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.*;      /*we are using io concept in our class that's why we are importing io pacakage.*/

     abstract class KeanMealPlan

   {
            protected int rate;

          abstract void getMealPlan(); 

  
            public void calculateBill(int semesters)
    
          {
            
              System.out.print(rate+" per semester "+rate*semesters+" in total");
          }

   }//end of Plan class.


// Step 2 

             //We are going to create a Concrete classes that extends Plan abstract class. 


     class  FreshmanMealPlan extends KeanMealPlan
   {
        //@override
         public void getMealPlan()
        {
             rate=1811;            
        }
   }//end of DomesticPlan class.



     class  UpperClassMealPlan extends KeanMealPlan
   {
        //@override 
         public void getMealPlan()
        { 
             rate=1283;
        } 
   }//end of CommercialPlan class.


// Step 3 

          //Create a GetPlanFactory to generate object of concrete classes based on given information.


 class GetPlanFactory 
{
	
   //use getPlan method to get object of type Plan 

  
     public KeanMealPlan getPlan(String planType)
    {

            if(planType == null)
           {
             return null;
           }

	      if(planType.equalsIgnoreCase("FreshmanMealPlan"))
           {
             return new FreshmanMealPlan();
           } 
   
           else if(planType.equalsIgnoreCase("UpperClassMealPlan"))
          {
            return new UpperClassMealPlan();
          } 

         

      return null;
   }
}//end of GetPlanFactory class.


// Step 4

         //Use the GetPlanFactory to get the object of concrete classes by passing an information such as type(DOMESTICPLAN/COMMERCIALPLAN/INSTITUTIONALPLAN).


  class GenerateBill
{
      
    public static void main(String args[])throws IOException, SQLException
   {
       
    	
    	String host = "jdbc:derby://localhost:1527/Employees";
    	
    	String username = "Your_Username_Here";

    	String password = " Your_Password_Here ";
    	
    	Connection con = DriverManager.getConnection( host, username, password );
    	
    	
      GetPlanFactory planFactory = new GetPlanFactory();

      //get an object of DomesticPaln and call its getPlan()method.But we want to calculate the bill for one plan at time not all.for this we IO concept.

      System.out.print("Enter the name of the meal plan for which the bill will be generated: ");
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

      String planName=br.readLine();
      
      System.out.print("Enter the number of semester you will be attending: ");  
      int semesters=Integer.parseInt(br.readLine()); 
      
      while(semesters >= 1000){
    	  System.out.print("Number is too big please enter again:");  
    	 semesters=Integer.parseInt(br.readLine());
      }

      KeanMealPlan p = planFactory.getPlan(planName);

      //call getRate() method and calculateBill()method of DomesticPaln.

       System.out.print("Bill amount for "+planName+" is " );
       p.getMealPlan();  
       p.calculateBill(semesters);
       
       if(planName.equalsIgnoreCase("UpperClassMealPlan") )
       {
    	   System.out.print(" (96 meals/$250 Cougar Dollars per semester)"); 
       } 
       
       if(planName.equalsIgnoreCase("FreshmanMealPlan") )
       {
    	   System.out.print(" (Unlimited meals/$150 Cougar Dollars per semester)"); 
       } 
          

           }
    }//end of GenerateBill class.
