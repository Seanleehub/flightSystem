import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Passenger{
	private String flightNo;
	private String passengerID;
	private String name;
	 static Passenger []passengers;
	double extra;

	public Passenger(String flightNo,String passengerID,String name)
	   {
		   this.flightNo = flightNo;
		   this.passengerID = passengerID;
		   this.name = name;
		   
   
	   	}
	   public Passenger(){
			
	   }
	
	 public double checkInBaggage(double weight)  
	
	 {
		 extra = (weight - 15)*20;
		 
		return extra;
	  }
	  public String name(){
	  return name;
	  }
	   public String passsengerID()
	   {
		   return passengerID;
	   }
	   public void printInRow()
	   {
	  
	      System.out.printf("%-13s", flightNo);
	      System.out.printf("%-15s", passengerID);
	      System.out.printf("%-15s", name);
	   
	     
	   }
	   public double checkInBaggage2(double weight) 
		 {
		   extra = (weight - 20)*20;
			 
			return extra;
			  
		  }
	   
	  
	  public String getFlightNo()
   {
      return flightNo;
   }
   
	   }
