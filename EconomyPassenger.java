

public class EconomyPassenger extends Passenger {

	   public EconomyPassenger(String flightNo,String passengerID,String name)
	   {
		super(flightNo,passengerID,name);
	   	
	  
	   }
	   public double checkInBaggage(double weight) 
		 {
			super.checkInBaggage(weight);
				   return super.extra;
			 
			  
		  }
	   public void printInRow()
	   {
	     super.printInRow();
	    
	   }
	   }
