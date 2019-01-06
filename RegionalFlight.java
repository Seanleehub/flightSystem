import java.util.*;

public class RegionalFlight extends Flight
{

   private Flight connectingFlight;
   
   public RegionalFlight(String flightNo, String departurePoint,
                         String destination, double flightLength, String flightDate,
                         String flightTime, int flightCapacity, Flight secondLeg)
   {
      super(flightNo, departurePoint, destination, flightLength, flightDate,
            flightTime, flightCapacity);

      connectingFlight = secondLeg;
      

   }
  
  
   
   public boolean reserveSeats(int seatsRequested) throws Exception
   {
	   if(super.getStatus() != 'S'){
		   throw new Exception("Flight is not in the correct State to Reserve Seats");}
   else if(super.getseatsBooked() + seatsRequested > super.getflightCapacity()){
		   throw new Exception("RegionalFlight has reached its Maximum Capacity");		   
	   }
   else{
      boolean seatsReserved = super.reserveSeats(seatsRequested);
      if (seatsReserved == true)
      {
         connectingFlight.reserveSeats(seatsRequested);
         return true;
      }
      return false;
   }
   }
   
   public boolean delay(int hours, int minutes) throws Exception
   {

	     
	     
      // status of first leg must be 'S' (scheduled) for it to be delayed
      if (super.getStatus() == 'S')
      {
    	  connectingFlight.setStatus('S');
         // attempt to delay the second leg
    	  boolean secondLegDelayed = connectingFlight.delay(hours, minutes);
    	  if(secondLegDelayed = false){
        	  throw new Exception("Arrival Time is beyond Mid-Night so flight is cancelled");
    	  }
         // check to see if the second leg was cancelled
         if (connectingFlight.getStatus() == 'C')
         {
            // cancel the first leg (this leg)
            super.setStatus('C');
         }
         else
         {
            // otherwise delay the first leg (this leg)
            super.delay(hours, minutes);
         }
         
         return true;
      }
     
    
	 
      
      return false;
      
   }
   
   private String getLayoverTime()
   {
      int layoverHours, layoverMinutes;

      // get the departure time for both legs
      String firstLegDepartureTime = super.getFlightTime();
      String secondLegDepartureTime = connectingFlight.getFlightTime();
      
      // split up the departure times for both legs
      String [] firstLegSplit = firstLegDepartureTime.split(":");
      String [] secondLegSplit = secondLegDepartureTime.split(":");
      
      // convert departure times in hours and minutes to int
      int firstLegHours = Integer.parseInt(firstLegSplit[0]);
      int firstLegMinutes = Integer.parseInt(firstLegSplit[1]);
      int secondLegHours = Integer.parseInt(secondLegSplit[0]);
      int secondLegMinutes = Integer.parseInt(secondLegSplit[1]);
      
      // work out the flight length in hours and minutes
      double firstLegFlightLength = super.getFlightLength();
      int flightLengthHours = (int)firstLegFlightLength;
      int flightLengthMinutes = (int)((firstLegFlightLength % 1.0) * 60);
      

      // work out the layover hours and minutes
      layoverHours = secondLegHours - (firstLegHours + flightLengthHours);
      layoverMinutes = secondLegMinutes - (firstLegMinutes + flightLengthMinutes);
      
      // adjust the layover hours is the layover minutes is negative
      if (layoverMinutes < 0)
      {
         layoverHours--;
         layoverMinutes = 60 - layoverMinutes;
      }

      String layoverTime = "";
      
      // pad hours out with a zero if the number is less than 10
      if (layoverHours < 10)
         layoverTime = layoverTime + "0";
      
      layoverTime = layoverTime + layoverHours + ":";
      
      // pad minutes out with a zero if the number is less than 10
      if (layoverMinutes < 10)
         layoverTime = layoverTime + "0";
      
      layoverTime = layoverTime + layoverMinutes;
      
      return layoverTime;
   }
   
   public void print()
   {
      System.out.printf("Regional Flight: %s to %s (via %s)\n", 
                        super.getDeparturePoint(),
                        connectingFlight.getDestination(),
                        super.getDestination());
      
      System.out.println("First Leg:");
      super.print();
      System.out.println("Layover: " + getLayoverTime());
      System.out.println("Second Leg:");
      connectingFlight.print();                 

   }
   
   public void printInRow()
   {
      System.out.printf("(Regional Flight - %s to %s via %s)\n",
                         super.getDeparturePoint(),
                         connectingFlight.getDestination(),
                         super.getDestination());
      super.printInRow();
      System.out.printf("%9s\n", getLayoverTime());
      connectingFlight.printInRow();
   }
}
