
import java.util.*;

public class Flight
{
 
private String flightNo;
   private String departurePoint;
   private String destination;
   private String flightTime;
   private String flightDate;
   private double flightLength;
   private char status;
   private int flightCapacity;
   private int seatsBooked;
  
   
   public Flight(String flightNo, String departurePoint, String destination,
                 double flightLength, String flightDate, String flightTime,
                 int flightCapacity)
   {
      this.flightNo = flightNo;
      this.departurePoint = departurePoint;
      this.destination = destination;
      this.flightLength = flightLength;
      this.flightDate = flightDate;
      this.flightTime = flightTime;
      this.flightCapacity = flightCapacity;
      status = 'S';
      seatsBooked = 0;
   }
  
public Flight(){
	
}
   public int getflightCapacity()
   {
	   return flightCapacity;
   }
   public int getseatsBooked()
   {
	   return seatsBooked;
   }
   public String getFlightNo()
   {
      return flightNo;
   }
   
   public String getDeparturePoint()
   {
      return departurePoint;
   }
   
   public String getDestination()
   {
      return destination;
   }
 
   public String getFlightDate()
   {
      return flightDate;
   }
   
   public String getFlightTime()
   {
      return flightTime;
   }
   
   public double getFlightLength()
   {
      return flightLength;
   }
   
   public char getStatus()
   {
      return status;
   }
   
   public void setStatus(char status)
   {
      this.status = status;
   }
   
  
   public boolean open() throws Exception
   {
	   if(status != 'S'){
		   throw new Exception("Flight is not in the Correct State to be Opened");}
	   else{
      if (status == 'S')
      {
      status = 'B';
      
         return true;
        
      }
      else
    	  
         return false;
	   }
   }
   
   public boolean close() throws Exception
   {
	   if(status != 'B'){
		   throw new Exception("Flight is not in the Correct State to be Closed");}
	   else{
      if (status == 'B')
      {
         status = 'D';
         return true;
      }
      else
         return false;

   }
}
  
	   
	   
	   
   
   public boolean reserveSeats(int seatsRequested) throws Exception
   {
	   if(status != 'S'){
		   throw new Exception("Flight is not in the correct State to Reserve Seats");}
	   else if(seatsBooked + seatsRequested > flightCapacity){
		   throw new Exception("Flight has reached its Maximum Capacity");
		   
	   }
	   
	   else{
      if (status == 'S' && seatsBooked + seatsRequested <= flightCapacity)
      {
         seatsBooked += seatsRequested;
         return true;
      }
      else
         return false;

   }
   }
   
   public boolean delay(int delayHours, int delayMinutes) throws Exception
   {
      String hoursToken, minutesToken;
      int departureHours, departureMinutes;
      int delayedHours, delayedMinutes;
      int flightHours, flightMinutes;
      int arrivalHours, arrivalMinutes;
    
       
      // prepare the various figures needed to perform the delay
      // calculations later on
      
      Scanner flightTimeSplitter = new Scanner(flightTime);
      flightTimeSplitter.useDelimiter(":");
      
      hoursToken = flightTimeSplitter.next();
      minutesToken = flightTimeSplitter.next();
      
      departureHours = Integer.parseInt(hoursToken);
      departureMinutes = Integer.parseInt(minutesToken);
      
      flightHours = (int) flightLength;
      flightMinutes = (int) ((flightLength % 1.0) * 60);
      
      arrivalHours = departureHours + flightHours + delayHours;
      arrivalMinutes = departureMinutes + flightMinutes + delayMinutes;
      
      if (arrivalMinutes >= 60)
      {
         arrivalHours += arrivalMinutes / 60;
         arrivalMinutes = arrivalMinutes % 60;
      }
      
      // check to see if the arrival time goes past 24:00 (midnight)
      int midnightInMinutes = 24 * 60;
      System.out.println(arrivalHours * 60  + arrivalMinutes);
    
      if (status != 'S')
    	  throw new Exception("Flight is not in the correct State to Be Delayed");
      
      if (arrivalHours * 60 + arrivalMinutes > midnightInMinutes)
      {
         // arrival time beyond 24:00 hours so cancel the flight
         status = 'C';
       
        
         throw new Exception("Arrival Time is beyond Mid-Night so flight is cancelled");
      }
    
   
	   else{
         // calculate the new departure time
         departureHours = departureHours + delayHours;
         departureMinutes = departureMinutes + delayMinutes;

         if (departureMinutes >= 60)
         {
            departureHours += departureMinutes / 60;
            departureMinutes = departureMinutes % 60;
         }
         
         // piece together the new flight time time
         
         flightTime = "";
         
         // need to insert a "0" if the hours are < 10 to maintain 
         // the hh:mm format for the flight time
         
         if (departureHours < 10)
            flightTime = flightTime + "0";
         
         flightTime = flightTime + departureHours;
         flightTime = flightTime + ":";
         
         // need to insert a "0" if the minutes are < 10 to maintain 
         // the hh:mm format for the flight time
         
         if (departureMinutes < 10)
            flightTime = flightTime + "0";
         
         flightTime += departureMinutes;
         
        
         return true;        
     
      
      }
      
   }

   
	   
	   
	   
   
   public void print()
   {
      System.out.printf("%-20s%s\n", "Flight No:", flightNo);
      System.out.printf("%-20s%s\n", "Departing:", departurePoint);
      System.out.printf("%-20s%s\n", "Destination:", destination);
      System.out.printf("%-20s%s\n", "Flight Time", flightTime);
      System.out.printf("%-20s%s\n", "Flight Date:", flightDate);
      System.out.printf("%-20s%.2f\n", "Flight Length:", flightLength);
      System.out.printf("%-20s", "Flight Status:");
      
      // print fancy status using switch
      switch(status)
      {
         case 'S':
            System.out.println("Scheduled");
            break;
         case 'B':
            System.out.println("Boarding");
            break;
         case 'D':
            System.out.println("Departed");
            break;
         case 'C':
            System.out.println("Cancelled");
            break;
      }
      System.out.printf("%-20s%d\n", "Flight Capacity:", flightCapacity);
      System.out.printf("%-20s%d\n\n", "Seats Booked:", seatsBooked);

   }
   
   public void printInRow()
   {
      System.out.printf("%-13s", flightNo);
      System.out.printf("%-15s", departurePoint);
      System.out.printf("%-15s", destination);
      System.out.printf("%-7s", flightTime);
      System.out.printf("%-12s", flightDate);
      System.out.printf("%7.2f", flightLength);
      System.out.printf("%10d", flightCapacity);
      System.out.printf("%11d", seatsBooked);
      switch(status)
      {
         case 'S':
            System.out.printf("%12s", "Scheduled");
            break;
         case 'B':
            System.out.printf("%12s", "Boarding");
            break;
         case 'D':
            System.out.printf("%12s", "Departed");
            break;
         case 'C':
            System.out.printf("%12s", "Cancelled");
            break;
      }
      
   }


}
