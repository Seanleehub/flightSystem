
public class BusinessPassenger extends Passenger {


	private String mealType;
	   public BusinessPassenger(String flightNo,String passengerID,String name, String mealType)
	   {
		super(flightNo,passengerID,name);
		 this.mealType = mealType;
	   	}
	  
	   
	   public double checkInBaggage2(double weight) 
		 {
		super.checkInBaggage2(weight);
			return extra;
			  
		  }
	 
	   public void printInRow()
	   {
		  
	     super.printInRow();
	     System.out.printf("%-15s", mealType);
	   }
}
